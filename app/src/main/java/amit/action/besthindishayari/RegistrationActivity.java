package amit.action.besthindishayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.NetworkErrorException;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText nameField,emailField,passField,conPassField;
    private Button signupBtn;
    private ProgressDialog mProgress;
    private FirebaseUser curUser;
    private TextView loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mAuth=FirebaseAuth.getInstance();
        mProgress=new ProgressDialog(this);

        nameField=findViewById(R.id.signup_name);
        emailField=findViewById(R.id.signup_email);
        passField=findViewById(R.id.signup_password);
        conPassField=findViewById(R.id.signup_con_password);
        signupBtn=findViewById(R.id.signup_button);
        loginLink=findViewById(R.id.signup_login_link);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyDetails();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationActivity.this,LoginActivity.class));
                finish();
            }
        });
    }

    private void verifyDetails() {
        String name=nameField.getText().toString().trim();
        String email=emailField.getText().toString().trim();
        String pass=passField.getText().toString().trim();
        String conPass=conPassField.getText().toString().trim();

        if (!name.matches("[A-Z][a-z]*") || name.isEmpty() || name.length()<4){
            nameField.setError("Not a valid name!");
            nameField.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailField.setError("Enter a valid email address");
            emailField.requestFocus();
            return;
        }

        if (pass.isEmpty() || pass.length() < 6){
            passField.setError("Enter a valid password of min 6 character!");
            passField.requestFocus();
            return;
        }

        if(!pass.equals(conPass)){
            conPassField.setError("Passwords did not match!");
            conPassField.requestFocus();
            return;
        }

        mProgress.setTitle("Creating New Account");
        mProgress.setMessage("please wait ...");
        registerUser(email,pass,name);
    }

    private void registerUser(String email, String pass, final String name) {
        mProgress.show();
        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mProgress.dismiss();
                    curUser=mAuth.getCurrentUser();
                    UserProfileChangeRequest profileChangeRequest=new UserProfileChangeRequest.Builder().setDisplayName(name).build();
                    curUser.updateProfile(profileChangeRequest);
                    Toast.makeText(RegistrationActivity.this, "Registration Successful. ", Toast.LENGTH_SHORT).show();
                    goToMainActivity();

                }else{
                    mProgress.dismiss();
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(RegistrationActivity.this, "Already have an account!, please login", Toast.LENGTH_SHORT).show();
                    }else if(task.getException() instanceof NetworkErrorException){
                        Toast.makeText(RegistrationActivity.this, "Check your internet connection!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(RegistrationActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RegistrationActivity.this,HomeActivity.class));
        finish();
    }

    private void goToMainActivity() {
        Intent intent=new Intent(RegistrationActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }

}
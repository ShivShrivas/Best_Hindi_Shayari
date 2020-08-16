package amit.action.besthindishayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText nameField,emailField,passField,conPassField;
    private Button signupBtn;
    private ProgressDialog mProgress;

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

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyDetails();
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

    private void registerUser(String email, String pass, String name) {
        mProgress.show();
        mAuth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mProgress.dismiss();
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
package amit.action.besthindishayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.accounts.NetworkErrorException;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText emailField,passField;
    private Button loginBtn;
    private TextView signupLink,forgotPassLink;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth=FirebaseAuth.getInstance();
        mProgress=new ProgressDialog(this);

        emailField=findViewById(R.id.login_email);
        passField=findViewById(R.id.login_password);
        loginBtn=findViewById(R.id.login_button);
        signupLink=findViewById(R.id.login_signup_link);
        forgotPassLink=findViewById(R.id.login_forgot_pass_link);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verfifyDetails();
            }
        });

        forgotPassLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ResetPasswordActivity.class));
            }
        });

        signupLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
            }
        });
    }

    private void verfifyDetails() {
        String email=emailField.getText().toString().trim();
        String pass=passField.getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailField.setError("Not a valid email address!");
            emailField.requestFocus();
            return;
        }

        mProgress.setTitle("Logging In");
        mProgress.setMessage("please wait...");

        loginUser(email,pass);
    }

    private void loginUser(String email, String pass) {
        mProgress.show();

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    mProgress.dismiss();
                    goToMainActivity();
                }else{
                    if (task.getException() instanceof NetworkErrorException){
                        Toast.makeText(LoginActivity.this, "Check your internet connection!", Toast.LENGTH_SHORT).show();
                    }else if (task.getException() instanceof FirebaseAuthInvalidUserException){
                        Toast.makeText(LoginActivity.this, "No existing account found, please register!", Toast.LENGTH_SHORT).show();
                        //startActivity(new Intent(LoginActivity.this,RegistrationActivity.class));
                    }else{
                        Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void goToMainActivity() {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
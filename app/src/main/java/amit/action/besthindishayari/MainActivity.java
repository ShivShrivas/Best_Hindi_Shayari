package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser curUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        curUser=mAuth.getCurrentUser();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (curUser==null){
            goToSignUp();
        }

    }

    public void goToLogin(View view) {

        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }

    public void goToSignUp() {
        Intent intent= new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
}
package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser curUser;
    private Button signUp,logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        curUser=mAuth.getCurrentUser();
        //signUp=findViewById(R.id.main_signup);
        //logoutBtn=findViewById(R.id.main_logout);
/*

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUp();
            }
        });
*/
/*

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                checkUserExistence();
            }
        });
*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        checkUserExistence();

    }

    public void goToLogin(View view) {

        //startActivity(new Intent(MainActivity.this,LoginActivity.class));
        Snackbar snackbar=Snackbar.make(view,"Welcome "+curUser.getDisplayName(),Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    public void goToSignUp() {
        Intent intent= new Intent(MainActivity.this,RegistrationActivity.class);
        startActivity(intent);
        finish();
    }
    public void checkUserExistence(){
        curUser=mAuth.getCurrentUser();
        if (curUser==null){
            goToSignUp();
        }
    }
}
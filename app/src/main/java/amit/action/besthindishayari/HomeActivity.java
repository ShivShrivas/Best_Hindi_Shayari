package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToLoginActivity(View view) {
        Intent intent=new Intent(HomeActivity.this,LoginActivity.class);
        startActivity(intent);

    }

    public void goToSignupActivity(View view) {
        Intent intent=new Intent(HomeActivity.this,RegistrationActivity.class);
        startActivity(intent);

    }
}
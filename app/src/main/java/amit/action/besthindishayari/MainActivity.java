package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser curUser;
    private Button signUp,logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        curUser=mAuth.getCurrentUser();

        List<String> list=new ArrayList<>();
        list.add("Alone");
        list.add("Sad");
        list.add("Love");
        list.add("Dosti");
        list.add("Dard");
        list.add("Good Morning");
        list.add("Good Night");
        list.add("Zindagi");


    }

    @Override
    protected void onStart() {
        super.onStart();
        checkUserExistence();

    }

    public void goToLogin(View view) {

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

    public void goToTopicMenu(View view) {
        String id=view.getResources().getResourceEntryName(view.getId());
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show();
    }
}
package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FavouriteShayariActivity extends AppCompatActivity {
    private TextView loginText,zeroShayariText;
    private Button loginBtn;
    private FirebaseAuth mAuth;
    private FirebaseUser curUser;
    private RecyclerView recyclerView;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_shayari);

        mAuth=FirebaseAuth.getInstance();

        loginText=findViewById(R.id.fav_text_login);
        loginBtn=findViewById(R.id.fav_button_login);
        toolbar=findViewById(R.id.favourite_shayari_app_bar);
        zeroShayariText=findViewById(R.id.fav_shayari_text);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Favourite Shayaries");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FavouriteShayariActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        curUser=mAuth.getCurrentUser();
        if (curUser==null){
            loginText.setVisibility(View.VISIBLE);
            loginBtn.setVisibility(View.VISIBLE);
        }else{
            zeroShayariText.setVisibility(View.VISIBLE);
        }

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
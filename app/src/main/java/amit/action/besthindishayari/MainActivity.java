package amit.action.besthindishayari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser curUser;
    private TextView headerName,headerEmail,categoriesText;
    boolean doubleTap=false;

    private Toolbar mToolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    private Animation sideAnim,bottomAnim;
    GridLayout gridLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        curUser=mAuth.getCurrentUser();

        //Hooks
        mToolbar=findViewById(R.id.main_app_bar);
        gridLayout=findViewById(R.id.main_grid_layout);
        categoriesText=findViewById(R.id.main_text_categories);
        navigationView=findViewById(R.id.main_navigation_view);

        //Toolbar
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Hindi Shayari 2020");

        drawerLayout=findViewById(R.id.main_drawer_layout);

        //NavigationView
        actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        View navView=navigationView.inflateHeaderView(R.layout.navigation_header);
        headerName=navView.findViewById(R.id.nav_header_name);
        headerEmail=navView.findViewById(R.id.nav_header_email);

        //Animations
        sideAnim= AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        gridLayout.setAnimation(sideAnim);
        categoriesText.setAnimation(bottomAnim);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                UserMenuSelector(menuItem);
                return false;
            }
        });

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

    private void UserMenuSelector(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.nav_home:
                drawerLayout.closeDrawer(Gravity.LEFT);
                Toast.makeText(getApplicationContext(), "You are on HOME!", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_logout:

                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Dou you really want to logout!");
                builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAuth.signOut();
                        checkUserExistence();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

                break;

            case R.id.nav_fav:
                Intent intent=new Intent(MainActivity.this,FavouriteShayariActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            if (doubleTap){
                super.onBackPressed();
            }
            else {
                Snackbar backSnakbar=Snackbar.make(drawerLayout,"Press back twice to exit Best Hindi Shayari app",Snackbar.LENGTH_SHORT);
                backSnakbar.show();
                doubleTap=true;
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleTap=false;
                    }
                },1000); //one second
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkUserExistence();
        //Snackbar snackbar=Snackbar.make(drawerLayout,"Welcome "+curUser.getDisplayName(),Snackbar.LENGTH_LONG);
        //snackbar.show();
    }


    public void goToHomeActivity() {
        Intent intent= new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
    public void checkUserExistence(){
        curUser=mAuth.getCurrentUser();
        if (curUser==null){
            goToHomeActivity();
        }
    }

    public void goToTopicMenu(View view) {
        //String name=view.getResources().get(view.getId());
        String name_id=view.getResources().getResourceEntryName(view.getId());
        Intent intent=new Intent(MainActivity.this,TopicShayariActivity.class);
        intent.putExtra("topic_name",name_id);
        startActivity(intent);
    }
}
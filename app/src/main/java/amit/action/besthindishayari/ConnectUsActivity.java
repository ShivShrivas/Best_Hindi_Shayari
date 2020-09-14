package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;

import mehdi.sakout.aboutpage.AboutPage;

public class ConnectUsActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect_us);

        toolbar=findViewById(R.id.connect_app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Connect with us");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                //.addGroup("Developer Profile")
                .setImage(R.drawable.about_image)
                .setDescription("Hello guys please show your support")
                //.addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("developeramit00" +
                        "@gmail.com")
                //.addWebsite("http://medyo.github.io/")
                .addFacebook("amitsharma000")
                .addTwitter("awesomeamit98")
                .addYoutube("UCZT0aW4u2_TOi4NX15iG8bA")
                //.addPlayStore("com.ideashower.readitlater.pro")
                .addInstagram("i__amit")
                .addGitHub("amits999")
                .create();

        setContentView(aboutPage);
    }
}
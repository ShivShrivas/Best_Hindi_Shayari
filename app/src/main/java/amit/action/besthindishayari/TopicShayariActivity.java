package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class TopicShayariActivity extends AppCompatActivity {
    private StringBuffer topicNameText;
    private ImageView shayariImage;
    private Button prevButton,nextButton,moreButton,favButton;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_shayari);

        prevButton=findViewById(R.id.topic_shayari_prev_button);
        nextButton=findViewById(R.id.topic_shayari_next_button);
        favButton=findViewById(R.id.topic_shayari_fav_button);
        moreButton=findViewById(R.id.topic_shayari_more_button);
        shayariImage=findViewById(R.id.topic_shayari_image);

        topicNameText=new StringBuffer(getIntent().getStringExtra("topic_name"));
        topicNameText.replace(0,0,Character.toString(topicNameText.charAt(0)).toUpperCase());
        toolbar=findViewById(R.id.topic_shayari_app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(topicNameText+" Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
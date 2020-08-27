package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TopicShayariActivity extends AppCompatActivity {
    private StringBuffer topicNameText;
    private String topic;
    private TextView shayariText;
    private ImageView shayariImage;
    private Button prevButton,nextButton,moreButton,favButton;
    private Toolbar toolbar;
    private ArrayList<String> dard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_shayari);

        prevButton=findViewById(R.id.topic_shayari_prev_button);
        nextButton=findViewById(R.id.topic_shayari_next_button);
        favButton=findViewById(R.id.topic_shayari_fav_button);
        moreButton=findViewById(R.id.topic_shayari_more_button);
        shayariImage=findViewById(R.id.topic_shayari_image);
        shayariText=findViewById(R.id.topic_shayari_text);

        topicNameText=new StringBuffer(getIntent().getStringExtra("topic_name"));
        topic=new String(topicNameText);
        topicNameText.replace(0,1,Character.toString(topicNameText.charAt(0)).toUpperCase());
        toolbar=findViewById(R.id.topic_shayari_app_bar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(topicNameText+" Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dard =new ArrayList<>();
        dard.add("गुलशन की बहारों पे सर-ए-शाम लिखा है,\n" +
                "फिर उस ने किताबों पे मेरा नाम लिखा है,\n" +
                "ये दर्द इसी तरह मेरी दुनिया में रहेगा,\n" +
                "कुछ सोच के उस ने मेरा अंजाम लिखा है।");
        dard.add("नसीहत अच्छी देती है दुनिया,\n" +
                "अगर दर्द किसी ग़ैर का हो।");
        dard.add("खामोशियाँ कर देतीं बयान तो अलग बात है,\n" +
                "कुछ दर्द हैं जो लफ़्ज़ों में उतारे नहीं जाते।");
        dard.add("आँखों में उमड़ आता है बादल बन कर,\n" +
                "दर्द एहसास को बंजर नहीं रहने देता।");
        dard.add("रोज़ पिलाता हूँ एक ज़हर का प्याला उसे,\n" +
                "एक दर्द जो दिल में है मरता ही नहीं है।");
        dard.add("दर्द मोहब्बत का ऐ दोस्त बहुत खूब होगा,\n" +
                "न चुभेगा.. न दिखेगा.. बस महसूस होगा।");

        ArrayList<String> shayariList = null;
        if(topic.equals("dard")){
            shayariList=dard;
            shayariImage.setImageResource(R.drawable.dard);
        }

        final int[] index = {0};
        shayariText.setText(shayariList.get(index[0]));
        final ArrayList<String> finalShayariList = shayariList;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index[0]++;
                if (index[0] > finalShayariList.size()-1){
                    index[0] =0;
                }
                shayariText.setText(finalShayariList.get(index[0]));
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index[0]--;
                if (index[0] <0){
                    index[0] =finalShayariList.size()-1;
                }
                shayariText.setText(finalShayariList.get(index[0]));

            }
        });
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopicShayariActivity.this, "Added to favorite :-)", Toast.LENGTH_SHORT).show();
            }
        });
        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopicShayariActivity.this, "Jald aa raha :-)", Toast.LENGTH_SHORT).show();
            }
        });
        shayariImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TopicShayariActivity.this, "Ye bhi jald aa raha :-)", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
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
    private ArrayList<String> dard,alone,attitude,love,dosti,zindagi,funny,bewafa,sad,judai,good_morning,good_night,birthday,mother,father,new_year,intezaar;
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

        attitude =new ArrayList<>();

        attitude.add("हक़ से दो तो तुम्हारी नफरत भी कबूल हमें,\n" +
                "खैरात में तो हम तुम्हारी मोहब्बत भी न लें।");

        attitude.add("सूरज ढला तो कद से ऊँचे हो गए साये,\n" +
                "कभी पैरों से रौंदी थी यहीं परछाइयां हमने।");

        love =new ArrayList<>();
        love.add("एक उमर बीत चली है तुझे चाहते हुए,\n" +
                "तू आज भी बेखबर है कल की तरह।");

        love.add("अना कहती है इल्तेजा क्या करनी,\n" +
                "वो मोहब्बत ही क्या जो मिन्नतों से मिले।");
        dosti =new ArrayList<>();
        dosti.add("आसमान से तोड़ कर सितारा दिया है,\n" +
                "आलम-ए-तन्हाई में एक शरारा दिया है,\n" +
                "मेरी किस्मत भी नाज़ करती है मुझपे,\n" +
                "खुदा ने दोस्त ही इतना प्यारा दिया है।");

        dosti.add("हम जब भी आपकी दुनिया से जायेंगे,\n" +
                "इतनी खुशियाँ और अपनापन दे जायेंगे,\n" +
                "कि जब भी याद करोगे इस पागल दोस्त को,\n" +
                "हँसती आँखों से आँसू निकल आयेंगे।");
        zindagi =new ArrayList<>();
        funny =new ArrayList<>();
        bewafa =new ArrayList<>();
        sad =new ArrayList<>();
        judai =new ArrayList<>();
        good_morning=new ArrayList<>();
        good_night =new ArrayList<>();
        birthday =new ArrayList<>();
        mother =new ArrayList<>();
        father =new ArrayList<>();
        new_year =new ArrayList<>();
        intezaar =new ArrayList<>();


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
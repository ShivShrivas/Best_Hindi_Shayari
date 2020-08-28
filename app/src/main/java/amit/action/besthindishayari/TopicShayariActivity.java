package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class TopicShayariActivity extends AppCompatActivity {
    private StringBuffer topicNameText;
    private String topic,curShayari;
    private TextView shayariText;
    private ImageView shayariImage;
    private Button prevButton,nextButton,moreButton,favButton,whatsAppShareButton,copyButton,shareButton;
    private Toolbar toolbar;
    private Animation leftAnim,rightAnim;
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
        whatsAppShareButton=findViewById(R.id.topi_shayari_whatsapp_share);
        copyButton=findViewById(R.id.topic_shayari_copy_text);
        shareButton=findViewById(R.id.topic_shayari_share);

        topicNameText=new StringBuffer(getIntent().getStringExtra("topic_name"));
        topic=new String(topicNameText);
        topicNameText.replace(0,1,Character.toString(topicNameText.charAt(0)).toUpperCase());
        toolbar=findViewById(R.id.topic_shayari_app_bar);

        leftAnim= AnimationUtils.loadAnimation(this,R.anim.left_anim);
        rightAnim= AnimationUtils.loadAnimation(this,R.anim.right_anim);
        shayariImage.setAnimation(leftAnim);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(topicNameText+" Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        alone =new ArrayList<>();
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
        zindagi.add("समंदर न सही पर एक नदी तो होनी चाहिए,\n" +
                "तेरे शहर में ज़िंदगी कहीं तो होनी चाहिए।");
        zindagi.add("इक टूटी-सी ज़िंदगी को समेटने की चाहत थी,\n" +
                "न खबर थी उन टुकड़ों को ही बिखेर बैठेंगे हम।");
        zindagi.add("ले दे के अपने पास फ़क़त एक नजर तो है,\n" +
                "क्यूँ देखें ज़िंदगी को किसी की नजर से हम।");

        funny =new ArrayList<>();
        funny.add("इस दुनिया में लाखों लोग रहते हैं,\n" +
                "कोई हँसता है तो कोई रोता है,\n" +
                "पर सबसे सुखी वही होता है,\n" +
                "जो शाम को दो पैग मार के सोता है।");
        funny.add("उसी दिन से व्हाट्सएप्प से नफरत हो गयी ग़ालिब,\n" +
                "जब बाल कटवाने के लिए एडमिन ने चंदा माँग लिया।\n");

        bewafa =new ArrayList<>();
        bewafa.add("अब के अब तस्लीम कर लें तू नहीं तो मैं सही,\n" +
                "कौन मानेगा कि हम में से बेवफा कोई नहीं।");
        bewafa.add("मेरे फन को तराशा है सभी के नेक इरादों ने,\n" +
                "किसी की बेवफाई ने किसी के झूठे वादों ने।");

        sad =new ArrayList<>();
        sad.add("जिसके नसीब मे हों ज़माने की ठोकरें,\n" +
                "उस बदनसीब से ना सहारों की बात कर।");
        sad.add("बुला रहा है कौन मुझको उस तरफ,\n" +
                "मेरे लिए भी क्या कोई उदास बेक़रार है।");
        sad.add("वो तेरे खत तेरी तस्वीर और सूखे फूल,\n" +
                "उदास करती हैं मुझ को निशानियाँ तेरी।");


        judai =new ArrayList<>();
        judai.add("दिल से निकली ही नहीं शाम जुदाई वाली,\n" +
                "तुम तो कहते थे बुरा वक़्त गुज़र जाता है।");
        judai.add("जुदा हुए हैं बहुत से लोग एक तुम भी सही,\n" +
                "अब इतनी सी बात पे क्या जिंदगी हैरान करें।");

        good_morning=new ArrayList<>();
        good_morning.add("सुबह होते ही जब दुनिया आबाद होती है,\n" +
                "आँख खुलते ही दिल में आपकी याद होती है,\n" +
                "खुशियों के फूल हों आपके आँचल में,\n" +
                "ये मेरे होंठों पे पहली फ़रियाद होती है।\n" +
                "सुप्रभात!");
        good_morning.add("सुबह हुयी हवाओं में खुशबु महकी,\n" +
                "प्यारी सी सुबह कर रही है तुम्हारा इंतज़ार,\n" +
                "अब तो जाग जाओ और खोल दो आँखें,\n" +
                "हमारा एस.एम.एस. ले कर आया है ढेर सारा प्यार।");

        good_night =new ArrayList<>();
        good_night.add("ऐसा लगता है कुछ होने जा रहा है,\n" +
                "कोई मीठे सपनों में खोने जा रहा है,\n" +
                "धीमी कर दे अपनी रोशनी ऐ चाँद,\n" +
                "मेरा कोई अपना अब सोने जा रहा है।\n" +
                "शुभ रात्रि।");
        good_night.add("जाने कब आपकी आँखों से इजहार होगा,\n" +
                "आपके दिल में हमारे लिए प्यार होगा,\n" +
                "गुजर रही है ये रात आपकी याद में,\n" +
                "कभी तो आपको भी हमारा इंतज़ार होगा।\n" +
                "शुभरात्रि");

        birthday =new ArrayList<>();
        birthday.add("आपके जन्मदिन पर हम देते हैं ये दुआ,\n" +
                "खुशियाँ आपके दामन से कभी न हों जुदा,\n" +
                "खुदा की रहमतों में कभी कमी न आये,\n" +
                "आपके होंठों की ये मुस्कराहट न जाए।");
        birthday.add("दुनिया की खुशियाँ आपको मिल जायें,\n" +
                "अपनों से मिलके आपका मन खिल जाये,\n" +
                "चेहरे पर दुःख की कभी शिकन भी न हो,\n" +
                "आपके जन्मदिन पर मेरी दिल से शुभकामनाएं।");

        mother =new ArrayList<>();
        mother.add("चलती फिरती आँखों से अज़ाँ देखी है,\n" +
                "मैंने जन्नत तो नहीं देखी है माँ देखी है।");
        mother.add("तेरे क़दमों में ये सारा जहां होगा एक दिन,\n" +
                "माँ के होठों पे तबस्सुम को सजाने वाले।");

        father =new ArrayList<>();
        father.add("मुझे मोहब्बत है अपने हाथों की सब लकीरों से,\n" +
                "ना जाने पापा ने कौनसी ऊँगली को पकड़कर चलना सिखाया था।");
        father.add("नसीब वाले हैं जिनके सर पर पिता का हाथ होता हैं,\n" +
                "ज़िद पूरी हो जाती हैं सब गर पिता का साथ होता हैं।");

        new_year =new ArrayList<>();
        new_year.add("बीते साल को विदा इस कदर करते हैं,\n" +
                "ज़ो नहीं किया अब तक वो भी कर गुज़रते हैं,\n" +
                "नया साल आने की खुशियाँ तो सब मनाते हैं,\n" +
                "चलो हम, इस बार बीते साल की यादो का जश्न मनाते हैं!!");
        new_year.add("कभी हसती है तो कभी रूलाती है\n" +
                "ये जिंन्दगी भी न जाने कितने रंग दिखाती है।\n" +
                "हसते हैं तो भी आंखों में नमी आ जाती है\n" +
                "ना जाने ये कैसी यादें है जो दिल में बस जाती है\n" +
                "दुआ करते हैं इन नये साल के अवसर पर\n" +
                "मेरे दोस्तो के लवों पर सदा मुस्कान रहे\n" +
                "क्योंकि उन की हर मुस्कुराहट हमे खुशी दे जाती है.");

        intezaar =new ArrayList<>();
        intezaar.add("ऐ मौत उन्हें भुलाए ज़माने गुजर गए,\n" +
                "आ जा कि ज़हर खाए ज़माने गुजर गए,\n" +
                "ओ जाने वाले आ कि तेरे इंतजार में,\n" +
                "रास्ते को घर बनाए ज़माने गुजर गए।");
        intezaar.add("दिन भर भटकते रहते हैं अरमान तुझसे मिलने के,\n" +
                "न ये दिल ठहरता है न तेरा इंतज़ार रुकता है।");


        ArrayList<String> shayariList = null;
        if(topic.equals("alone")){
            shayariList=alone;
            shayariImage.setImageResource(R.drawable.alone);
        }else if(topic.equals("attitude")){
            shayariList=attitude;
            shayariImage.setImageResource(R.drawable.attitude);
        }else if(topic.equals("love")){
            shayariList=love;
            shayariImage.setImageResource(R.drawable.love);
        }else if(topic.equals("dosti")){
            shayariList=dosti;
            shayariImage.setImageResource(R.drawable.dosti);
        }else if(topic.equals("zindagi")){
            shayariList=zindagi;
            shayariImage.setImageResource(R.drawable.zindagi);
        }else if(topic.equals("funny")){
            shayariList=funny;
            shayariImage.setImageResource(R.drawable.funny);
        }else if(topic.equals("bewafa")){
            shayariList=bewafa;
            shayariImage.setImageResource(R.drawable.bewafa);
        }else if(topic.equals("sad")){
            shayariList=sad;
            shayariImage.setImageResource(R.drawable.sad);
        }else if(topic.equals("judai")){
            shayariList=judai;
            shayariImage.setImageResource(R.drawable.judai);
        }else if(topic.equals("dard")){
            shayariList=dard;
            shayariImage.setImageResource(R.drawable.dard);
        }else if(topic.equals("good_morning")){
            shayariList=good_morning;
            shayariImage.setImageResource(R.drawable.good_morning);
        }else if(topic.equals("good_night")){
            shayariList=good_night;
            shayariImage.setImageResource(R.drawable.good_night);
        }else if(topic.equals("birthday")){
            shayariList=birthday;
            shayariImage.setImageResource(R.drawable.birthday);
        }else if(topic.equals("mother")){
            shayariList=mother;
            shayariImage.setImageResource(R.drawable.mother);
        }else if(topic.equals("father")){
            shayariList=father;
            shayariImage.setImageResource(R.drawable.father);
        }else if(topic.equals("new_year")){
            shayariList=new_year;
            shayariImage.setImageResource(R.drawable.new_year);
        }else if(topic.equals("intezaar")){
            shayariList=intezaar;
            shayariImage.setImageResource(R.drawable.intezaar);
        }

        final int[] index = {0};
        shayariText.setText(shayariList.get(index[0]));
        curShayari=shayariList.get(index[0]);
        final ArrayList<String> finalShayariList = shayariList;
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shayariImage.startAnimation(rightAnim);
                //shayariText.startAnimation(rightAnim);
                index[0]++;
                if (index[0] > finalShayariList.size()-1){
                    index[0] =0;
                }
                shayariText.setText(finalShayariList.get(index[0]));
                curShayari=finalShayariList.get(index[0]);
            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shayariImage.startAnimation(leftAnim);
                //shayariText.startAnimation(leftAnim);
                index[0]--;
                if (index[0] <0){
                    index[0] =finalShayariList.size()-1;
                }
                shayariText.setText(finalShayariList.get(index[0]));
                curShayari=finalShayariList.get(index[0]);

            }
        });
        shayariImage.setOnTouchListener(new OnSwipeTouchListener(TopicShayariActivity.this){
            public void onSwipeTop() {
                Toast.makeText(TopicShayariActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                shayariImage.startAnimation(leftAnim);
                shayariText.startAnimation(leftAnim);
                index[0]--;
                if (index[0] <0){
                    index[0] =finalShayariList.size()-1;
                }
                shayariText.setText(finalShayariList.get(index[0]));
                curShayari=finalShayariList.get(index[0]);
            }
            public void onSwipeLeft() {
                shayariImage.startAnimation(rightAnim);
                shayariText.startAnimation(rightAnim);
                index[0]++;
                if (index[0] > finalShayariList.size()-1){
                    index[0] =0;
                }
                shayariText.setText(finalShayariList.get(index[0]));
                curShayari=finalShayariList.get(index[0]);
            }
            public void onSwipeBottom() {
                Toast.makeText(TopicShayariActivity.this, "bottom", Toast.LENGTH_SHORT).show();
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
        copyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("Shayari",curShayari);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(TopicShayariActivity.this, "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        whatsAppShareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, curShayari);
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(TopicShayariActivity.this, "WhatsApp have not been installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
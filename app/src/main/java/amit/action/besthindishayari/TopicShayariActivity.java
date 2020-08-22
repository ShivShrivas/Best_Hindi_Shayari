package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TopicShayariActivity extends AppCompatActivity {
    private String topicNameText;
    private TextView topicName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_shayari);

        topicNameText=getIntent().getStringExtra("topic_name");
        topicName=findViewById(R.id.topic_name);
        topicName.setText(topicNameText);
    }
}
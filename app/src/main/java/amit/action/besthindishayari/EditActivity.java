package amit.action.besthindishayari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.FileProvider;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EditActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String shayariText,topic;
    private Button backgroundBtn,gradient,textColor,saveImage,textStyle,addToFav,whatsAppShare,shareAll,copyText;
    private ImageView bgImage,testImage;
    private TextView shayariTextView;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        toolbar=findViewById(R.id.edit_app_bar);
        shayariTextView=findViewById(R.id.edit_shayari_text);
        bgImage=findViewById(R.id.edit_shayari_image);
        backgroundBtn=findViewById(R.id.edit_shayari_background);
        shareAll=findViewById(R.id.edit_shayari_share);
        whatsAppShare=findViewById(R.id.edit_shayari_whatsapp_share);
        copyText=findViewById(R.id.edit_shayari_copy_text);
        gradient=findViewById(R.id.edit_shayari_gradient);
        textColor=findViewById(R.id.edit_shayari_text_color);
        textStyle=findViewById(R.id.edit_shayari_text_style);
        saveImage=findViewById(R.id.edit_shayari_save_image);
        addToFav=findViewById(R.id.edit_shayari_fav);
        relativeLayout=findViewById(R.id.edit_relative_layout);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Edit Shayari");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        shayariText=getIntent().getStringExtra("cur_shayari");
        topic=getIntent().getStringExtra("topic");

        shayariTextView.setText(shayariText);
        if(topic.equals("alone")){
            bgImage.setImageResource(R.drawable.alone);
        }else if(topic.equals("attitude")){
            bgImage.setImageResource(R.drawable.attitude);
        }else if(topic.equals("love")){
            bgImage.setImageResource(R.drawable.love);
        }else if(topic.equals("dosti")){
            bgImage.setImageResource(R.drawable.dosti);
        }else if(topic.equals("zindagi")){
            bgImage.setImageResource(R.drawable.zindagi);
        }else if(topic.equals("funny")){
            bgImage.setImageResource(R.drawable.funny);
        }else if(topic.equals("bewafa")){
            bgImage.setImageResource(R.drawable.bewafa);
        }else if(topic.equals("sad")){
            bgImage.setImageResource(R.drawable.sad);
        }else if(topic.equals("judai")){
            bgImage.setImageResource(R.drawable.judai);
        }else if(topic.equals("dard")){
            bgImage.setImageResource(R.drawable.dard);
        }else if(topic.equals("good_morning")){
            bgImage.setImageResource(R.drawable.good_morning);
        }else if(topic.equals("good_night")){
            bgImage.setImageResource(R.drawable.good_night);
        }else if(topic.equals("birthday")){
            bgImage.setImageResource(R.drawable.birthday);
        }else if(topic.equals("mother")){
            bgImage.setImageResource(R.drawable.mother);
        }else if(topic.equals("father")){
            bgImage.setImageResource(R.drawable.father);
        }else if(topic.equals("new_year")){
            bgImage.setImageResource(R.drawable.new_year);
        }else if(topic.equals("intezaar")){
            bgImage.setImageResource(R.drawable.intezaar);
        }

        shareAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                share();
            }
        });
        saveImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap=Bitmap.createBitmap(relativeLayout.getWidth(),relativeLayout.getHeight(),
                        Bitmap.Config.ARGB_8888);
                Canvas canvas=new Canvas(bitmap);
                relativeLayout.draw(canvas);

                Bitmap icon = bitmap;
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
                values.put(MediaStore.Images.Media.TITLE, "Your Shayari");
                values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
                MediaStore.Images.Media.insertImage(getContentResolver(), icon, topic+" shayari", "yourDescription");
                //getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
                Toast.makeText(EditActivity.this, "Image saved in gallery", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void share(){
        Bitmap bitmap=Bitmap.createBitmap(relativeLayout.getWidth(),relativeLayout.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(bitmap);
        relativeLayout.draw(canvas);

        Bitmap icon = bitmap;
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("image/png");

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis());
        values.put(MediaStore.Images.Media.TITLE, "Your Shayari");
        values.put(MediaStore.Images.Media.MIME_TYPE, "image/png");
        //MediaStore.Images.Media.insertImage(getContentResolver(), icon, topic+" shayari", "yourDescription");
        Uri uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values);


        OutputStream outstream;
        try {
            outstream = getContentResolver().openOutputStream(uri);
            icon.compress(Bitmap.CompressFormat.PNG, 100, outstream);
            outstream.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        share.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(share, "Share Image using:"));

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
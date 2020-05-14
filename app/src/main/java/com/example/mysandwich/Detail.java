package com.example.mysandwich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;
import com.example.mysandwich.Utils.JsonUtils;
import com.example.mysandwich.models.Sandwich;

public class Detail extends AppCompatActivity {
   private ImageView img;
   private TextView known,origin,des,ingri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img=(ImageView)findViewById(R.id.image_iv);
        known=(TextView)findViewById(R.id.also_known_tv);
        origin=(TextView)findViewById(R.id.origin_tv);
        des=(TextView)findViewById(R.id.description_tv);
        ingri=(TextView)findViewById(R.id.ingredients_tv);
        Intent a=getIntent();
        if(a==null) close();
        else{
          int pos= a.getIntExtra("position",-1);
            if(pos==-1) {
                close();
                return;
            }
           String[] sand=getResources().getStringArray(R.array.sandwich_details);
           String json=sand[pos];
           Sandwich snd= JsonUtils.parseSandwichJson(json);
           if(snd==null) {
               close();
               return;
           }
           populateUI(snd);
            Picasso.with(this)
                    .load(snd.getImage())
                    .into(img);

            setTitle(snd.getMainName());
         }

    }
    private void close() {
        finish();
        Toast.makeText(this, R.string.detail_error_message, Toast.LENGTH_SHORT).show();
    }
    public void populateUI(Sandwich snd)
    {    known.setText(snd.getMainName());
         origin.setText(snd.getPlaceOfOrigin());
         des.setText(snd.getDescription());
         ingri.setText(snd.getDescription());

    }
}

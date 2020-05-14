package com.example.mysandwich;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView lv;
    private String[] sandname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.list);
        sandname=getResources().getStringArray(R.array.sandwich_names);
        ArrayAdapter<String> ad=new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,sandname);
        lv.setAdapter(ad);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                   Intent a=new Intent(getApplicationContext(),Detail.class);
                   a.putExtra("position",position);
                   startActivity(a);

            }
        });

    }
}

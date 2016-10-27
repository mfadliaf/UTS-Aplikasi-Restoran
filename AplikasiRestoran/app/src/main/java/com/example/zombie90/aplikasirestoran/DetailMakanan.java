package com.example.zombie90.aplikasirestoran;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMakanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);
        TextView tvDetails = (TextView) findViewById(R.id.tvDetails);
        ImageView ivDetails = (ImageView) findViewById(R.id.ivDetails);

        Intent i = getIntent();
        //retriving data from intents and setting it to textview and imageview
        ivDetails.setImageResource(i.getIntExtra("makanan", R.drawable.kerak_telor));
        tvDetails.setText(i.getIntExtra("details", R.string.details_keraktelor));
    }
}

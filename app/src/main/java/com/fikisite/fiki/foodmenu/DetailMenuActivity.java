package com.fikisite.fiki.foodmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMenuActivity extends AppCompatActivity {
    private TextView tvNama;
    private TextView tvHarga;
    private ImageView imgPhoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);
        tvNama = findViewById(R.id.tv_item_name);
        tvHarga = findViewById(R.id.tv_item_harga);
        imgPhoto = findViewById(R.id.img_item_photo);

        tvNama.setText(getIntent().getStringExtra("nama"));
        tvHarga.setText(getIntent().getStringExtra("harga"));

        Glide.with(this)
                .load(getIntent().getStringExtra("photo"))
                .override(55, 55)
                .crossFade()
                .into(imgPhoto);
    }
}

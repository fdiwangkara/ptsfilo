package com.example.pts_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_JUDUL = "EXTRA_JUDUL";
    public static final String EXTRA_GAMBAR = "EXTRA_JUDUL1";
    public static final String EXTRA_DESC = "EXTRA_JUDUL2";

    private TextView judul,desc;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        judul = findViewById(R.id.judul_berita);
        desc = findViewById(R.id.deskripsi_berita);
        image = findViewById(R.id.berita_gambar);

       String sub = getIntent().getStringExtra(EXTRA_JUDUL);
       String desck = getIntent().getStringExtra(EXTRA_DESC);
       Integer gambar = getIntent().getIntExtra(EXTRA_GAMBAR, 0);




        judul.setText(sub);
        desc.setText(desck);
        image.setImageResource(gambar);
    }
}
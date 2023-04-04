package com.example.pts_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Locale;

public class NewsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_hero);

        ArrayList<Hero> heroes = getListHeroes();

        ListHeroAdapter adapter = new ListHeroAdapter(heroes);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);









    }

    private ArrayList<Hero> getListHeroes(){

        String[] judul = getResources().getStringArray(R.array.judul_berita);
        String[] desc = getResources().getStringArray(R.array.deskripsi_berita);
        String[] category = getResources().getStringArray(R.array.kategori_berita);
        String[] tanggal = getResources().getStringArray(R.array.tanggal_berita);
        TypedArray poster = getResources().obtainTypedArray(R.array.gambar_berita);

        ArrayList<Hero> heroes = new ArrayList<>();

        for(int i = 0; i < judul.length; i++){
            Hero hero = new Hero();

            hero.setTanggal(tanggal[i]);
            hero.setCategory(category[i]);
            hero.setJudul(judul[i]);
            hero.setDesc(desc[i]);
            hero.setGambar(poster.getResourceId(i,-1));

            heroes.add(hero);
        }

        return heroes;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        return super.onCreateOptionsMenu(menu);
    }
}
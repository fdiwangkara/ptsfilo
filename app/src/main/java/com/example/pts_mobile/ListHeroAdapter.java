package com.example.pts_mobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ViewHolder>{

    private ArrayList<Hero> localDataSet;

    public ListHeroAdapter(ArrayList<Hero> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.tvJudul.setText(localDataSet.get(position).getCategory());
        holder.tvCategory.setText(localDataSet.get(position).getJudul());
        holder.tvDate.setText(localDataSet.get(position).getTanggal());
        holder.tvImage.setImageResource(localDataSet.get(position).getGambar());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);


            intent.putExtra(DetailActivity.EXTRA_JUDUL, localDataSet.get(position).getJudul());
            intent.putExtra(DetailActivity.EXTRA_DESC, localDataSet.get(position).getDesc());
            intent.putExtra(DetailActivity.EXTRA_GAMBAR, localDataSet.get(position).getGambar());


            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvJudul, tvCategory, tvDate;
        private ImageView tvImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvJudul = (TextView) itemView.findViewById(R.id.berita_category);
            tvCategory = (TextView) itemView.findViewById(R.id.berita_judul);
            tvDate = (TextView) itemView.findViewById(R.id.berita_date);
            tvImage = itemView.findViewById(R.id.hero_image);
        }
    }
}

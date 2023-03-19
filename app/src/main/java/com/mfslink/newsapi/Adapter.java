package com.mfslink.newsapi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mfslink.newsapi.Model.newsModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {

    Context context;
    ArrayList<newsModel> list;

    public Adapter(Context context, ArrayList<newsModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_rec_lay, null,false);
       return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", list.get(position).getUrl());
                context.startActivity(intent);

            }
        });

        holder.headline.setText(list.get(position).getTitle());
        holder.time.setText("Published At:-"+list.get(position).getPublishedAt());
        holder.containt.setText(list.get(position).getDescription());
        holder.author.setText(list.get(position).getAuthor());

        Glide.with(context).load(list.get(position).getUrlToImage()).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView headline, containt, author, time, category;
        CardView cardView;
        ImageView imageView;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            headline = itemView.findViewById(R.id.headline);
            containt = itemView.findViewById(R.id.containt);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            cardView = itemView.findViewById(R.id.cardview);
            imageView = itemView.findViewById(R.id.imageview);

        }
    }
}

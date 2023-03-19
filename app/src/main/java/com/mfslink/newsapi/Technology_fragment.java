package com.mfslink.newsapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mfslink.newsapi.Model.ApiUtilities;
import com.mfslink.newsapi.Model.MainNews;
import com.mfslink.newsapi.Model.newsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Technology_fragment extends Fragment {

    private RecyclerView rv_technology_frag;
    String country = "in";
    String category = "technology";
    ArrayList<newsModel> list;
    Adapter adapter;
    String apikey = "9e555fb76bbf4aeab5b9dca583da40a6";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.technology_fragment, null);



        rv_technology_frag = view.findViewById(R.id.rv_technology_frag);
        list= new ArrayList<>();
        rv_technology_frag.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new Adapter(getContext(), list);
        rv_technology_frag.setAdapter(adapter);

        findNews();


        return view;
    }

    private void findNews() {
        ApiUtilities.getApiInterface().getCategoryNews(category,country,100, apikey).enqueue(new Callback<MainNews>() {
            @Override
            public void onResponse(Call<MainNews> call, Response<MainNews> response) {
                if (response.isSuccessful()) {
                    list.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<MainNews> call, Throwable t) {

            }
        });
    }
}
package com.mfslink.newsapi.Model;

import java.util.ArrayList;

public class MainNews {

    private String status;
    private String totalResults;
   private ArrayList<newsModel> articles;

    public MainNews(String status, String totalResults, ArrayList<newsModel> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<newsModel> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<newsModel> articles) {
        this.articles = articles;
    }
}

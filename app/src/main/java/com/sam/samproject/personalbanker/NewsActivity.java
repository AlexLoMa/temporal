package com.sam.samproject.personalbanker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sam.samproject.R;
import com.sam.samproject.adapters.NewsFeedAdapter;
import com.sam.samproject.base.BaseActivity;
import com.sam.samproject.model.Article;
import com.sam.samproject.model.ResponseModel;
import com.sam.samproject.restApi.ApiClient;
import com.sam.samproject.restApi.ApiInterface;
import com.sam.samproject.utils.OnRecyclerViewItemClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends BaseActivity implements OnRecyclerViewItemClickListener {

    public static final String API_KEY = "402f5282a270493db6b7cbc0266ed3f9";
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feedlayout);

        final RecyclerView mainRecycler = findViewById(R.id.news_feed_rv);

        final LinearLayoutManager linearLayoutManager = new
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        mainRecycler.setLayoutManager(linearLayoutManager);

        progressDialog = new ProgressDialog(this);
        showProgressDialog("Fetching News...");

        final ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseModel> call = apiService.getLatestNews("techcrunch",API_KEY);
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel>call, Response<ResponseModel> response) {
                progressDialog.dismiss();
                if(response.body().getStatus().equals("ok")) {
                    List<Article> articleList = response.body().getArticles();
                    if(articleList.size()>0) {
                        final NewsFeedAdapter newsFeedAdapter = new NewsFeedAdapter(articleList);
                        newsFeedAdapter.setOnRecyclerViewItemClickListener(NewsActivity.this);
                        mainRecycler.setAdapter(newsFeedAdapter);
                    }
                }
            }
            @Override
            public void onFailure(Call<ResponseModel>call, Throwable t) {
                progressDialog.dismiss();
                Log.e("out", t.toString());
                Toast.makeText(getApplicationContext(),"Something went wrong Please check internet connection",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showProgressDialog(String strMsg) {
        progressDialog.setMessage(strMsg);
        progressDialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        progressDialog.dismiss();
    }

    @Override
    public void onItemClick(int position, View view) {
        switch (view.getId()) {
            case R.id.news_feed_ll_parent:
                Article article = (Article) view.getTag();
                if(!TextUtils.isEmpty(article.getUrl())) {
                    Log.e("clicked url", article.getUrl());
         //           Intent webActivity = new Intent(this,WebActivity.class);
           //         webActivity.putExtra("url",article.getUrl());
           //         startActivity(webActivity);
                }
                break;
        }
    }
}

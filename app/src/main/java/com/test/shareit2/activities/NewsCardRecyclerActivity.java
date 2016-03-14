package com.test.shareit2.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.test.shareit2.R;
import com.test.shareit2.adapters.NewsCardRecyclerAdapter;
import com.test.shareit2.repositories.GenerableRepository;
import com.test.shareit2.repositories.Repository;
import com.test.shareit2.utils.widgets.SpacesItemDecorator;

public class NewsCardRecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_card_list);

        initViews();
        initData();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        setRecyclerConfig(newConfig);
    }

    private void initViews() {
        mRecycler = (RecyclerView) findViewById(R.id.activity_card_list_recycler_view);
        setRecyclerConfig(getResources().getConfiguration());
        mRecycler.addItemDecoration(new SpacesItemDecorator(this, R.dimen.half_margin));
    }

    private void initData() {
        Repository repository = new GenerableRepository();
        mRecycler.setAdapter(new NewsCardRecyclerAdapter(this, repository.getNewsCardList()));
    }

    private void setRecyclerConfig(Configuration config) {
        if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            mRecycler.setLayoutManager(new GridLayoutManager(this, 2));
        } else if (config.orientation == Configuration.ORIENTATION_PORTRAIT){
            mRecycler.setLayoutManager(new LinearLayoutManager(this));
        }
    }
}

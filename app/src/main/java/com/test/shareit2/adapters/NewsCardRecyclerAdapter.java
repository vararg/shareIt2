package com.test.shareit2.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.test.shareit2.R;
import com.test.shareit2.models.NewsCard;

import java.util.List;


/**
 * Created by user on 13.03.2016.
 */
public class NewsCardRecyclerAdapter extends RecyclerView.Adapter<NewsCardRecyclerAdapter.NewsCardViewHolder>
        implements OnRecyclerItemClickListener {

    private Context mContext;
    private List<NewsCard> mNewsCards;

    public NewsCardRecyclerAdapter(Context context, List<NewsCard> newsCards) {
        mContext = context;
        mNewsCards = newsCards;
    }

    @Override
    public NewsCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_news_card, parent, false);

        return new NewsCardViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(NewsCardViewHolder holder, int position) {
        NewsCard newsCard = getItem(position);
        setTitleText(holder, newsCard.getTitle());
        setContentImage(holder, newsCard.getImageUrl());
        setSourceText(holder, newsCard.getSourceUrl());
    }

    @Override
    public int getItemCount() {
        return mNewsCards != null ? mNewsCards.size() : 0;
    }

    @Override
    public void onClick(View view, int position) {
        NewsCard newsCard = getItem(position);
        Toast.makeText(mContext, newsCard.getTitle(), Toast.LENGTH_SHORT).show();

        shareNews(newsCard);
    }

    public NewsCard getItem(int position) {
        return mNewsCards.get(position);
    }

    private void setTitleText(NewsCardViewHolder viewHolder, String title) {
        viewHolder.titleTextView.setText(title);
    }

    private void setContentImage(NewsCardViewHolder viewHolder, String imageUrl) {
        ImageView contentImageView = viewHolder.contentImageView;
        if (!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(mContext)
                    .load(imageUrl)
                    .placeholder(R.color.colorPrimary)
                    .into(contentImageView);
        } else {
            contentImageView.setImageResource(R.color.colorPrimary);
        }
    }

    private void setSourceText(NewsCardViewHolder viewHolder, String sourceUrl) {
        viewHolder.sourceTextView.setText(sourceUrl);
    }

    private void shareNews(NewsCard newsCard) {
        Intent shareIntent = ShareCompat.IntentBuilder.from((Activity) mContext)
                .setType("text/*")
                .setText(newsCard.getSourceUrl())
                .setSubject(newsCard.getTitle())
                .getIntent();
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        mContext.startActivity(shareIntent);
    }

    public static class NewsCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTextView;
        TextView sourceTextView;
        ImageView contentImageView;

        OnRecyclerItemClickListener itemClickListener;

        public NewsCardViewHolder(View itemView, OnRecyclerItemClickListener listener) {
            super(itemView);

            itemClickListener = listener;
            titleTextView = (TextView) itemView.findViewById(R.id.item_recycler_news_card_title_text_view);
            contentImageView = (ImageView) itemView.findViewById(R.id.item_recycler_news_card_content_image_view);
            sourceTextView = (TextView) itemView.findViewById(R.id.item_recycler_news_card_source_text_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onClick(view, getAdapterPosition());
            }
        }
    }
}

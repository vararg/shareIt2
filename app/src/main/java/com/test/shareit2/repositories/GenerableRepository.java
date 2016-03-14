package com.test.shareit2.repositories;

import com.test.shareit2.models.NewsCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14.03.2016.
 */
public class GenerableRepository implements Repository {

    private static List<String> mImageList;

    static {
        mImageList = new ArrayList<>();
        mImageList.add("http://i.telegraph.co.uk/multimedia/archive/02551/fuji_2551323b.jpg");
        mImageList.add("https://icons.wunderground.com/data/wximagenew/s/schmrkiewich/219.jpg");
        mImageList.add("http://darkbook.ru/Mesta1/41_pustynja/danakil6.jpg");
        mImageList.add("http://cdn.zmescience.com/wp-content/uploads/2015/12/Atlantic-Forest-South-East-Reserves.jpg");
    }

    @Override
    public List<NewsCard> getNewsCardList() {
        List<NewsCard> newsCards = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < 20; i++) {
            if (count >= mImageList.size()) count = 0;
            String photoUrl = mImageList.get(count);
            newsCards.add(new NewsCard("Topic №" + (i + 1), photoUrl, photoUrl));
            count++;
        }

        return newsCards;
    }

}

package com.test.shareit2.repositories;

import com.test.shareit2.models.NewsCard;

import java.util.List;

/**
 * Created by user on 14.03.2016.
 */
public interface Repository {
    List<NewsCard> getNewsCardList();
}

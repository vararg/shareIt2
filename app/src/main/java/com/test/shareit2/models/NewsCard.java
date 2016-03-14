package com.test.shareit2.models;

/**
 * Created by user on 13.03.2016.
 */
public class NewsCard {

    private String title;
    private String imageUrl;
    private String sourceUrl;

    public NewsCard(String title, String imageUrl, String sourceUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }
}

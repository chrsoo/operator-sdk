package com.richemont.dms.catalog.article;

public class ArticleBean implements Article {

    private String id;
    // private Trigram brand;
    private String title;
    private String description;
    private String ref;
    private String businessRef;

    // -- getters

    /*
    @Override
    public Trigram getBrand() {
        return brand;
    }
    */

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getRef() {
        return ref;
    }

    @Override
    public String getBusinessRef() {
        return businessRef;
    }

}

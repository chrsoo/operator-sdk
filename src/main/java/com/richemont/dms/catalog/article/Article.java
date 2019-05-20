package com.richemont.dms.catalog.article;

public interface Article {
    String getId();

    // Trigram getBrand();

    String getTitle();

    String getDescription();

    String getRef();

    String getBusinessRef();
}

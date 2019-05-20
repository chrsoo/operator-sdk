package com.richemont.dms.catalog.product;

import com.richemont.dms.catalog.Trigram;
import com.richemont.dms.catalog.article.Article;

import java.util.List;

public interface Product extends Article {
    List<Article> getSerials();
    Trigram getFamily();
    List<LocalData> getLocal();
}

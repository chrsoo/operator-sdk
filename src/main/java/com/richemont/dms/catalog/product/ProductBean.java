package com.richemont.dms.catalog.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.richemont.dms.catalog.Trigram;
import com.richemont.dms.catalog.article.Article;
import com.richemont.dms.catalog.article.ArticleBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductBean extends ArticleBean implements Product {

    public static ProductBean Load(InputStream stream) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(stream, ProductBean.class);
        } catch (IOException e) {
            throw new RuntimeException("Could not parse ProductBean resource", e);
        }
    }

    private Trigram family;
    private List<LocalData> local;
    private List<Article> serials;

    public Trigram getFamily() {
        return family;
    }

    public List<Article> getSerials() {
        return serials;
    }
    public List<LocalData> getLocal() {
        return local;
    }

}

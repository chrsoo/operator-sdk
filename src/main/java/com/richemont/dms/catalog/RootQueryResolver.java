package com.richemont.dms.catalog;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.richemont.dms.catalog.article.Article;
import com.richemont.dms.catalog.article.ArticleFilter;
import com.richemont.dms.catalog.product.Product;
import com.richemont.dms.catalog.product.ProductDaoMock;
import com.richemont.dms.catalog.product.ProductDataFilter;
import com.richemont.dms.catalog.watch.Watch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private ProductDaoMock productDao;

    public List<Article> articles(ArticleFilter article) {
        return new ArrayList<>();
    }
    public List<Product> products(ArticleFilter article, ProductDataFilter product) {
        return new ArrayList<>();
    }
    public List<Watch> watches(ArticleFilter article, ProductDataFilter product) {
        return new ArrayList<>();
    }

}

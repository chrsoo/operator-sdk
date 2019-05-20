package com.richemont.dms.catalog.product;

import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

/**
 * Mock implementation of the ProductDao interface
 */
//TODO move to test sources once we have a real implementation!
@Repository
public class ProductDaoMock implements ProductDao {

    private final ProductBean product = ProductBean.Load(ProductBean.class.getResourceAsStream("/product/BMM0A10119.json"));
    private final List<Product> products = Collections.singletonList(product);

    public List<Product> list(int count, int offset) {
        return products;
    }
}

package com.richemont.dms.catalog;

import com.richemont.dms.catalog.product.ProductBean;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class ProductBeanTest {

    @Test
    public void load() {
        InputStream stream = ProductBeanTest.class.getResourceAsStream("/product/BMM0A10119.json");
        ProductBean product = ProductBean.Load(stream);
        assertNotNull(product);
        assertEquals("watch", product.getTitle());
        assertEquals("Fancy watch", product.getDescription());
    }
}
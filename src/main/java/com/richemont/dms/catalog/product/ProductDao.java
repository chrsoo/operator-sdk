package com.richemont.dms.catalog.product;

import com.richemont.dms.catalog.DataAccessObject;

import java.util.List;

public interface ProductDao extends DataAccessObject<Product> {
    List<Product> list(int count, int offset);
}

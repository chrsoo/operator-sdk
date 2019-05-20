package com.richemont.dms.catalog.product;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalDataResolver implements GraphQLResolver<LocalData> {
    public List<Price> getPrices(LocalData data) {
        return null;
    }
}

package com.richemont.dms.catalog.product;

import com.richemont.dms.catalog.Trigram;

import java.math.BigDecimal;

public class PriceFilter {
    private String code;
    private Trigram currency;
    private BigDecimal min;
    private BigDecimal max;
}

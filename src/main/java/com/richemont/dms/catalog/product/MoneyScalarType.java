package com.richemont.dms.catalog.product;

import com.richemont.dms.catalog.Trigram;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MoneyScalarType extends GraphQLScalarType {
    public MoneyScalarType() {
        super("Money", "Monetary value with zero to four decimals",
                new Coercing<BigDecimal, String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        if (dataFetcherResult instanceof BigDecimal) {
                            return dataFetcherResult.toString();
                        }
                        throw new CoercingSerializeException("Could not serialize value of "
                                + dataFetcherResult.getClass());
                    }

                    @Override
                    public BigDecimal parseValue(Object input) throws CoercingParseValueException {
                        try {
                            return parseMoney(input.toString());
                        } catch(NumberFormatException nfe) {
                            throw new CoercingParseValueException("Could not parse the input as a Money value", nfe);
                        }
                    }

                    @Override
                    public BigDecimal parseLiteral(Object input) throws CoercingParseLiteralException {
                        try {
                            return parseMoney(input.toString());
                        } catch(NumberFormatException nfe) {
                            throw new CoercingParseLiteralException("Could not parse the value as a Money value", nfe);
                        }
                    }
                });
    }

    private static BigDecimal parseMoney(String value) {
        BigDecimal money = new BigDecimal(value);
        if(money.scale() > 4) {
            throw new NumberFormatException("Number of decimals is larger than 4");
        }
        return money;
    }
}

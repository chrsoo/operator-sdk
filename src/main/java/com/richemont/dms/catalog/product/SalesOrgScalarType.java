package com.richemont.dms.catalog.product;

import com.richemont.dms.catalog.Region;
import graphql.schema.*;
import org.springframework.stereotype.Component;

// TODO write a unit test for testing the SalesOrgScalarType validation
@Component
public class SalesOrgScalarType extends GraphQLScalarType {

    public SalesOrgScalarType() {
        super("SalesOrg", "SAP Gemini identifier for a Region and Brand defining a market",
                new Coercing<String,String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        return dataFetcherResult.toString();
                    }

                    @Override
                    public String parseValue(Object input) throws CoercingParseValueException {
                        try {
                            return parse(input);
                        } catch (IllegalArgumentException iae) {
                            throw new CoercingParseValueException("Could not parse SalesOrg", iae);
                        }
                    }

                    @Override
                    public String parseLiteral(Object input) throws CoercingParseLiteralException {
                        try {
                            return parse(input);
                        } catch (IllegalArgumentException iae) {
                            throw new CoercingParseLiteralException("Could not parse SalesOrg", iae);
                        }
                    }
                });
    }

    static String parse(Object input) throws IllegalArgumentException {
        String salesOrg = input.toString();
        if(salesOrg.length() != 4) {
            throw new IllegalArgumentException("SalesOrgs must have four characters");
        }

        if(!salesOrg.equals(salesOrg.toUpperCase())) {
            throw new IllegalArgumentException("SalesOrgs must be all upper case");
        }

        // Throws an illegal argument exception when not a valid region
        Region.valueOf(salesOrg.substring(0,2));

        // TODO validate the brand bigram
        return salesOrg;
    }
}

package com.richemont.dms.catalog;

import graphql.schema.*;
import org.springframework.stereotype.Component;

@Component
public class TrigramScalarType extends GraphQLScalarType {
    public TrigramScalarType() {
        super("Trigram", "Three upper case alpha numeric characters starting with a letter",
                new Coercing<Trigram,String>() {
                    @Override
                    public String serialize(Object dataFetcherResult) throws CoercingSerializeException {
                        if(dataFetcherResult instanceof Trigram) {
                            return dataFetcherResult.toString();
                        }

                        throw new CoercingSerializeException("Could not serialize value of "
                                + dataFetcherResult.getClass());
                    }

                    @Override
                    public Trigram parseValue(Object input) throws CoercingParseValueException {
                        try {
                            return new Trigram((String) input);
                        } catch(IllegalArgumentException iae) {
                            throw new CoercingSerializeException("Could not parse input as Trigram", iae);
                        }
                    }

                    @Override
                    public Trigram parseLiteral(Object input) throws CoercingParseLiteralException {
                        try {
                            return new Trigram(input.toString());
                        } catch(IllegalArgumentException iae) {
                            throw new CoercingParseLiteralException("Could not parse value as Trigram", iae);
                        }
                    }
                });
    }
}

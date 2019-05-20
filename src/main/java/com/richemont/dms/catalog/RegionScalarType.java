package com.richemont.dms.catalog;

import graphql.schema.*;
import org.springframework.stereotype.Component;

@Component
public class RegionScalarType extends GraphQLScalarType {
    public RegionScalarType() {
        super("Region",
                "ISO 3166-1 two letter region code for countries plus Richemont specific `WW` code.",
                new Coercing<Region,String>() {
                    @Override
                    public String serialize(Object o) throws CoercingSerializeException {
                        try {
                            return o.toString();
                        } catch(Exception e) {
                            throw new CoercingSerializeException("Could not load Region enum code", e);
                        }
                    }

                    @Override
                    public Region parseValue(Object o) throws CoercingParseValueException {
                        try {
                            return Region.valueOf(o.toString());
                        } catch(IllegalArgumentException e) {
                            throw new CoercingParseValueException("Could not load Region enum code", e);
                        }
                    }

                    @Override
                    public Region parseLiteral(Object o) throws CoercingParseLiteralException {
                        try {
                            return Region.valueOf(o.toString());
                        } catch(IllegalArgumentException e) {
                            throw new CoercingParseLiteralException("Could not load Region enum code", e);
                        }
                    }
                });
    }
}

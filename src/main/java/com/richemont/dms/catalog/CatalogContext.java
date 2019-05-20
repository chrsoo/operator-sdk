package com.richemont.dms.catalog;

import graphql.schema.GraphQLEnumType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogContext {

    /**
     * ISO 3166-1 two letter region code for countries plus Richemont specific <code>WW</code> code.
     *
     * @return the Region GraphQLEnumType bean
     */
    @Bean
    public GraphQLEnumType region() {

        GraphQLEnumType.Builder regionEnum = GraphQLEnumType.newEnum()
                .name("Region")
                .description("ISO 3166-1 two letter region code for countries plus Richemont specific `WW` code.");

        for (Region region : Region.values()) {
            regionEnum.value(region.name(), region, region.getShortName());
        }

        return regionEnum.build();
    }
}

package com.richemont.dms.catalog;

import com.coxautodev.graphql.tools.TypeDefinitionFactory;
import graphql.language.Definition;
import graphql.schema.GraphQLEnumType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CatalogTypeDefinitionFactory implements TypeDefinitionFactory {

    @Autowired
    private GraphQLEnumType regionEnumType;

    @Override
    public List<Definition<?>> create(final List<Definition<?>> existing) {

        List<Definition<?>> types = new ArrayList<>();
        types.add(regionEnumType.getDefinition());

        return types;
    }
}

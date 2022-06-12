package com.project.Shoes.util;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class EntityURLBuilder {
    public static String buildURL(final String entity, final String id){
        //devuelvo la url para seguir el formato rest
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{entity}/{id}")
                .buildAndExpand(entity,id)
                .toUriString();
    }
}

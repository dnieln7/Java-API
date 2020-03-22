package com.dnieln7.javaapi.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author dnieln7
 */
@ApplicationPath("resources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();

        resources.add(com.dnieln7.javaapi.service.FoodRest.class);
        resources.add(com.dnieln7.javaapi.service.StoreRest.class);

        return resources;
    }
}

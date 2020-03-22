package com.dnieln7.javaapi.service;

import com.dnieln7.javaapi.data.dao.DaoFood;
import com.dnieln7.javaapi.data.dao.IDao;
import com.dnieln7.javaapi.data.dto.DeleteResponse;
import com.dnieln7.javaapi.data.dto.Food;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author dnieln7
 */
@Path("food")
public class FoodRest {
    @Context
    private UriInfo context;
    private final IDao<Food, Integer> daoFood;

    public FoodRest() {
        daoFood = new DaoFood();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Food> get() {
        return daoFood.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Food getbyId(@PathParam("id") int id) {
        return daoFood.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Food post(Food food) {
        daoFood.insert(food);

        return food;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Food put(Food food) {
        daoFood.update(food);

        return food;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeleteResponse delete(@PathParam("id") int id) {
        if (daoFood.find(id) == null) {
            return new DeleteResponse(1, "Store not found!");
        }
        else {
            if (daoFood.delete(id)) {
                return new DeleteResponse(1, "Store deleted!");
            }

            return new DeleteResponse(0, "Error!");
        }
    }
}

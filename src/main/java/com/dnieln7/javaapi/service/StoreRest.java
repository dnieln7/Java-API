package com.dnieln7.javaapi.service;

import com.dnieln7.javaapi.data.dao.DaoStore;
import com.dnieln7.javaapi.data.dao.IDao;
import com.dnieln7.javaapi.data.dto.DeleteResponse;
import com.dnieln7.javaapi.data.dto.Store;
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
@Path("stores")
public class StoreRest {
    @Context
    private UriInfo context;
    private final IDao<Store, Integer> daoStore;

    public StoreRest() {
        daoStore = new DaoStore();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Store> get() {
        return daoStore.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Store getbyId(@PathParam("id") int id) {
        return daoStore.find(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Store post(Store store) {
        daoStore.insert(store);

        return store;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Store put(Store store) {
        daoStore.update(store);

        return store;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public DeleteResponse delete(@PathParam("id") int id) {
        if (daoStore.find(id) == null) {
            return new DeleteResponse(1, "Food not found!");
        }
        else {
            if (daoStore.delete(id)) {
                return new DeleteResponse(1, "Food deleted!");
            }

            return new DeleteResponse(0, "Error!");
        }
    }
}

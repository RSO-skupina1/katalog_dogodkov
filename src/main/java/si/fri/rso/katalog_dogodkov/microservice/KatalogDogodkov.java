package si.fri.rso.katalog_dogodkov.microservice;

import si.fri.rso.katalog_dogodkov.bean.DogodekBean;
import si.fri.rso.katalog_dogodkov.entity.Dogodek;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("katalog_dogodkov")
public class KatalogDogodkov {

    @Inject
    private DogodekBean dogodekBean;

    @GET
    public Response getAllEvents() {
        System.out.println("DELA");

        List<Dogodek> dogodki = dogodekBean.getEvents();
        
        return Response.ok(dogodki).build();
    }

    @GET
    @Path("/{dogodekId}")
    public Response getEvent(@PathParam("dogodekId") int dogodekId) {
        Dogodek dogodek = dogodekBean.getEvent(dogodekId);

        return Response.ok(dogodek).build();
    }

    @POST
    public Response saveEvent(Dogodek dogodek) {
        dogodekBean.saveEvent(dogodek);

        return Response.noContent().build();
    }

    @PUT
    public Response updateEvent(Dogodek dogodek) {
        dogodekBean.updateEvent(dogodek);

        return Response.ok().build();
    }

}

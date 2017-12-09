package si.fri.rso.katalog_dogodkov.rest;

import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;
import org.eclipse.microprofile.metrics.annotation.Metric;
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
@Log(LogParams.METRICS)
public class KatalogDogodkovREST {

    @Inject
    @Metric(name = "dogodekBean")
    private DogodekBean dogodekBean;

    @GET
    @Path("/test")
    public Response test() {
        return Response.ok("OK").build();
    }

    @GET
    public Response getAllEvents() {
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

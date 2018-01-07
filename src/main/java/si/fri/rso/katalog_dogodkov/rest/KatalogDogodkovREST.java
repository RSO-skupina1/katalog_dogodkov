package si.fri.rso.katalog_dogodkov.rest;

import com.kumuluz.ee.logs.cdi.Log;
import com.kumuluz.ee.logs.cdi.LogParams;
import org.eclipse.microprofile.metrics.annotation.Metric;
import si.fri.rso.katalog_dogodkov.bean.DogodekBean;
import si.fri.rso.katalog_dogodkov.entity.Dogodek;
import si.fri.rso.katalog_dogodkov.entity.Projekt;

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
    @Path("/info")
    public Response projekt() {

        Projekt projekt = new Projekt();
        projekt.setClani(new String[]{"db8913", "jk1234"});
        projekt.setOpisProjekta("Projekt implementira preprosto socialno omrežje");
        projekt.setMikrostoritve(new String[]{"http://169.51.21.133:30010/v1/katalog_dogodkov", "http://169.51.21.133:30011/v1/upravljanje_dogodkov"});
        projekt.setGithub(new String[]{"https://github.com/RSO-skupina1/katalog_dogodkov", "https://github.com/RSO-skupina1/upravljanje_dogodkov"});
        projekt.setTravis(new String[]{"https://travis-ci.org/RSO-skupina1/katalog_dogodkov", "https://travis-ci.org/RSO-skupina1/upravljanje_dogodkov"});
        projekt.setDockerhub(new String[]{"https://hub.docker.com/r/db8913/katalog_dogodkov", "https://hub.docker.com/r/db8913/upravljanje_dogodkov"});

        return Response.ok(projekt).build();

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

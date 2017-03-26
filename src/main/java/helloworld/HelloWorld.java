package helloworld; /**
 * Created by Chris on 20-Mar-17.
 */

import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/hello")
public class HelloWorld {

    JSONObject jObject = new JSONObject();
    JSONArray avg = new JSONArray();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMessage() {
        return "Hello w0rld!";
    }


@GET
@Path("/{nmr1}/{nmr2}")
public Response avg2(@PathParam("nmr1") double nr1, @PathParam("nmr2") double nr2) {

    if(nr1 <= 0 || nr2 <= 0){
        Response error = showError("Getal mag niet 0 of kleiner zijn", 500);
        return error;
    }

    double result = (nr1 + nr2) / 2;

    avg.put(result);

    System.out.println(result);
    jObject.put("resultaat van delen door 2", avg);

    return Response.status(Status.OK).entity(jObject.toString()).build();
}

    @GET
    @Path("/{nmr1}/{nmr2}/{nmr3}")
    public Response avg3(@PathParam("nmr1") int nr1, @PathParam("nmr2") int nr2, @PathParam("nmr3") int nr3) {
        if(nr1 <= 0 || nr2 <= 0 || nr3 <= 0){
            Response error = showError("Getal mag niet 0 of kleiner zijn", 500);
            return error;
        }

        double result = (nr1 + nr2 + nr3) / 3;

        avg.put(result);

        System.out.println(result);
        jObject.put("resultaat van delen door 3", avg);

        return Response.status(Status.OK).entity(jObject.toString()).build();
    }

    @GET
    @Path("/{nmr1}/{nmr2}/{nmr3}/{nmr4}")
    public Response avg4(@PathParam("nmr1") double nr1, @PathParam("nmr2") double nr2, @PathParam("nmr3") double nr3, @PathParam("nmr4") double nr4) {

        if(nr1 <= 0 || nr2 <= 0 || nr3 <= 0 || nr4 <= 0){
            Response error = showError("Getal mag niet 0 of kleiner zijn", 500);
            return error;
        }

        double result = (nr1 + nr2 + nr3 + nr4) / 4;

        avg.put(result);

        System.out.println(result);
        jObject.put("resultaat van delen door 4", avg);

        return Response.status(Status.OK).entity(jObject.toString()).build();
    }

    @GET
    @Path("/{nmr1}/{nmr2}/{nmr3}/{nmr4}/{nmr5}")
    public Response avg5(@PathParam("nmr1") double nr1, @PathParam("nmr2") double nr2, @PathParam("nmr3") double nr3, @PathParam("nmr4") double nr4, @PathParam("nmr5") double nr5) {

        if(nr1 <= 0 || nr2 <= 0 || nr3 <= 0 || nr4 <= 0 || nr5 <= 0){
            Response error = showError("Getal mag niet 0 of kleiner zijn", 500);
            return error;
        }

        double result = (nr1 + nr2 + nr3 + nr4 + nr5) / 5;

        avg.put(result);

        System.out.println(result);
        jObject.put("resultaat van delen door 5", avg);

        return Response.status(Status.OK).entity(jObject.toString()).build();
    }

    public Response showError(String message, int code){
        JSONObject jObject = new JSONObject();

        JSONArray error = new JSONArray();
        error.put(code);
        error.put(message);
        jObject.put("Error", error);

        return Response.status(Status.INTERNAL_SERVER_ERROR).entity(jObject.toString()).build();
    }

}
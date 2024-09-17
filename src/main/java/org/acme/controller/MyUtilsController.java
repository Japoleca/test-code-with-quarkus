package org.acme.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import org.acme.service.MyUtilsService;

@Path("/util")
public class MyUtilsController {

    @Inject
    MyUtilsService utilService;

    @GET
    @Path("/validate/prime/{number}")
    public Response verifyPrimeNumber(@PathParam("number") int number) {

        try{
            return Response.ok(utilService.isPrimeNumber(number)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/count/{text}")
    public Response verifyTextSize(@PathParam("text") String text) {

        try{
            return Response.ok(utilService.countCharacters(text)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }


}

package org.jc.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jc.controller.response.CommonResponse;
import org.jc.exception.CustomException;
import org.jc.model.Customer;
import org.jc.service.DataProcessingService;
import org.jc.service.FileReaderService;
import org.jc.util.ValidationHelper;

import java.util.List;

import static jakarta.ws.rs.core.Response.status;

@Path("/api")
public class DataController {

    @Inject
    DataProcessingService dataProcessingService;

    FileReaderService fileReaderService = new FileReaderService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("data/{fileName}")
    public Response getData(@PathParam("fileName") String fileName) {
        CommonResponse<Object> jsonResp = new CommonResponse<>();
        try{
            ValidationHelper.isEmptyOrNull(fileName);
            String data = fileReaderService.readFromCsv(fileName);
            List<Customer> customers = dataProcessingService.convertDataToList(data);
            jsonResp.setStatus(String.valueOf(Response.Status.OK.getStatusCode()));
            jsonResp.setData(customers);
            return Response.ok(jsonResp).build();
        }catch(CustomException e){
            jsonResp.setStatus(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
            jsonResp.setData(e.getMessage());
            return Response.accepted(jsonResp).build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("data/{fileName}/validate")
    public Response validateData(@PathParam("fileName") String fileName) {
        CommonResponse<String> jsonResp = new CommonResponse<>();
        try{
            ValidationHelper.isEmptyOrNull(fileName);
            String data = fileReaderService.readFromCsv(fileName);
            ValidationHelper.isNull(data);
            List<Customer> customers = dataProcessingService.convertDataToList(data);
            jsonResp.setStatus(String.valueOf(Response.Status.OK.getStatusCode()));
            jsonResp.setData(dataProcessingService.findDuplicateCustomer(customers));
            return Response.ok(jsonResp).build();
        }catch(CustomException e){
            jsonResp.setStatus(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
            jsonResp.setData(e.getMessage());
            return Response.accepted(jsonResp).build();
        }
    }
}

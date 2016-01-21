package org.apache.zeppelin.service;

import org.apache.zeppelin.server.JsonResponse;
import org.apache.zeppelin.service.common.DFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by zhanglei on 16-1-21.
 */

@Path("/df")
@Produces("application/json")
public class DFService {
    Logger logger = LoggerFactory.getLogger(DFService.class);

    public DFService() {}

    @GET
    @Path("/")
    public Response GetData() {
        return new JsonResponse(Response.Status.OK, "", DFUtils.getDFData().message()).build();
    }

    @GET
    @Path("{dfId}")
    public Response GetDFData(@PathParam("dfId") String dfId) {
        return new JsonResponse(Response.Status.OK, "", DFUtils.getDFData(dfId).message()).build();
    }
}
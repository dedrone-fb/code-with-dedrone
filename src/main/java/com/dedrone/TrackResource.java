package com.dedrone;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import java.util.List;

@Path("/track")
public class TrackResource {

    private final TrackService trackService;

    @Inject
    TrackResource(TrackService trackService) {
        this.trackService = trackService;
    }


    @GET
    public List<TrackPoint> list() {
        return trackService.list();
    }

    @POST
    public List<TrackPoint> add(TrackPoint trackPoint) {
        trackService.add(trackPoint);
        return trackService.list();
    }

    @DELETE
    public List<TrackPoint> delete(TrackPoint trackPoint) {
        trackService.delete(trackPoint);
        return trackService.list();
    }
}

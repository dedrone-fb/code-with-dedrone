package com.dedrone;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class TrackService {

    private List<TrackPoint> trackPoints = Collections.synchronizedList(new LinkedList<>());

    public void add(TrackPoint trackPoint) {
        trackPoints.add(trackPoint);
    }

    public List<TrackPoint> list() {
        return trackPoints;
    }

    public boolean delete(TrackPoint trackPoint) {
        return trackPoints.reversed().remove(trackPoint);
    }
}

package com.dedrone;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@QuarkusTest
@DisplayName("TrackResource should")
class TrackResourceTest {

    @Inject
    TrackService trackService;

    @Test
    @DisplayName("return a track")
    void initialTrack() {
        final List<TrackPoint> expected =
                List.of(new TrackPoint(51.311222, 9.537594), new TrackPoint(51.311024, 9.538154));
        expected.forEach(trackService::add);

        final List<TrackPoint> trackPoints = given().when()
                .get("/track")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(new TypeRef<List<TrackPoint>>() {});

        assertThat(trackPoints).containsAll(expected);
    }
}

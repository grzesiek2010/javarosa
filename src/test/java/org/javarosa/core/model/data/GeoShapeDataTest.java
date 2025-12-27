package org.javarosa.core.model.data;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeoShapeDataTest {
    @Test
    public void equals_comparesPoints() {
        GeoShapeData data = new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
            new double[]{0.0, 0.0, 0.0, 0.0},
            new double[]{1.0, 1.0, 0.0, 0.0}
        )));

        assertThat(data, equalTo(data));
        assertThat(
            data,
            equalTo(new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
                new double[]{0.0, 0.0, 0.0, 0.0},
                new double[]{1.0, 1.0, 0.0, 0.0}
            ))))
        );
        assertThat(
            data,
            not(equalTo(new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
                new double[]{0.0, 0.0, 0.0, 0.0},
                new double[]{2.0, 2.0, 0.0, 0.0}
            )))))
        );
    }

    @Test
    public void hashCode_isTheSameForTheSamePoints() {
        GeoShapeData data = new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
            new double[]{0.0, 0.0, 0.0, 0.0},
            new double[]{1.0, 1.0, 0.0, 0.0}
        )));

        assertThat(data.hashCode(), equalTo(data.hashCode()));
        assertThat(
            data.hashCode(),
            equalTo(new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
                new double[]{0.0, 0.0, 0.0, 0.0},
                new double[]{1.0, 1.0, 0.0, 0.0}
            ))).hashCode()));
        assertThat(
            data,
            not(equalTo(new GeoShapeData(new GeoShapeData.GeoShape(Arrays.asList(
                new double[]{0.0, 0.0, 0.0, 0.0},
                new double[]{2.0, 2.0, 0.0, 0.0}
            )))).hashCode())
        );
    }
}
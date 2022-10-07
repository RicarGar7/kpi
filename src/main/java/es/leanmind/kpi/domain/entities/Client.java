package es.leanmind.kpi.domain.entities;

import java.util.List;

public final class Client {
    public final String key;
    public final List<Reading> readings;

    public final Double median;

    public Client(String key, List<Reading> readings, Double median) {
        this.key = key;
        this.readings = readings;
        this.median = median;
    }
}

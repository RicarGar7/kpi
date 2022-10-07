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

//    public Double getMedian() {
//        Object[] clientReadingsValues = readings
//                .stream()
//                .map(reading -> reading.value).toArray();
//
//        Arrays.sort(clientReadingsValues);
//        double median;
//        if (clientReadingsValues.length % 2 == 0)
//            median = ((int)clientReadingsValues[clientReadingsValues.length/2] + (int)clientReadingsValues[clientReadingsValues.length/2 - 1])/2;
//        else
//            median = (int) clientReadingsValues[clientReadingsValues.length/2];
//        return median;
//    }
//
//    public List<Reading> getSuspiciousReadingsKpi() {
//        int defaultSuspiciousClientThreshold = 5000;
//        Double median = getMedian();
//        return readings
//                .stream()
//                .filter(reading ->
//                        median - defaultSuspiciousClientThreshold > reading.value
//                                || median + defaultSuspiciousClientThreshold < reading.value
//                )
//                .toList();
//    }
}

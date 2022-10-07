package es.leanmind.kpi.infrastructure.adapters.client.mappers;

import es.leanmind.kpi.infrastructure.adapters.client.entities.ClientEntity;
import es.leanmind.kpi.domain.entities.Client;
import es.leanmind.kpi.domain.entities.Reading;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientMapper {
    public List<Client> toSuspiciousClientCollection(List<ClientEntity> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(ClientEntity::getClient))
                .entrySet()
                .stream()
                .map(entry ->
                        {
                            List<Reading> clientReadings = entry.getValue()
                                    .stream()
                                    .map(value ->
                                            new Reading(
                                                    value.period,
                                                    Integer.parseInt(value.reading)
                                            )
                                    ).toList();
                            return new Client(
                                    entry.getKey(),
                                    this.getSuspiciousReadingsKpi(clientReadings),
                                    this.getMedian(clientReadings)
                            );
                        }
                ).toList();

    }

    private Double getMedian(List<Reading> readings) {
        Object[] clientReadingsValues = readings
                .stream()
                .map(reading -> reading.value).toArray();

        Arrays.sort(clientReadingsValues);
        double median;
        if (clientReadingsValues.length % 2 == 0)
            median = ((int) clientReadingsValues[clientReadingsValues.length / 2] + (int) clientReadingsValues[clientReadingsValues.length / 2 - 1]) / 2;
        else
            median = (int) clientReadingsValues[clientReadingsValues.length / 2];
        return median;
    }

    private List<Reading> getSuspiciousReadingsKpi(List<Reading> readings) {
        int defaultSuspiciousClientThreshold = 5000;
        Double median = getMedian(readings);
        return readings
                .stream()
                .filter(reading ->
                        median - defaultSuspiciousClientThreshold > reading.value
                                || median + defaultSuspiciousClientThreshold < reading.value
                )
                .toList();
    }
}

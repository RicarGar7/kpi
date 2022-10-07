package es.leanmind.kpi.infrastructure.adapters.client.mappers;

import es.leanmind.kpi.domain.entities.Client;
import es.leanmind.kpi.domain.entities.Reading;
import es.leanmind.kpi.infrastructure.adapters.client.entities.ClientEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ClientMapper {
    public static List<Client> toClientCollection(List<ClientEntity> collection) {
        return collection.stream()
                .collect(Collectors.groupingBy(ClientEntity::getClient))
                .entrySet()
                .stream()
                .map(entry ->
                        new Client(
                                entry.getKey(),
                                entry.getValue()
                                        .stream()
                                        .map(value ->
                                                new Reading(
                                                        value.period,
                                                        Integer.parseInt(value.reading)
                                                )
                                        ).toList()
                        )
                ).toList();

    }
}

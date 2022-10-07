package es.leanmind.kpi.infrastructure.adapters.client;

import es.leanmind.kpi.domain.entities.Client;
import es.leanmind.kpi.domain.ports.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static es.leanmind.kpi.infrastructure.adapters.client.deserializers.ClientReadingsDeserializer.fromResourceName;
import static es.leanmind.kpi.infrastructure.adapters.client.mappers.ClientMapper.toClientCollection;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    @Override
    public List<Client> findAll(String filename) {
        return toClientCollection(fromResourceName(filename));
    }
}

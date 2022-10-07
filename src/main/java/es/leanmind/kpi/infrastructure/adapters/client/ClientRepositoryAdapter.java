package es.leanmind.kpi.infrastructure.adapters.client;

import es.leanmind.kpi.domain.entities.Client;
import es.leanmind.kpi.domain.ports.ClientRepository;
import es.leanmind.kpi.infrastructure.adapters.client.mappers.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

import static es.leanmind.kpi.infrastructure.adapters.client.deserializers.ClientReadingsDeserializer.fromResourceName;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    private ClientMapper clientMapper;

    public ClientRepositoryAdapter(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @Override
    public List<Client> findAllSuspicious(String filename) {
        return clientMapper.toSuspiciousClientCollection(fromResourceName(filename));
    }
}

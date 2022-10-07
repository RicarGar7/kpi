package es.leanmind.kpi.application;

import es.leanmind.kpi.domain.entities.Client;
import es.leanmind.kpi.domain.ports.ClientRepository;
import es.leanmind.kpi.domain.queries.FindAllSuspiciousClientsQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientApplication {
    private final ClientRepository clientRepository;

    public ClientApplication(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAllSuspicious(FindAllSuspiciousClientsQuery query) {
        return clientRepository.findAllSuspicious(query.readingFilename);
    }
}

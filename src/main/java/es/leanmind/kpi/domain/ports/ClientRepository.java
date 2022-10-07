package es.leanmind.kpi.domain.ports;

import es.leanmind.kpi.domain.entities.Client;

import java.util.List;

public interface ClientRepository {
    List<Client> findAllSuspicious(String filename);
}

package es.leanmind.kpi.infrastructure.adapters.client.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "readings")
public final class ClientEntities {
    @JacksonXmlProperty(localName = "reading")
    public final List<ClientEntity> clients = null;

}

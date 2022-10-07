package es.leanmind.kpi.infrastructure.adapters.client.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public final class ClientEntity {
    @JacksonXmlProperty(isAttribute = true, localName = "clientID")
    public final String client = null;

    @JacksonXmlProperty(isAttribute = true, localName = "period")
    public final String period = null;

    @JacksonXmlText(value = true)
    public final String reading = null;

    public String getClient() {
        return client;
    }
}

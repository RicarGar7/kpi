package es.leanmind.kpi.infrastructure.adapters.client.deserializers;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import es.leanmind.kpi.infrastructure.adapters.client.entities.ClientEntities;
import es.leanmind.kpi.infrastructure.adapters.client.entities.ClientEntity;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClientReadingsDeserializer {

    private static ResourceLoader resourceLoader;

    public ClientReadingsDeserializer(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public static List<ClientEntity> fromResourceName(String filename) {
        Resource resource = resourceLoader.getResource("classpath:" + filename);

        String extension = FilenameUtils.getExtension(filename);

        switch (extension) {
            case "csv":
                CsvMapper csvMapper = new CsvMapper();
                CsvSchema csvSchema = csvMapper.schemaFor(ClientEntity.class).withHeader().withColumnSeparator(',');
                try {
                    return (List<ClientEntity>)(Object) csvMapper
                            .readerWithSchemaFor(ClientEntity.class)
                            .with(csvSchema)
                            .readValues(resource.getInputStream())
                            .readAll();
                } catch (IOException e) {
                    return new ArrayList();
                }
            case "xml":
                JacksonXmlModule xmlModule = new JacksonXmlModule();
                xmlModule.setDefaultUseWrapper(false);
                try {
                    return new XmlMapper(xmlModule).readValue(resource.getInputStream(), ClientEntities.class).clients;
                } catch (IOException e) {
                    return new ArrayList();
                }
            default:
                return new ArrayList();
        }
    }
}

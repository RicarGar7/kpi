package es.leanmind.kpi.domain.queries;

public final class FindAllClientsQuery {
    public final String readingFilename;

    public FindAllClientsQuery(String readingFilename) {
        this.readingFilename = readingFilename;
    }
}

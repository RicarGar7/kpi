package es.leanmind.kpi.domain.queries;

public final class FindAllSuspiciousClientsQuery {
    public final String readingFilename;

    public FindAllSuspiciousClientsQuery(String readingFilename) {
        this.readingFilename = readingFilename;
    }
}

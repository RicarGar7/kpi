package es.leanmind.kpi.domain.entities;

public final class Reading {
    public final String period;
    public final int value;

    public Reading(String period, Integer value) {
        this.period = period;
        this.value = value;
    }
}

package ru.onuchin.MTS.App.model;

import java.time.LocalDateTime;

public class Reading {
    private Long id;
    private LocalDateTime ts;
    private Integer value;

    public Reading(Long id, LocalDateTime ts, Integer value) {
        this.id = id;
        this.ts = ts;
        this.value = value;
    }

    public Reading() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public void setTs(LocalDateTime ts) {
        this.ts = ts;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

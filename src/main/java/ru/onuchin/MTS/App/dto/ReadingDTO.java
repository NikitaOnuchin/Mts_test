package ru.onuchin.MTS.App.dto;

import java.time.LocalDateTime;

public class ReadingDTO {
    private Long id;
    private LocalDateTime ts;
    private Integer value;

    public ReadingDTO(Long id, LocalDateTime ts, Integer value) {
        this.id = id;
        this.ts = ts;
        this.value = value;
    }

    public ReadingDTO() {
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

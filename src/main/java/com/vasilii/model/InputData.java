package com.vasilii.model;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"originalString"})
public class InputData {

    private LocalDate date;

    private LocalTime time;

    private String name;

    private String action;

    private String originalString;

    @Override
    public String toString() {
        return originalString;
    }
}

package com.prova.avaliacao.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum EstadoCivil {
    SOLTEIRO, CASADO, DIVORCIADO, VIUVO;

    @JsonCreator
    public static EstadoCivil from(String value) {
        return EstadoCivil.valueOf(value.toUpperCase());
    }
}



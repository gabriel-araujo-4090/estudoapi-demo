package edu.estudoapi.demo.dto;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class TaskRequest {

    private String title;
    private String description;
    private final Set<String> camposNaoPermitidos = new LinkedHashSet<>();

    public TaskRequest() {
    }

    @JsonAnySetter
    public void registrarCampoNaoPermitido(String campo, Object valor) {
        camposNaoPermitidos.add(campo);
    }

    public void validarCamposPermitidos() {
        if (camposNaoPermitidos.contains("id")) {
            throw new IllegalArgumentException("O campo 'id' não pode ser informado na criação");
        }
        if (camposNaoPermitidos.contains("completed")) {
            throw new IllegalArgumentException("O campo 'completed' não pode ser informado na criação");
        }
        if (!camposNaoPermitidos.isEmpty()) {
            throw new IllegalArgumentException(
                    "Campo(s) não permitido(s): " + String.join(", ", camposNaoPermitidos));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

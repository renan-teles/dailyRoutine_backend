package com.dailyroutine.dailyroutine.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public abstract class AbstractDTO {
    @Min(value = 0, message = "O ID não pode ser menor que 0.")
    private Integer id;

    @NotBlank(message = "O nome não pode ser nulo.")
    @Size(min = 1, message = "O nome não pode estar vazio")
    @Size(max = 100, message = "O nome é muito longo, máximo de 100 caracteres.")
    private String name;

    @NotBlank(message = "A descrição não pode ser nula.")
    @Size(min = 1, message = "A descrição não pode estar vazia.")
    @Size(max = 255, message = "A descrição é muito longa, máximo de 255 caracteres.")
    private String description;

    public AbstractDTO(){}

    public AbstractDTO(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public AbstractDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

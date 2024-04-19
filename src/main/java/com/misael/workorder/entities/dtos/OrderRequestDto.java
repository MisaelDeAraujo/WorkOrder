package com.misael.workorder.entities.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

/**
 * OrderRequestDto
 */
@Builder
public record OrderRequestDto(
    
    @NotNull(message = "Campo nome do cliente não pode ser nulo")
    @NotBlank(message = "Campo nome do cliente não pode ser vazio")
    @Length(max = 50, message = "Campo nome do cliente excedeu limite de caracteres")
    String ClientName,
    @NotNull(message = "Campo titulo não pode ser nulo")
    @NotBlank(message = "Campo titulo não pode ser vazio")
    @Length(max = 50, message = "Campo titulo excedeu limite de caracteres")
    String title,
    @NotNull(message = "Campo descrição não pode ser nulo")
    @NotBlank(message = "Campo descrição não pode ser vazio")
    String description
) {
}
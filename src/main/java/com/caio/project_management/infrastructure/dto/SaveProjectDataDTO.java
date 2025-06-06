package com.caio.project_management.infrastructure.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SaveProjectDataDTO {

    @NotNull(message = "Name cannot be empty")
    @Size(min = 1, max = 36, message = "Invalid name")
    private final String name;

    @NotNull(message = "Description cannot be empty")
    @Size(min = 1, max = 150, message = "Invalid description")
    private final String description;

    @NotNull(message = "Initial date cannot be empty")
    private final LocalDate initialDate;

    @NotNull(message = "Final date cannot be empty")
    private final LocalDate finalDate;

    private final String status;

    @AssertTrue(message = "Dates are not consistent")
    @SuppressWarnings("unused")
    public boolean isInitialDateBeforeFinalDate() {
        return initialDate.isBefore(finalDate);
    }
}

package com.makingbigger.portafoliojmc.infrastructure.exception.dto;

import java.time.LocalDateTime;

public record ErrorDetails (
    LocalDateTime timestamp,
    int status,
    String message
)
{}

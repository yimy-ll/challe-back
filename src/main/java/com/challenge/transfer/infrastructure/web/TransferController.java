package com.challenge.transfer.infrastructure.web;

import com.challenge.exception.domain.ErrorMessage;
import com.challenge.transfer.application.service.TransferService;
import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.infrastructure.TransferMapper;
import com.challenge.transfer.infrastructure.web.dto.TransferDto;
import com.challenge.utils.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
@Tag(name = "Transfer", description = "Transfer operations")
public class TransferController {
    private final TransferService transferService;
    private final TransferMapper transferMapper;

    @Operation(
            summary = "Crear una transferencia",
            description = "Crea una transferencia con los datos proporcionados."
    )
    @ApiResponse(
            responseCode = "201",
            description = "Tranferencia creada exitosamente",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = ResponseDto.class,
                    description = "Respuesta exitosa con la transferencia creada.",
                    example = "{\n" +
                            "  \"status\": \"success\",\n" +
                            "  \"message\": \"Empresa creada exitosamente\",\n" +
                            "  \"data\": {\n" +
                            "    \"id\": \"fcd846d1-350f-45cf-b881-799a7e319d62\",\n" +
                            "    \"amount\": \"1200.2\",\n" +
                            "    \"transferType\": \"Cuenta de Débito\",\n" +
                            "    \"dateTransfer\": \"2024-07-11T14:50:00\"\n" +
                            "  }\n" +
                            "}"
            ))
    )
    @ApiResponse(
            responseCode = "400",
            description = "Solicitud inválida",
            content = @Content(mediaType = "application/json", schema = @Schema(
                    implementation = ErrorMessage.class,
                    description = "Respuesta de error por solicitud inválida."
            ))
    )
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createCompany(@Valid @RequestBody TransferDto transferDto) {
        Transfer transfer = transferService.createTransfer(transferMapper.transferDtoToTransfer(transferDto));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ResponseDto.builder().status("success")
                        .message("Empresa creada exitosamente")
                        .data(transferMapper.transferToTransferDto(transfer))
                        .build());
    }

}
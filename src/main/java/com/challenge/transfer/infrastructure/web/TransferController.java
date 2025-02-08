package com.challenge.transfer.infrastructure.web;

import com.challenge.transfer.domain.TransferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
@Tag(name = "Transfer", description = "Transfer operations")
public class TransferController {
    private final TransferService transferService;
}
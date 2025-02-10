package com.challenge.transfer.infrastructure;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import com.challenge.transfer.infrastructure.web.dto.TransferDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TransferMapper {
    Transfer transferEntityToTransfer(TransferEntity transferEntity);

    TransferEntity transferToTransferEntity(Transfer transfer);

    TransferDto transferToTransferDto(Transfer transfer);

    Transfer transferDtoToTransfer(TransferDto transferDto);
}

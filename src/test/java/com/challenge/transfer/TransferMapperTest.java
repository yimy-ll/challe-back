package com.challenge.transfer;
import static org.junit.jupiter.api.Assertions.*;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferType;
import com.challenge.transfer.infrastructure.TransferMapper;
import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class TransferMapperTest {
    private final TransferMapper transferMapper = Mappers.getMapper(TransferMapper.class);

    @Test
    public void testTransferEntityToTransfer() {
        TransferEntity transferEntity = TransferEntity.builder()
                .id("test1")
                .amount(1000.0)
                .transferType(TransferType.CUENTA_DEBITO)
                .build();

        Transfer transfer = transferMapper.transferEntityToTransfer(transferEntity);

        assertNotNull(transfer);
        assertEquals(transferEntity.getId(), transfer.getId());
        assertEquals(transferEntity.getAmount(), transfer.getAmount());
        assertEquals(transferEntity.getTransferType(), transfer.getTransferType());
    }

    @Test
    public void testTransferToTransferEntity() {
        Transfer transfer = Transfer.builder()
                .id("test1")
                .amount(1000.0)
                .transferType(TransferType.CUENTA_DEBITO)
                .build();

        TransferEntity transferEntity = transferMapper.transferToTransferEntity(transfer);

        assertNotNull(transfer);
        assertEquals(transferEntity.getId(), transfer.getId());
        assertEquals(transferEntity.getAmount(), transfer.getAmount());
        assertEquals(transferEntity.getTransferType(), transfer.getTransferType());
    }
}
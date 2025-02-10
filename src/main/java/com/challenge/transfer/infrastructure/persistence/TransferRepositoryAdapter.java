package com.challenge.transfer.infrastructure.persistence;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferRepository;
import com.challenge.transfer.infrastructure.TransferMapper;
import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransferRepositoryAdapter implements TransferRepository {
    private final PostgreSQLTransferRepository postgreSQLTransferRepository;
    private final TransferMapper transferMapper;

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity updatedTransferEntity = transferMapper.transferToTransferEntity(transfer);
        updatedTransferEntity = postgreSQLTransferRepository.save(updatedTransferEntity);
        return transferMapper.transferEntityToTransfer(updatedTransferEntity);
    }

    @Override
    public List<Transfer> findAll() {
        return postgreSQLTransferRepository.findAll().stream()
                .map(transferMapper::transferEntityToTransfer)
                .toList();
    }
}

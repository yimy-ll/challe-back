package com.challenge.transfer.infrastructure.persistence;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferRepository;
import com.challenge.transfer.infrastructure.TransferMapper;
import com.challenge.transfer.infrastructure.persistence.entity.TransferEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RepositoryAdapter implements TransferRepository {
    private final PostgreSQLTransferRepository postgreSQLTransferRepository;
    private final TransferMapper transferMapper;

    @Override
    public Transfer save(Transfer transfer) {
        TransferEntity updatedTransferEntity = transferMapper.transferToTransferEntity(transfer);
        updatedTransferEntity = postgreSQLTransferRepository.save(updatedTransferEntity);
        return transferMapper.transferEntityToTransfer(updatedTransferEntity);
    }

    @Override
    public Optional<Transfer> findById(String id) {
        Optional<TransferEntity> transferEntity = postgreSQLTransferRepository.findById(id);
        return transferEntity.map(transferMapper::transferEntityToTransfer);
    }

    @Override
    public Transfer update(Transfer transfer) {
        return this.save(transfer);
    }

    @Override
    public void deleteById(String id) {
        postgreSQLTransferRepository.deleteById(id);
    }

    @Override
    public List<Transfer> findAll() {
        return postgreSQLTransferRepository.findAll().stream()
                .map(transferMapper::transferEntityToTransfer)
                .toList();
    }
}

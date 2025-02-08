package com.challenge.transfer.application;

import com.challenge.transfer.domain.Transfer;
import com.challenge.transfer.domain.TransferRepository;
import com.challenge.transfer.domain.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransferServiceImpl implements TransferService {

    private final TransferRepository transferRepository;

    @Override
    public Transfer update(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> findAll() {
        return transferRepository.findAll();
    }

    @Override
    public Transfer findById(String id) {
        return transferRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
        transferRepository.deleteById(id);
    }
}
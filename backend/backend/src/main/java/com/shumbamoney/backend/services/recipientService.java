package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.recipientDto;
import com.shumbamoney.backend.exceptions.recipientNotFound;
import com.shumbamoney.backend.models.recipient;
import com.shumbamoney.backend.repo.recipientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor

public class recipientService {
    @Autowired

    private final recipientRepo _recipientRepo;

    // Save Recipient
    public recipient save (recipientDto _recipient) {
        recipient recipient1 = recipient.builder()
                .recipientName(_recipient.getRecipientName())
                .recipientEmail(_recipient.getRecipientEmail())
                .recipientAddress(_recipient.getRecipientAddress())
                .recipientCell(_recipient.getRecipientCell())
                .recipientCountry(_recipient.getRecipientCountry())
                .recipientTown(_recipient.getRecipientTown())
                .build();
        return _recipientRepo.save(recipient1);
    }

    // Get All Recipients
    public List<recipient> getRecipients() {

        return _recipientRepo.findAll();
    }
    // Get Specific Recipient
    public recipient getRecipient(Long id) {
        return _recipientRepo.findById(id)
                .orElseThrow(() -> new recipientNotFound("No Recipients Found"));
    }

    // Delete Recipient
    public recipient deleteRecipient (Long id) {
        _recipientRepo.deleteAllById(Collections.singleton(id));
        return  null;
    }
}

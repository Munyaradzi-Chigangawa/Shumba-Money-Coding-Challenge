package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.RecipientDto;
import com.shumbamoney.backend.exceptions.RecipientNotFound;
import com.shumbamoney.backend.models.Recipient;
import com.shumbamoney.backend.repo.RecipientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor

public class RecipientService {
    @Autowired

    private final RecipientRepo recipientRepo;

    // Save Recipient
    public Recipient save (RecipientDto _recipient) {
        Recipient recipient1 = Recipient.builder()
                .recipientName(_recipient.getRecipientName())
                .recipientEmail(_recipient.getRecipientEmail())
                .recipientAddress(_recipient.getRecipientAddress())
                .recipientCell(_recipient.getRecipientCell())
                .recipientCountry(_recipient.getRecipientCountry())
                .recipientTown(_recipient.getRecipientTown())
                .build();
        return recipientRepo.save(recipient1);
    }

    // Get All Recipients
    public List<Recipient> getRecipients() {

        return recipientRepo.findAll();
    }
    // Get Specific Recipient
    public Recipient getRecipient(Long id) {
        return recipientRepo.findById(id)
                .orElseThrow(() -> new RecipientNotFound("No Recipients Found"));
    }

    // Delete Recipient
    public Recipient deleteRecipient (Long id) {
        recipientRepo.deleteAllById(Collections.singleton(id));
        return  null;
    }

    // Update Recipient

//    public void updateRecipient (recipientDto _recipient) {
//        recipient recipient1 = _recipientRepo.findById;
//
//        return _recipientRepo.save(recipient);
//    }
}

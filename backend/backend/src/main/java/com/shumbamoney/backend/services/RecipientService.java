package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.RecipientDto;
import com.shumbamoney.backend.exceptions.DataNotFoundException;
import com.shumbamoney.backend.models.Recipient;
import com.shumbamoney.backend.models.Sender;
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
    private final SenderService senderService;

    // Save Recipient
    public Recipient save (RecipientDto recipient, Long senderId) {

        Sender sender = senderService.findById(senderId);


        Recipient recipient1 = Recipient.builder()
                .recipientName(recipient.getRecipientName())
                .recipientMaidenName(recipient.getRecipientMaidenName())
                .recipientSurname(recipient.getRecipientSurname())
                .recipientEmail(recipient.getRecipientEmail())
                .sender(sender)
                .recipientAddress(recipient.getRecipientAddress())
                .recipientCell(recipient.getRecipientCell())
                .recipientCountry(recipient.getRecipientCountry())
                .recipientTown(recipient.getRecipientTown())
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
                .orElseThrow(() -> new DataNotFoundException("No Recipients Found"));
    }

    // Delete Recipient
    public Recipient deleteRecipient (Long id) {
        recipientRepo.deleteAllById(Collections.singleton(id));
        return  null;
    }

    // Update Recipient
    public Recipient updateRecipient (RecipientDto recipientDto, Long id) {
        Recipient recipient = recipientRepo.findById(id)
                .orElseThrow(() -> new DataNotFoundException("No Recipients Found"));
        recipient.setRecipientName(recipientDto.getRecipientName());
        recipient.setRecipientMaidenName(recipient.getRecipientMaidenName());
        recipient.setRecipientSurname(recipientDto.getRecipientSurname());
        recipient.setRecipientEmail(recipientDto.getRecipientEmail());
        recipient.setRecipientAddress(recipientDto.getRecipientAddress());
        recipient.setRecipientCell(recipientDto.getRecipientCell());
        recipient.setRecipientCountry(recipientDto.getRecipientCountry());
        recipient.setRecipientTown(recipientDto.getRecipientTown());
        return recipientRepo.save(recipient);
    }

    public List<Recipient> getRecipients(long senderId) {

        Sender sender = senderService.findById(senderId);
        return recipientRepo.getRecipientBySender(sender);

    }


//    public void updateRecipient (RecipientDto recipient) {
//        recipient recipient1 = recipientRepo.findById;
//
//        return RecipientRepo.save(recipient);
//    }
}

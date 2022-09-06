package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.SenderDto;
import com.shumbamoney.backend.exceptions.DataNotFoundException;
import com.shumbamoney.backend.models.Sender;
import com.shumbamoney.backend.repo.SenderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor

public class SenderService {

    @Autowired
    private final SenderRepo senderRepo;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();

    public Sender save (SenderDto sender) {
        sender.setToken(generateToken());
        Sender sender1 = Sender.builder()
                .senderName(sender.getSenderName())
                .senderAddress(sender.getSenderAddress())
                .senderCell(sender.getSenderCell())
                .senderCountry(sender.getSenderCountry())
                .senderEmail(sender.getSenderEmail())
                .senderTown(sender.getSenderTown())
                .password(sender.getPassword())
                .token(sender.getToken())
                .build();

        return senderRepo.save(sender1);
    }

    private String generateToken() {
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }

    public Sender login(SenderDto sender) {
        Sender existingSender = senderRepo.findSenderBySenderEmail(sender.getSenderEmail()).orElse(null);
        assert existingSender != null;
        if (
            existingSender.getSenderEmail().equals(sender.getSenderEmail()) &&
                    existingSender.getPassword().equals(sender.getPassword())
        ) {
            existingSender.setPassword("");
            return existingSender;
        }
        return null;
    }

    public Sender findById(Long senderId) {
        return senderRepo.findById(senderId).orElseThrow(()-> new DataNotFoundException("Sender with ID "+senderId+" was not found"));
    }

    // Get All Senders
    public List<Sender> getSenders() {
        return senderRepo.findAll();
    }

}

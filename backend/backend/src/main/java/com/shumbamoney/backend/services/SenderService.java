package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.SenderDto;
import com.shumbamoney.backend.models.Sender;
import com.shumbamoney.backend.repo.SenderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;

@Transactional
@Service
@RequiredArgsConstructor

public class SenderService {

    @Autowired
    private final SenderRepo senderRepo;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();

    public Sender save (SenderDto _sender) {
        _sender.setToken(generateToken());
        Sender sender1 = Sender.builder()
                .senderName(_sender.getSenderName())
                .senderAddress(_sender.getSenderAddress())
                .senderCell(_sender.getSenderCell())
                .senderCountry(_sender.getSenderCountry())
                .senderEmail(_sender.getSenderEmail())
                .senderTown(_sender.getSenderTown())
                .password(_sender.getPassword())
                .token(_sender.getToken())
                .build();

        return senderRepo.save(sender1);
    }

    private String generateToken() {
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }

    public Sender login(Sender _sender) {
        Sender existingSender = senderRepo.findById(_sender.getSenderEmail()).orElse(null);
        assert existingSender != null;
        if (
            existingSender.getSenderEmail().equals(_sender.getSenderEmail()) &&
                    existingSender.getPassword().equals(_sender.getPassword())
        ) {
            existingSender.setPassword("");
            return existingSender;
        }
        return null;
    }

}

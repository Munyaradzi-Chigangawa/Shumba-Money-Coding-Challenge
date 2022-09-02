package com.shumbamoney.backend.services;
import com.shumbamoney.backend.d.t.o.senderDto;
import com.shumbamoney.backend.models.sender;
import com.shumbamoney.backend.repo.senderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;

@Transactional
@Service
@RequiredArgsConstructor

public class senderService {

    @Autowired
    private final senderRepo _senderRepo;
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64encoder = Base64.getUrlEncoder();

    public sender save (senderDto _sender) {
        _sender.setToken(generateToken());
        sender sender1 = sender.builder()
                .senderName(_sender.getSenderName())
                .senderAddress(_sender.getSenderAddress())
                .senderCell(_sender.getSenderCell())
                .senderCountry(_sender.getSenderCountry())
                .senderEmail(_sender.getSenderEmail())
                .senderTown(_sender.getSenderTown())
                .password(_sender.getPassword())
                .token(_sender.getToken())
                .build();

        return _senderRepo.save(sender1);
    }

    private String generateToken() {
        byte[] token = new byte[24];
        secureRandom.nextBytes(token);
        return base64encoder.encodeToString(token);

    }
    private boolean checkSenderExist(sender _sender) {
        sender existingSender = _senderRepo.findById(_sender.getSenderEmail()).orElse(null);

        return existingSender != null;
    }

    public sender login(sender _sender) {
        sender existingSender = _senderRepo.findById(_sender.getSenderEmail()).orElse(null);
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

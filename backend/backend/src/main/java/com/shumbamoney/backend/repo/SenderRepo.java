package com.shumbamoney.backend.repo;
import com.shumbamoney.backend.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SenderRepo extends JpaRepository <Sender, Long> {
    Optional<Sender> findSenderBySenderEmail(String email);

}

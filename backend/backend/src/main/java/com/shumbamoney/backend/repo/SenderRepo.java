package com.shumbamoney.backend.repo;
import com.shumbamoney.backend.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SenderRepo extends JpaRepository <Sender, Long> {
    Sender findSenderBySenderEmail(String email);

}

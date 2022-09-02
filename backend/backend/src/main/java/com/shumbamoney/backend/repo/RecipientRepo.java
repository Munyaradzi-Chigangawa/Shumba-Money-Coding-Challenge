package com.shumbamoney.backend.repo;
import com.shumbamoney.backend.models.Recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepo extends JpaRepository <Recipient, Long> {
}

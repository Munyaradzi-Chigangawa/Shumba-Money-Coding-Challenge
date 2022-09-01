package com.shumbamoney.backend.repo;
import com.shumbamoney.backend.models.recipient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface recipientRepo extends JpaRepository <recipient, String> {
}

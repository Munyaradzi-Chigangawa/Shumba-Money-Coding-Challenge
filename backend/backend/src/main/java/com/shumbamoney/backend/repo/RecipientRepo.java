package com.shumbamoney.backend.repo;
import com.shumbamoney.backend.models.Recipient;
import com.shumbamoney.backend.models.Sender;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipientRepo extends JpaRepository <Recipient, Long> {

    List<Recipient> getRecipientBySender(Sender sender);
}

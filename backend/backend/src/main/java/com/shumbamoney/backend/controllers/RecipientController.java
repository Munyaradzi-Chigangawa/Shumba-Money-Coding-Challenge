package com.shumbamoney.backend.controllers;

import com.shumbamoney.backend.d.t.o.RecipientDto;
import com.shumbamoney.backend.models.Recipient;
import com.shumbamoney.backend.services.RecipientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Slf4j
public class RecipientController {

    private final RecipientService recipientService;

    // Create Endpoint
    @PostMapping( value = "/addRecipient")
    public ResponseEntity<Recipient> addRecipient (@RequestBody RecipientDto recipient,@RequestParam Long senderId) {
        log.info("Recipient Added.");
        return new ResponseEntity<>(recipientService.save(recipient,senderId), HttpStatus.CREATED);
    }

    // Read All Endpoint
    @GetMapping( value = "/getRecipients")
    public ResponseEntity<List<Recipient>> getRecipients(@RequestParam long senderId) {
        log.info("Recipients Retrieved.");
        return new ResponseEntity<>(recipientService.getRecipients(senderId), HttpStatus.OK);
    }


    // Read Specific Record Endpoint
    @GetMapping( value = "/getRecipient/{id}")
    public ResponseEntity<Recipient> getRecipient(@PathVariable Long id) {
        log.info("Recipient Retrieved");
        return new ResponseEntity<>(recipientService.getRecipient(id), HttpStatus.OK);
    }

    // Delete Endpoint
    @DeleteMapping( value = "/deleteRecipient/{id}")
    public ResponseEntity<Recipient> deleteRecipient (@PathVariable Long id) {
        log.info("Recipient Deleted.");
        return new ResponseEntity<>(recipientService.deleteRecipient(id), HttpStatus.OK);
    }

    // Update Endpoint
    @PutMapping( value = "/updateRecipient/{id}")
    public ResponseEntity<Recipient> updateRecipient (@PathVariable Long id, @RequestBody RecipientDto recipient, @RequestParam Long senderId) {
        log.info("Recipient Updated.");
        return new ResponseEntity<>(recipientService.updateRecipient(recipient, id), HttpStatus.OK);
    }

}

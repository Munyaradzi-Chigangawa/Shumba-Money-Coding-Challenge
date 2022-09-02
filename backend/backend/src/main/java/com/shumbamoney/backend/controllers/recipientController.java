package com.shumbamoney.backend.controllers;

import com.shumbamoney.backend.d.t.o.recipientDto;
import com.shumbamoney.backend.models.recipient;
import com.shumbamoney.backend.services.recipientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Slf4j
public class recipientController {

    private final recipientService _recipientService;

    // Create Endpoint
    @PostMapping( value = "/addRecipient")
    public ResponseEntity<recipient> addRecipient (@RequestBody recipientDto recipient) {
        log.info("Recipient Added.");
        return new ResponseEntity<>(_recipientService.save(recipient), HttpStatus.CREATED);
    }

    // Read All Endpoint
    @GetMapping( value = "/getRecipients")
    public ResponseEntity<List<recipient>> getRecipients() {
        log.info("Recipients Retrieved.");
        return new ResponseEntity<>(_recipientService.getRecipients(), HttpStatus.OK);
    }

    // Read Specific Record Endpoint
    @GetMapping( value = "/getRecipient/{id}")
    public ResponseEntity<recipient> getRecipient(@PathVariable Long id) {
        log.info("Recipient Retrieved");
        return new ResponseEntity<>(_recipientService.getRecipient(id), HttpStatus.OK);
    }

    // Delete Endpoint
    @DeleteMapping( value = "/deleteRecipient/{id}")
    public ResponseEntity<recipient> deleteRecipient (@PathVariable Long id) {
        log.info("Recipient Deleted.");
        return new ResponseEntity<>(_recipientService.deleteRecipient(id), HttpStatus.OK);
    }

    // Update Endpoint
//    @PutMapping( value = "/updateRecepient/{id}")
//    public ResponseEntity<recipient> updateRecipient (@PathVariable Long id) {
//
//    }



}

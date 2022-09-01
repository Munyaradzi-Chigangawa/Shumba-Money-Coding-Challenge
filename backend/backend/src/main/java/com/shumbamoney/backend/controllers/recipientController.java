package com.shumbamoney.backend.controllers;

import com.shumbamoney.backend.d.t.o.recipientDto;
import com.shumbamoney.backend.models.recipient;
import com.shumbamoney.backend.services.recipientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@CrossOrigin(value = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@Slf4j
public class recipientController {

    private final recipientService _recipientService;

    @PostMapping( value = "/addRecipient")
    public ResponseEntity<recipient> addRecipient (@RequestBody recipientDto recipient) {
        log.info("Recipient Added.");
        return new ResponseEntity<>(_recipientService.save(recipient), HttpStatus.CREATED);
    }

}

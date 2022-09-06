package com.shumbamoney.backend.controllers;
import com.shumbamoney.backend.d.t.o.SenderDto;
import com.shumbamoney.backend.models.Sender;
import com.shumbamoney.backend.services.SenderService;
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

public class SenderController {

    private final SenderService senderService;

    // Create Sender Endpoint
    @PostMapping( value = "/addSender")
    public ResponseEntity <Sender> addSender (@RequestBody SenderDto sender) {
        log.info("Sender Added.");
        return new ResponseEntity<>(senderService.save(sender), HttpStatus.CREATED);
    }

    // Login Endpoint
    @PostMapping( value = "/login")
    public ResponseEntity <Sender> login (@RequestBody SenderDto sender) {
        log.info("Sender Logged In.");
        return new ResponseEntity<>(senderService.login(sender), HttpStatus.OK);
    }

    // Read All Endpoint
    @GetMapping( value = "/getSenders")
    public ResponseEntity <List<Sender>> getSenders() {
        log.info("Senders Retrieved.");
        return new ResponseEntity<>(senderService.getSenders(), HttpStatus.OK);
    }
    
    // @PostMapping( value = "/login")
    // public Sender login (@RequestBody Sender sender) {
    //     log.info("Sender Logged in.");
    //     return senderService.login(sender);
    // }

}

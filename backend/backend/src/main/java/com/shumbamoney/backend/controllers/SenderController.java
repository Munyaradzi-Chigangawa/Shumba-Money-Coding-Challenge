package com.shumbamoney.backend.controllers;
import com.shumbamoney.backend.d.t.o.SenderDto;
import com.shumbamoney.backend.models.Sender;
import com.shumbamoney.backend.services.SenderService;
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

public class SenderController {

    private final SenderService senderService;

    @PostMapping( value = "/addSender")
    public ResponseEntity <Sender> addSender (@RequestBody SenderDto sender) {
        log.info("Sender Added.");
        return new ResponseEntity<>(senderService.save(sender), HttpStatus.CREATED);
    }

    @PostMapping( value = "/login")
    public Sender login (@RequestBody Sender sender) {
        log.info("Sender Logged in.");
        return senderService.login(sender);
    }

}
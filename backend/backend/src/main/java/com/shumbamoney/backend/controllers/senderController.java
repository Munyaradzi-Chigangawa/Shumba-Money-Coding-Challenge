package com.shumbamoney.backend.controllers;
import com.shumbamoney.backend.d.t.o.senderDto;
import com.shumbamoney.backend.models.sender;
import com.shumbamoney.backend.services.senderService;
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

public class senderController {

    private final senderService _senderService;

    @PostMapping( value = "/addSender")
    public ResponseEntity <sender> addSender (@RequestBody senderDto sender) {
        log.info("Sender Added.");
        return new ResponseEntity<>(_senderService.save(sender), HttpStatus.CREATED);
    }

    @PostMapping( value = "/login")
    public sender login (@RequestBody sender _sender) {
        log.info("Sender Logged in.");
        return _senderService.login(_sender);
    }

}

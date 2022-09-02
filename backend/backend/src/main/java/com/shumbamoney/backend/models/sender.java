package com.shumbamoney.backend.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "senders")
@Builder

// Sender Model
public class sender {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(length = 100)
    private Long senderId;
    @Column(name = "sender_name", columnDefinition = "varchar(255)")
    private String senderName;
    private String senderEmail;
    private String senderAddress;
    private String password;
    private String senderCell;
    private String senderCountry;
    private  String senderTown;
}

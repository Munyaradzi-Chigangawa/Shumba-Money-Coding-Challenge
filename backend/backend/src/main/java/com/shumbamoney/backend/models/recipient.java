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
@Table(name = "recipients")
@Builder


// Recipient Model
public class recipient {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(length = 100)
    private Long recipientId;
    @Column(name = "recipient_name", columnDefinition = "varchar(255)")
    private String recipientName;
    private String recipientEmail;
    private String recipientAddress;
    private String recipientCell;
    private String recipientCountry;
    private  String recipientTown;

}

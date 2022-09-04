package com.shumbamoney.backend.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Recipient {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(length = 100)
    private Long recipientId;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "sender_id", foreignKey = @ForeignKey(name = "sender_id_fk"),referencedColumnName = "sender_id")
    private Sender sender;
    @Column(name = "recipient_name", columnDefinition = "varchar(255)")
    private String recipientName;
    private String recipientMaidenName;
    private String recipientSurname;
    private String recipientEmail;
    private String recipientAddress;
    private String recipientCell;
    private String recipientCountry;
    private String recipientTown;

}

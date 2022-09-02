package com.shumbamoney.backend.d.t.o;
import java.io.Serializable;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class senderDto implements Serializable {
    private String senderName;
    private String senderEmail;
    private String senderAddress;
    private String password;
    private String senderCell;
    private String senderCountry;
    private  String senderTown;
}

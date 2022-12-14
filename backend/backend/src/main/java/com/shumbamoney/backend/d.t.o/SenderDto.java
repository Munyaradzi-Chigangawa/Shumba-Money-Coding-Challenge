package com.shumbamoney.backend.d.t.o;
import java.io.Serializable;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class SenderDto implements Serializable {
    @NotEmpty(message = "Name Required.")
    private String senderName;
    @NotEmpty(message = "Email Required.")
    private String senderEmail;
    @NotEmpty(message = "Address Required.")
    private String senderAddress;
    @NotEmpty(message = "Password Required.")
    private String senderPassword;
    @NotEmpty(message = "Phone Number Required.")
    private String senderCell;
    @NotEmpty(message = "Country Required.")
    private String senderCountry;
    @NotEmpty(message = "Town Required.")
    private String senderTown;
    private String token;
}

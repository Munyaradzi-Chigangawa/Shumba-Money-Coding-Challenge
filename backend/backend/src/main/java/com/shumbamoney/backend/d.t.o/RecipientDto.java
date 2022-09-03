package com.shumbamoney.backend.d.t.o;
import lombok.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class RecipientDto implements Serializable {
    @NotEmpty(message = "Name Required.")
    private String recipientName;
    @NotEmpty(message = "Email Required.")
    private String recipientEmail;
    @NotEmpty(message = "Address Required.")
    private String recipientAddress;
    @NotEmpty(message = "Phone Number Required.")
    private String recipientCell;
    @NotEmpty(message = "Country Required.")
    private String recipientCountry;
    @NotEmpty(message = "Town Required.")
    private String recipientTown;
}

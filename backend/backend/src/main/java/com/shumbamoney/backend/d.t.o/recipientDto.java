package com.shumbamoney.backend.d.t.o;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class recipientDto implements Serializable {
//    @NotEmpty(message = "")
    private String recipientName;
    private String recipientEmail;
    private String recipientAddress;
    private String recipientCell;
    private String recipientCountry;
    private  String recipientTown;
}

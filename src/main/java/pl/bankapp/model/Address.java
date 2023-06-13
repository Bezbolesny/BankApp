package pl.bankapp.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String postCode;
    private String city;
    private String street;

}

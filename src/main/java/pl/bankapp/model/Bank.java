package pl.bankapp.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Bank {

    private final String name;
    private List<Customer> customers = new ArrayList<>();

}

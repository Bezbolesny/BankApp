package pl.bankapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bankapp.exception.NotFoundException;
import pl.bankapp.mapper.CSVMapper;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private int age;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String pesel;
    private Address address;
    private LocalDate dateOfBirth;
    private UUID id = UUID.randomUUID();

    @Builder.Default
    private List<Account> accounts = new ArrayList<>();

    public Customer(String name, String surname, String phone, String email,
                    String pesel, Address address, LocalDate dateOfBirth)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.pesel = pesel;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.accounts = new ArrayList<>();
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public boolean addAccount(Account account) {
        return accounts.add(account);
    }

    public boolean removeAccount(Account account) {
        return accounts.remove(account);
    }

    public void listAccounts() {
        accounts.forEach(System.out::println);
    }

    public Account getAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Account not found!"));
    }

    public String toCsv() {
        return String.join(CSVMapper.DELIMITER, List.of(
                String.valueOf(id), name, surname, phone, email, pesel, String.valueOf(age), dateOfBirth.toString(),
                address.getCity(), address.getStreet(), address.getPostCode())
        );
    }

}

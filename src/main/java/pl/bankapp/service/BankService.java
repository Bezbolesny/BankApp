package pl.bankapp.service;

import lombok.RequiredArgsConstructor;
import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;
import pl.bankapp.model.Account;
import pl.bankapp.model.Address;
import pl.bankapp.model.Bank;
import pl.bankapp.model.Customer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

@RequiredArgsConstructor
public class BankService {

    private final Bank bank;
    private final Scanner scanner;
    private final AccountFactory accountFactory = new AccountFactory();

    public void createCustomer() {
        String name = getString("Name: ");
        String surname = getString("Surname: ");
        String phone = getString("Phone: ");
        String email = getString("Email: ");
        String pesel = getString("Pesel: ");
        String city = getString("City: ");
        String street = getString("Street: ");
        String postCode = getString("Post code: ");
        String dateOfBirthSt = getString("Date of birth (dd/mm/yyyy): ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthSt, formatter);

        Address address = new Address(city, street, postCode);
        Customer customer = new Customer(name, surname, phone, email, pesel, address, dateOfBirth);
        bank.addCustomer(customer);
    }

    public void createCustomerAccount() {
        String pesel = getPesel();
        Customer customer = bank.findCustomer(pesel);

        String message = "Currency: " + Arrays.toString(Currency.values());
        String currencySt = getString(message).toUpperCase();

        message = "Account Type: " + Arrays.toString(AccountType.values());
        String accountTypeSt = getString(message).toUpperCase();

        Currency currency = Currency.valueOf(currencySt);
        AccountType accountType = AccountType.valueOf(accountTypeSt);

        Account account = accountFactory.createAccount(accountType, currency);
        customer.addAccount(account);
    }

    public void listCustomers() {
        if (bank.getCustomers().size() == 0) {
            System.out.println("Customers list empty!");
            return;
        }
        System.out.println("Customers list: ");
    }

    public void listCustomerAccounts(){
        String pesel = getPesel();
        Customer customer = bank.findCustomer(pesel);
        System.out.println("Account list: ");
        customer.listAccounts();
    }

    public void removeCustomerAccount() {
        String pesel = getPesel();
        Customer customer = bank.findCustomer(pesel);

        String accountNumber = getString("Account number : ");
        Account accountToRemove = customer.getAccount(accountNumber);

        boolean removed = customer.removeAccount(accountToRemove);
        System.out.printf("Account removed : %s\n", removed);

    }

    public void removeCustomer() {
        String pesel = getPesel();
        boolean deleted = bank.removeCustomer(pesel);
        System.out.printf("Customer deleted: %s", deleted);
    }

    public void getCustomerByPesel() {
        String pesel = getPesel();
        Customer customer = bank.findCustomer(pesel);
        System.out.printf("Customer info: %s\n", customer);
    }

    private String getPesel() {
        return getString("Pesel: ");
    }

    private String getString(String text) {
        System.out.println(text);
        return scanner.nextLine();
    }

}

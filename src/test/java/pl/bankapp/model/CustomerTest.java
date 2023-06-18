package pl.bankapp.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import pl.bankapp.enums.Currency;
import pl.bankapp.exception.NotFoundException;
import pl.bankapp.utils.AccountNumberGenerator;

import java.util.List;

class CustomerTest {

    @Test
    void testAddAccountSuccess() {
        // given
        Customer customer = new Customer();
        Account account = new StandardAccount(Currency.USD);
        List<Account> accounts = customer.getAccounts();

        // when
        boolean added = customer.addAccount(account);

        // then
        Assertions.assertTrue(added);
        Assertions.assertTrue(accounts.contains(account));
    }

    @Test
    void testRemoveAccountSuccess() {
        //given
        Customer customer = new Customer();
        Account account = new SavingAccount(Currency.EUR);
        List<Account> accounts = customer.getAccounts();
        customer.addAccount(account);

        //when
        boolean removed = customer.removeAccount(account);

        //then
        Assertions.assertTrue(removed);
        Assertions.assertFalse(accounts.contains(account));
    }

    @Test
    void testGetAccountSuccess() {
        // given
        Customer customer = new Customer();
        Account expectedAccount = new PremiumAccount(Currency.PLN);
        customer.addAccount(expectedAccount);
        String accountNumber = expectedAccount.getAccountNumber();

        // when
        Account actualAccount = customer.getAccount(accountNumber);

        // then
        Assertions.assertEquals(expectedAccount, actualAccount);
    }

    @Test
    void testGetAccountNotFound() {
        // given
        Customer customer = new Customer();
        String expectedMessage = "Account not found!";
        String nonExistingAccountNumber = AccountNumberGenerator.generate();

        // when
        Executable executable = () -> customer.getAccount(nonExistingAccountNumber);

        // then
        NotFoundException ex = Assertions.assertThrows(NotFoundException.class, executable);
        Assertions.assertEquals(expectedMessage, ex.getMessage());
    }

}
package pl.bankapp.model;

import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

public class SavingAccount extends Account {

    public SavingAccount(Currency currency) {
        super(currency, AccountType.SAVING);
    }

}

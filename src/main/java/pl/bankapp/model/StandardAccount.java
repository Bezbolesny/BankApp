package pl.bankapp.model;

import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

public class StandardAccount extends Account{

    public StandardAccount(Currency currency) {
        super(currency, AccountType.STANDARD);
    }

}

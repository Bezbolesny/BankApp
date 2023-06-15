package pl.bankapp.model;

import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

public class PremiumAccount extends Account {

    public PremiumAccount(Currency currency) {
        super(currency, AccountType.PREMIUM);
    }

}

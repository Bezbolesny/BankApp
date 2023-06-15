package pl.bankapp.service;

import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;
import pl.bankapp.model.Account;
import pl.bankapp.model.PremiumAccount;
import pl.bankapp.model.SavingAccount;
import pl.bankapp.model.StandardAccount;

public class AccountFactory {

    public Account createAccount(AccountType accountType, Currency currency){
        return switch (accountType){
            case SAVING -> new SavingAccount(currency);
            case STANDARD -> new StandardAccount(currency);
            case PREMIUM -> new PremiumAccount(currency);
        };
    }

}

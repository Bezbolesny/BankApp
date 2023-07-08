package pl.bankapp.model;

import lombok.NoArgsConstructor;
import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

@NoArgsConstructor
public class PremiumAccount extends Account {

    public PremiumAccount(Currency currency) {
        super(currency, AccountType.PREMIUM);
    }

}

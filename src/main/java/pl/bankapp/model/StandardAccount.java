package pl.bankapp.model;

import lombok.NoArgsConstructor;
import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

@NoArgsConstructor
public class StandardAccount extends Account{

    public StandardAccount(Currency currency) {
        super(currency, AccountType.STANDARD);
    }

}

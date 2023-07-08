package pl.bankapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;

import java.math.BigDecimal;

@NoArgsConstructor
public class SavingAccount extends Account {

    public SavingAccount(Currency currency) {
        super(currency, AccountType.SAVING);
    }

    @Getter
    private final BigDecimal interestRate = BigDecimal.valueOf(0.08);

    // TODO: Scheduling
    public void addInterest() {
        BigDecimal interest = calculateInterest();
        BigDecimal total = getCurrentAmount().add(interest);
        setCurrentAmount(total);
    }

    private BigDecimal calculateInterest() {
        return getCurrentAmount().multiply(interestRate);
    }

}

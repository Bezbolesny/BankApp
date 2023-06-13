package pl.bankapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.bankapp.enums.AccountType;
import pl.bankapp.enums.Currency;
import pl.bankapp.utils.AccountNumberGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Data // @Data = @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Currency currency;
    private AccountType accountType;
    private UUID id = UUID.randomUUID();
    private BigDecimal currentAmount = BigDecimal.ZERO;
    private String accountNumber = AccountNumberGenerator.generate();

    public Account(Currency currency, AccountType accountType) {
        this.currency = currency;
        this.accountType = accountType;
    }

}

package model.score;

import model.account.Account;
import model.money.Money;

public class CurrentScore extends Score{
    private DebetScore debetScore;
    public CurrentScore(Money balance, Account owner, Integer
            number, DebetScore debetScore) {
        super(balance, owner, number);
        this.debetScore = debetScore;
    }
    @Override
    protected boolean checkBefore(Money money) {
        double usdValueIn = money.getValue() * money.getCurrency().getUsdCource();
        if (usdValueIn > constants.getAMOUNT_REASON_FOR_CASHBACK()){
            this.debetScore.addMoney(new Money("USD", constants.getCASHBACK_AMOUNT()));
        }
        return true;
    }
}

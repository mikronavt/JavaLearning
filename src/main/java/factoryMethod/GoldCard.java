package factoryMethod;

import java.math.BigDecimal;

public class GoldCard implements Card{
    @Override
    public BigDecimal getCreditLimit() {
        System.out.println("Calculating Gold Card credit limit");
        return null;
    }

    @Override
    public BigDecimal getAnnualCharge() {
        System.out.println("Calculating Gold Card annual charge");

        return null;
    }
}

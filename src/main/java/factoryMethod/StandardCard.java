package factoryMethod;

import java.math.BigDecimal;

public class StandardCard implements Card{
    @Override
    public BigDecimal getCreditLimit() {
        System.out.println("Calculating Standard Card credit limit");

        return null;
    }

    @Override
    public BigDecimal getAnnualCharge() {
        System.out.println("Calculating Standard Card annual charge");

        return null;
    }
}

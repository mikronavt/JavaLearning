package factoryMethod;

import java.math.BigDecimal;

public class PlatinumCard implements Card{
    @Override
    public BigDecimal getCreditLimit() {
        System.out.println("Calculating Platinum Card credit limit");

        return null;
    }

    @Override
    public BigDecimal getAnnualCharge() {
        System.out.println("Calculating Platinum Card annual charge");

        return null;
    }
}

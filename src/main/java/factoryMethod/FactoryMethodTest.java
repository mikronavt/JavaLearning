package factoryMethod;

public class FactoryMethodTest {
    public void testFactoryMethod(){
        ClientAttributes attributes = new ClientAttributes();
        CardFactory standardCardFactory = new StandardCardFactory();
        CardFactory goldCardFactory = new GoldCardFactory();
        CardFactory platinumCardFactory = new PlatinumCardFactory();
        Card standardCard = standardCardFactory.newCard(attributes);
        Card goldCard = goldCardFactory.newCard(attributes);
        Card platinumCard = platinumCardFactory.newCard(attributes);
        standardCard.getCreditLimit();
        standardCard.getAnnualCharge();
        goldCard.getCreditLimit();
        goldCard.getAnnualCharge();
        platinumCard.getCreditLimit();
        platinumCard.getAnnualCharge();
    }
}

package factoryMethod;

public class GoldCardFactory implements CardFactory{
    public Card newCard(ClientAttributes attributes) {
        return new GoldCard();
    }
}

package factoryMethod;

public class StandardCardFactory implements CardFactory{
    public Card newCard(ClientAttributes attributes) {
        return new StandardCard();
    }
}

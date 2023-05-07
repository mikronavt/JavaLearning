package factoryMethod;

public class PlatinumCardFactory implements CardFactory{
    public Card newCard(ClientAttributes attributes) {
        return new PlatinumCard();
    }
}

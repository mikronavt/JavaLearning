package strategy;

public class NoABSSlowdownStrategy implements SlowdownStrategy{
    @Override
    public void slowdown(){
        System.out.println("Тормозим без использования АБС");
    }
}

package strategy;

public class ABSSlowdownStrategy implements SlowdownStrategy{
    @Override
    public void slowdown(){
        System.out.println("Тормозим с использованием АБС");
    }
}

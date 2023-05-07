package strategy;

public class ElectricSteerStrategy implements SteerStrategy {
    @Override
    public void steer(){
        System.out.println("Поворачиваем с использованием электроусилителя руля");
    }
}

package strategy;

public class MechanicalSteerStrategy implements SteerStrategy {
    @Override
    public void steer(){
        System.out.println("Поворачиваем с использованием руля без усилителя");
    }
}

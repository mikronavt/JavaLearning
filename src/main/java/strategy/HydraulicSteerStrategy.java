package strategy;

public class HydraulicSteerStrategy implements SteerStrategy{
    @Override
    public void steer() {
        System.out.println("Поворачиваем с использованием гидроусилителя руля");
    }
}

package strategy;

public class Car {
    private String name;
    private SlowdownStrategy slowdownStrategy;
    private SteerStrategy steerStrategy;

    public Car(String name, SlowdownStrategy slowdownStrategy, SteerStrategy steerStrategy) {
        this.name = name;
        this.slowdownStrategy = slowdownStrategy;
        this.steerStrategy = steerStrategy;
    }

    public void testDrive() {
        System.out.println("Тестируем машину " + name);
        steerStrategy.steer();
        slowdownStrategy.slowdown();
    }
}

package strategy;

public class StrategyTest {
    public void testStrategy(){
        Car lada = new Car("Лада", new NoABSSlowdownStrategy(), new MechanicalSteerStrategy());
        Car volga = new Car("Волга", new NoABSSlowdownStrategy(), new HydraulicSteerStrategy());
        Car ford = new Car("Форд", new NoABSSlowdownStrategy(), new ElectricSteerStrategy());
        Car toyota = new Car("Тойота", new ABSSlowdownStrategy(), new MechanicalSteerStrategy());
        Car bmw = new Car("БМВ", new ABSSlowdownStrategy(), new HydraulicSteerStrategy());
        Car mercedes = new Car("Мерседес Бенц", new ABSSlowdownStrategy(), new ElectricSteerStrategy());
        lada.testDrive();
        volga.testDrive();
        ford.testDrive();
        toyota.testDrive();
        bmw.testDrive();
        mercedes.testDrive();
    }
}

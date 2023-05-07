package responsibilityChain;

public class RobotOperatorImpl implements Operator {
    @Override
    public void answer(Call call) {
        System.out.println("Ваш звонок очень важен для нас (конечно же нет). Перезвоните позже, а лучше никогда.");
    }

    @Override
    public Boolean isOnCall() {
        return false;
    }

    @Override
    public void setNextOperator(Operator next) {
        throw new UnsupportedOperationException("Робот - это последний оператор. Для тебя, кусок мяса, точно последний!");
    }
}

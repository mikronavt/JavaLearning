package responsibilityChain;

public class CallCenter {
    private Operator firstOperator;

    public CallCenter() {
        Operator firstOperator = new HumanOperatorImpl("Vasya");
        Operator secondOperator = new HumanOperatorImpl("Masha");
        Operator thirdOperator = new HumanOperatorImpl("Petya");
        Operator fourthOperator = new HumanOperatorImpl("Olya");
        Operator robotOperator = new RobotOperatorImpl();

        firstOperator.setNextOperator(secondOperator);
        secondOperator.setNextOperator(thirdOperator);
        thirdOperator.setNextOperator(fourthOperator);
        fourthOperator.setNextOperator(robotOperator);

        this.firstOperator = firstOperator;
    }

    public void answerIncomingCall(Call call){
        firstOperator.answer(call);
    }
}

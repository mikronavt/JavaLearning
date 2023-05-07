package responsibilityChain;

public interface Operator {
    void answer(Call call);
    Boolean isOnCall();
    void setNextOperator(Operator next);
}

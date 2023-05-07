package responsibilityChain;

public class HumanOperatorImpl implements Operator{
    private String name;
    private Boolean onCall; // Сейчас оператор говорит по телефону?
    private Operator next; // Следующий оператор в цепочке

    public HumanOperatorImpl(String name) {
        this.name = name;
        onCall = false;
    }

    @Override
    public Boolean isOnCall() {
        return onCall;
    }

    @Override
    public void setNextOperator(Operator next) {
        this.next = next;
    }

    @Override
    public void answer(Call call) {
        if(this.onCall) {
            next.answer(call);
        } else {
            System.out.println("Здравствуйте, оператор " + this.name + " слушает");
            onCall = true;
        }
    }
}

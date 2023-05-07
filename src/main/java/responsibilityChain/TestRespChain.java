package responsibilityChain;

public class TestRespChain {
    public void testRespChain(){
        CallCenter callCenter = new CallCenter();
        callCenter.answerIncomingCall(new Call());
        callCenter.answerIncomingCall(new Call());
        callCenter.answerIncomingCall(new Call());
        callCenter.answerIncomingCall(new Call());
        callCenter.answerIncomingCall(new Call());
        callCenter.answerIncomingCall(new Call());

    }
}

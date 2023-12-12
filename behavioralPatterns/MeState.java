package myTest.behavioralPatterns;

import java.util.Stack;

public class MeState {
    public static void main(String[] args) {
        Context context = new Context();

        context.request();

        context.request();
    }
}

class Context {
    private State currenState;

    public Context() {
        this.currenState = new ConcreteStateA();
    }

    public void setState(State state) {
        this.currenState = state;
    }

    public void request() {
        currenState.handle(this);
    }
}

interface State {
    void handle(Context context);
}

class ConcreteStateA implements State {

    @Override
    public void handle(Context context) {
       // 현재 상태가 실행될 때 할 작업
        System.out.println("A");

        context.setState(new ConcreteStateB());
    }
}

class ConcreteStateB implements State {
    @Override
    public void handle(Context context) {
        System.out.println("B");

        context.setState(new ConcreteStateA());
    }
}


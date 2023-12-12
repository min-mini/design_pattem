package myTest.behavioralPatterns;

import org.jetbrains.annotations.Nullable;

public class MeChainOfResponsibility {
    public static void main(String[] args) {
        //.setNext(new ConcreteHandler2()) 해도 되고 안해도 됌
        Handler handler = new ConcreteHandler1().setNext(new ConcreteHandler2());
        handler.handle(Handler.Level.L1);
        handler.handle(Handler.Level.L2);
    }

}

abstract class Handler {

    enum Level {
        L1, L2;
    }

    enum Result {
        SUCCESS, FAILURE
    }

    private Level level;

    @Nullable
    private Handler next;

    public Handler(Level level) {
        this(level, null);
    }

    public Handler(Level level, @Nullable Handler next) {
        this.level = level;
        this.next = next;
    }

    public Handler setNext(Handler next) {
        this.next = next;
        return this;
    }

    public Result handle(Level level) {
        if (this.level == level) {
            return onHandle();
        }
        if (next != null) {
            return next.handle(level);
        }
        return Result.FAILURE;
    }
    abstract Result onHandle();
}

class ConcreteHandler1 extends Handler {

    ConcreteHandler1() {
        super(Level.L1, new ConcreteHandler2());
    }

    @Override
    Result onHandle() {
        System.out.println("LEVEL 1");
        return Result.SUCCESS;
    }
}

class ConcreteHandler2 extends Handler {

    ConcreteHandler2() {
        super(Level.L2);
    }

    @Override
    Result onHandle() {
        System.out.println("LEVEL 2");
        return Result.SUCCESS;
    }
}
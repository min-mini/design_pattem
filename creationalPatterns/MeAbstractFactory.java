package myTest.creationalPatterns;

public class MeAbstractFactory {
    public static void main(String[] args) {
        codes();
    }

    private static void codes() {
        AbstractFactory abstractFactory1 = new ConcreteFactory1();
        AbstractFactory abstractFactory2 = new ConcreteFactory2();
        AbstractProduct A1 = abstractFactory1.createA();
        AbstractProduct B1 = abstractFactory1.createB();
        AbstractProduct A2 = abstractFactory2.createA();
        AbstractProduct B2 = abstractFactory2.createB();

        System.out.println(A1.getId());
        System.out.println(A2.getId());
        System.out.println(B1.getId());
        System.out.println(B2.getId());
    }
}

interface AbstractFactory {
    AbstractProduct createA();
    AbstractProduct createB();
}

class ConcreteFactory1 implements AbstractFactory {
    @Override
    public AbstractProduct createA() {
        return new AbstractProductA(1);
    }

    @Override
    public AbstractProduct createB() {
        return new AbstractProductB(3);
    }
}

class ConcreteFactory2 implements AbstractFactory {
    @Override
    public AbstractProduct createA() {
        return new AbstractProductA(2);
    }

    @Override
    public AbstractProduct createB() {
        return new AbstractProductB(4);
    }
}

interface AbstractProduct {
    int getId();
}

class AbstractProductA implements AbstractProduct {
    private int id;

    AbstractProductA(int id) {
        this.id = id;
    }
    @Override
    public int getId() {
        return this.id;
    }
}

class AbstractProductB implements AbstractProduct {
    private int id;

    AbstractProductB(int id) {
        this.id = id;
    }
    @Override
    public int getId() {
        return this.id;
    }
}
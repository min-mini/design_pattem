package myTest.creationalPatterns;

public class MeFactoryMethod {
    public static void main(String[] args) {
        Usecase usecase1 = new Usecase(new ConcreteFactoryA());
        Usecase usecase2 = new Usecase(new ConcreteFactoryB());

        usecase1.print();
        usecase2.print();
    }
}

class Usecase {
    FactoryProduct product;

    Usecase(Factory factory) {
        product = factory.create();
    }

    void print() {
        product.print();
    }
}


interface Factory {
    FactoryProduct create();
}
interface FactoryProduct {
    void print();
}

class ConcreteFactoryA implements Factory {
    @Override
    public FactoryProduct create() {
        return new FactoryProductA();
    }
}

class ConcreteFactoryB implements Factory {
    @Override
    public FactoryProduct create() {
        return new FactoryProductB();
    }
}

class FactoryProductA implements FactoryProduct {
    @Override
    public void print() {
        System.out.println("프린트 A");
    }
}

class FactoryProductB implements FactoryProduct {
    @Override
    public void print() {
        System.out.println("프린트 B");
    }
}


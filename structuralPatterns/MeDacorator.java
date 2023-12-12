package myTest.structuralPatterns;

public class MeDacorator {
    public static void main(String[] args) {
        // 기본 커피
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Description : " + simpleCoffee.getDescription());
        System.out.println("Cost : $" + simpleCoffee.cost());

        System.out.println();

        // 우유 추가
        Coffee milkCoffee = new MilkDecorator(simpleCoffee);
        System.out.println("Description : " + milkCoffee.getDescription());
        System.out.println("Cost : $" + milkCoffee.cost());

        System.out.println();

        // 설탕 추가
        Coffee sweetCoffee = new SugarDecorator(simpleCoffee);
        System.out.println("Description : " + sweetCoffee.getDescription());
        System.out.println("Cost : $" + sweetCoffee.cost());

        System.out.println();

        // 우유 + 설탕
        Coffee milkAndSugarCoffee = new SugarDecorator(new MilkDecorator(simpleCoffee));
        System.out.println("Description : " + milkAndSugarCoffee.getDescription());
        System.out.println("Cost : $" + milkAndSugarCoffee.cost());
    }

}

// Component Interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component - 기본 베이스 객체
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple 커피";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

// Decorator 클래스
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffe) {
        super(decoratedCoffe);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}

class SugarDecorator extends CoffeeDecorator {
    SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return super.cost() + 0.2;
    }
}
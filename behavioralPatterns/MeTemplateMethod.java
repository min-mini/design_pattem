package myTest.behavioralPatterns;

public class MeTemplateMethod {
    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.makeCoffe();
    }
}

// 템플릿 메소드를 정의한 추상 클래스
abstract class CoffeeTemplate {

    // 템플릿 메소드
    final void makeCoffe() {
        boilWater();
        brewCofferGrounds();
        pourInCup();
        addCondiments();
    }

    // 하위 클래스에서 구현되어야 하는 메소드들
    abstract void boilWater();
    abstract void brewCofferGrounds();
    abstract void pourInCup();
    abstract void addCondiments();
}

// 커피를 만드는 구체 클래스
class Coffee extends CoffeeTemplate {
    @Override
    void boilWater() {
        System.out.println("물 끓이기");
    }

    @Override
    void brewCofferGrounds() {
        System.out.println("커피 내리기");
    }

    @Override
    void pourInCup() {
        System.out.println("컵에 따르기");
    }

    @Override
    void addCondiments() {
        System.out.println("설탕과 우유 추가");
    }
}

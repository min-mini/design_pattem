package myTest.behavioralPatterns;

public class MeVisitor {
    public static void main(String[] args) {
        // 각 요소를 방문하여 구체적 방문자 클래스 안의 작업을 한다.
        Animal dog = new Dog();
        Animal cat = new Cat();

        AnimalVisitor soundVisitor = new SoundVisitor();

        dog.accept(soundVisitor);
        cat.accept(soundVisitor);
    }
}

// 방문자 인터페이스
interface AnimalVisitor {
    void visit(Dog dog);
    void visit(Cat cat);
}

// 요소 인터페이스
interface Animal {
    void accept(AnimalVisitor visitor);
}

// 구체적인 요소 클래스들
class Dog implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

class Cat implements Animal {
    @Override
    public void accept(AnimalVisitor visitor) {
        visitor.visit(this);
    }
}

// 구체적인 방문자 클래스
class SoundVisitor implements AnimalVisitor {
    @Override
    public void visit(Dog dog) {
        System.out.println("강아지가 짖습니다.");
    }

    @Override
    public void visit(Cat cat) {
        System.out.println("고양이가 울부짖습니다.");
    }
}
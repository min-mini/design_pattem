package myTest.behavioralPatterns;

import java.util.List;
import java.util.Stack;

public class MeMemento {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State 1");
        originator.printState();

        caretaker.saveMemento(originator.save());

        originator.setState("State 2");
        originator.printState();

        originator.restore(caretaker.retrieveMemento());
        originator.printState();
    }
}

interface Memento {
    String getState();
}

//  원조자(Originator) 객체의 상태를 캡슐화하는 역할
class ConcreteMemento implements Memento {
    private String state;

    public ConcreteMemento(String state) {
        this.state = state;
    }
    @Override
    public String getState() {
        return state;
    }
}

// 클래스 상태를 저장하고 복원하는 기능
class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento save() {
        return new ConcreteMemento(state);
    }

    public void restore(Memento memento) {
        if (memento instanceof ConcreteMemento) {
            this.state = memento.getState();
        }
    }

    public  void printState() {
        System.out.println("Current State : " + state);
    }
}

// 메멘토 관리
class Caretaker {
    private Memento memento;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento retrieveMemento() {
        return memento;
    }
}

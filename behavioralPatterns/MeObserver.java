package myTest.behavioralPatterns;

import java.util.ArrayList;
import java.util.List;

public class MeObserver {
    public static void main(String[] args) {
       ConcreteSubject subject = new ConcreteSubject();

       ConcreateObserver observer1 = new ConcreateObserver();
       ConcreateObserver observer2 = new ConcreateObserver();

       subject.registerObserver(observer1);
       subject.registerObserver(observer2);

       subject.setState(10);
    }
}

// 주체
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// 주체의 상태가 변경되면 등록된 모든 옵저버들에게 알림을 보내어 상태 갱신을 유도
class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

// 옵저버
interface Observer {
    void update(int state);
}

// 실제로 상태 변화를 감지하고 업데이트하는 객체
class ConcreateObserver implements Observer {
    private int observerState;

    @Override
    public void update(int state) {
        observerState = state;
        System.out.println("observer update with state : " + observerState);
    }
}

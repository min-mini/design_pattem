package myTest.behavioralPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MeMediator {
    public static void main(String[] args) {
        // 미디에이터 생성
        ConcreteMediator mediator = new ConcreteMediator();

        // 동료 객체들 생성
        Colleague colleague1 = new ConcreteColleague(mediator, "Colleague 1");
        Colleague colleague2 = new ConcreteColleague(mediator, "Colleague 2");
        Colleague colleague3 = new ConcreteColleague(mediator, "Colleague 3");

        // 메시지 전송 예시
        colleague1.sendMessage("안뇽~ 메세지 보낸다");
    }
}

interface Mediator {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague colleague);
}

interface Colleague {
    void receiveMessage(String message);
    void sendMessage(String message);
}

class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues;

    public ConcreteMediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            // 메시지를 보낸 객체를 제외한 다른 객체들에게 메세지 전달
            if (colleague != sender) {
                colleague.receiveMessage(message);
            }
        }
    }
}

class ConcreteColleague implements Colleague {
    private Mediator mediator;
    private String name;

    public ConcreteColleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.addColleague(this); // 미디에이터에 자신을 등록
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends message: " + message);
        mediator.sendMessage(message, this); // 미디에이터를 통해 다른 객체들에게 메시지 전달
    }
}
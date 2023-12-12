package myTest.behavioralPatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MeCommand {
    public static void main(String[] args) {
        Light light = new Light();

        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.setCommand(lightOnCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(lightOffCommand);
        remoteControl.pressButton();
    }

}

// Command 인터페이스
interface Command {
    void execute();
}

// ConcreteCommand 클래스
class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

// ConcreteCommand 클래스
class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

// Receiver 클래스
class Light {
    public void turnOn() {
        System.out.println("전등을 킨다~");
    }

    public void turnOff() {
        System.out.println("전등을 끈다!");
    }
}

// Invoker 클래스
class RemoteControl {
    private Queue<Command> commandQueue = new LinkedList<>();

    public void setCommand(Command command) {
        commandQueue.add(command);
    }

    public void execute() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
        }
    }

    public void pressButton() {
        execute();
    }
}

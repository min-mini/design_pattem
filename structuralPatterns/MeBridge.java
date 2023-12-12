package myTest.structuralPatterns;

public class MeBridge {
    public static void main(String[] args) {
        Message emailMessage = new Message(new EmailSender());
        emailMessage.send("메일로 보내봅니당~");

        Message SNSMessge = new Message(new SNSSender());
        SNSMessge.send("SNS로 보내요~");
    }

}

// 브리지 인터페이스
interface MessageSender {
    void sendMessage(String message);
}

// 구현체1
class EmailSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending email : " + message);
    }
}

// 구현체 2
class SNSSender implements MessageSender {
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending SNS : " + message);
    }
}

// 브리지 역할의 클래스
class Message {
    private MessageSender messageSender;

    Message(MessageSender messageSender){
        this.messageSender = messageSender;
    }

    void send(String message) {
        messageSender.sendMessage(message);
    }
}



package myTest.behavioralPatterns;

public class MeChainOfResponsibility2 {
    public static void main(String[] args) {
        // Approver 객체들 생성
        Approver employee = new Employee();
        Approver manager = new Manager();
        Approver vicePresident = new VicePresident();

        // 체인 구성
        employee.setNextApprover(manager);
        manager.setNextApprover(vicePresident);

        // 요청 생성 및 처리
        PurchaseRequest request1 = new PurchaseRequest(1, 800);
        PurchaseRequest request2 = new PurchaseRequest(2, 3500);
        PurchaseRequest request3 = new PurchaseRequest(3, 10000);

        employee.processRequest(request1);
        employee.processRequest(request2);
        employee.processRequest(request3);

    }
}

// Handler 인터페이스
interface Approver {
    void processRequest(PurchaseRequest request);
    void setNextApprover(Approver nextApprover);
}

// ConcreteHandler 클래스
class Employee implements Approver {
    private Approver nextApprover;

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 1000) {
            System.out.println("Employee approves purchase request #" + request.getNumber());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request #" + request.getNumber() + " requires higher approval.");
        }
    }
    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

class Manager implements Approver {
    private Approver nextApprover;

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() <= 5000) {
            System.out.println("Manager approves purchase request #" + request.getNumber());
        } else if (nextApprover != null) {
            nextApprover.processRequest(request);
        } else {
            System.out.println("Request #" + request.getNumber() + " requires higher approval.");
        }
    }
    @Override
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}

class VicePresident implements Approver {
    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("Vice President approves purchase request #" + request.getNumber());
    }

    @Override
    public void setNextApprover(Approver nextApprover) {
        // VicePresident는 마지막 핸들러이므로 setNextApprover 메서드에서 아무것도 하지 않습니다.
    }
}

// Context 클래스
class PurchaseRequest {
    private int number;
    private double amount;

    public PurchaseRequest(int number, double amount) {
        this.number = number;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }
}


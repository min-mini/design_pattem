package myTest.structuralPatterns;

public class MeProxy {
    public static void main(String[] args) {
        // 가상 프록시 생성
        Subject proxy = new Proxy();

        // 프록시를 통해 실제 객체에 접근
        proxy.request();
    }

}

// 실제 객체를 나타내는 인터페이스
interface Subject {
    void request();
}

// 실제 객체 클래스
class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject 처리중입니다.");
    }
}

// 가상 프록시 클래스
class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void request() {
        // 실제 객체가 필요한 시점에 생성 (지연 로딩)
        // 지연로딩 : 실제 객체가 생성되어 있지 않으면 객체를 생성하고 초기화한 후에 해당 메서드를 호출
        if (realSubject == null) {
            realSubject = new RealSubject();
        }

        // 가상 프록시를 통해 실제 객체에 접근
        realSubject.request();
    }
}


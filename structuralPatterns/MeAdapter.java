package myTest.structuralPatterns;

public class MeAdapter {
    public static void main(String[] args) {
        // 기존의 Adaptee 생성
        Adaptee adaptee = new Adaptee();
        // 어댑터를 통해 Target 인터페이스를 사용
        Target target = new Adapter(adaptee);

        // 클라이언트는 Target 인터페이스를 통해 메서드 호출
        target.request();
    }
}

// 타겟 대상 인터페이스
interface Target {
    void request();
}

// 적응 대상 클래스
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee에게 구체적인 요청!");
    }
}

// 어댑터 클래스
class Adapter implements Target {
    private Adaptee adaptee;

    Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        // 특정 요청을 대상 인터페이스에 적용한다.
        adaptee.specificRequest();
    }
}


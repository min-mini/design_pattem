package myTest.creationalPatterns;


// 이중검사-락 싱글패턴
class Singleton {
    // volatile 키워드를 사용하여 인스턴스의 변경을 즉시 다른 스레드에 반영
    private static volatile Singleton instance;

    // private 생성자로 외부에서 직접 인스턴스를 생성하는 것을 막음
    private Singleton() {
        // 생성자 내용
    }

    // 인스턴스를 얻는 메서드 (이중 검사 락 사용)
    public static Singleton getInstance() {
        // 인스턴스가 생성되지 않았을 때만 동기화
        if (instance == null) {
            // instance 객체를 사용하여 synchronized 블록을 설정하는 것은 안전하지 않음.
            // 초기에 instance가 null일 때 여러 스레드가 동시에 synchronized 블록에 진입할 수 있음.
            // 이로 인해 여러 스레드가 동시에 instance를 생성할 수 있으며, 싱글턴 패턴의 의도가 깨짐.
            synchronized (Singleton.class) {
                // 다시 한 번 체크하여 중복 생성 방지
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 다른 메서드 및 속성들을 추가할 수 있음

    public void doSomething() {
        System.out.println("Singleton is doing something.");
    }
}

public class MeSingleton {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);

        singleton1.doSomething();
    }
}

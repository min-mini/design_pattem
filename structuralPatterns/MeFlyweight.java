package myTest.structuralPatterns;

import java.util.HashMap;
import java.util.Map;

public class MeFlyweight {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();

        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.print("123");

        Flyweight flyweight2 = factory.getFlyweight("B");
        flyweight2.print("456");

        Flyweight flyweight3 = factory.getFlyweight("A");
        flyweight3.print("789");

    }



}

// 플라이웨이트 인터페이스 - 객체가 가져야 하는 공통 동작을 정의
interface Flyweight {
    void print(String content);
}

// 구현 클래스
class SharedFlyweight implements Flyweight {
    private String sharedContent;

    public SharedFlyweight(String sharedContent){
        this.sharedContent = sharedContent;
    }

    @Override
    public void print(String content) {
        System.out.println("sharedContent : " + sharedContent + ", Non-shared Content:" + content);
    }
}

// 플라이웨이트 팩토리 - 객체를 생성하고 관리
class FlyweightFactory {
    private Map<String, Flyweight> flyweights = new HashMap<>();

    // 공유 가능한 객체를 얻어오는 메서드
    public Flyweight getFlyweight(String sharedContent) {
        // 객체가 없다면 새로운 객체를 생성하여 맵에 저장하고 반환
        if(!flyweights.containsKey(sharedContent)) {
            flyweights.put(sharedContent, new SharedFlyweight(sharedContent));
        }
        return flyweights.get(sharedContent);
    }
}

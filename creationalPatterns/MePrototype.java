package myTest.creationalPatterns;

// 얕은 복사
class SimPrototype implements Cloneable {
    private String data;

    public SimPrototype(String data) {
        this.data = data;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

public class MePrototype {
    public static void main(String[] args) {
        // 원본 객체 생성
        SimPrototype orgin = new SimPrototype("orgin!!");

        try {
            // 복제를 통해 새로운 객체 생성
            SimPrototype clone = (SimPrototype) orgin.clone();

            // 복제된 객체의 데이터 변경
            clone.setData("Modified Data");

            // 원본 객체와 복제된 객체의 데이터 출력
            System.out.println(orgin.getData());
            System.out.println(clone.getData());
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

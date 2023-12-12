package myTest.creationalPatterns;

public class MeBuilder {
    public static void main(String[] args) {
        codes();
    }

    static void codes() {
        Builder builder = new BuilderImpl();
        BuilderProduct productABC =
                builder
                        .partA("A")
                        .partB("B")
                        .partC("C")
                        .build();

        BuilderProduct productC =
                builder
                        .partA(null)
                        .partB(null)
                        .build();

        BuilderProduct productA =
                builder
                        .partA("A")
                        .partB(null)
                        .partC(null)
                        .build();

        System.out.println(productABC);
        System.out.println(productA);
        System.out.println(productC);
    }
}

interface Builder {
    Builder partA(String a);
    Builder partB(String b);
    Builder partC(String c);
    BuilderProduct build();
}

interface BuilderProduct {
    // 정적 팩토리 메소드 - 생성자 대신 사용
    static BuilderProduct create(String a, String b, String c) {
        return new BuilderProductImpl(a, b, c);
    }
}

class BuilderProductImpl implements BuilderProduct {
    private String a;
    private String b;
    private String c;

    BuilderProductImpl(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class BuilderImpl implements Builder {
    private String a;
    private String b;
    private String c;

    @Override
    public Builder partA(String a) {
        this.a = a;
        return this;
    }

    @Override
    public Builder partB(String b) {
        this.b = b;
        return this;
    }

    @Override
    public Builder partC(String c) {
        this.c = c;
        return this;
    }

    @Override
    public BuilderProduct build() {
        return BuilderProduct.create(a, b, c);
    }
}





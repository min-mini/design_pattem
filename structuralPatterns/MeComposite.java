package myTest.structuralPatterns;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MeComposite {
    public static void main(String[] args) {
//         단일 도형
        Shape circle = new Circle();
        circle.draw();

        // 복합 도형 그룹
        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(new Circle());
        compositeShape.addShape(new Rectangle());
        compositeShape.draw();
    }
}

// 컴포넌트 인터페이스
interface Shape {
    void draw();
}

// 단일 도형 (Leaf 클래스)
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("단일 도형 그리기!");
    }
}

// 단일 직사각형 도형 (Leaf 클래스)
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("단일 직사각형 그리기!");
    }
}

// 여러 도형을 그룹화한 복합 도형 (Composite 클래스)
class CompositeShape implements Shape {
    private List<Shape> shapes = new ArrayList<>();

    void addShape(Shape shape) {
        shapes.add(shape);
    }

    void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void draw() {
        System.out.println("여러 도형 그리기!");
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
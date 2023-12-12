package myTest.behavioralPatterns;

import java.util.*;

public class MeIterator {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();
        myList.add("Item 1");
        myList.add("Item 2");
        myList.add("Item 3");

        MyIterator<String> iterator = myList.createIterator();

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
    }
}

// Iterator 인터페이스
interface MyIterator<T> {
    boolean hasNext();
    T next();
}

// Aggregate 인터페이스 - 컬렉션 인터페이스
interface MyAggregate<T> {
    MyIterator<T> createIterator();
}

// ConcreteIterator 클래스
class MyListIterator<T> implements MyIterator<T> {
    private List<T> list;
    private int index;

    public MyListIterator(List<T> list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        if (hasNext()) {
            return list.get(index++);
        } else {
            return null;
        }
    }
}

// ConcreteAggregate 클래스
class MyList<T> implements MyAggregate {
    private List<T> list;

    public MyList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    @Override
    public MyIterator createIterator() {
        return new MyListIterator<>(list);
    }
}



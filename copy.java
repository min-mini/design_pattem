package myTest;

// 얕은 복사  (Shallow Copy)
// 객체를 복사할 때, 원본 객체와 복사본 객체가 같은 객체를 참조
// 복사본 객체에서 객체의 내부 객체를 변경하면, 원본 객체에도 영향
// 두 객체가 서로 다른 내부 객체를 참조하는 경우,
// 한 객체에서 내부 객체를 수정해도 다른 객체에는 영향을 주지 않음
class Person1 {
    String name;
    Address1 address;

    public Person1(String name, Address1 address) {
        this.name = name;
        this.address = address;
    }
}

class Address1 {
    String city;

    public Address1(String city) {
        this.city = city;
    }
}

// 깊은 복사 (Deep Copy)
// 객체를 복사할 때, 원본 객체와 복사본 객체가 서로 다른 객체를 참조
// 복사본 객체에서 객체의 내부 객체를 변경해도, 원본 객체에는 영향을 주지 않음
class Person2 implements Cloneable {
    String name;
    Address2 address2;

    public Person2(String name, Address2 address) {
        this.name = name;
        this.address2 = address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
         Person2 clonedPerson = (Person2) super.clone();
         clonedPerson.address2 = (Address2) address2.clone();
         return clonedPerson;
    }
}

class Address2 implements Cloneable {
    String city;

    public Address2(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 주소 객체도 복사
        return super.clone();
    }
}

public class copy {
    public static void main(String[] args) {
        Address1 address = new Address1("City");
        Person1 person1 = new Person1("길동", address);

        // 얕은복사 : 같은 주소를 참조
        Person1 person2 = new Person1(person1.name, person1.address);
        // 주소 같음
        System.out.println(person1.address == person2.address);


        Address2 address2 = new Address2("City");
        Person2 person3 = new Person2("길동", address2);

        try {
            // 깊은 복사: person3 새로운 주소 객체를 참조
            Person2 person4 = (Person2) person3.clone();

            // person1과 person3 주소 객체는 서로 다름
            System.out.println(person3.address2 == person4.address2);  // 출력: false
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

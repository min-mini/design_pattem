package myTest.creationalPatterns;

// 깊은 복사

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ComplexObj implements Cloneable {
    private int num;
    private String text;
    private List<String> stringList;

    public ComplexObj(int num, String text, List<String> stringList) {
       this.num = num;
       this.text = text;
       this.stringList = stringList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> clonedList = new ArrayList<>(this.stringList);

        ComplexObj clonedObj = new ComplexObj(this.num, this.text, clonedList);

        return  clonedObj;
    }

// list도 함께 독립적인 완전한 객체를 만드는 코드
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        List<String> clonedList = new ArrayList<>(this.stringList.size());
//        for (String item : this.stringList) {
//            clonedList.add(new String(item)); // 혹은 item.clone()을 사용할 수도 있음
//        }
//
//        ComplexObj clonedObj = new ComplexObj(this.num, this.text, clonedList);
//
//        return clonedObj;
//    }

    public int getNum() {
        return num;
    }

    public String getText() {
        return text;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}


public class MePrototype2 {
    public static void main(String[] args) {
       List<String> oringList = Arrays.asList("One, Two, Three");
       ComplexObj oringObj = new ComplexObj(42, "oringText", oringList);

       try {
           ComplexObj clone = (ComplexObj) oringObj.clone();

           clone.setNum(99);
           clone.setText("변경된 text");
           clone.getStringList().add("Four");

           System.out.println( "oring :" + oringObj.getNum());
           System.out.println( "oring :" + oringObj.getText());
           System.out.println( "oring :" + oringObj.getStringList());
           System.out.println( "clone :" + clone.getNum());
           System.out.println( "clone :" + clone.getText());
           System.out.println( "clone :" + clone.getStringList());


       }catch (CloneNotSupportedException e) {
           e.printStackTrace();
       }

    }
}

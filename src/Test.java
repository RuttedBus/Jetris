/**
 * Created by STUDLER on 1/23/15.
 */
public class Test {
    public static void main(String[] args) {
        print();
        TestObject test = new TestObject("Test");
        System.out.println(test.getName());
        test.setName("This");
        System.out.println(test.getName());
    }
    public static void print() {
        System.out.println("hello");
    }
}

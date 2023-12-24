import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main extends LC5 {
    public static class A {
        public int a = 100;
    }

    public static class B extends A {
        public int getA() {
            return a;
        }
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("LC1423");
            Method maxScore = aClass.getMethod("maxScore", int[].class, int.class);
            int[] i = {96, 90, 41, 82, 39, 74, 64, 50, 30};
            int invoke = (int) maxScore.invoke(aClass.newInstance(), i, 8);
            System.out.println(invoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void test(int test) {
        class Test{
            void print(){
                System.out.println(test);
            }
        }
    }
}
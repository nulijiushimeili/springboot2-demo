package nu.springboot2.lang3;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-12-18 21:43
 * Description:
 **/


public class TestRecursion01 {
    public static void main(String[] args) {
//        a();
        System.out.println(factorial(5));
    }

    static int count = 0;

    static void a(){
        System.out.println("a");
        count ++;
        b();
    }

    static void b(){
        System.out.println("b");
        if(count < 10){
            a();
        }
    }

    /**
     * 递归计算阶乘
     * @param n
     * @return
     */
    public static long factorial(int n ){
        if(n == 1){
            return 1;
        }else{
            return n * factorial(n -1);
        }
    }
}

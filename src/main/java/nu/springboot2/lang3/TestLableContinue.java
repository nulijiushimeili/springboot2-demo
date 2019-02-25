package nu.springboot2.lang3;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-12-18 21:04
 * Description:
 **/


public class TestLableContinue {
    public static void main(String[] args) {
        // 打印101-150之间所有的质数
        outer:
        for (int i = 101; i < 150; i++) {
            for (int j = 2; j < i / 2; j++) {
                if(i % j == 0){
                    continue outer;
                }
            }
            System.out.println(i + " ");
        }
    }
}

package nu.springboot2.lang3;

import org.apache.commons.lang3.SystemUtils;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-12-08 20:24
 * Description:
 *
 **/


public class Lang3TestDemo {
    public static void main(String[] args) {


    }

    public void test(){

    }

    /**
     * 系统变量获取
     */
    public void testSystemUtils(){
        System.out.println(SystemUtils.getJavaHome());
        System.out.println(SystemUtils.getUserDir());
        System.out.println(SystemUtils.getUserHome());
        System.out.println(SystemUtils.getJavaIoTmpDir());

        // D:\app-home\java\jre
        // D:\project\spring-boot-example\spring-boot-hello
        // C:\Users\Mypc
        // C:\Users\Mypc\AppData\Local\Temp
    }
}

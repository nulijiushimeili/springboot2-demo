package nu.springboot2.utils;

import org.apache.commons.beanutils.ConvertUtils;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-12-06 20:31
 * Description:
 *
 *
 *
 **/


public class MyConvertUtils {

    /**
     *   将对象转换为 tClass 的实例 的值
     * @param src
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T convert(Object src, Class<T> tClass){
        try {
            Object value = ConvertUtils.convert(src, tClass);
            T t = (T) value;
            return t;
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}

package nu.springboot2.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Program: springboothello
 * @Author: 努力就是魅力
 * @Since: 2018-12-06 20:15
 * Description:
 *
 *          读取配置文件的配置，并将配置的值转换为想要的类型
 **/


public class PropertiesUtils {

    private static final  Object o = new Object();

    private static final ConcurrentHashMap<String , Properties> propertiesCHashMap = new ConcurrentHashMap<>();


    /**
     * 获取配置文件的配置
     * @param file 配置文件名
     * @param key      配置 的 key
     * @param tClass   配置的值得类型
     * @param <T>      配置的值得类型
     * @return         需要的值类型
     */
    public static <T> T  getProperty(String file ,String key ,Class<T> tClass){
        if(StringUtils.isBlank(file)){
            System.out.println("The property file is blank !");
            return null;
        }

        synchronized (o){
            if(!propertiesCHashMap.contains(file)){
                try {
                    InputStream is = PropertiesUtils.class.getResource(file).openStream();
                    Properties properties = new Properties();
                    properties.load(is);
                    propertiesCHashMap.put(file,properties);
                } catch (IOException e) {
                    e.printStackTrace();
                    propertiesCHashMap.put(file,null);
                }
            }
        }

        Properties props = propertiesCHashMap.get(file);
        if(props == null){
            System.out.println("The properties is null");
            return null;
        }

        String value = props.getProperty(key);
        return MyConvertUtils.convert(value,tClass);
    }


    /**
     * 获取配置文件的配置爱
     * @param file
     * @param key
     * @param tClass
     * @param defaultValue    可以设置默认的值，如果配置文件没有配置的话
     * @param <T>
     * @return
     */
    public static <T> T getProperty(String file , String key, Class<T> tClass, T defaultValue){
        if(defaultValue == null){
            throw new RuntimeException("defaultValue is null");
        }
        T t = getProperty(file, key, tClass);

        if(t == null){
            return defaultValue;
        }else{
            return t;
        }
    }


    public static void main(String[] args) {
        System.out.println(getProperty("/test.properties","aaa",Long.class));
        System.out.println(getProperty("/test.properties","bbb",Boolean.class));
        System.out.println(getProperty("/test.properties","ccc",Float.class));
        System.out.println(getProperty("/test.properties","ddd",String.class));
    }
}

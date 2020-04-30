package nu.springboot2.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/******************************
 * @Project: coder-helper
 * @FileName: UDFProperties.java
 * @ClassName: UDFProperties
 * @time 2020/5/1 6:43
 * @version 1.00
 * @author nulijiushimeili
 * @Description:  加载自定义配置文件
 ******************************/
@Configuration
@ConfigurationProperties(prefix="udf")
@PropertySource(value = "classpath:udf.properties", encoding = "utf-8")
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UDFProperties {

    @Value("${my.jdbc.url}")
    private String jdbcUrl;
    @Value("${my.jdbc.driver-name}")
    private String driverName;
    @Value("${my.jdbc.username}")
    private String username;
    @Value("${my.jdbc.password}")
    private String password;

}

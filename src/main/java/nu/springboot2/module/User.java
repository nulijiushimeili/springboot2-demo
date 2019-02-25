package nu.springboot2.module;

import lombok.Data;

/**
 * @program: spring-boot2-mybatis
 * @author: 努力就是魅力
 * @create: 2018-09-27 21:08
 * description:
 *      使用lombok简化程序开发
 *
 *      -@Data      相当于getter and setter
 *      -@Getter
 *      -@Setter
 *      -@slf4j     可以直接在类里面使用log.info()等日志功能
 **/

//@Data
public class User {

    private int id;

    private String username;

    private String password;


    private String gender;
    private String cellphone;
    private String email;

    public User( String username, String password, String gender, String cellphone, String email) {
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.cellphone = cellphone;
        this.email = email;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

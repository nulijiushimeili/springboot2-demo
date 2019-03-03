package nu.springboot2.hadoop;

/**
 * @Program: spring-boot2-demo
 * @Author: 努力就是魅力
 * @Since: 2019-02-28 17:59
 * Description:  TODO
 **/


public class ReturnRes {

    private int code;
    private String status;
    private String message;


    public ReturnRes(){}

    public ReturnRes(String msg){
        this.message = msg;
    }

    public ReturnRes(int code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    public void setMessage(String msg){
        this.message = msg;
    }

    public String getMessage(){
        return message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

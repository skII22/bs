package vueshop.common;

import lombok.Data;
@Data
public class Result<T>{
    private Object data;
    private String code;
    private String msg;
    public Result(){
    }
    public Result(String code,Object data){
        this.code=code;
        this.data=data;
    }
    public Result(String code,Object data,String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
    public Result(String code,String msg){
        this.code = code;
        this.msg = msg;
    }


}

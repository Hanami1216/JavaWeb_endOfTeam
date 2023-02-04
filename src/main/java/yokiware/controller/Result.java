package yokiware.controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = 8413782072084810966L;
    /**
     * 请使用本类的静态变量，SUCCESS,ERROR,WARN
     */
    private int result;

    /**
     * 对页面的消息提示，比如说出错的时候，给页面的错误提示信息
     */
    private String msg;

    /**
     * 传递回去的数据，比如说从数据库中查询的数据，存放到此变量中
     */
    private Object data;


}
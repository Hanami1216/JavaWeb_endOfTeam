package yokiware.controller;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/18  22:18
 */
public class Code {
    public static final Integer SAVE_OK = 20011;
    public static final Integer DELETE_OK = 20021;
    public static final Integer UPDATE_OK = 20031;
    public static final Integer GET_OK = 20041;

    public static final Integer SAVE_ERR = 20010;
    public static final Integer DELETE_ERR = 20020;
    public static final Integer UPDATE_ERR = 20030;
    public static final Integer GET_ERR = 20040;

    //业务操作返回
    public static final Integer SUCCESS = 10010;
    public static final Integer ERROR = 10011;
    public static final Integer WARN = 10020;

    //异常
    public static final Integer SYSTEM_ERR = 10020;
    public static final Integer BUSINESS_ERR = 10020;
    public static final Integer SYSTEM_TIMEOUT_ERR = 10020;
    public static final Integer SYSTEM_UNKNOW_ERR = 11111;
}

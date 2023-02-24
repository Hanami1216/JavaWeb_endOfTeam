package yokiware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/21  0:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oder {

    private int id;
    private String content;
    private String update_time;
    private String telephone_number;
    private int Payment_method;
    private int uid;

    private boolean state;

}

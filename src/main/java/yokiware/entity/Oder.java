package yokiware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/21  0:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oder {

    int id;
    String content;
    Timestamp update_time;
    String telephone_number;
    int Payment_method;
    int uid;

}

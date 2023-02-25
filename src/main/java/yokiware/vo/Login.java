package yokiware.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description :
 * @Author : YokiWare
 * @Date: 2023/2/25  11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Login {
    private boolean state;

    private int power;
}

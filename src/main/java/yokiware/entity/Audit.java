package yokiware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Audit {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private int power;
    private String password;
    private boolean state;
}

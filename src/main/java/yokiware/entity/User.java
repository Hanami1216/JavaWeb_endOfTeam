package yokiware.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String address;
    private int power;
    private String password;
}

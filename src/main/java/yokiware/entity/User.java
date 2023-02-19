package yokiware.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String sex;
    private String age;
    private String address;
    private int power;
    private String password;
}

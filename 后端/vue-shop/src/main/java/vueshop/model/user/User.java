package vueshop.model.user;

import lombok.Data;

@Data
public class User {

    private Integer user_id;
    private String userName;
    private String password;
    private String userPhoneNumber;
}

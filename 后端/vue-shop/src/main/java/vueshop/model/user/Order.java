package vueshop.model.user;

import lombok.Data;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
public class Order {
    private int id;
    private BigInteger order_id;
    private int user_id;
    private int product_id;
    private int product_num;
    private int product_price;
    private Timestamp order_time;
    private String product_picture;
    private String product_name;
}

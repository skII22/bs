package vueshop.model.user;

import lombok.Data;

@Data
public class ShoppingCart {
    private Long id;
    private int user_id;
    private int product_id;
    private int num;
}

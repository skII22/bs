package vueshop.model.user;

import lombok.Data;

import java.util.List;

@Data
public class Product_Picture {
    private int id;
    private int product_id;
    private String product_picture;
    private String intro;

}

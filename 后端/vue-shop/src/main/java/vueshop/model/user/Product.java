package vueshop.model.user;

import lombok.Data;

@Data
public class Product {
    private int product_id;
    private String product_name;
    private int category_id;
    private String product_title;
    private String product_intro;
    private String product_picture;
    private int product_price;
    private int product_selling_price;
    private int product_num;
    private int product_sales;

}

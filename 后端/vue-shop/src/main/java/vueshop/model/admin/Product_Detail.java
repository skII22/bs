package vueshop.model.admin;

import lombok.Data;

import java.util.List;
@Data
public class Product_Detail {
    private int id;
    private String name;
    private List imageUrl;
}

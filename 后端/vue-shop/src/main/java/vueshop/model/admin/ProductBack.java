package vueshop.model.admin;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import lombok.Data;
import vueshop.common.EnumCategory;

@Data
public class ProductBack {
    private int id;
    private String name;
    private EnumCategory CategoryId;
    private String title;
    private String intro;
    private String imageUrl;
    private int price;
    private int sellingPrice;
    private int num;
    private int sales;

}

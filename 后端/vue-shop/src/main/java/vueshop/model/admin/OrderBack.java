package vueshop.model.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

@Data
public class OrderBack {
    private int id;
    private BigInteger orderId;
    private String userName;
    private String product_name;
    private int productNum;
    private int productPrice;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date orderTime;
}

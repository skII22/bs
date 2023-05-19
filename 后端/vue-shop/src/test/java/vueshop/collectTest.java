package vueshop;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import vueshop.common.EnumCategory;

import java.text.SimpleDateFormat;
import java.util.*;


public class collectTest {
    @Test
    public void addCollect(){
        long l = System.currentTimeMillis();

        int r=new Random().nextInt(100);
        System.out.println(r);
        System.out.println(l+r);
    }
    @Test
    public void adfasf(){
        String s ="http://localhost:3000/public/imgs/goods/26d3e24c-e7fc-49ce-8798-722a4763ec25.jpg";
        System.out.println(s.substring(22));

    }
    @Test
    public void ad() {
        System.out.println(EnumCategory.fromJson(1).name());
    }

}

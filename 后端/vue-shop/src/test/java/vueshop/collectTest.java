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
<<<<<<< HEAD
    public void ttt(){
        String url ="http://localhost:81/public/imgs/goods/36ae6c45-2e82-4589-95e4-9ff311856696.jpg";
        String pre = "http://localhost:81/";
        if (url.startsWith(pre)){
            System.out.println("yes");
            url=url.substring(pre.length());
            System.out.println(url);
        }
=======
    public void ad() {
        System.out.println(EnumCategory.fromJson(1).name());
>>>>>>> 32478a31c06519498ac512df3778dd391cd6f415
    }

}

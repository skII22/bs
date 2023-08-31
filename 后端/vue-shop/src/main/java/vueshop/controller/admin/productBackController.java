package vueshop.controller.admin;

import com.github.pagehelper.PageInfo;
import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vueshop.common.Result;
import vueshop.model.admin.ProductBack;
import vueshop.service.admin.productBackService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@Log
@RequestMapping("/product")
public class productBackController {
    @Autowired
    productBackService service;
    @RequestMapping("/getAll")
    public Result getAll(@RequestParam("page")int page,@RequestParam("pageSize")int pageSize){
        PageInfo all = service.getAll(page,pageSize);
        return new Result<>("200",all);
    }
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile f,
    @RequestParam("name") String name,
    @RequestParam("price") String price,
    @RequestParam("title") String title,
    @RequestParam("intro") String intro,
    @RequestParam("categoryId") String categoryId,
    @RequestParam("sellingPrice") String sellPrice,
    @RequestParam("num") String num
    ) throws IOException {

        List<String> list  = new ArrayList<>();
        String path="src/main/resources/public/imgs/goods/";
        String Path="/public/imgs/goods/";
        String filename =f.getOriginalFilename();
        assert filename != null;
        String type = filename.contains(".") ? filename.substring(filename.lastIndexOf(".")): null;
        //uuid重新命名避免重复
        //拼接文件路径，方便前端接收
        String filepath = path + UUID.randomUUID() + type;
        File filePath = new File(path);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            outputStream.write(f.getBytes());
            list.add(filepath.replace(path,Path));
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
            }
        }
        // 数据库添加
        int i = service.addPicture(list.get(0), name, price, title, intro, categoryId, sellPrice, num);
        if (i==1) {
            String s = "http://localhost:81" + list.get(0);
            list.set(0, list.get(0)+s);
            return new Result<>("200",list,"success");
        }
        return new Result<>("400","error");




    }
    @RequestMapping("/upload-edit")
    public Result uploadEdit(@RequestParam("file") MultipartFile f,
                         @RequestParam("name") String name
    )throws Exception {

        List<String> list  = new ArrayList<>();
        String path="src/main/resources/public/imgs/goods/";
        String Path="/public/imgs/goods/";
        String filename =f.getOriginalFilename();
        assert filename != null;
        String type = filename.contains(".") ? filename.substring(filename.lastIndexOf(".")): null;
        //uuid重新命名避免重复
        //拼接文件路径，方便前端接收
        String filepath = path + UUID.randomUUID() + type;
        File filePath = new File(path);
        if (!filePath.exists()){
            filePath.mkdirs();
        }
        BufferedOutputStream outputStream = null;
        try {
            outputStream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));
            outputStream.write(f.getBytes());
            list.add(filepath.replace(path,Path));
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (outputStream != null) {
                outputStream.flush();
                outputStream.close();
            }
        }
        // 数据库添加
        int i = service.editPicture(list.get(0), name);
        if (i==1) {
            String s = "http://localhost:81" + list.get(0);
            list.set(0, list.get(0)+s);
            return new Result<>("200",list,"success");
        }
        return new Result<>("400","error");
    }
    @RequestMapping("/editForm")
    public Result<String> edit(@RequestBody ProductBack product){
        int edit = service.edit(product);
        return new Result<>("200","ss");
    }
    @RequestMapping("/delete")
    public Result<String> delete(@RequestBody List<Integer> data) {
        log.warning(String.valueOf(data));
        try {
            service.delete(data);
        } catch (Exception e) {
            return new Result<>("400","有订单或购物车有此商品不能删除");
        }
        return new Result<>("200","删除成功");
    }
    @RequestMapping("/deletePhoto")
    public Result<String> deletePhoto(@RequestBody Map map){
        String  url = (String) map.get("url");
        String pre = "http://localhost:81/";
        log.warning(url);
        if (url.startsWith(pre)){
            System.out.println("yes");
            url=url.substring(pre.length());
            System.out.println(url);
        }
        log.warning(url);
        service.deletePhoto(url);
        return new Result<>("200","success");
    }
}

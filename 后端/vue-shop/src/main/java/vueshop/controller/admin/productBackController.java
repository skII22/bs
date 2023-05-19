package vueshop.controller.admin;

import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vueshop.common.Result;
import vueshop.model.admin.ProductBack;
import vueshop.service.admin.productBackService;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@Log
@RequestMapping("/product")
public class productBackController {
    @Autowired
    productBackService service;
    @RequestMapping("/getAll")
    public Result getAll(){
        return new Result<>("200",service.getAll());
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
    )throws Exception {
        String UID = String.valueOf(UUID.randomUUID());
        String newFilename = UID+".jpg"; // 新文件名
        String storageDirectoryPath = "src/main/resources/public/imgs/goods/";
        // 创建一个临时文件并将 multipartFile 中的数据复制到该文件中
        File tempFile = File.createTempFile("temp", null);
        f.transferTo(tempFile);
        // 对临时文件进行重命名
        File renamedFile = new File(tempFile.getParentFile(), newFilename);
        tempFile.renameTo(renamedFile);
        // 创建目标存储位置（如果不存在）
        File storageDirectory = new File(storageDirectoryPath);
        if (!storageDirectory.exists()) {
            storageDirectory.mkdirs();
        }
        // 将重命名后的文件移动到目标存储位置
        FileUtils.moveFileToDirectory(renamedFile, storageDirectory, true);
        // 删除临时文件
//        tempFile.delete();
//        int productId = service.findId(name);
//        switch (categoryId){
//            case "手机":
//                categoryId="1";
//            break;
//            case "电视机":
//                categoryId="2";;
//            break;
//            case "空调":
//                categoryId="3";;
//            break;
//            case "洗衣机":
//                categoryId="4";;
//            break;
//            case "保护套":
//                categoryId="5";;
//            break;
//            case "保护膜":
//                categoryId="6";;
//                break;
//            case "充电器":
//                categoryId="7";;
//                break;
//            case "充电宝":
//                categoryId="8";;
//                break;
//            default:
//                break;
//        }

        int i = service.addPicture("public/imgs/goods/" + UID + ".jpg", name, price, title, intro, categoryId, sellPrice, num);
        if (i==1) {
            String url = "http://localhost:3000/public/imgs/goods/"+UID+".jpg";
            return new Result<>("200",url,"success");
        }
        return new Result<>("400","error");
    }
    @RequestMapping("/upload-edit")
    public Result uploadEdit(@RequestParam("file") MultipartFile f,
                         @RequestParam("name") String name
    )throws Exception {
        String UID = String.valueOf(UUID.randomUUID());
        String newFilename = UID+".jpg"; // 新文件名
        String storageDirectoryPath = "src/main/resources/public/imgs/goods/";
        // 创建一个临时文件并将 multipartFile 中的数据复制到该文件中
        File tempFile = File.createTempFile("temp", null);
        f.transferTo(tempFile);
        // 对临时文件进行重命名
        File renamedFile = new File(tempFile.getParentFile(), newFilename);
        tempFile.renameTo(renamedFile);
        // 创建目标存储位置（如果不存在）
        File storageDirectory = new File(storageDirectoryPath);
        if (!storageDirectory.exists()) {
            storageDirectory.mkdirs();
        }
        // 将重命名后的文件移动到目标存储位置
        FileUtils.moveFileToDirectory(renamedFile, storageDirectory, true);
        // 删除临时文件
//        tempFile.delete();
//        int productId = service.findId(name);
          service.editPicture("public/imgs/goods/" + UID + ".jpg",name);

            String url = "http://localhost:3000/public/imgs/goods/"+UID+".jpg";
            return new Result<>("200",url,"success");
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
    public Result<String> deletePhoto(@RequestBody String url){
        url = url.substring(30,url.length()-2);
        log.warning(url);
        service.deletePhoto(url);
        return new Result<>("200","success");
    }
}

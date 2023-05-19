package vueshop.controller.admin;

import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vueshop.common.Result;
import vueshop.model.admin.Product_Detail;
import vueshop.service.admin.goodsService;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Log
@RestController
@RequestMapping("/goods")
public class goodsController {
    // 商品详细页图片
    @Autowired
    goodsService service;
    @RequestMapping("/getDetail")
    public Result getProduct(){
        List detail = service.getDetail();
        return new Result("200",detail);
    }
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile f,String name) throws Exception {
        String UID = String.valueOf(UUID.randomUUID());
        String newFilename = UID+".jpg"; // 新文件名
        String storageDirectoryPath = "src/main/resources/public/imgs/product_picture/";
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
        tempFile.delete();

        int productId= service.findId(name);
        service.addPicture("public/imgs/product_picture/"+UID+".jpg",productId);
        String url = "http://localhost:3000/public/imgs/product_picture/"+UID+".jpg";
        return new Result<>("200",url,"success");
    }
    @RequestMapping("/editForm")
    public Result<String> edit(@RequestBody Product_Detail detail){
        int id = detail.getId();
        String name = detail.getName();
        List image = detail.getImageUrl();
        for (int i = 0; i < image.size(); i++) {
            image.set(i, image.get(i).toString().substring(22));
        }
        log.info(String.valueOf(detail));
        service.editName(id, name);
        for (int i = 0; i < image.size(); i++) {
            service.edit(id, String.valueOf(image.get(i)));
        }


        return new Result<>("200","s");
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
        service.deletePhoto(url);
        return new Result<>("200","success");
    }
}

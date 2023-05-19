package vueshop.controller.admin;

import lombok.extern.java.Log;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vueshop.common.Result;
import vueshop.service.user.resourceService;
import java.io.File;
import java.util.UUID;

@Log
@RestController
@RequestMapping("/goods")
public class UploadController {
    @Autowired
    resourceService service;
    @RequestMapping("/carousel-upload")
    public Result uploadProduct(@RequestParam("file") MultipartFile f) throws Exception {

        String UID = String.valueOf(UUID.randomUUID());
        String newFilename = UID+".jpg"; // 新文件名
        String storageDirectoryPath = "src/main/resources/public/imgs/carousel/";
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
        service.addPicture("public/imgs/carousel/"+UID+".jpg");
        String url = "http://localhost:3000/public/imgs/carousel/"+UID+".jpg";
        return new Result<>("200",url);
    }
}

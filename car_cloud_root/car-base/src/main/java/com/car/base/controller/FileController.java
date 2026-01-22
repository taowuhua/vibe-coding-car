package com.car.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.car.base.common.Result;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    // 默认上传路径，可以通过配置文件覆盖
    @Value("${file.upload-dir:./uploads}")
    private String uploadDir;

    @PostMapping("/upload")
    public Result<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return Result.error(400, "File is empty");
        }

        try {
            // 确保目录存在
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // 生成新文件名防止冲突
            String originalFilename = file.getOriginalFilename();
            String extension = "";
            if (originalFilename != null && originalFilename.contains(".")) {
                extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            }
            String newFilename = UUID.randomUUID().toString() + extension;
            
            // 保存文件
            File dest = new File(directory, newFilename);
            file.transferTo(dest);

            logger.info("File uploaded successfully: {}", dest.getAbsolutePath());

            Map<String, Object> data = new HashMap<>();
            data.put("url", dest.getAbsolutePath()); // 实际项目中应该返回访问URL
            data.put("filename", newFilename);
            
            return Result.success(data, "Upload successful");
        } catch (IOException e) {
            logger.error("Upload failed", e);
            throw new RuntimeException("Upload failed: " + e.getMessage());
        }
    }
}

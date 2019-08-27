package com.upload.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FileHandlers {
    private static final Logger log = LoggerFactory.getLogger(FileHandlers.class);

    /**
     *
     * @param file
     * @return
     */
    public static Map<String, String> uploadFile(MultipartFile file, String destFolderPath) {
        Map<String, String> resultMap = new HashMap<>();
        try {
            if (file.isEmpty()) {
                resultMap.put("code", StatusCodeEnum.FAIL.getStatusCode());
                resultMap.put("message", "No source file chosen, Please select a file to upload");
                return resultMap;
            }

            String sourceFileName = file.getOriginalFilename();
            String fileSuffix = sourceFileName.substring(sourceFileName.lastIndexOf("."));
            log.info("Prepare to send file path : {}", sourceFileName);

            String destFileName = Calendar.getInstance().getTimeInMillis() + "-" + sourceFileName.substring(0, sourceFileName.indexOf(fileSuffix)) + fileSuffix;
            String fileStorageFullPath =  destFolderPath + destFileName;
            File destFile = new File(destFolderPath + destFileName);
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }
            file.transferTo(destFile);
            log.info("Upload Succeed, file location is {}.", fileStorageFullPath);
            resultMap.put("code", StatusCodeEnum.SUCCESS.getStatusCode());
            resultMap.put("message", "Upload Success");
            resultMap.put("fileSize", String.valueOf(file.getSize()));
            resultMap.put("fileUrl", "/uploaded/" + destFileName);
            return resultMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultMap.put("code", StatusCodeEnum.FAIL.getStatusCode());
        resultMap.put("message", "Exception Occurred");
        return resultMap;
    }


}

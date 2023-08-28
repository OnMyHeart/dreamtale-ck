package com.dreamtale.ck.utils;

import com.alibaba.fastjson.JSONObject;
import com.dreamtale.ck.entity.json.FileAttributesJson;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileSystemUtils {

    public static List<FileAttributesJson> getFileList(String path) {
        List<FileAttributesJson> fileAttributesJsonList = new ArrayList<>();
        try {
            List<Path> fileList = Files.list(Paths.get(path)).collect(Collectors.toList());
            if (!CollectionUtils.isEmpty(fileList)) {
                fileAttributesJsonList = fileList.stream().map(p -> {
                    FileAttributesJson fileAttributesJson = new FileAttributesJson();
                    fileAttributesJson.setFileOrFolder(1);
                    fileAttributesJson.setName(p.getFileName().toString());
                    fileAttributesJson.setPath("movie/" + fileAttributesJson.getName());
                    return fileAttributesJson;
                }).collect(Collectors.toList());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileAttributesJsonList;
    }
}

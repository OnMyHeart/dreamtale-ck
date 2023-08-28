package com.dreamtale.ck.entity.json;

public class FileAttributesJson {

    private String path;

    private String name;

    private Integer fileOrFolder;


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFileOrFolder() {
        return fileOrFolder;
    }

    public void setFileOrFolder(Integer fileOrFolder) {
        this.fileOrFolder = fileOrFolder;
    }
}

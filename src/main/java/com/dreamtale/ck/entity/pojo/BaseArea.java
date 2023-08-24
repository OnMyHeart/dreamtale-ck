package com.dreamtale.ck.entity.pojo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.time.LocalDateTime;
import java.util.List;

public class BaseArea {

    private Long id;
    private String name;
    private Integer level;
    private Long parentId;
    private String pinyin;
    private String abbreviationPinyin;
    private String fullName;
    private String fullPinyin;
    private String abbreviationFullPinyin;
    private String parentUrl;
    private String childrenUrl;
    private Integer sortIndex;
    private Integer status;
    List<BaseArea> children;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullPinyin() {
        return fullPinyin;
    }

    public void setFullPinyin(String fullPinyin) {
        this.fullPinyin = fullPinyin;
    }

    public String getAbbreviationPinyin() {
        return abbreviationPinyin;
    }

    public void setAbbreviationPinyin(String abbreviationPinyin) {
        this.abbreviationPinyin = abbreviationPinyin;
    }

    public String getAbbreviationFullPinyin() {
        return abbreviationFullPinyin;
    }

    public void setAbbreviationFullPinyin(String abbreviationFullPinyin) {
        this.abbreviationFullPinyin = abbreviationFullPinyin;
    }

    public String getParentUrl() {
        return parentUrl;
    }

    public void setParentUrl(String parentUrl) {
        this.parentUrl = parentUrl;
    }

    public String getChildrenUrl() {
        return childrenUrl;
    }

    public void setChildrenUrl(String childrenUrl) {
        this.childrenUrl = childrenUrl;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public List<BaseArea> getChildren() {
        return children;
    }

    public void setChildren(List<BaseArea> children) {
        this.children = children;
    }

    public void text2Pinyin(String text) throws BadHanyuPinyinOutputFormatCombination {
        HanyuPinyinCaseType  hanyuPinyinCaseType = HanyuPinyinCaseType.LOWERCASE;
        HanyuPinyinToneType hanyuPinyinToneType = HanyuPinyinToneType.WITHOUT_TONE;
        HanyuPinyinVCharType hanyuPinyinVCharType = HanyuPinyinVCharType.WITH_V;
        char[] charArr = text.trim().toCharArray();
        StringBuilder fullAbbreviation = new StringBuilder();
        StringBuilder fullName = new StringBuilder();
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setCaseType(hanyuPinyinCaseType);
        hanyuPinyinOutputFormat.setToneType(hanyuPinyinToneType);
        hanyuPinyinOutputFormat.setVCharType(hanyuPinyinVCharType);
        for (int i = 0; i< charArr.length; i++) {
            if (Character.toString(charArr[i]).matches("[\\u4E00-\\u9FA5]+")) {
                String[] pinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(charArr[i], hanyuPinyinOutputFormat);
                String fullPinYin = pinyinStringArray[0];
                String abbreviation = Character.toString(fullPinYin.charAt(0)).toUpperCase();
                fullName.append(abbreviation).append(fullPinYin.substring(1));
                fullAbbreviation.append(abbreviation);
            }
        }
        this.setPinyin(fullName.toString());
        this.setAbbreviationPinyin(fullAbbreviation.toString());
    }

}

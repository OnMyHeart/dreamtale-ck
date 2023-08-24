package com.dreamtale.ck.utils;

import com.alibaba.fastjson.JSONObject;
import com.dreamtale.ck.entity.pojo.BaseArea;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class BaseAreaSpiderUtils {

    private static Logger logger = LoggerFactory.getLogger(BaseAreaSpiderUtils.class);

    static String INSERT_SQL = "INSERT INTO `base_area`(`id`, `name`, `level`, `parent_id`, `abbreviation_pinyin`, `pinyin`, `full_name`, `full_pinyin`, `abbreviation_full_pinyin`, `sort_index`, `parent_url`, `children_url`, `status`, `create_time`, `update_time`) " +
            " (%s, \"%s\", %s, %s, \"%s\", \"%s\", \"%s\",\" %s\", \"%s\",%s, \"%s\", \"%s\", 0, now(), now());\r";

    public static List<BaseArea> getProvinceList() throws Exception {
        List<BaseArea> area = new ArrayList<>();
        String className  = "provincetr";
        Map<String, String> classNameMap = new HashMap<>();
        classNameMap.put("provincetr","citytr");
        classNameMap.put("citytr","countytr");
        classNameMap.put("countytr","towntr");
        classNameMap.put("towntr","villagetr");
        String url = "http://www.stats.gov.cn/sj/tjbz/tjyqhdmhcxhfdm/2022/";
        String parentUrl = url + "index.html";
        Document document = getDocument(parentUrl);
        Elements elements = document.getElementsByClass(className);
        int i = 0;
        try {
            FileWriter fw = new FileWriter("../base_area.sql", true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Element element : elements) {
                Elements aList = element.getElementsByTag("a");
                for (Element a : aList) {
                    String provinceName = a.text();
                    if (!StringUtils.equals("北京市", provinceName)
                            && !StringUtils.equals("河北省", provinceName)
                            && !StringUtils.equals("山西省", provinceName)
                            && !StringUtils.equals("辽宁省", provinceName)
                            && !StringUtils.equals("内蒙古自治区", provinceName)
                            && !StringUtils.equals("天津市", provinceName)) {
                        String href = a.attr("href");
                        String[] attr = href.split("\\.");
                        String ids = attr[0] + "0000000000";
                        Long id = Long.parseLong(ids);
                        BaseArea province = new BaseArea();
                        province.setId(id);
                        province.setName(provinceName);
                        province.setParentId(1L);
                        province.setParentUrl(parentUrl);
                        province.setChildrenUrl(url + href);
                        province.setLevel(1);
                        province.setCreateTime(LocalDateTime.now());
                        province.setUpdateTime(LocalDateTime.now());
                        province.setStatus(0);
                        province.setSortIndex(i++);
                        province.text2Pinyin(provinceName);
                        province.setAbbreviationFullPinyin(province.getAbbreviationPinyin());
                        province.setFullPinyin(province.getPinyin());
                        province.setFullName(province.getName());
                        area.add(province);
//                        new JDBCConnection(province);
                        String sql = String.format(INSERT_SQL,
                                province.getId(),
                                province.getName(),
                                province.getLevel(),
                                province.getParentId(),
                                province.getAbbreviationPinyin(),
                                province.getPinyin(),
                                province.getFullName(),
                                province.getFullPinyin(),
                                province.getAbbreviationFullPinyin(),
                                province.getSortIndex(),
                                province.getParentUrl(),
                                province.getChildrenUrl()
                        );
                        bw.write(sql);

                        List<BaseArea> children = getChild(url, href, classNameMap.get(className), classNameMap, province);
                        if (children.size()>0) {
                            for (BaseArea child : children) {
                                String temp = String.format(INSERT_SQL,
                                        child.getId(),
                                        child.getName(),
                                        child.getLevel(),
                                        child.getParentId(),
                                        child.getAbbreviationPinyin(),
                                        child.getPinyin(),
                                        child.getFullName(),
                                        child.getFullPinyin(),
                                        child.getAbbreviationFullPinyin(),
                                        child.getSortIndex(),
                                        child.getParentUrl(),
                                        child.getChildrenUrl()
                                );
                                bw.write(temp);
                            }
                        }
                        bw.flush();
                        bw.close();
                        fw.close();
                        area.addAll(getChild(url, href, classNameMap.get(className), classNameMap, province));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static List<BaseArea> getChild(String url, String childHref, String className, Map<String, String> classNameMap, BaseArea parentBaseArea) throws Exception {
        Document document = getDocument(url + childHref);
        Elements elements = document.getElementsByClass(className);
        List<BaseArea> children = new ArrayList<>();
        int i = 0;
        for (Element element : elements) {
            Elements childList = element.getElementsByTag("td");
            Element childIdTr = childList.get(0);
            Element childNameTr = childList.get(1);
            String childName = childNameTr.getElementsByTag("a").text();
            if (StringUtils.isBlank(childName)) {
                childName = childNameTr.text();
            }
            String href = childNameTr.getElementsByTag("a").attr("href");
            String childIds = childIdTr.getElementsByTag("a").text();
            if (StringUtils.isBlank(childIdTr.getElementsByTag("a").text())) {
                childIds = childIdTr.text();
            }
            Long childId = Long.parseLong(childIds);
            String tempUrl = url + childHref;
            tempUrl = tempUrl.substring(0, tempUrl.lastIndexOf("/") + 1);
            BaseArea child = new BaseArea();
            child.setId(childId);
            child.setName(childName);
            child.setParentId(parentBaseArea.getParentId());
            child.setParentUrl(url + childHref);
            child.setChildrenUrl(tempUrl);
            child.setLevel(parentBaseArea.getLevel() + 1);
            child.setCreateTime(LocalDateTime.now());
            child.setUpdateTime(LocalDateTime.now());
            child.setStatus(0);
            child.setParentId(parentBaseArea.getId());
            child.setSortIndex(i++);
            child.text2Pinyin(child.getName());
            child.setFullName(parentBaseArea.getFullName() + child.getName());
            child.setAbbreviationFullPinyin(parentBaseArea.getAbbreviationFullPinyin() + child.getAbbreviationPinyin());
            child.setFullPinyin(parentBaseArea.getFullPinyin() + child.getPinyin());
            children.add(child);
//            new JDBCConnection(child);
            if (StringUtils.isNotBlank(href)) {
                String childClassName = classNameMap.get(className);
                if ("villagetr".equals(childClassName)) {
                    children.addAll(getVillage(tempUrl, href, childClassName, child));
//                    child.setChildren(getVillage(tempUrl, href, childClassName, child));
                } else {
                    children.addAll(getChild(tempUrl, href, childClassName, classNameMap, child));
//                    child.setChildren(getChild(tempUrl, href, childClassName, classNameMap, child));
                }
            }

        }
        return children;
    }

    private static List<BaseArea> getVillage(String url, String childHref, String className, BaseArea parentBaseArea) throws Exception {
        Document document = getDocument(url + childHref);
//        Document document = Jsoup.parse(new URL(url + childHref), 30000);
        Elements elements = document.getElementsByClass(className);
        List<BaseArea> villageList = new ArrayList<>();
        int i = 0;
        for (Element element : elements) {
            Elements childList = element.getElementsByTag("td");
            Element childIdTr = childList.get(0);
            Element childNameTr = childList.get(2);
            String childName = childNameTr.text();
            Long childId = Long.parseLong(childIdTr.text());
            BaseArea child = new BaseArea();
            child.setId(childId);
            child.setName(childName);
            child.setParentId(parentBaseArea.getParentId());
            child.setParentUrl(url + childHref);
            child.setChildrenUrl(null);
            child.setLevel(parentBaseArea.getLevel() + 1);
            child.setCreateTime(LocalDateTime.now());
            child.setUpdateTime(LocalDateTime.now());
            child.setStatus(0);
            child.setParentId(parentBaseArea.getId());
            child.setSortIndex(i++);
            child.text2Pinyin(child.getName());
            child.setFullName(parentBaseArea.getFullName() + child.getName());
            child.setAbbreviationFullPinyin(parentBaseArea.getAbbreviationFullPinyin() + child.getAbbreviationPinyin());
            child.setFullPinyin(parentBaseArea.getFullPinyin() + child.getPinyin());
//            new JDBCConnection(child);
            villageList.add(child);
        }
        return villageList;
    }

    public static Document getDocument(String url) throws InterruptedException {
        Document document = null;
        try {
            document = Jsoup.parse(new URL(url), 30000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Thread.sleep(30000);
            document = getDocument(url);
        }
        if (!Objects.isNull(document)) {
            return document;
        } else {
            return getDocument(url);
        }
    }

}

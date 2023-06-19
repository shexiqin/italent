package com.soft.italent.util;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Word 操作工具类
 */
public class WordUtil {
    // 定义静态的文件后缀
    public static final String SUFFIX_DOC = ".doc";
    public static final String SUFFIX_DOCX = ".docx";

    /**
     * 读取 Word 入口方法，根据后缀，调用方法
     * @param suffix 文件后缀
     * @param inputStream 文件输入流
     * @return
     */
    private static String readWord(String suffix, InputStream inputStream) {
        // docx 类型
        if (SUFFIX_DOCX.equals(suffix)) {
            return readDocx(inputStream);
        // doc 类型
        } else if (SUFFIX_DOC.equals(suffix)) {
            return readDoc(inputStream);
        } else {
            return null;
        }
    }

    /**
     * 读取 doc 类型，使用 WordExtractor 对象，传递输入流
     *
     * @param inputStream
     * @return
     */
    public static String readDoc(InputStream inputStream) {
        try {
            String content = "";
            WordExtractor ex = new WordExtractor(inputStream);
            content = ex.getText();
            ex.close();
            return content;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 读取 docx 类型，使用 XWPFDocument 对象，传递输入流
     *
     * @param inputStream
     * @return
     */
    public static String readDocx(InputStream inputStream) {
        try {
            String content = "";
            XWPFDocument xdoc = new XWPFDocument(inputStream);
            XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);
            content = extractor.getText();
            extractor.close();

            return content;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 识别 word 文档
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static Map<String, String> readWord2Txt(MultipartFile file) throws IOException {
        if (file == null) {
            return new HashMap<>();
        }

        String originalFilename = file.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(i);


        // 获取word文本
        String text = readWord(suffix, file.getInputStream());

        if(text != null){
            text = text.replace(" ", "");
        }

        Map<String, String> map = new HashMap<>();
        map.put("result", text);
        map.putAll(ResumeUtil.pattern(text));

        if(originalFilename.indexOf("智联简历") != -1){
            String[] s = originalFilename.split("_");
            map.put("name1", s[0]);
            map.put("jobname", s[2]);
            map.put("region", s[3]); // 期望工作地点
            map.put("resource", "智联招聘"); // 期望工作地点
        }


        return map;
    }



}

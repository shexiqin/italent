package com.soft.italent.util;

import com.soft.common.utils.file.FileUploadUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResumeUtil {

    public static Map<String, String> readDoc2Txt(MultipartFile multipartFile, String resumePath) throws IOException {

        if(multipartFile == null){
            return null;
        }

        String originalFilename = multipartFile.getOriginalFilename();
        Map<String, String> stringMap = null;
        if(originalFilename.endsWith(WordUtil.SUFFIX_DOC) || originalFilename.endsWith(WordUtil.SUFFIX_DOCX)){
            stringMap = WordUtil.readWord2Txt(multipartFile);
        } else if(originalFilename.endsWith(PdfUtil.SUFFIX_PDF)){
            stringMap = PdfUtil.readPdf2Txt(multipartFile);
        }

        return stringMap;
    }

    /**
     * 上传文件
     * @param file
     * @param resumePath
     * @return
     * @throws IOException
     */
    public static String upload(MultipartFile file, String resumePath) throws IOException {
        // 文件夹对象
        File folder = new File(resumePath);

        // 文件夹创建
        if(!folder.exists()){
            folder.mkdirs();
        }

        String originalFilename = file.getOriginalFilename();
        int j = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(j);
        // DB 名字
        String fileName = UUID.randomUUID().toString() + suffix;
        // 文件路径
        String url = FileUploadUtils.getPathFileName(resumePath, fileName);
        // Word 文件转化为 PDF
        if(originalFilename.endsWith(WordUtil.SUFFIX_DOC) || originalFilename.endsWith(WordUtil.SUFFIX_DOCX)){
            // word 转 pdf 新的文件名
            String w2pName = "W2P-" + fileName + PdfUtil.SUFFIX_PDF;
            PdfUtil.word2Pdf(file.getInputStream(), resumePath, w2pName);
            url = FileUploadUtils.getPathFileName(resumePath, w2pName);
        }
        // 文件上传到本地 PDF和Word都上传
        file.transferTo(new File(resumePath, fileName));

        return url;
    }

    /**
     * 通过正则表达式匹配指定信息
     *
     * @param str
     * @return
     */
    public static Map<String, String> pattern(String str) {

        // 定义固定的正则表达式
        Map<String, String> pats = new HashMap<>();

        pats.put("name1", "(姓名|名前)[:：\\s]([a-zA-Z\\u4e00-\\u9fa5]{2,3})");
        pats.put("name4", "(姓名|名前)([a-zA-Z\\u4e00-\\u9fa5]{2,4})");
        pats.put("name2", "()([a-zA-Z\\u4e00-\\u9fa5]{2,})(点击此处联系候选人)");
        pats.put("name3", "(姓\\s{0,}名)[:：\\s]([a-zA-Z\\u4e00-\\u9fa5]{2,3})");
        pats.put("name5", "()([\\u4e00-\\u9fa5]{2,3})([0-9]{11})");

        pats.put("tel", "()([0-9*]{11})");
        pats.put("address", "(地址)[:：\\s](\\S{0,})");
        pats.put("birthday", "(出生年月|生日|出生日期)[:：\\s](\\S{0,10})");
        pats.put("graduate", "(毕业时间)[:：\\s](\\S{0,})");
        pats.put("sex", "()(男|女)");
        pats.put("education", "(学历)[:：\\s](\\S{0,})");
        pats.put("prjexp", "(项目经验)[:：\\s]([.\r\n\t\\s\\S]*)");

        pats.put("exp1", "()([0-9]{0,2})(年工作经验)");
        pats.put("exp2", "(工作经验)[:：\\s]([0-9]{0,2})");

        pats.put("age1", "()([0-9]{2})(岁)");
        pats.put("age2", "(年龄)[:：\\s]([0-9]{2})");

        pats.put("jobname", "(求职方向|求职意向|期望职业|期望职能|目标职位)[:：\\s](.{3,9})");

        Map<String, String> result = new HashMap<>();

        if (str == null || "".equals(str)) {
            return result;
        }

        pats.forEach((k, v) -> {
            Pattern pattern = Pattern.compile(v);
            if (pattern != null) {
                Matcher matcher = pattern.matcher(str.trim().replace(" ", "").replaceAll("\t",""));
                if (matcher.find()) {
                    String group = matcher.group(2);
                    if (group == null) {
                        group = "";
                    }
                    result.put(k, group.trim());
                }
            }
        });

        return result;
    }
}

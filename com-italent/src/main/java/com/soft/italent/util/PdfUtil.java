package com.soft.italent.util;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class PdfUtil {
    // 定义静态后缀
    public static final String SUFFIX_PDF = ".pdf";

    /**
     * PDF 转 文字
     *
     * @param multipartFile
     * @return
     */
    public static Map<String, String> readPdf2Txt(MultipartFile multipartFile) {
        PDDocument document = null;
        String content = "";
        try {
            document = PDDocument.load(multipartFile.getInputStream());
            int pageSize = document.getNumberOfPages();
            // 一页一页读取
            for (int i = 0; i < pageSize; i++) {
                // 文本内容
                PDFTextStripper stripper = new PDFTextStripper();
                // 设置按顺序输出
                stripper.setSortByPosition(true);
                stripper.setStartPage(i + 1);
                stripper.setEndPage(i + 1);
                String text = stripper.getText(document);
                content += text.trim() + "\n";
            }

            if(content != null){
                content = content.replace(" ", "").replace("\n", "").replace("\r", "");
            }


            Map<String, String> map = new HashMap<>();
            map.put("result", content);
            map.putAll(new ResumeUtil().pattern(content));

            return map;
        } catch (InvalidPasswordException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (IOException e) {
            }
        }
        return null;
    }

    /**
     * word 转 PDF
     * @param inputStream
     * @param resumePath
     * @return
     */
    public static void word2Pdf(InputStream inputStream, String resumePath, String fileName){
        try  {
            OutputStream outputStream = new FileOutputStream(new File(resumePath, fileName));
            IConverter converter = LocalConverter.builder().build();
            converter.convert(inputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

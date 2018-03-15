package com.zhoulin.demo.utils;

import com.ansj.vec.constants.Constants;
import org.apache.commons.io.FileUtils;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

/**
 * Created by Jackie on 2016/12/3 0003.
 */
public class TokenizerAnalyzerUtils {

    public TokenizerAnalyzerUtils(){

    }


    public static void main(String args[]   ) throws IOException {
        String tokenizerResult = getAnalyzerResult("证据 取证 提交 配偶 第三者 离婚 当事人 ");
        System.out.println(tokenizerResult);
    }

    public static String getAnalyzerResult(String input) {
        StringReader sr=new StringReader(input);
        IKSegmenter ik=new IKSegmenter(sr, true);//true is use smart
        Lexeme lex=null;
        List<String> stopWordsList = getStopWordsList();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while((lex=ik.next())!=null){
                if(stopWordsList.contains(lex.getLexemeText())) {
                    continue;
                }
                stringBuilder.append(lex.getLexemeText() + Constants.BLANKSPACE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to parse input content");
        }
        return stringBuilder.toString();
    }


    private static List<String> getStopWordsList(){
        List<String> stopWordList = null;
        File stopWordFile = new File(TokenizerAnalyzerUtils.class.getResource("/library/stopwords.dic").getPath());
//          File stopWordFile = new File(TokenizerAnalyzerUtils.class.getResource("/library/stopwords/swresult_withoutnature.txt").getPath());
        try {
             stopWordList = FileUtils.readLines(stopWordFile, Constants.ENCODING);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("fail to load stop word dictionary");
        }
        return stopWordList;
    }

}

package com.zhoulin.demo;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.search.SearchService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.logging.Logger;


public class SearchServiceTest extends DemoApplicationTests {

    @Autowired
    private SearchService searchService;

    @Autowired
    private InformationService informationService;

    @Test
    public void indexTest(){
        long id = 9380;
        searchService.index(id);
//        Assert.assertTrue(isSuccess);
}
    @Test
    public void infoTest(){
        long id = 9380;
        try {
            Information information = informationService.getInfoByInfoId(id);
            System.out.println(information.getDescription());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Assert.assertTrue(isSuccess);
    }

    @Test
    public void removeTest(){
        long id = 4416L;
        searchService.remove(id);
    }

    @Test
    public void foreachTest(){
        try {
            List<Information> infoList = informationService.findAll();

            for (Information information: infoList) {
                long id = information.getId();
                searchService.indexPro(id);
//                Assert.assertTrue(isSuccess);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Test
    public void testQuery(){

        InfoSearch infoSearch = new InfoSearch();

        infoSearch.setTitleSearch("美");

        searchService.query(infoSearch);

        ServiceMultiResult<Long> multiResult = searchService.query(infoSearch);

//        Assert.assertEquals(1, multiResult.getTotal());
        System.out.println("dasdasdasdasdas:      " + multiResult.getTotal());
    }

    @Test
    public void testWord2Vec(){
        String info = "";
        String content = "";
        try {
            List<Information> informationList = informationService.findAll();
            for (Information information: informationList) {
                info = info + "\n" + information.getDescription();
                content = content + "\n" + information.getContent();
            }
            System.out.println(">>>>>>>" + info);
            System.out.println("<<<<<<<" + content);

            File writename = new File("D:\\Java\\generator\\src\\main\\resources\\library\\word2vec.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            out.write(info + content); // \r\n即为换行
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

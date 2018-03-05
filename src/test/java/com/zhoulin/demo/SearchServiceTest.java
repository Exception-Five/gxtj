package com.zhoulin.demo;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.search.SearchService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SearchServiceTest extends DemoApplicationTests {

    @Autowired
    private SearchService searchService;

    @Autowired
    private InformationService informationService;

    @Test
    public void indexTest(){
        long id = 4415L;
        boolean isSuccess = searchService.index(id);
        Assert.assertTrue(isSuccess);
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
                boolean isSuccess = searchService.index(id);
                Assert.assertTrue(isSuccess);
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }


}

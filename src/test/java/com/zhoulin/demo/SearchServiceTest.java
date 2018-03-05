package com.zhoulin.demo;

import com.zhoulin.demo.service.search.SearchService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class SearchServiceTest extends DemoApplicationTests {

    @Autowired
    private SearchService searchService;

    @Test
    public void indexTest(){
        long id = 4415L;
        boolean isSuccess = searchService.index(id);
        Assert.assertTrue(isSuccess);
}

    @Test
    public void removeTest(){
        long id = 4415L;
        searchService.remove(id);
}

}

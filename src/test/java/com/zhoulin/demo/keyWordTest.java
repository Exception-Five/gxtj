package com.zhoulin.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhoulin.demo.bean.Info;
import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import org.elasticsearch.search.SearchHit;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class keyWordTest extends DemoApplicationTests{

    @Autowired
    private ModService modService;

    @Autowired
    private InformationService informationService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void kwTest(){

        List<Information> informationList = new ArrayList<>();

        boolean isSuccess = false;
        try {
            informationList = informationService.findAll();
            for (Information information: informationList) {
                isSuccess = modService.modAnalyse(information.getId());
                Assert.assertTrue(isSuccess);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        long id = 21316;
//
//        boolean isSuccess = false;
//
//        try {
//            isSuccess = modService.modAnalyse(id);
//
//            Assert.assertTrue(isSuccess);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    /**
     * 多字段抓取
     */
    @Test
    public void queryMutiTest(){

        InfoSearch infoSearch = new InfoSearch();

        String keywords = "";

        long id = 25886;

        List<Information> informationList = new ArrayList<>();

        try {
            Information information = informationService.getInfoByInfoId(id);

            keywords = information.getKeyword();

            infoSearch.setMutiContent(keywords);

            ServiceMultiResult<String> multiResult = modService.queryMuti(infoSearch);

            multiResult.getResult();

            for (String rs:multiResult.getResult()) {
//                System.out.println(rs);
                Info information1 = objectMapper.readValue(rs, Info.class);
                System.out.println("转换结果："  +  information1.toString());
            }

            System.out.println("<><><>" + multiResult.getTotal() );


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

package com.zhoulin.demo;

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

    }

    @Test
    public void queryMutiTest(){

        InfoSearch infoSearch = new InfoSearch();

        String keywords = "";

        long id = 9323;

        List<Information> informationList = new ArrayList<>();

        try {
            Information information = informationService.getInfoByInfoId(id);

            keywords = information.getKeyword();

            infoSearch.setMutiContent(keywords);

            ServiceMultiResult<Long> multiResult = modService.queryMuti(infoSearch);

            multiResult.getResult();

            System.out.println(multiResult.getResult().get(0) + "<><><>" + multiResult.getResult().size() + multiResult.getResult().get(1));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import com.zhoulin.demo.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 推送功能模块
 */
@Component
public class PushServiceImpl implements PushService {

    @Autowired
    private ModService modService;

    @Autowired
    private InformationService informationService;

    @Override
    public long pushInformation(long id) {

        boolean isSuccess = false;

        InfoSearch infoSearch = new InfoSearch();

        String keywords = "";

        List<Information> informationList = new ArrayList<>();

        try {
            isSuccess = modService.modAnalyse(id);
            if (isSuccess == true){
                Information information = informationService.getInfoByInfoId(id);

                keywords = information.getKeyword();

                infoSearch.setMutiContent(keywords);

                ServiceMultiResult<Long> multiResult = modService.queryMuti(infoSearch);

                return multiResult.getResult().get(1);
            }
            return -1L;
        } catch (Exception e) {
            e.printStackTrace();
            return -1L;
        }

    }
}

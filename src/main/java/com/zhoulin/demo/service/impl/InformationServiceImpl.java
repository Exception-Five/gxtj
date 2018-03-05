package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.mapper.InformationMapper;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.search.SearchService;
import com.zhoulin.demo.utils.VerificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

    @Autowired
    private InformationMapper informationMapper;

    @Autowired
    private SearchService searchService;

    @Autowired
    private VerificationUtils verificationUtils;

    @Override
    public InfoSearch getInitInfo(InfoSearch infoSearch) {

        return null;
    }

    @Override
    public Information getInfoByInfoId(long infoId){

        Information information = new Information();

        try {
            information = informationMapper.getInfoByInfoId(infoId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return information;
    }

    @Override
    public Integer updateInformation(Information information){

        Integer updateStatus = -1;

        try {
            updateStatus = verificationUtils.verification(informationMapper.updateInformation(information));
            if (updateStatus == 1){
                //更新索引数据
                searchService.index(information.getId());
            }
            return updateStatus;
        } catch (Exception e) {
            e.printStackTrace();
            return updateStatus;
        }
    }

    @Override
    public Integer deleteInformationById(long infoId){

        Integer delStatus = -1;

        try {
            delStatus = verificationUtils.verification(informationMapper.deleteInformationById(infoId));
            if (delStatus == 1){
                //删除索引数据
                searchService.remove(infoId);
            }
            return delStatus;
        } catch (Exception e) {
            e.printStackTrace();
            return delStatus;
        }

    }

    @Override
    public List<Information> findAll() {

        List<Information> infoList = new ArrayList<>();
        try {
            infoList = informationMapper.findAll();
            return infoList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

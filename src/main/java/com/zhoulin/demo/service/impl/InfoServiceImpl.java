package com.zhoulin.demo.service.impl;

import com.zhoulin.demo.bean.Info;
import com.zhoulin.demo.bean.InfoContent;
import com.zhoulin.demo.bean.InfoImage;
import com.zhoulin.demo.mapper.InfoContentMapper;
import com.zhoulin.demo.mapper.InfoImageMapper;
import com.zhoulin.demo.mapper.InfoMapper;
import com.zhoulin.demo.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InfoServiceImpl implements InfoService{

    private static final Logger logger = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Autowired
    private InfoMapper infoMapper;

    @Autowired
    private InfoContentMapper infoContentMapper;

    @Autowired
    private InfoImageMapper infoImageMapper;

    /**
     * 完整版
     * @param infoId
     * @return
     */
    @Override
    public Info getInfoByInfoId(long infoId) {

        Info info = new Info();

        InfoContent infoContent = new InfoContent();

        InfoImage infoImage = new InfoImage();

        try {
            info = infoMapper.getInfoByInfoId(infoId);

            infoContent = infoContentMapper.getInfoContentByInfoId(infoId);
            infoImage = infoImageMapper.getInfoImageByInfoId(infoId);

            info.setInfoContent(infoContent);
            info.setInfoImage(infoImage);

            return info;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 缩略图版
     * @param infoId
     * @return
     * @throws Exception
     */
    @Override
    public Info getInfoByInfoIdForImage(long infoId) throws Exception {

        Info info = new Info();

        InfoImage infoImage = new InfoImage();

        try {
            info = infoMapper.getInfoByInfoId(infoId);

            infoImage = infoImageMapper.getInfoImageByInfoId(info.getInfoId());

            info.setInfoImage(infoImage);

            return info;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Integer updateInfo(Info info) {
        return null;
    }

    @Override
    public Integer deleteInfoById(long infoId) {
        return null;
    }

    @Override
    public List<Info> findAll(){
        return null;
    }

    /**
     * 获取最新资讯 根据时间
     * @param limitNum
     * @return
     */
    @Override
    public List<Info> findInfoByDate(int limitNum){

        int offset = limitNum * 20;

        List<Info> dateList = new ArrayList<>();

//        InfoContent infoContent = new InfoContent();

        InfoImage infoImage = new InfoImage();

        try {
            dateList = infoMapper.findInfoByDate(limitNum);

            for (Info info : dateList) {
//                infoContent = infoContentMapper.getInfoContentByInfoId(info.getId());
                infoImage = infoImageMapper.getInfoImageByInfoId(info.getInfoId());

//                info.setInfoContent(infoContent);
                info.setInfoImage(infoImage);
                logger.info("资讯图片注入成功");
            }

            return dateList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

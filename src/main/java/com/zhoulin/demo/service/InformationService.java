package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.Information;

public interface InformationService {

    public Information getInfoByInfoId(long infoId) throws Exception;

    public Integer updateInformation(Information information) throws Exception;

    public Integer deleteInformationById(long infoId) throws Exception;

}

package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;

import java.util.List;

public interface ModService {

    public boolean modAnalyse(long id) throws Exception;

    public ServiceMultiResult<Long> queryMuti(InfoSearch infoSearch);

    public String modForInfoType(long id, String type) throws Exception;

}

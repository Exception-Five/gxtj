package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;

public interface ModService {

    public boolean modAnalyse(long id) throws Exception;

    public ServiceMultiResult<Long> queryMuti(InfoSearch infoSearch);


}

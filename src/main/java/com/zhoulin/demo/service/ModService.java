package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.form.InfoSearch;
import com.zhoulin.demo.bean.form.ServiceMultiResult;

import java.util.List;

public interface ModService {

    public ServiceMultiResult<Long> queryMuti(InfoSearch infoSearch);

}

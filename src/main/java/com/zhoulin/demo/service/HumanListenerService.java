package com.zhoulin.demo.service;

import com.zhoulin.demo.bean.LogInfoDTO;

import java.util.List;

public interface HumanListenerService {

    public List<LogInfoDTO> userReadTime(int userId) throws Exception;

}

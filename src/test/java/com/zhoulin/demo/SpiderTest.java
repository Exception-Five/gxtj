package com.zhoulin.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.spider.convert.InfoConvert;
import com.spider.convert.InformationConvert;
import com.spider.getHtml;
import com.spider.util.DateUtil;
import com.textrank.TextRankKeyword;
import com.zhoulin.demo.bean.*;
import com.zhoulin.demo.mapper.*;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.SpiderService;
import com.zhoulin.demo.service.impl.ModServiceImpl;
import com.zhoulin.demo.utils.TokenizerAnalyzerUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class SpiderTest extends DemoApplicationTests{
    private static final Logger logger = LoggerFactory.getLogger(ModServiceImpl.class);

//  private InformationService informationService;
    @Autowired
    private SpiderService spiderService;
    @Test
    public void test() {
        spiderService.run(1);

    }



}

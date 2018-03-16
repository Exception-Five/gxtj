package com.zhoulin.demo;

import com.zhoulin.demo.service.SpiderService;
import com.zhoulin.demo.service.impl.ModServiceImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


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

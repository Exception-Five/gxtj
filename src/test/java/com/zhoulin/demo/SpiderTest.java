package com.zhoulin.demo;

import com.zhoulin.demo.service.PushUserGroupService;
import com.zhoulin.demo.service.SpiderService;
import com.zhoulin.demo.service.impl.ModServiceImpl;
import com.zhoulin.demo.utils.ReckonUserGroup;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class SpiderTest extends DemoApplicationTests{
    private static final Logger logger = LoggerFactory.getLogger(ModServiceImpl.class);

//  private InformationService informationService;
    @Autowired
    private SpiderService spiderService;

    @Autowired
    private ReckonUserGroup reckonUserGroup;

    @Autowired
    private PushUserGroupService pushUserGroupService;

    @Test
    public void test() {
        spiderService.run(5);

    }

    @Test
    public void testArea(){

        List<Integer> integerlist = reckonUserGroup.reckonTypeArea(1);

        System.out.println(integerlist);

    }



}

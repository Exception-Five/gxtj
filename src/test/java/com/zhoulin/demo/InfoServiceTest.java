package com.zhoulin.demo;

import com.zhoulin.demo.bean.Info;
import com.zhoulin.demo.service.InfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InfoServiceTest extends DemoApplicationTests {

    @Autowired
    private InfoService infoService;

    @Test
    public void dateFindTest(){

        try {
            List<Info> infoList = infoService.findInfoByDate(0);
            for (Info info: infoList) {
                System.out.println("!!!!" + info.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void forImageTest(){

        long id = 24473;

        try {
            Info info = infoService.getInfoByInfoId(id);
            System.out.println(info.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

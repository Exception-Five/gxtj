package com.zhoulin.demo;

import com.zhoulin.demo.bean.Information;
import com.zhoulin.demo.service.InformationService;
import com.zhoulin.demo.service.ModService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ModTest extends DemoApplicationTests {

    @Autowired
    private ModService modService;

    @Autowired
    private InformationService informationService;

    @Test
    public void modForInfo(){

        List<Information> informationList = new ArrayList<>();

        String type = "财经";

        String finalType = "";

        try {
            informationList = informationService.findAll();
            for (Information information:informationList) {
                finalType = modService.modForInfoType(information.getId(), type);
                System.out.println("类型>>>>>>>>>>>" + finalType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void modForInfo1(){

        List<Information> informationList = new ArrayList<>();

        String type = "法律";

        String finalType = "";

        try {
            informationList = informationService.findAll();
            for (Information information:informationList) {
                finalType = modService.modForInfoType(information.getId(), type);
                System.out.println("类型>>>>>>>>>>>" + finalType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void modForInfo2(){

        List<Information> informationList = new ArrayList<>();

        String type = "生活";

        String finalType = "";

        try {
//            informationList = informationService.findAll();
//            for (Information information:informationList) {
                finalType = modService.modForInfoType(22163, type);
                System.out.println("类型>>>>>>>>>>>" + finalType);
//            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

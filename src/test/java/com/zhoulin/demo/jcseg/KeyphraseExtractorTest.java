package com.zhoulin.demo.jcseg;



import com.jcseg.extractor.impl.TextRankKeyphraseExtractor;
import com.jcseg.tokenizer.core.*;
import com.zhoulin.demo.DemoApplicationTests;
import com.zhoulin.demo.service.InfoService;
import com.zhoulin.demo.service.JcsegService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class KeyphraseExtractorTest extends DemoApplicationTests {

    @Autowired
    private JcsegService jcsegService;

    @Autowired
    private InfoService infoService;


    public static void main(String[] args) 
    {
        //create your JcsegTaskConfig here please
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setClearStopwords(true);
        config.setAppendCJKSyn(false);
        config.setEnSecondSeg(false);
        config.setKeepUnregWords(false);
        ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
        
        try {
            ISegment seg = SegmentFactory
                    .createJcseg(JcsegTaskConfig.COMPLEX_MODE, new Object[]{config, dic});
            
            TextRankKeyphraseExtractor extractor = new TextRankKeyphraseExtractor(seg);
            extractor.setMaxIterateNum(10);
            extractor.setWindowSize(5);
            extractor.setKeywordsNum(15);
            extractor.setMaxWordsNum(4);
            //extractor.setAutoMinLength(4);
            
            List<String> phrases;

            String doc = "关于我们            黑龙江龙广律师事务所，是一家综合制律师事务所。龙广所目前为黑龙江省人民政府、招商银行哈尔滨分行及省内多家知名企业提供专业法律顾问服务、新三板等非诉法律服务；同时还面向社会公众提供优质诉讼业务服务。   联系方式：400-872-6900   律所地址：哈尔滨市赣水路3" +
                    "关于我们     黑龙江龙广律师事务所，是一家综合制律师事务所。龙广所目前为黑龙江省人民政府、招商银行哈尔滨分行及省内多家知名企业提供专业法律顾问服务、新三板等非诉法律服务；同时还面向社会公众提供优质诉讼业务服务。 联系方式：400-872-6900 律所地址：哈尔滨市赣水路30号地王大厦7层    综合来源：台州交通广播及网络        “那天我把车子停在路边，打开车门，一只脚已经下车，另一只脚还在车上的时候，听到‘砰’的很响一声，一辆电瓶车撞到了我的车门上。”周某是这样描述当时撞人的情景的，一开始，他有点蒙，“我觉得人不是我撞的，是她自己撞到我车门上的。”        浦江人周某因交通肇事罪，被判处有期徒刑一年，缓刑六个月。        2014年9月1日上午9点多，周某独自一人开车到城里办事，把自己的小型商务车停靠在了路边。准备下车前，他瞄了一眼后视镜，没看到后面有车辆。之后他解下安全带、将车子熄火、拔下汽车钥匙，打开了驾驶室侧门，把一只脚跨了出去。         可就在这停车到开车门不到20秒的时间里，悲剧发生了。才三十出头的吴女士骑着电瓶车同方向行驶，来不及躲避撞了上来，当场昏迷。 吴女士的电瓶车侧翻在地上，人却飞了出去。不幸的是，吴女士头部着地，虽然血流得不多，但是失去了意识。         一看吴女士摔得不轻，周某连忙想办法抢救吴女士，并让行人帮忙报了警。但经过十多天的抢救，吴女士还是走了。        经浦江县交警大队事故责任认定：周某驾驶机动车在道路上临时停车，开车门时未注意来往车辆，承担事故全部责任。        9月22日，周某与吴女士家属达成民事赔偿协议，赔偿了62万余元，并取得被害人家属的谅解。        浦江县人民法院审理认为，周某违反道路交通安全法，应当以交通肇事罪依法追究其刑事责任。因周某有自首情节，有明显悔罪表现，且取得了吴女士家属的谅解，可酌情从轻处罚并适用缓刑，故作出上述判决。 法律规定： 不管开车还是乘车，开车门都应注意！一定要看清周边路况！  提醒：停车后应\"二次开门\"，先将车门开拳头大小缝，经观察确认安全后再开门。告诉身边的人，千万别大意！ 微信号：lgls82143999 电话：400-872-6900 地址：哈尔滨市南岗区赣水路30号地王大厦7层";

            phrases = extractor.getKeyphraseFromString(doc);

//            phrases = extractor.getKeyphraseFromString("支持向量机广泛应用于文本挖掘，例如，"
//                    + "基于支持向量机的文本自动分类技术研究一文中很详细的介绍支持向量机的算法细节，"
//                    + "文本自动分类是文本挖掘技术中的一种！");
            //phrases = extractor.getKeyphraseFromFile("/home/chenxin/curpos/5.txt");
            System.out.println(phrases);
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jcesegTest(){
        String doc = "关于我们            黑龙江龙广律师事务所，是一家综合制律师事务所。龙广所目前为黑龙江省人民政府、招商银行哈尔滨分行及省内多家知名企业提供专业法律顾问服务、新三板等非诉法律服务；同时还面向社会公众提供优质诉讼业务服务。   联系方式：400-872-6900   律所地址：哈尔滨市赣水路3" +
                "关于我们     黑龙江龙广律师事务所，是一家综合制律师事务所。龙广所目前为黑龙江省人民政府、招商银行哈尔滨分行及省内多家知名企业提供专业法律顾问服务、新三板等非诉法律服务；同时还面向社会公众提供优质诉讼业务服务。 联系方式：400-872-6900 律所地址：哈尔滨市赣水路30号地王大厦7层    综合来源：台州交通广播及网络        “那天我把车子停在路边，打开车门，一只脚已经下车，另一只脚还在车上的时候，听到‘砰’的很响一声，一辆电瓶车撞到了我的车门上。”周某是这样描述当时撞人的情景的，一开始，他有点蒙，“我觉得人不是我撞的，是她自己撞到我车门上的。”        浦江人周某因交通肇事罪，被判处有期徒刑一年，缓刑六个月。        2014年9月1日上午9点多，周某独自一人开车到城里办事，把自己的小型商务车停靠在了路边。准备下车前，他瞄了一眼后视镜，没看到后面有车辆。之后他解下安全带、将车子熄火、拔下汽车钥匙，打开了驾驶室侧门，把一只脚跨了出去。         可就在这停车到开车门不到20秒的时间里，悲剧发生了。才三十出头的吴女士骑着电瓶车同方向行驶，来不及躲避撞了上来，当场昏迷。 吴女士的电瓶车侧翻在地上，人却飞了出去。不幸的是，吴女士头部着地，虽然血流得不多，但是失去了意识。         一看吴女士摔得不轻，周某连忙想办法抢救吴女士，并让行人帮忙报了警。但经过十多天的抢救，吴女士还是走了。        经浦江县交警大队事故责任认定：周某驾驶机动车在道路上临时停车，开车门时未注意来往车辆，承担事故全部责任。        9月22日，周某与吴女士家属达成民事赔偿协议，赔偿了62万余元，并取得被害人家属的谅解。        浦江县人民法院审理认为，周某违反道路交通安全法，应当以交通肇事罪依法追究其刑事责任。因周某有自首情节，有明显悔罪表现，且取得了吴女士家属的谅解，可酌情从轻处罚并适用缓刑，故作出上述判决。 法律规定： 不管开车还是乘车，开车门都应注意！一定要看清周边路况！  提醒：停车后应\"二次开门\"，先将车门开拳头大小缝，经观察确认安全后再开门。告诉身边的人，千万别大意！ 微信号：lgls82143999 电话：400-872-6900 地址：哈尔滨市南岗区赣水路30号地王大厦7层";

        try {
            List<String> phrase =  jcsegService.getKeyphrase(doc);
            for (String p: phrase) {
                System.out.println("!!" + p);
            }

            System.out.println(phrase.get(0) );

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getHotWordsTest(){

        try {
            List<String> phrase = infoService.getHotWords();
            System.out.println("!!!" + phrase);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

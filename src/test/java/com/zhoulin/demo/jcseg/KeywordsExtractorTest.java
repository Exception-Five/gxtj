package com.zhoulin.demo.jcseg;

import com.jcseg.extractor.impl.TextRankKeywordsExtractor;
import com.jcseg.tokenizer.core.*;

import java.io.IOException;
import java.util.List;

public class KeywordsExtractorTest {

    public static void main(String[] args) 
    {
        //create your JcsegTaskConfig here please
        JcsegTaskConfig config = new JcsegTaskConfig(true);
        config.setClearStopwords(true);
        config.setAppendCJKSyn(false);
        config.setKeepUnregWords(false);
        ADictionary dic = DictionaryFactory.createSingletonDictionary(config);
        
        try {
            ISegment seg = SegmentFactory
                    .createJcseg(JcsegTaskConfig.NLP_MODE, new Object[]{config, dic});
            
            TextRankKeywordsExtractor extractor = new TextRankKeywordsExtractor(seg);
            extractor.setMaxIterateNum(100);
            extractor.setWindowSize(5);
            extractor.setKeywordsNum(7);
            
            String doc = "";
            List<String> keywords;
            /*doc = "当中国南方还处于深秋时节，中国的北方已经下了几场雪了。"
                + "不知道大家在下雪的时候是选择在家上网休息，还是会到户外享受美妙的雪景呢？"
                + "但是小编作为南方人是真的很羡慕北方的孩纸们....  话说回来，"
                + "前两天北京下雪后小编的朋友圈就已经被刷屏了...尽管都是雪景，"
                + "但是大多数人还是从欣赏的角度出发。。。除了这些逗比：其实我们今天要说的事情是这样的，"
                + "最近网络中曝出一组中国人民公安大学学生在大雪天训练的照片...  "
                + "20岁出头的小鲜肉们在此严酷的环境中训练，小编还是替他们的女朋友感到心痛的...   "
                + "但是，作为将来要保家卫国的军人，公安大学的学生们在如此寒冷的天气中赤膊上阵训练更多的是让人振奋！"
                + "在曝光的训练队伍中甚至还有一名女生！  相对于其他男人赤膊上阵，这名女生也仅仅穿了一件T恤！"
                + "让人无比钦佩！  在雪中训练已经成为军人日常训练之一。在北方冬天动辄零下10几度的气温中训练，"
                + "无论对于人的耐力还是毅力都是一个极大的考验。  这样的雪浴训练更是官兵们的必修课：     当然，"
                + "其他常规训练也是必不可少的：     网友评论： @修坡贱：一入警校深似海，从此女票是路人 "
                + "@官庄工区派出所社区大队：抓紧锻炼身体，上班啃老本。女票不女票全都然并卵。 "
                + "@ilovelilybabe：好man好喜欢 @_陈毅勋：我想知道的是后来他们生病了没有。 "
                + "@-Davie-：好想去公安大学看看，不愧为中国第一公安院校，佩服！  相对于雪地训练历史更早的韩国和日本，"
                + "中国对于士兵的雪地训练开展得相对较晚，但是随着中国军人培养机制的日渐成熟，"
                + "雪地训练已经成为学兵和官兵们重要的训练科目！看到祖国的未来在大雪中艰苦的训练，你是怎样的心情呢？"
                + "赶紧分享出去让你的小伙伴们也看到吧！";*/
            //insert you test text here
            doc = "婚后买房，公婆出资给儿媳离婚还要还？随着近年来房价暴涨，房子已经成了中国家庭最大的财富之一。如果男友父母出资购房登记在男友一人名下，那房子与你无关！那么只好要求加自己名字咯~~       但真的写你名字就能拿走一半吗？       很多妹子会说，那肯定啦。      根据《婚姻法解释（二）》第22条的规定，不管他爹妈婚前婚后买房，加又是一经典判决！在民间借贷关系的基础上，申XX同意支付利息，同时认可涉案借款系用于投资购买房产并约定有利息，且现有证据亦显示申XX、左XX实际通过申传来支付房款的方式购买了两套房屋，故本院对申XX、秦XX关于涉案借款约定有利息的主张予以采信。一审法院判令申传来支付利息并无不当，故本院予以维持。  关于左XX是否应承担共同还款责任问题。《最高人民法院关于适用〈中华人民共和国婚姻法〉若干问题的解释（二）》第二十四条规定：“债权人就婚姻关系存续期间夫妻一方以个人名义所负债务主张权利的，应当按夫妻共同债务处理。但夫妻一方能够证明债权人与债务人明确约定为个人债务，或者能够证明属于婚姻法第十九条第三款规定情形的除外。”本案中，申传来的借款行为发生在申传来、左兆燕的夫妻关系存续期间，同时现有证据亦显示申传来、左兆燕在结婚后通过申传来支付房款的方式购买了两套房屋，并不存在上述规定的除外情形，一审法院据此判令左兆燕与申传来共同承担还款义务并无不当，故本院予以维持。  关于程序问题。根据一审卷宗记载，申XX、秦XX在起诉状中即已要求申传来、左XX偿还借款及利息，在2017年6月22日的庭审中明确表示利息按照同期人民银行贷款利率从实际转账之日起计算至实际给付之日止，各方此后围绕申XX、秦XX的诉讼请求进行了举证、质证及法庭辩论，并不存在左兆燕所述剥夺其辩论权利的情况。根据一审卷宗记载，一审法院确曾对申传东进行过询问。申XX的陈述不属于当事人陈述，亦不属于证人证言，其陈述不属于民事证据的范畴，但一审法院并未将申传东的陈述作为认定案件事实的依据，故一审法院的做法并不存在违法之处。综上，左XX上诉主张一审法院程序违法，缺乏事实和法律依据，本院对其该项上诉意见不予采纳。  综上所述，左XX的上诉理由不能成立，应予驳回；一审法院判决认定事实清楚，适用法律正确，应予维持。依照《中华人民共和国民事诉讼法》第一百七十条第一款第（一）项之规定，判决如下：  驳回上诉，维持原判。  二审案件受理费28412元，由左XX负担（已交纳）。  本判决为终审判决。  审　判　长　　邢　军 审　判　员　　龚勇超 代理审判员　　霍思宇  二〇一七年十一月七日 法官　助理　　李思巧 书　记　员　　刘　鸽 来源：法律讲堂  ";
        
//            doc = "保护作品完整权，作为著作权人一项重要的人身性权利，是为保障著作权人通过其作品忠实体现其人格和思想的权利。保护作品完整权规范的行为为“歪曲”、“篡改”，“歪曲”是指对作品作有违作者本意的体现，“篡改”是指以作伪手段进行改动，并以作者声誉是否受到损害和作者的社会评价是否降低为判断标准。然而实践中经常与改";
            keywords = extractor.getKeywordsFromString(doc);
            //keywords = extractor.getKeywordsFromFile("/home/chenxin/curpos/1.txt");
            System.out.println(keywords);
        } catch (JcsegException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

<template>
    <section id="search">
        <VHeader 
        :isLogined="isLogined" 
        :userInfo="userInfo" 
        :isLoginShow="isLoginShow"
        :isRegisterShow="isRegisterShow"
        :isSearchShow="isSearchShow"
        @handleForm="handleForm"
        @closeForm="closeForm"
        @loginConfirm="loginConfirm"
        @registerConfirm="registerConfirm"
        @logout="logout"
        @handleSearch="handleSearch"
        ></VHeader>
<div class="placeholder-height"></div>
<div class="edit-warp" id="per_center">
    <div class="user-container" style="min-height: 700px;">
        <div class="go-back"><a href="/member"><i class="icon icon-go-back"></i>返回首页</a></div>

        <div class="nav-warp">
            <ul>
                <li class=""><a href="/user/setting/base.html"></a></li>
                <li class="active"><a href="/user/setting/account.html">账户信息</a></li>
                <li class=""><a href="/user/setting/bind.html"></a></li>
            </ul>
        </div>
                    <div class="acnt-item-box">
    <div class="acnt-item">

        <i class="icon acnt-item-icon icon-round-ok"></i>
        <label class="acnt-item-label">用户名:</label>

        <div class="control-box under-control account ">{{userInfo.username}}</div>

        <div class="btn-group  btn-group-box pull-right js-edit-user-info ">
            <span class="btn btn-default  btn-dropdown-show js-edit-user-name">修改</span>
            <button type="button" class="btn btn-default dropdown-toggle">
                <span class="icon icon-add"></span>
            </button>
        </div>
    </div>
    <div class="acnt-item">

        <i class="icon acnt-item-icon icon-round-ok"></i>
        <label class="acnt-item-label">昵称:</label>

        <div class="control-box under-control account ">{{userInfo.nickname}}</div>

        <div class="btn-group  btn-group-box pull-right js-edit-user-info ">
            <span class="btn btn-default  btn-dropdown-show js-edit-user-name">修改</span>
            <button type="button" class="btn btn-default dropdown-toggle">
                <span class="icon icon-add"></span>
            </button>
        </div>
    </div>
    <div class="acnt-item acnt-item-content ">
        <ul class="under-ul">
            <div class="form-warp">
                <label class="control-label">新昵称：</label>
                <input style="width: 345px;" class="control-input" id="nickname" placeholder="新昵称" v-model="userInfo.newNickname">
            </div>
            <button class="btn btn-blue js-reset-username" @click="updateUserInfo(1)">完成</button>
        </ul>
    </div>

</div>
<div class="acnt-item-box">
    <div class="acnt-item">
        <i class="icon acnt-item-icon icon-round-ok"></i>
        <label class="acnt-item-label">头&nbsp;&nbsp;&nbsp;像：</label>

        <div class="control-box under-control account">
            <div class="face-box">
                <img src="https://img.huxiucdn.com/auth/data/avatar/2.jpg">
            </div>
        </div>
        <div class="btn-group  btn-group-box pull-right js-edit-user-info ">
            <span class="btn btn-default  btn-dropdown-show js-edit-user-head">修改</span>
            <button type="button" class="btn btn-default dropdown-toggle">
                <span class="icon icon-add"></span>
            </button>
        </div>
    </div>
    <div class="acnt-item acnt-item-content">
        <ul class="under-ul" style="display: none;">
            <li><span class="span-color-a2">仅支持JPG、PNG格式的图片文件，小于2MB</span></li>
            <li>
                <div style="margin: 0 auto;">
                    <object type="application/x-shockwave-flash" id="swf" name="swf" data="/static_2015/js/fullAvatarEditor.swf" width="750" height="340"><param name="menu" value="true"><param name="scale" value="noScale"><param name="allowFullscreen" value="true"><param name="allowScriptAccess" value="always"><param name="wmode" value="transparent"><param name="flashvars" value="id=swf&amp;upload_url=%2Fuser%2Fchange_avatar%3Fis_ajax%3D1%26huxiu_hash_code%3Dfd0f8941fa8f00b25749ae12ca30e643&amp;src_upload=2&amp;tab_visible=false&amp;browse_box_width=204&amp;browse_box_height=204&amp;browse_button=请上传您的头像&amp;checkbox_visible=false&amp;avatar_sizes=200*200|150*150|40*40&amp;avatar_sizes_desc=200*200像素|150*150像素|40*40像素&amp;avatar_tools_visible=false&amp;browse_box_align=left"></object>
                </div>

                <button id="upload" class="btn btn-blue-user disabled">上传头像</button>

            </li>
        </ul>
    </div>
</div>
<div class="acnt-item-box">
    <div class="acnt-item">
        <i class="icon acnt-item-icon icon-round-warning"></i>
        <label class="acnt-item-label">邮&nbsp;&nbsp;&nbsp;箱：</label>

        <div class="control-box under-control account"></div>
        <div class="btn-group  btn-group-box pull-right js-edit-user-info ">
            <span class="btn btn-default  btn-dropdown-show js-edit-user-email">修改</span>
            <button type="button" class="btn btn-default dropdown-toggle">
                <span class="icon icon-add"></span>
            </button>
        </div>
    </div>
    <div class="acnt-item acnt-item-content">
        <ul class="under-ul" style="display: none;">
            <div class="form-warp">
                <label class="control-label">密&nbsp;&nbsp;&nbsp;码：</label>
                <input class="control-input" id="mdf_password" type="password" placeholder="密码">
            </div>
            <div class="form-warp">
                <label class="control-label">新邮箱：</label>
                <input class="control-input" id="email" placeholder="新邮箱">
            </div>
            <div class="form-warp">
                <label class="control-label">验证码：</label>
                <input class="control-input" id="captcha_email" placeholder="邮箱验证码">
                <button class="btn btn-default js-btn-captcha-email">免费获取</button>
            </div>
            <button class="btn btn-blue js-mdf-email">完成</button>
        </ul>
    </div>
</div>
<div class="acnt-item-box">
    <div class="acnt-item acnt-item-content">
        <ul class="under-ul" style="display: none;">
            <div class="form-warp">
                <label class="control-label">密&nbsp;&nbsp;&nbsp;码：</label>
                <input class="control-input" id="mobile-password" type="password" placeholder="密码">
            </div>
            <div class="form-warp">
                <label class="control-label">新手机号：</label>
                <input class="control-input bind-label-select-input" id="new-mobile" placeholder="新手机号">
                <a class="js-label-select label-select-box bind-edit-label-select text-center"><span class="js-bind-country-user">+86</span><i class="icon-modal icon-l-caret"></i></a>
                <div class="country-box edit-mobile-box">
                    <ul class="country-ul js-country-ul"><li data-code="+355"><span class="name">阿尔巴尼亚</span><span class="code">+355</span></li><li data-code="+213"><span class="name">阿尔及利亚</span><span class="code">+213</span></li><li data-code="+93"><span class="name">阿富汗</span><span class="code">+93</span></li><li data-code="+54"><span class="name">阿根廷</span><span class="code">+54</span></li><li data-code="+353"><span class="name">爱尔兰</span><span class="code">+353</span></li><li data-code="+20"><span class="name">埃及</span><span class="code">+20</span></li><li data-code="+251"><span class="name">埃塞俄比亚</span><span class="code">+251</span></li><li data-code="+372"><span class="name">爱沙尼亚</span><span class="code">+372</span></li><li data-code="+971"><span class="name">阿拉伯联合酋长国</span><span class="code">+971</span></li><li data-code="+297"><span class="name">阿鲁巴</span><span class="code">+297</span></li><li data-code="+968"><span class="name">阿曼</span><span class="code">+968</span></li><li data-code="+376"><span class="name">安道尔</span><span class="code">+376</span></li><li data-code="+244"><span class="name">安哥拉</span><span class="code">+244</span></li><li data-code="+1264"><span class="name">安圭拉</span><span class="code">+1264</span></li><li data-code="+1268"><span class="name">安提瓜和巴布达</span><span class="code">+1268</span></li><li data-code="+61"><span class="name">澳大利亚</span><span class="code">+61</span></li><li data-code="+43"><span class="name">奥地利</span><span class="code">+43</span></li><li data-code="+994"><span class="name">阿塞拜疆</span><span class="code">+994</span></li><li data-code="+1246"><span class="name">巴巴多斯</span><span class="code">+1246</span></li><li data-code="+675"><span class="name">巴布亚新几内亚</span><span class="code">+675</span></li><li data-code="+1242"><span class="name">巴哈马</span><span class="code">+1242</span></li><li data-code="+375"><span class="name">白俄罗斯</span><span class="code">+375</span></li><li data-code="+1441"><span class="name">百慕大</span><span class="code">+1441</span></li><li data-code="+92"><span class="name">巴基斯坦</span><span class="code">+92</span></li><li data-code="+595"><span class="name">巴拉圭</span><span class="code">+595</span></li><li data-code="+973"><span class="name">巴林</span><span class="code">+973</span></li><li data-code="+507"><span class="name">巴拿马</span><span class="code">+507</span></li><li data-code="+359"><span class="name">保加利亚</span><span class="code">+359</span></li><li data-code="+55"><span class="name">巴西</span><span class="code">+55</span></li><li data-code="+1670"><span class="name">北马里亚纳群岛</span><span class="code">+1670</span></li><li data-code="+229"><span class="name">贝宁</span><span class="code">+229</span></li><li data-code="+32"><span class="name">比利时</span><span class="code">+32</span></li><li data-code="+354"><span class="name">冰岛</span><span class="code">+354</span></li><li data-code="+267"><span class="name">博茨瓦纳</span><span class="code">+267</span></li><li data-code="+48"><span class="name">波兰</span><span class="code">+48</span></li><li data-code="+591"><span class="name">玻利维亚</span><span class="code">+591</span></li><li data-code="+501"><span class="name">伯利兹</span><span class="code">+501</span></li><li data-code="+387"><span class="name">波斯尼亚和黑塞哥维那</span><span class="code">+387</span></li><li data-code="+975"><span class="name">不丹</span><span class="code">+975</span></li><li data-code="+226"><span class="name">布基拉法索</span><span class="code">+226</span></li><li data-code="+257"><span class="name">布隆迪</span><span class="code">+257</span></li><li data-code="+850"><span class="name">朝鲜</span><span class="code">+850</span></li><li data-code="+240"><span class="name">赤道几内亚</span><span class="code">+240</span></li><li data-code="+45"><span class="name">丹麦</span><span class="code">+45</span></li><li data-code="+49"><span class="name">德国</span><span class="code">+49</span></li><li data-code="+670"><span class="name">东帝汶</span><span class="code">+670</span></li><li data-code="+228"><span class="name">多哥</span><span class="code">+228</span></li><li data-code="+1809"><span class="name">多米尼加共和国</span><span class="code">+1809</span></li><li data-code="+1767"><span class="name">多米尼克</span><span class="code">+1767</span></li><li data-code="+593"><span class="name">厄瓜多尔</span><span class="code">+593</span></li><li data-code="+291"><span class="name">厄立特里亚</span><span class="code">+291</span></li><li data-code="+7"><span class="name">俄罗斯</span><span class="code">+7</span></li><li data-code="+33"><span class="name">法国</span><span class="code">+33</span></li><li data-code="+298"><span class="name">法罗群岛</span><span class="code">+298</span></li><li data-code="+379"><span class="name">梵蒂冈</span><span class="code">+379</span></li><li data-code="+689"><span class="name">法属波利尼西亚</span><span class="code">+689</span></li><li data-code="+1599"><span class="name">法属圣马丁</span><span class="code">+1599</span></li><li data-code="+679"><span class="name">斐济</span><span class="code">+679</span></li><li data-code="+63"><span class="name">菲律宾</span><span class="code">+63</span></li><li data-code="+358"><span class="name">芬兰</span><span class="code">+358</span></li><li data-code="+238"><span class="name">佛得角</span><span class="code">+238</span></li><li data-code="+500"><span class="name">福克兰群岛</span><span class="code">+500</span></li><li data-code="+220"><span class="name">冈比亚</span><span class="code">+220</span></li><li data-code="+242"><span class="name">刚果（布）</span><span class="code">+242</span></li><li data-code="+243"><span class="name">刚果（金）</span><span class="code">+243</span></li><li data-code="+299"><span class="name">格陵兰</span><span class="code">+299</span></li><li data-code="+1473"><span class="name">格林纳达</span><span class="code">+1473</span></li><li data-code="+995"><span class="name">格鲁吉亚</span><span class="code">+995</span></li><li data-code="+57"><span class="name">哥伦比亚</span><span class="code">+57</span></li><li data-code="+506"><span class="name">哥斯达黎加</span><span class="code">+506</span></li><li data-code="+1671"><span class="name">关岛</span><span class="code">+1671</span></li><li data-code="+53"><span class="name">古巴</span><span class="code">+53</span></li><li data-code="+592"><span class="name">圭亚那</span><span class="code">+592</span></li><li data-code="+509"><span class="name">海地</span><span class="code">+509</span></li><li data-code="+82"><span class="name">韩国</span><span class="code">+82</span></li><li data-code="+7"><span class="name">哈萨克斯坦</span><span class="code">+7</span></li><li data-code="+382"><span class="name">黑山</span><span class="code">+382</span></li><li data-code="+31"><span class="name">荷兰</span><span class="code">+31</span></li><li data-code="+599"><span class="name">荷属安的列斯群岛</span><span class="code">+599</span></li><li data-code="+504"><span class="name">洪都拉斯</span><span class="code">+504</span></li><li data-code="+233"><span class="name">加纳</span><span class="code">+233</span></li><li data-code="+1"><span class="name">加拿大</span><span class="code">+1</span></li><li data-code="+855"><span class="name">柬埔寨</span><span class="code">+855</span></li><li data-code="+241"><span class="name">加蓬</span><span class="code">+241</span></li><li data-code="+253"><span class="name">吉布提</span><span class="code">+253</span></li><li data-code="+420"><span class="name">捷克共和国</span><span class="code">+420</span></li><li data-code="+996"><span class="name">吉尔吉斯斯坦</span><span class="code">+996</span></li><li data-code="+686"><span class="name">基里巴斯</span><span class="code">+686</span></li><li data-code="+263"><span class="name">津巴布韦</span><span class="code">+263</span></li><li data-code="+224"><span class="name">几内亚</span><span class="code">+224</span></li><li data-code="+245"><span class="name">几内亚比绍</span><span class="code">+245</span></li><li data-code="+1345"><span class="name">开曼群岛</span><span class="code">+1345</span></li><li data-code="+237"><span class="name">喀麦隆</span><span class="code">+237</span></li><li data-code="+974"><span class="name">卡塔尔</span><span class="code">+974</span></li><li data-code="+61"><span class="name">科科斯（基林）	群岛</span><span class="code">+61</span></li><li data-code="+385"><span class="name">克罗地亚</span><span class="code">+385</span></li><li data-code="+269"><span class="name">科摩罗</span><span class="code">+269</span></li><li data-code="+254"><span class="name">肯尼亚</span><span class="code">+254</span></li><li data-code="+225"><span class="name">科特迪瓦</span><span class="code">+225</span></li><li data-code="+965"><span class="name">科威特</span><span class="code">+965</span></li><li data-code="+682"><span class="name">库克群岛</span><span class="code">+682</span></li><li data-code="+266"><span class="name">莱索托</span><span class="code">+266</span></li><li data-code="+856"><span class="name">老挝</span><span class="code">+856</span></li><li data-code="+371"><span class="name">拉脱维亚</span><span class="code">+371</span></li><li data-code="+961"><span class="name">黎巴嫩</span><span class="code">+961</span></li><li data-code="+231"><span class="name">利比里亚</span><span class="code">+231</span></li><li data-code="+218"><span class="name">利比亚</span><span class="code">+218</span></li><li data-code="+423"><span class="name">列支敦士登</span><span class="code">+423</span></li><li data-code="+370"><span class="name">立陶宛</span><span class="code">+370</span></li><li data-code="+40"><span class="name">罗马尼亚</span><span class="code">+40</span></li><li data-code="+352"><span class="name">卢森堡</span><span class="code">+352</span></li><li data-code="+250"><span class="name">卢旺达</span><span class="code">+250</span></li><li data-code="+261"><span class="name">马达加斯加</span><span class="code">+261</span></li><li data-code="+960"><span class="name">马尔代夫</span><span class="code">+960</span></li><li data-code="+356"><span class="name">马耳他</span><span class="code">+356</span></li><li data-code="+60"><span class="name">马来西亚</span><span class="code">+60</span></li><li data-code="+265"><span class="name">马拉维</span><span class="code">+265</span></li><li data-code="+223"><span class="name">马里</span><span class="code">+223</span></li><li data-code="+44"><span class="name">曼岛</span><span class="code">+44</span></li><li data-code="+230"><span class="name">毛里求斯</span><span class="code">+230</span></li><li data-code="+222"><span class="name">毛里塔尼亚</span><span class="code">+222</span></li><li data-code="+389"><span class="name">马其顿</span><span class="code">+389</span></li><li data-code="+692"><span class="name">马绍尔群岛</span><span class="code">+692</span></li><li data-code="+262"><span class="name">马约特</span><span class="code">+262</span></li><li data-code="+1"><span class="name">美国</span><span class="code">+1</span></li><li data-code="+1684"><span class="name">美属萨摩亚</span><span class="code">+1684</span></li><li data-code="+1340"><span class="name">美属维尔京群岛</span><span class="code">+1340</span></li><li data-code="+976"><span class="name">蒙古</span><span class="code">+976</span></li><li data-code="+880"><span class="name">孟加拉国</span><span class="code">+880</span></li><li data-code="+1664"><span class="name">蒙特塞拉特</span><span class="code">+1664</span></li><li data-code="+95"><span class="name">缅甸</span><span class="code">+95</span></li><li data-code="+691"><span class="name">密克罗尼西亚</span><span class="code">+691</span></li><li data-code="+51"><span class="name">秘鲁</span><span class="code">+51</span></li><li data-code="+373"><span class="name">摩尔多瓦</span><span class="code">+373</span></li><li data-code="+212"><span class="name">摩洛哥</span><span class="code">+212</span></li><li data-code="+377"><span class="name">摩纳哥</span><span class="code">+377</span></li><li data-code="+258"><span class="name">莫桑比克</span><span class="code">+258</span></li><li data-code="+52"><span class="name">墨西哥</span><span class="code">+52</span></li><li data-code="+264"><span class="name">纳米比亚</span><span class="code">+264</span></li><li data-code="+27"><span class="name">南非</span><span class="code">+27</span></li><li data-code="+672"><span class="name">南极洲</span><span class="code">+672</span></li><li data-code="+674"><span class="name">瑙鲁</span><span class="code">+674</span></li><li data-code="+977"><span class="name">尼泊尔</span><span class="code">+977</span></li><li data-code="+505"><span class="name">尼加拉瓜</span><span class="code">+505</span></li><li data-code="+227"><span class="name">尼日尔</span><span class="code">+227</span></li><li data-code="+234"><span class="name">尼日利亚</span><span class="code">+234</span></li><li data-code="+683"><span class="name">纽埃</span><span class="code">+683</span></li><li data-code="+47"><span class="name">挪威</span><span class="code">+47</span></li><li data-code="+680"><span class="name">帕劳</span><span class="code">+680</span></li><li data-code="+870"><span class="name">皮特凯恩群岛</span><span class="code">+870</span></li><li data-code="+351"><span class="name">葡萄牙</span><span class="code">+351</span></li><li data-code="+81"><span class="name">日本</span><span class="code">+81</span></li><li data-code="+46"><span class="name">瑞典</span><span class="code">+46</span></li><li data-code="+41"><span class="name">瑞士</span><span class="code">+41</span></li><li data-code="+503"><span class="name">萨尔瓦多</span><span class="code">+503</span></li><li data-code="+381"><span class="name">塞尔维亚</span><span class="code">+381</span></li><li data-code="+232"><span class="name">塞拉利昂</span><span class="code">+232</span></li><li data-code="+221"><span class="name">塞内加尔</span><span class="code">+221</span></li><li data-code="+357"><span class="name">塞浦路斯</span><span class="code">+357</span></li><li data-code="+248"><span class="name">塞舌尔</span><span class="code">+248</span></li><li data-code="+685"><span class="name">萨摩亚</span><span class="code">+685</span></li><li data-code="+966"><span class="name">沙特阿拉伯</span><span class="code">+966</span></li><li data-code="+590"><span class="name">圣巴泰勒米</span><span class="code">+590</span></li><li data-code="+61"><span class="name">圣诞岛</span><span class="code">+61</span></li><li data-code="+239"><span class="name">圣多美和普林西比</span><span class="code">+239</span></li><li data-code="+290"><span class="name">圣赫勒拿</span><span class="code">+290</span></li><li data-code="+1869"><span class="name">圣基茨和尼维斯</span><span class="code">+1869</span></li><li data-code="+1758"><span class="name">圣卢西亚</span><span class="code">+1758</span></li><li data-code="+378"><span class="name">圣马力诺</span><span class="code">+378</span></li><li data-code="+508"><span class="name">圣皮埃尔和密克隆群岛</span><span class="code">+508</span></li><li data-code="+1784"><span class="name">圣文森特和格林纳丁斯</span><span class="code">+1784</span></li><li data-code="+94"><span class="name">斯里兰卡</span><span class="code">+94</span></li><li data-code="+421"><span class="name">斯洛伐克</span><span class="code">+421</span></li><li data-code="+386"><span class="name">斯洛文尼亚</span><span class="code">+386</span></li><li data-code="+268"><span class="name">斯威士兰</span><span class="code">+268</span></li><li data-code="+249"><span class="name">苏丹</span><span class="code">+249</span></li><li data-code="+597"><span class="name">苏里南</span><span class="code">+597</span></li><li data-code="+677"><span class="name">所罗门群岛</span><span class="code">+677</span></li><li data-code="+252"><span class="name">索马里</span><span class="code">+252</span></li><li data-code="+66"><span class="name">泰国</span><span class="code">+66</span></li><li data-code="+886"><span class="name">台湾</span><span class="code">+886</span></li><li data-code="+992"><span class="name">塔吉克斯坦</span><span class="code">+992</span></li><li data-code="+676"><span class="name">汤加</span><span class="code">+676</span></li><li data-code="+255"><span class="name">坦桑尼亚</span><span class="code">+255</span></li><li data-code="+1649"><span class="name">特克斯和凯科斯群岛</span><span class="code">+1649</span></li><li data-code="+1868"><span class="name">特立尼达和多巴哥</span><span class="code">+1868</span></li><li data-code="+90"><span class="name">土耳其</span><span class="code">+90</span></li><li data-code="+993"><span class="name">土库曼斯坦</span><span class="code">+993</span></li><li data-code="+216"><span class="name">突尼斯</span><span class="code">+216</span></li><li data-code="+690"><span class="name">托克劳</span><span class="code">+690</span></li><li data-code="+688"><span class="name">图瓦卢</span><span class="code">+688</span></li><li data-code="+681"><span class="name">瓦利斯和富图纳</span><span class="code">+681</span></li><li data-code="+678"><span class="name">瓦努阿图</span><span class="code">+678</span></li><li data-code="+502"><span class="name">危地马拉</span><span class="code">+502</span></li><li data-code="+58"><span class="name">委内瑞拉</span><span class="code">+58</span></li><li data-code="+673"><span class="name">文莱</span><span class="code">+673</span></li><li data-code="+256"><span class="name">乌干达</span><span class="code">+256</span></li><li data-code="+380"><span class="name">乌克兰</span><span class="code">+380</span></li><li data-code="+598"><span class="name">乌拉圭</span><span class="code">+598</span></li><li data-code="+998"><span class="name">乌兹别克斯坦</span><span class="code">+998</span></li><li data-code="+34"><span class="name">西班牙</span><span class="code">+34</span></li><li data-code="+30"><span class="name">希腊</span><span class="code">+30</span></li><li data-code="+65"><span class="name">新加坡</span><span class="code">+65</span></li><li data-code="+687"><span class="name">新喀里多尼亚</span><span class="code">+687</span></li><li data-code="+64"><span class="name">新西兰</span><span class="code">+64</span></li><li data-code="+36"><span class="name">匈牙利</span><span class="code">+36</span></li><li data-code="+963"><span class="name">叙利亚</span><span class="code">+963</span></li><li data-code="+1876"><span class="name">牙买加</span><span class="code">+1876</span></li><li data-code="+374"><span class="name">亚美尼亚</span><span class="code">+374</span></li><li data-code="+967"><span class="name">也门</span><span class="code">+967</span></li><li data-code="+39"><span class="name">意大利</span><span class="code">+39</span></li><li data-code="+964"><span class="name">伊拉克</span><span class="code">+964</span></li><li data-code="+98"><span class="name">伊朗</span><span class="code">+98</span></li><li data-code="+91"><span class="name">印度</span><span class="code">+91</span></li><li data-code="+62"><span class="name">印度尼西亚</span><span class="code">+62</span></li><li data-code="+44"><span class="name">英国</span><span class="code">+44</span></li><li data-code="+1284"><span class="name">英属维尔京群岛</span><span class="code">+1284</span></li><li data-code="+972"><span class="name">以色列</span><span class="code">+972</span></li><li data-code="+962"><span class="name">约旦</span><span class="code">+962</span></li><li data-code="+84"><span class="name">越南</span><span class="code">+84</span></li><li data-code="+260"><span class="name">赞比亚</span><span class="code">+260</span></li><li data-code="+235"><span class="name">乍得</span><span class="code">+235</span></li><li data-code="+350"><span class="name">直布罗陀</span><span class="code">+350</span></li><li data-code="+56"><span class="name">智利</span><span class="code">+56</span></li><li data-code="+236"><span class="name">中非共和国</span><span class="code">+236</span></li><li data-code="+86"><span class="name">中国</span><span class="code">+86</span></li><li data-code="+852"><span class="name">中国香港特别行政区</span><span class="code">+852</span></li><li data-code="+853"><span class="name">中国澳门特别行政区</span><span class="code">+853</span></li></ul>
                </div>
            </div>

            <div class="form-warp clearfix" id="new-mobile-gt-guide" style="padding-top: 35px;">
            <div class="gt_holder gt_float" style="touch-action: none;"><div class="gt_widget gt_hide"><div class="gt_holder_top"></div><div class="gt_box_holder" style="height: 116px;"><div class="gt_box"><div class="gt_loading"><div class="gt_loading_icon"></div><div class="gt_loading_text">加载中...</div></div><a class="gt_bg gt_show" style="background-image: none;"><div class="gt_cut_bg gt_show"><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -157px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -145px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -265px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -277px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -181px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -169px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -241px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -253px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -109px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -97px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -289px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -301px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -85px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -73px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -25px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -37px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -13px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -1px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -121px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -133px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -61px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -49px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -217px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -229px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -205px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -193px -58px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -145px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -157px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -277px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -265px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -169px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -181px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -253px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -241px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -97px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -109px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -301px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -289px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -73px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -85px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -37px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -25px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -1px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -13px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -133px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -121px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -49px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -61px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -229px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -217px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -193px 0px;"></div><div class="gt_cut_bg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/bg/21602a332.webp&quot;); background-position: -205px 0px;"></div></div><div class="gt_slice gt_show" style="left: 124px; background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/slice/21602a332.png&quot;); width: 53px; height: 51px; top: 37px;"></div></a><a class="gt_fullbg gt_show" style="cursor: default; background-image: none;"><div class="gt_cut_fullbg gt_show"><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -157px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -145px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -265px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -277px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -181px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -169px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -241px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -253px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -109px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -97px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -289px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -301px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -85px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -73px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -25px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -37px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -13px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -1px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -121px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -133px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -61px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -49px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -217px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -229px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -205px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -193px -58px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -145px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -157px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -277px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -265px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -169px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -181px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -253px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -241px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -97px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -109px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -301px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -289px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -73px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -85px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -37px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -25px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -1px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -13px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -133px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -121px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -49px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -61px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -229px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -217px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -193px 0px;"></div><div class="gt_cut_fullbg_slice" style="background-image: url(&quot;https://static.geetest.com/pictures/gt/6121c49a0/6121c49a0.webp&quot;); background-position: -205px 0px;"></div></div><div class="gt_flash gt_hide" style="height: 94px;"></div><div class="gt_ie_success"></div></a><a class="gt_curtain gt_hide" style="background-image: none;"><div class="gt_curtain_bg_wrap"><div class="gt_curtain_bg"><div class="gt_cut_curtain"></div></div></div><div class="gt_curtain_button gt_hide"></div></a><a class="gt_box_tips" style="display: none;"></a></div><div class="gt_info gt_hide"><div class="gt_info_tip gt_success"><div class="gt_info_icon"></div><div class="gt_info_text"><span class="gt_info_type">验证通过:</span><span class="gt_info_content">2.3 秒的速度超过 94% 的用户</span></div></div></div></div><div class="gt_bottom"><a class="gt_refresh_button"><div class="gt_refresh_tips">刷新验证</div></a><a class="gt_help_button" href="http://www.geetest.com/contact#report" target="_blank"><div class="gt_help_tips">帮助反馈</div></a><a class="gt_logo_button" href="http://www.geetest.com/first_page" target="_blank"></a></div></div><div class="gt_input"><input class="geetest_challenge" type="hidden" name="geetest_challenge" value="f0aef598f18fd2f0e124383109b840db3m"><input class="geetest_validate" type="hidden" name="geetest_validate" value="0b4694bc4b6a50209b106c117897a702"><input class="geetest_seccode" type="hidden" name="geetest_seccode" value="0b4694bc4b6a50209b106c117897a702|jordan"></div><div class="gt_slider"><div class="gt_guide_tip gt_hide">按住左边滑块，拖动完成上方拼图</div><div class="gt_slider_knob gt_show" style="left: 124px;"></div><div class="gt_curtain_tip gt_hide">点击上图按钮并沿道路拖动到终点处</div><div class="gt_curtain_knob gt_hide">移动到此开始验证</div><div class="gt_ajax_tip gt_success"></div></div></div></div>
            <div class="form-warp">
                <label class="control-label">验证码：</label>
                <input class="control-input" id="captcha" placeholder="短信验证码">
                <button class="btn btn-default js-btn-captcha-phone">免费获取</button>
            </div>
            <button class="btn btn-blue js-save-mobile">完成</button>
        </ul>
    </div>
</div>
<div class="acnt-item-box">
    <div class="acnt-item">
        <i class="icon acnt-item-icon icon-round-ok"></i>
        <label class="acnt-item-label">密&nbsp;&nbsp;&nbsp;码：</label>

        <div class="control-box under-control account">

        </div>
        <div class="btn-group  btn-group-box pull-right js-edit-user-info  disabled">
            <span class="btn btn-default  btn-dropdown-show js-edit-user-pw">收起</span>
            <button type="button" class="btn btn-default dropdown-toggle">
                <span class="icon icon-del"></span>
            </button>
        </div>
    </div>
    <div class="acnt-item acnt-item-content">
        <ul class="under-ul" style="display: block;">
            <div class="form-warp">
                <label class="control-label">密&nbsp;&nbsp;&nbsp;码：</label>
                <input class="control-input" type="password" id="oldpassword" placeholder="密码">
            </div>
            <div class="form-warp">
                <label class="control-label">新密码：</label>
                <input class="control-input" type="password" id="password1" placeholder="新密码">
            </div>
            <div class="form-warp">
                <label class="control-label">确认密码：</label>
                <input class="control-input" type="password" id="password2" placeholder="确认密码">
            </div>
            <button class="btn btn-blue js-reset-pw">完成</button>
        </ul>

    </div>
</div>
            </div>
    <div style="height: 60px">

    </div>
</div>
<div style="height: 60px">

</div>
</div>
<div style="clear:both;"></div>
<VFooter></VFooter>

  </section>
</template>
<script>
import {requestLogin, requestRegister,updateUser} from '../api/api.js'

import VHeader from '@/components/Header.vue'
import VFooter from '@/components/Footer.vue'
import VueNotifications from 'vue-notifications'

export default {
    data(){
        return{
            userInfo: {
                userId:1,
                username: "",
                password: "",
                nickname: "",
                newNickname:"",
                userMail: "",
                userGroupId: 1
            },
            isLogined: false,
            isLoginShow: false,
            isRegisterShow: false,
            isSearchShow: false,
        }
    },
    components: {VHeader,VFooter},
    mounted(){
        let token = window.localStorage.getItem("token")
        if(token!=null&&token!=""){
            this.userInfo = JSON.parse(window.localStorage.getItem("user"))
            this.isLogined = true
        }
    },
    methods: {
        /* header方法 */
        handleForm(...data) {
            console.log(data)
            console.log("dsadsadsa")
            if(data[0] === 0){//点击登录
                this.isLoginShow = true
                this.isRegisterShow = false
            }else if(data[0] === 1){//点击注册
                this.isLoginShow = false
                this.isRegisterShow = true
            }
        },
        closeForm() {
            this.isLoginShow = false
            this.isRegisterShow = false
        },
        loginConfirm () {
            requestLogin(this.userInfo).then(res => {
                console.log(res)
                if(res.data.status === 1){
                    this.isLoginShow = false
                    this.isLogined = true
                    this.userInfo = JSON.parse(window.localStorage.getItem("user"))
                    this.showSuccessMsg({title:"成功",message:"登录成功"})
                }else if(res.data.status === -1){
                    this.showErrorMsg({title:"失败",message:"用户名不存在"})
                }
            })
        },
        registerConfirm () {
            let param = this.userInfo
            requestRegister(param).then(res => {
                console.log(res)
                if(res.status === 1){
                    this.showSuccessMsg({title:"成功",message:"已成功向您的邮箱发送帐号激活邮件,请确认"})
                }else{
                    this.showErrorMsg({title:"失败",message:"发送邮件失败"})
                }
            })
        },
        logout () {
            window.localStorage.removeItem("token")
            window.localStorage.removeItem("user")
            this.isLogined = false
        },
        handleSearch(...data){
            if(data[0] === 0){//关闭
                this.isSearchShow = false
            }else if(data[0] === 1){
                this.isSearchShow = true
            }    
        },
        
        updateUserInfo(flag){
            let param = {
                userId: this.userInfo.userId,
                username: this.userInfo.username
            }
            switch(flag){
                case 0: 
                    param.username = this.userInfo.username
                    updateUser(param).then(res=>{
                        console.log(res.result)
                    })
                    break
                case 1:
                    param.nickname = this.userInfo.newNickname
                    updateUser(param).then(res=>{
                        if(res.data.status === 1){
                            this.showSuccessMsg({title:"成功",message:"修改成功"})
                        }
                    })
                    break
                case 2:
                    break 
            }
        }
    },
    //通知插件
    notifications: {
        showSuccessMsg: {
        type: VueNotifications.types.success,
        title: 'Hello there',
        message: 'That\'s the success!'
        },
        showInfoMsg: {
        type: VueNotifications.types.info,
        title: 'Hey you',
        message: 'Here is some info for you'
        },
        showWarnMsg: {
        type: VueNotifications.types.warn,
        title: 'Wow, man',
        message: 'That\'s the kind of warning'
        },
        showErrorMsg: {
        type: VueNotifications.types.error,
        title: 'Wow-wow',
        message: 'That\'s the error'
        }
    },
    metaInfo () {
        const title = ""
        return {
            title: "用户中心",
            meta:[{
                vmid: 'referrer',
                name: 'referrer',
                content: 'never'
            }]
        }
    },
}
</script>
<style>
@import '../assets/bootstrap/css/bootstrap.min.css';
@import '../assets/css/build.css';
@import '../assets/css/login.css';
@import '../assets/css/dlzc.css';
@import '../assets/css/zzsc.css';
@import '../assets/css/userinfo.css';

#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}
</style>


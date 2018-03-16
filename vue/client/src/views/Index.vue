
<template>
    <section id="index">
        <VHeader 
        :isLogined="isLogined" 
        :userInfo="userInfo" 
        :isLoginShow="isLoginShow"
        :isRegisterShow="isRegisterShow"
        @handleForm="handleForm"
        @closeForm="closeForm"
        @loginConfirm="loginConfirm"
        @registerConfirm="registerConfirm"
        @logout="logout"
        ></VHeader>

<div class="placeholder-height"></div>
<div class="container" id="index">
	<div class="wrap-left pull-left">
        <div class="big-pic-box">
             <div class="big-pic">
                  <a href="#" target="_blank" class="transition" title="醒醒吧，腾讯、网易称霸的游戏行业，谁都没机会成为第三">
                     <div class="back-img"><img src="../assets/sy-img/061708387437.jpg"  alt="醒醒吧，腾讯、网易称霸的游戏行业，谁都没机会成为第三"></div>
                     <div class="big-pic-content">
                          <h1 class="t-h1">醒醒吧，腾讯、网易称霸的游戏行业，谁都没机会成为第三</h1>
                      </div>
                  </a>
             </div>
             <div class="big2-pic big2-pic-index big2-pic-index-top">
                  <a href="#" class="back-img transition" target="_blank" title="嘘！Facebook 正在上海悄悄寻找办公室">
                     <img class="lazy" src="../assets/sy-img/142618969973.jpg" alt="嘘！Facebook 正在上海悄悄寻找办公室">
                  </a>
                  <a href="#" target="_blank" title="嘘！Facebook 正在上海悄悄寻找办公室">
                     <div class="big2-pic-content">
                          <h2 class="t-h1">嘘！Facebook 正在上海悄悄寻找办公室</h2>
                     </div>
                  </a>
             </div>
             <div class="big2-pic big2-pic-index big2-pic-index-bottom">
                  <a href="#" class="back-img transition" target="_blank" title="马云在人生最艰难时去了延安，在革命根据地决定建立淘宝">
                     <img class="lazy" src="../assets/sy-img/093433055013.jpg" alt="马云在人生最艰难时去了延安，在革命根据地决定建立淘宝">
                  </a>
                  <a href="#" target="_blank" title="马云在人生最艰难时去了延安，在革命根据地决定建立淘宝">
                     <div class="big2-pic-content">
                          <h2 class="t-h1">马云在人生最艰难时去了延安，在革命根据地决定建立淘宝</h2>
                     </div>
                  </a>
             </div>
       </div>
    <div class="msgAlert" :class="{'active': isMsgAlert}">
           <p class="msgAlert-text">{{isMsgAlertText}}</p>
       </div>
       <div class="mod-info-flow">
            <div class="mod-b mod-art" data-aid="213665" v-for="info in infoList">
            	 <div class="mod-angle">热</div>
                 <div class="mod-thumb ">
                       <a class="transition" title="你的公司够前沿吗？至少在AI这件事上，多数企业都眼高手低" href="#" target="_blank">
						  <img class="lazy" style="height:100%" :src="`${info.infoImage.image}`" :onerror="defaultImg" alt="你的公司够前沿吗？至少在AI这件事上，多数企业都眼高手低">
                       </a>
                 </div>
                 <div class="column-link-box">
                 	<a href="#" class="column-link" target="_blank">娱乐淘金</a>
                 </div>
                 <div class="mob-ctt">
                    <h2><router-link :to="`/article/${info.infoId}`" class="transition msubstr-row2" target="_blank">{{info.title}}</router-link></h2>
					<div class="mob-author">
                        <div class="author-face">
                            <a href="#" target="_blank"><img src="../assets/sy-img/59_1502432173.jpg"></a>
                        </div>
                        <a href="#" target="_blank">
                        <span class="author-name ">{{info.author}}</span>
                        </a>
                        <a href="#" target="_blank" title="购买VIP会员"></a>
                        <span class="time">{{info.publishDate | formatDateDiff}}</span>
                        <i class="icon icon-fvr"></i><em>{{info.likes}}</em>
                        <i class="icon icon-cmt"></i><em>0</em>
                    </div>
                    <div class="mob-sub">{{info.description}}</div>
                 </div>
            </div>
		</div>
        <div class="get-mod-more js-get-mod-more-list transition" @click="loadMore()">
            点击加载更多
        </div>
	</div>
    <div class="wrap-right pull-right">
        <div class="right-ad-box"></div>

<link rel="stylesheet" type="text/css" href="https://static.huxiucdn.com/www/css/moment.css">
		<div id="moment"></div>
		<div class="box-moder moder-story-list">
    		<h3>24小时</h3>
    		<span class="pull-right project-more story-more"><a href="#" class="transition index-24-right js-index-24-right" target="_blank">查看全部</a></span>
    		<span class="span-mark"></span>
    		<div class="story-box-warp hour-box-warp">
        		<div class="nano">
            	<div class="overthrow nano-content description" tabindex="0">
                	<ul class="box-list mt-box-list">
                    <!--公共24小时列表部分-->
                    	<li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。                                                            <a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp] </a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。 <a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。 <a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
                        <li>
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li><img class="hour-tx" src="../assets/sy-img/touxiang.jpg" alt="头像"></li>
                        				<li>
                            				<p>果然黑</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">#苹果至少要等到2019年才能摆脱对三星的依赖#  作为苹果现有LCD显示屏长期的供货商，LG Display可做到2019年实现OLED显示屏的全面发货，明年年底可以实现少量的发货。目前，LG与苹果就一些协商预付款的细节问题讨论到最后阶段。<a href="#" target="_blank" class="mt-index-cont2-a">[&nbsp原文&nbsp]</a>
                                         </p>
                        				 <div class="mt-index-end">
                            			 	<div class="mt-index-realend">...</div>
                        				 </div>
                    				</div>
                				</div>
            				</div>
        				</li>
					</ul>
            	</div>
            	<div class="nano-pane">
                	<div class="nano-slider" style="height: 179px; transform: translate(0px, 0px);"></div>
            	</div>
        	</div>
    	</div>
    	<div class="js-more-moment" data-cur_page="0"></div>
	</div>
	<div class="placeholder"></div>
<!--24小时部分结束1-->
	<div class="ad-wrap">
    	<div class="ad-title">广告</div>
    </div>
    <div class="placeholder"></div>
<!--传言-->
<!--传言部分开始-->
    <div id="rumor_center"></div>
    <div class="box-moder moder-rumors-list">
        <h3>传言</h3>
        <span class="span-mark"></span>
        <div class="big2-pic pull-right">
            <a href="#" class="back-img" target="_blank">
                <img class="lazy" src="../assets/sy-img/105108838520.jpg" alt="">
            </a>
            <a href="https://chuanyan.huxiu.com/rumor/detail/684.html" target="_blank">
                <div class="big2-pic-content">
                    <h2 class="t-h1">传苹果和亚马逊正在竞购“007”品牌特许经营权</h2>
                </div>
                <div class="clear"></div>
            </a>
        </div>
        <div class="clear"></div>
        <ul class="rumorlist">
            <li>
                <div class="icon-clock"><img src="../assets/images/clock.jpg"/></div>
                <p class="rumor-time">09月07日  08:00</p>
                <p class="rumor-detail"><a href="#" target="_blank">美媒报道称，苹果和亚马逊正在竞购“007”詹姆斯·邦德品牌的特...</a></p>
            </li>
        </ul>
        <div class="rumor-more">
            <p><a href="#" target="_blank">详情>></a></p>
        </div>
                    <!--24小时不展示此按钮-->
            <div class="rumor-brunt-box">
                <a class="btn btn-blue-cy js-update-cy transition  js-show-bruntback-box1" >我要爆料</a>
            </div>
            </div>
    <div class="placeholder"></div>
    <!--传言部分结束-->
	<div class="ad-wrap">
    	<div class="ad-title">广告</div>
	</div>
    <div class="placeholder"></div>
    <div class="box-moder moder-project-list">
        <h3>创业白板</h3>
        <span class="pull-right project-more"><a href="#" class="transition" target="_blank">全部</a></span>
        <span class="span-mark"></span>
        <ul>
            <li>
                <div class="project-pic">
                        <img src="../assets/sy-img/1503478306719861.png">
                </div>
                <div class="project-content">
                     <div class="project-title">
                         <a href="#" class="transition" target="_blank">车悦宝</a>
                     </div>
                     <p>车载综合音频娱乐服务商</p>
                 </div>
            </li>
           	<li>
                <div class="project-pic">
                        <img src="../assets/sy-img/1503478306719861.png">
                </div>
                <div class="project-content">
                     <div class="project-title">
                         <a href="#" class="transition" target="_blank">车悦宝</a>
                     </div>
                     <p>车载综合音频娱乐服务商</p>
                 </div>
            </li>
            <li>
                <div class="project-pic">
                        <img src="../assets/sy-img/1503478306719861.png">
                </div>
                <div class="project-content">
                     <div class="project-title">
                         <a href="#" class="transition" target="_blank">车悦宝</a>
                     </div>
                     <p>车载综合音频娱乐服务商</p>
                 </div>
            </li>
            <li>
                <div class="project-pic">
                        <img src="../assets/sy-img/1503478306719861.png">
                </div>
                <div class="project-content">
                     <div class="project-title">
                         <a href="#" class="transition" target="_blank">车悦宝</a>
                     </div>
                     <p>车载综合音频娱乐服务商</p>
                 </div>
            </li>
            <li>
                <div class="project-pic">
                        <img src="../assets/sy-img/1503478306719861.png">
                </div>
                <div class="project-content">
                     <div class="project-title">
                         <a href="#" class="transition" target="_blank">车悦宝</a>
                     </div>
                     <p>车载综合音频娱乐服务商</p>
                 </div>
            </li>
         </ul>
        <div class="project-btn-box">
            <a class="js-open-cy btn btn-blue-cy transition">立即报名，获得曝光机会！</a>
        </div>
        <ul class="project-info">
            <li>创业公司立即报名提交信息的好处：</li>
            <li>1.优质的展示和访谈机会</li>
            <li>2.获得投资人的关注</li>
            <li>3.虎嗅提供的创业支持服务</li>
        </ul>
    </div>
    <div class="placeholder"></div>
    <div class="box-moder moder-project-list promote-box">
        <h3>赞助内容</h3>
        <span class="span-mark"></span>
        <ul>
            <li>
                <div class="mod-thumb">
                     <a href="#" target="_blank">
                        <img src="../assets/sy-img/233950517521.jpg">
                     </a>
                </div>
                <div class="project-content">
                     <a href="#" class="c2" target="_blank">实体商业转型</a>
                     <span class="point">&bull;</span>
                     <a href="#" target="_blank">实体空间在召唤，他们押宝了零售业态转型升级</a>
                </div>
            </li>
            <li>
                <div class="mod-thumb">
                     <a href="#" target="_blank">
                        <img src="../assets/sy-img/233950517521.jpg">
                     </a>
                </div>
                <div class="project-content">
                     <a href="#" class="c2" target="_blank">实体商业转型</a>
                     <span class="point">&bull;</span>
                     <a href="#" target="_blank">实体空间在召唤，他们押宝了零售业态转型升级</a>
                </div>
            </li>
            <li>
                <div class="mod-thumb">
                     <a href="#" target="_blank">
                        <img src="../assets/sy-img/233950517521.jpg">
                     </a>
                </div>
                <div class="project-content">
                     <a href="#" class="c2" target="_blank">实体商业转型</a>
                     <span class="point">&bull;</span>
                     <a href="#" target="_blank">实体空间在召唤，他们押宝了零售业态转型升级</a>
                </div>
            </li>
         </ul>
    </div>
    <div class="placeholder"></div>


<!--研究报告部分开始-->
    <div class="box-moder hot-article">
        <h3>创新案例</h3>
        <span class="pull-right project-more story-more">
            <a href="#" class="transition" target="_blank">全部</a></span>
        <span class="span-mark"></span>
        <ul>           
            <li>
            	<div class="hot-article-img">
                	<a href="#" target="_blank">
                   		<img src="../assets/sy-img/105108838520.jpg">
                	</a>
            	</div>
            	<a href="#" class="transition" target="_blank">【经济学人】比特币内战打响，加密货币走到分岔路口</a>
            	<div class="report-author-info" style="margin-left:0px;margin-top:0px;">
                	<span class="author-face">
                    	<img src="../assets/sy-img/97.jpg">
                	</span>
                	<span>虎嗅会员小秘书</span>
                	<div style="margin-left: 40px;margin-top: 5px;">微信号：huxiuvip302</div>
            	</div>
        	</li>
        </ul>
        <div class="report-explain">全年30+篇 案例分析，复盘有代表性的创新公司，还原商业成功背后的魔鬼细节。</div>
    </div>
    <div class="placeholder"></div>
    <div class="box-moder hot-article">
        <h3>热文</h3>
        <span class="span-mark"></span>
        <ul>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            <li>
                <div class="hot-article-img">
                     <a href="#" target="_blank" title="华谊：老了，还花心">
                        <img src="../assets/sy-img/105108838520.jpg">
					 </a>
                </div>
                <a href="#" class="transition" target="_blank">华谊：老了，还花心</a>
            </li>
            
         </ul>
    </div>
    <div class="placeholder"></div>
</div>
</div>

<footer class="footer">
    <div class="modal-backdrop fade in js-modal-backdrop"></div>
    <div class="container copy-right">
        <div class="footer-tag-list">
            <a href="#" target="_blank" class="transition">关于我们</a>
            <a href="#" target="_blank" class="transition">加入我们</a>
            <a href="#" target="_blank" class="transition">合作伙伴</a>
            <a href="#" target="_blank" class="transition">广告及服务</a>
            <a href="#" target="_blank" class="transition">常见问题解答</a>
            <a href="#" target="_blank" class="transition">防网络诈骗专题</a>
        </div>
        <span style="text-align:left;">Copyright © <a href="#">虎嗅网</a> <a href="#" target="_blank">京ICP备12013432号-1</a>
            &nbsp;<a href="#" target="_blank"><i class="i-wj"></i>京公网安备 11010102001402号</a>&nbsp;&nbsp;&nbsp;<em class="bull-right">本站由</em><i class="icon-aliyun" style="width: 70px;background-size: 100%;left: 7px;"></i><em class="bull-em">提供计算与安全服务</em>
        </span>
        <div class="footer-icon-list pull-right">
            <ul class="Qr-codee">
                <a><li class="Qr-code-footer">
                    <div class="app-qrcode"><img src="../assets/images/weixin_erweima.png"></div>
                    <i class="icon icon-footer icon-footer-wx"></i>
                </li>
                </a>
                <a><li class="Qr-code-footer">
                	<div class="app-qrcode"><img src="../assets/images/app_erweima.png"></div>
                    <i class="icon icon-footer icon-footer-ios"></i>
                </li>
                </a>
                <a><li class="Qr-code-footer">
                    <div class="app-qrcode"><img src="../assets/images/app_erweima.png"></div>
                    <i class="icon icon-footer icon-footer-android"></i>
                </li>
                </a>
                <a href="#" target="_blank" title="虎嗅英文版">
                    <li><i class="icon icon-footer icon-footer-inter"></i></li>
                </a>
                <a href="#" target="_blank" title="虎嗅RSS订阅中心">
                    <li><i class="icon icon-footer icon-footer-rss"></i></li>
                </a>
            </ul>
        </div>
    </div>
<div id="moquu_wxin" class="moquu_wxin"><a href="javascript:void(0)"><div class="moquu_wxinh"></div></a></div>
<div id="moquu_wshare" class="moquu_wshare"><a href="javascript:void(0)"><div class="moquu_wshareh"></div></a></div>
</footer>

    </section>
</template>
<script>
import {requestLogin, requestRegister,getInfoByDate} from '../api/api.js'
import VHeader from '@/components/Header.vue'
import VueNotifications from 'vue-notifications'
import {GetDateDiff} from '../utils/date.js'

export default {
    data () {
        return {
            userInfo: {
                username: "",
                password: "",
                nickname: "",
                userMail: "",
                userGroupId: 1
            },
            isLogined: false,
            isLoginShow: false,
            isRegisterShow: false,
            
            isMsgAlert: true,
            isMsgAlertText: '',
            defaultImg: 'this.src="' + require('../assets/sy-img/150611228857.jpg') + '"',
            infoList: [],
            page: 1
        }
    },
    components:{
        VHeader
    },
    mounted(){
        let token = window.localStorage.getItem("token")
        if(token!=null&&token!=""){
            this.userInfo = JSON.parse(window.localStorage.getItem("user"))
            console.log(this.userInfo)
            this.isLogined = true
        }
        getInfoByDate(this.page).then((res)=>{
            console.log(res)
            if(res.status === 1){
                this.infoList = res.result
                this.isMsgAlert = false
                this.isMsgAlertText = "为您推荐了6条消息"
                setTimeout(()=>{
                    this.isMsgAlert = true
                },3000)
                
            }
            
        })
    },
    methods: {
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
        loadMore(){
            this.page += 1
            getInfoByDate(this.page).then((res)=>{
                console.log(res)
                if(res.status === 1){
                    for(let obj of res.result){
                        this.infoList.push(obj)
                    }
                }
            })
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
            title: "首页",
            meta:[{
                vmid: 'referrer',
                name: 'referrer',
                content: 'never'
            }]
        }
    },
    filters: {
		formatDateDiff(time) {
            return GetDateDiff(new Date(time));
		}
	}

}
</script>

<style scoped>
@import '../assets/bootstrap/css/bootstrap.min.css';
@import '../assets/css/build.css';
@import '../assets/css/activity.css';
@import '../assets/css/login.css';
@import '../assets/css/dlzc.css';
@import '../assets/css/zzsc.css';
@import '../assets/css/nanoscroller.css';

#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}

</style>





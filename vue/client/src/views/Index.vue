
<template>
    <section id="index">
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
<div class="container" id="index">
	<div class="wrap-left pull-left">
        <div class="big-pic-box" v-if="threeRecommendInfos != null">
            <div class="big-pic">
                <a href="#" target="_blank" class="transition" :title="threeRecommendInfos[0].title">
                    <div class="back-img">
                        <img class="lazy" style="height:100%" v-if="threeRecommendInfos[0].infoImage!=null" 
                        :src="`${threeRecommendInfos[0].infoImage.image}`" :onerror="defaultImg" :alt="threeRecommendInfos[0].title">
                    </div>
                    <div class="big-pic-content">
                        <h1 class="t-h1">{{threeRecommendInfos[0].title}}</h1>
                    </div>
                </a>
            </div>
            <div class="big2-pic big2-pic-index big2-pic-index-top">
                <a href="#" class="back-img transition" target="_blank" :title="threeRecommendInfos[1].title">
                    <img class="lazy" style="height:100%" v-if="threeRecommendInfos[1].infoImage!=null" 
                    :src="`${threeRecommendInfos[1].infoImage.image}`" :onerror="defaultImg" :alt="threeRecommendInfos[1].title">
                </a>
                <a href="#" target="_blank" :title="threeRecommendInfos[1].title">
                    <div class="big2-pic-content">
                        <h2 class="t-h1">{{threeRecommendInfos[1].title}}</h2>
                    </div>
                </a>
            </div>
            <div class="big2-pic big2-pic-index big2-pic-index-bottom">
                <a href="#" class="back-img transition" target="_blank" :title="threeRecommendInfos[2].title">
                    <img class="lazy" style="height:100%" v-if="threeRecommendInfos[2].infoImage!=null" 
                    :src="`${threeRecommendInfos[2].infoImage.image}`" :onerror="defaultImg" :alt="threeRecommendInfos[2].title">
                </a>
                <a href="#" target="_blank" :title="threeRecommendInfos[2].title">
                    <div class="big2-pic-content">
                        <h2 class="t-h1">{{threeRecommendInfos[2].title}}</h2>
                    </div>
                </a>
            </div>
       </div>
    <div class="msgAlert" :class="{'active': isMsgAlert}">
           <p class="msgAlert-text">{{isMsgAlertText}}</p>
       </div>
       <div class="mod-info-flow"  v-if="infoList != null">
            <div class="mod-b mod-art" data-aid="213665" v-for="info in infoList">
            	 <div class="mod-angle">热</div>
                 <div class="mod-thumb ">
                       <a class="transition" title="你的公司够前沿吗？至少在AI这件事上，多数企业都眼高手低" href="#" target="_blank">
						  <img class="lazy" style="height:100%" v-if="info.infoImage!=null" :src="`${info.infoImage.image}`" :onerror="defaultImg" alt="你的公司够前沿吗？至少在AI这件事上，多数企业都眼高手低">
                       </a>
                 </div>
                 <div class="column-link-box">
                 	<a href="#" class="column-link" target="_blank">不感兴趣
                         <i class="icon-not-interst"></i>
                     </a>
                 </div>
                 <div class="mob-ctt">
                    <h2><router-link :to="`/article/${info.infoId}`" class="transition msubstr-row2" :class="{'isRead': info.isRead}">{{info.title}}</router-link></h2>
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
    		<h3>最近热评</h3>
    		<span class="pull-right project-more story-more"><a href="#" class="transition index-24-right js-index-24-right" target="_blank">查看全部</a></span>
    		<span class="span-mark"></span>
    		<div class="story-box-warp hour-box-warp">
        		<div class="nano">
            	<div class="overthrow nano-content description" tabindex="0">
                	<ul class="box-list mt-box-list">
                    <!--公共24小时列表部分-->
                    	<li v-for="comment in hotCommentList">
            				<div class="story-content">
                				<div class="mt-story-title js-story-title" story-data-show="true">
                    				<p class="transition hour-arrow">
                        				<span class="icon icon-caret js-mt-index-icon"></span>
                   					</p>
                    				<ul class="hour-head">
                        				<li>
                                            <img style="width:25px;" :src="`${comment.userInfo.userImageUrl}`" :onerror="defaultAvatar">
                                        </li>
                        				<li>
                            				<p>{{comment.userInfo.nickname}}</p>
                            				<p>3分钟前</p>
                        				</li>
                    				</ul>
                				</div>
                				<div class="mt-index-info-parent">
                    				<div class="story-info mt-story-info">
                        				<p class="story-detail-hide hour-detail-hide mt-index-cont mt-index-cont2 js-mt-index-cont2">
                                            {{comment.content}}
                                            <router-link :to="`/article/${comment.infoId}`" class="mt-index-cont2-a">[&nbsp原文&nbsp]</router-link>
                                         </p>
                    				</div>
                				</div>
            				</div>
        				</li>
					</ul>
            	</div>
            	<!-- <div class="nano-pane">
                	<div class="nano-slider" style="height: 179px; transform: translate(0px, 0px);"></div>
            	</div> -->
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
    <!-- <div id="rumor_center"></div>
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
        </div> -->
                    <!--24小时不展示此按钮-->
            <!-- <div class="rumor-brunt-box">
                <a class="btn btn-blue-cy js-update-cy transition  js-show-bruntback-box1" >我要爆料</a>
            </div>
            </div> -->
    <div class="placeholder"></div>
    <!--传言部分结束-->
	<!-- <div class="ad-wrap">
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
            <li>3.Oreo提供的创业支持服务</li>
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
    <div class="placeholder"></div> -->


<!--研究报告部分开始-->
    <!-- <div class="box-moder hot-article">
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
                	<span>Oreo会员小秘书</span>
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
    </div> -->
    <div class="placeholder"></div>
</div>
</div>
<VFooter></VFooter>
    </section>
</template>
<script>
import {getAllType, getUserInfoById,requestLogin, requestRegister,getInfoByDate,getLogInfos,getHotComments,pushUserByLogInfo} from '../api/api.js'
import VHeader from '@/components/Header.vue'
import VFooter from '@/components/Footer.vue'

import VueNotifications from 'vue-notifications'
import {GetDateDiff} from '../utils/date.js'

export default {
    data () {
        return {
            userInfo: {
                // username: "",
                // password: "",
                // nickname: "",
                // userMail: "",
                // userGroupId: 1
            },
            isLogined: false,
            isLoginShow: false,
            isRegisterShow: false,
            isSearchShow: false,

            isMsgAlert: true,
            isMsgAlertText: '',
            defaultAvatar: 'this.src="https://img.huxiucdn.com/auth/data/avatar/2.jpg"',
            defaultImg: 'this.src="' + require('../assets/sy-img/150611228857.jpg') + '"',
            infoList: null,
            threeRecommendInfos: null,
            logInfoList: [],
            hotCommentList: [],
            typeList: [],
            page: 1,
        }
    },
    components:{
        VHeader,VFooter
    },
    mounted(){
        let token = window.localStorage.getItem("token")
        if(token!=null&&token!=""){
            // this.userInfo = JSON.parse(window.localStorage.getItem("user"))
            this.userInfo.userId = window.localStorage.getItem("user");
            getUserInfoById(this.userInfo.userId).then(res=>{
                if(res.status === 1){
                    this.userInfo = res.result
                }
            })
            this.isLogined = true
        }
        getHotComments().then(res=>{
            if(res.status === 1){
                this.hotCommentList = res.result
            }
        })
        getLogInfos().then(res=>{
            if(res.status === 1){
                this.logInfoList = res.result
                 pushUserByLogInfo().then((res)=>{
                    if(res.status === 1){
                        console.log("文章:",res.result)
                        /* 设置文章为已读或未读 */
                        let infos = res.result
                        for(let info of infos){
                            info.isRead = false
                            for(let log of this.logInfoList){
                                if(log.infoId === info.infoId){
                                    console.log(info.title+"已经读过")
                                    info.isRead = true
                                }
                            }
                        }
                        console.log(infos)
                        this.infoList = infos
                        this.threeRecommendInfos = []
                        this.threeRecommendInfos.push(infos[0])
                        this.threeRecommendInfos.push(infos[1])
                        this.threeRecommendInfos.push(infos[2])
                        this.infoList.splice(0,3)
                        this.isMsgAlert = false
                        this.isMsgAlertText = `为您推荐了${infos.length}条文章`
                        setTimeout(()=>{
                            this.isMsgAlert = true
                        },3000)
                        
                    }
                    
                })
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
                    getUserInfoById(window.localStorage.getItem("user")).then(res=>{
                        if(res.status === 1){
                            this.userInfo = res.result
                            this.showSuccessMsg({title:"成功",message:"登录成功"})
                        }
                    })
                    // this.userInfo = JSON.parse(window.localStorage.getItem("user"))
                    this.webSocketConnect();
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
        webSocketConnect(){
            let token = window.localStorage.getItem("token")
            let ws = null
                if ('WebSocket' in window){
                    ws = new WebSocket("ws://localhost:8000/socketServer/"+token);    
                }    
                else if ('MozWebSocket' in window){
                    ws = new MozWebSocket("ws://localhost:8000/socketServer/"+token);    
                }
                else{
                    alert("该浏览器不支持websocket");    
                }    
                    
                    
                ws.onmessage = function(evt) {    
                    alert(evt.data);    
                };    
                    
                ws.onclose = function(evt) {    
                    alert("连接中断");    
                };    
                    
                ws.onopen = function(evt) {    
                    alert("连接成功");    
                };  
            
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





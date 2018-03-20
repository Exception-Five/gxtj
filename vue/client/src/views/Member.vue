
<template>
  <section id="member" style="background-color:#f0f4fb;">
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
<div class="container per_center_body" id="per_center">
    <div class="user-info-warp">
        <div class="user-head-box">
            <div class="user-face">
                <img :src="`${userInfo.userImageUrl}`" :onerror="defaultAvatar">
            </div>
            <div class="user-name">{{userInfo.nickname}}<a href="#" target="_blank"><i class="i-vip icon-vip" title="Oreo黑卡会员"></i></a></div>
            <div class="user-one">产品老司机</div>
                 <div class="user-one user-auth">Oreo认证作者<i class="i-icon icon-auth3" title="Oreo认证作者"></i></div>
                 <a href="javascript:" class="btn btn-messages js-login" uid="1373658" name="判官">给TA发私信</a>
                 <div class="admin-btn-warp"></div>
        	</div>
        	<div class="user-info-box">
            <div class="col-lg-5">
                <div class="user-info"><i class="icon icon-user-point"></i>用户名: {{userInfo.username}}</div>
                <div class="user-info"><i class="icon icon-user-point"></i>昵称: {{userInfo.nickname}}</div>
                <div class="user-info"><i class="icon icon-user-point"></i>邮箱：{{userInfo.userMail}}</div>
            </div>
            <!-- <div class="col-lg-7">
                <div class="user-info"><i class="icon icon-user-point"></i>微博：http://weibo.com/alexli2011</div>
                <div class="user-info"><i class="icon icon-user-point"></i>微信：17276694</div>
                <div class="user-info"><i class="icon icon-user-point"></i>微信公众号：lvkeapp2015</div>
            </div> -->
            <div class="btn-box new-edit-btn">
                <router-link :to="`/userinfo`" class="btn-user-new-edit pull-right">
                    <img src="https://static.huxiucdn.com/www/image/reward/user_info_editIcon.png" alt="">修改资料
                </router-link>
            </div>
            <div class="more-user-info-box">
                <div class="col-lg-5">
                    <div class="more-user-info"><i class="icon icon-user-point"></i>真实姓名：保密</div>
                    <div class="more-user-info"><i class="icon icon-user-point"></i>手机：保密</div>
                </div>
                <div class="col-lg-7">
                    <div class="more-user-info"><i class="icon icon-user-point"></i>性别：男</div>
                    <div class="more-user-info"><i class="icon icon-user-point"></i>所在地址：保密</div>
                </div>
                <div style="clear:both; width:100%;">
                    <div class="more-user-info"><i class="icon icon-user-point"></i>注册时间：2015-06-29</div>
                </div>
                <div style="width:100%;">
                    <div class="more-user-info" style="padding-left:75px;"><span>认证星级：<i class="i-icon2 icon2-stars03"></i></span></div>
                </div>
            </div>
        </div>
    </div>
    <div id="menu" name="menu"></div>
    <div class="user-menu-warp">
        <div class="menu-warp">
            <ul id=myTabs1>
                <li class="active" onMouseDown=Tabs1(this,0);><a href="#menu">最近阅读</a></li>
                <li class="" onMouseDown=Tabs1(this,1);><a href="#menu">TA的评论</a></li>
                <li class="" onMouseDown=Tabs1(this,2);><a href="#menu">TA的收藏</a></li>
                <li class="" onMouseDown=Tabs1(this,3);><a href="#menu">TA的关注</a></li>
                <li class="" onMouseDown=Tabs1(this,4);><a href="#menu" >TA的项目</a></li>
            </ul>
        </div>
		<div class="user-content-warp" id=myTabs1_Content0>
            <div class="message-box" >
                <div class="mod-b mod-art " v-for="info in recentReadInfos">
                    <a class="transition" href="/article/197348.html?f=member_article" target="_blank">
                        <div class="mod-thumb"><img class="lazy" :src="`${info.infoImage.image}`" :onerror="defaultInfoImg" alt='冷眼看快手、陌陌们的"短视频社交"' style="display: inline;"></div>
                    </a>
                    <div class="mob-ctt">
                            <h3><a href="/article/197348.html?f=member_article" class="transition" target="_blank">{{info.title}}</a></h3>
                            <div class="mob-author"><span class="time">2017-05-28</span></div>
                            <div class="mob-sub">{{info.description}}</div>
                    </div>
                </div>          
                <nav class="page-nav">
                <ul class="pagination">
                    <li class="disabled"><a href="#" aria-label="First"><span aria-hidden="true"><i class="icon icon-first"></i></span></a></li>
                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true"><i class="icon icon-lt"></i></span></a></li>
                    <li class="active"><a>1</a></li>
                    <li><a href="/member/1373658/article/2.html">2</a></li>
                    <li><a href="/member/1373658/article/3.html">3</a></li>
                    <li><a href="/member/1373658/article/4.html">4</a></li>
                    <li><a href="/member/1373658/article/2.html"><i class="icon icon-gt"></i></a></li>
                    <li><a href="/member/1373658/article/4.html"><i class="icon icon-last"></i></a></li>
                    </ul>
                </nav>        
            </div>
        </div>
        <div class="user-content-warp" style="display:none" id=myTabs1_Content1>
    		<ul class='nav-box' id=myTabs2>
        		<li class="active" onMouseDown=Tabs2(this,0);><a href="#">评论（115）</a></li>
        		<li class="" onMouseDown=Tabs2(this,1)><a href="#">点评（540）</a></li>
    		</ul>
            <div class="message-box" id=myTabs2_Content0>
        		<ul>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">1直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                    <li type="comment" >
                    	<div class="message-title"><a href="#" target="_blank">10直播甚至短视频的最大隐患在于，主流用户的消费习惯尚未形成，一旦受限于用户规模增长停滞，则高流失率带来的后果可想而知</a></div>
                    	<div class="message-time">1天前<span class="message-article">来自文章：<a href="#" target="_blank">资本的局，直播的病，斗鱼映客们扎堆融资背后的心思与隐忧</a></span></div>
                    </li>
                </ul>
                <nav class="page-nav">
                 	<ul class="pagination">
                    	<li class="disabled"><a href="#" aria-label="First"><span aria-hidden="true"><i class="icon icon-first"></i></span></a></li>
                        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true"><i class="icon icon-lt"></i></span></a></li>
                        <li class="active"><a>1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#"><i class="icon icon-gt"></i></a></li>
                        <li><a href="#"><i class="icon icon-last"></i></a></li>
                     </ul>
                 </nav> 
            </div>
        	<div class="message-box" style="display:none" id=myTabs2_Content1>
        		<ul>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>1社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>
                    <li type="recomment">
                    	<blockquote>10社交国内产品真能成大气候，月活过三亿的，我估计最终会有四个，微信、QQ、微博、……。过一亿在垂直领域有大成就的，也会有四个左右［不算过三亿］，陌陌、快手基本上会是，还有二个位置</blockquote>
                    	<div class="message-title"><span class="me-dp">TA的点评：</span><a href="#" target="_blank">微博是social media，快手是video community，严格讲不算社交产品</a></div>
                    	<div class="message-time">2017-05-29<span class="message-article">来自文章：<a href="/article/197348.html" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a></span></div>
                    </li>  
                </ul>
        		<nav class="page-nav">
                 	<ul class="pagination">
                    	<li class="disabled"><a href="#" aria-label="First"><span aria-hidden="true"><i class="icon icon-first"></i></span></a></li>
                        <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true"><i class="icon icon-lt"></i></span></a></li>
                        <li class="active"><a>1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#"><i class="icon icon-gt"></i></a></li>
                        <li><a href="#"><i class="icon icon-last"></i></a></li>
                     </ul>
                 </nav> 
            </div>
    	</div>
        <div class="user-content-warp" style="display:none" id=myTabs1_Content2>
        	 <div class="collect-box" data-cid="129416"><span class="collect-title">我的默认收藏夹</span></div>
		</div>
        <div class="user-content-warp" style="display:none" id=myTabs1_Content3>
    		<div class="topic-message-wrap">
                 <div class="no-content-prompt">TA还没有关注</div>
            </div>
		</div>
        <div class="user-content-warp" style="display:none" id=myTabs1_Content4>
        	<div class="product-html-box">
        		<div class="message-box">
            		<ul>
                        <li type="article">
                            <div class="cy-mod-thumb">
                        		<a class="transition" href="#" target="_blank"><img class="lazy" src="../assets/images/1461314509617354.png" alt="旅客"></a>
                    		</div>
                    		<div class="cy-mob-ctt">
                        		<div class="cp-name"><a href="#" class="transition" target="_blank">旅客</a></div>
                        		<div class="cp-time"> 提交时间：2016-04-22</div>
                    		</div>
                		</li>
            		</ul>
        		</div>
    		</div>
		</div>
    </div>
</div>
<VFooter></VFooter>


  </section>
</template>

<script>
import {getUserInfoById,requestLogin, requestRegister,getInfoByDate, getLogInfos,getLogInfoNowadays} from '../api/api.js'
import VHeader from '@/components/Header.vue'
import VFooter from '@/components/Footer.vue'
import VueNotifications from 'vue-notifications'
export default {
    data(){
        return{
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
            isSearchShow: false,
            defaultInfoImg: 'this.src="' + require('../assets/sy-img/150611228857.jpg') + '"',
            defaultAvatar: 'this.src="https://img.huxiucdn.com/auth/data/avatar/2.jpg"',
            logInfoList: [],
            //用户最近浏览的资讯
            recentReadInfos: []
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
        }else{
            this.handleForm(0)
        }
        getLogInfoNowadays().then(res=>{
            if(res.status === 1){
                console.log(res.result)
                this.recentReadInfos = res.result
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
}
</script>

<style>
@import '../assets/bootstrap/css/bootstrap.min.css';
@import '../assets/css/build.css';
@import '../assets/css/login.css';
@import '../assets/css/dlzc.css';
@import '../assets/css/zzsc.css';
#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}
</style>

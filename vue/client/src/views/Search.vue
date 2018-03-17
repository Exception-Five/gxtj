<template>
  <section id="search" style="background-color:#f0f4fb;">
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
   <div class="pull-left">
      <div class="c-search-box">
         <input class="search-input-list" name="s" v-model="searchContent"/>
         <button class="search-btn" @click="init()"><i class="icon icon-search-list"></i></button>
      </div>
      <div class="search-list-warp">
            <ul class="search-wrap-list-ul">
                <li v-for="item in searchList">
                    <h2><a href="/article/227732.html" target="_blank">{{item.title}}</a></h2>
                    <div class="mob-summay" v-html="item.description"></div>
                    <div class="mob-author">
                        <span class="name"><a target="_blank" href="/member/303086.html">{{item.author}}</a></span>
                        <span class="time">2017-12-29 08:00</span>
                    </div>
                </li>
                <li>
                    <h2><a href="/article/217973.html" target="_blank">搜狗招股说明书暗藏玄机，查尔斯迎来美股<em>搜狐</em>系三驾马车？</a></h2>
                    <div class="mob-summay">随着搜狗即将上市，张朝阳的<em>搜狐</em>系将拥有：<em>搜狐</em>、畅游、搜狗三家。这对中国互联网大佬来说，几乎是前无古人的伟绩。看来，姜还是老的辣。nbsp;说完王小川和张朝阳，再来看看搜狗的天时地利人和怎么样。nbsp;首先说说...</div>
                    <div class="mob-author">
                        <span class="name"><a target="_blank" href="/member/293144.html">菠萝财经</a></span><span class="time">2017-10-14 10:52</span>
                    </div>
                </li>
                <li>
                    <h2><a href="/article/197559.html" target="_blank">张朝阳的梦醒时分，与<em>搜狐</em>失去的黄金十年</a></h2>
                    <div class="mob-summay"><em>搜狐</em>也重复了这样的历史，从PC到移动互联网，<em>搜狐</em>布局很广，有畅游、<em>搜狐</em>视频、<em>搜狐</em>新闻客户端这样的好产品，但往往是开局不错，后续乏力，无法成为真正意义的第一。nbsp;于是就有了“千年老二”的戏谑之称。nbsp;这...</div>
                    <div class="mob-author">
                        <span class="name"><a target="_blank" href="/member/1871804.html">首席人物观©</a></span><span class="time">2017-05-31 13:25</span>
                    </div>
                </li>
            </ul>
            <nav class="page-nav"><ul class="pagination"><li class="disabled"><a href="#" aria-label="First"><span aria-hidden="true"><i class="icon icon-first"></i></span></a></li><li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true"><i class="icon icon-lt"></i></span></a></li><li class="active"><a>1</a></li><li><a href="/search.html?s=%E6%90%9C%E7%8B%90&amp;sort=&amp;per_page=2">2</a></li><li><a href="/search.html?s=%E6%90%9C%E7%8B%90&amp;sort=&amp;per_page=3">3</a></li><li><a href="/search.html?s=%E6%90%9C%E7%8B%90&amp;sort=&amp;per_page=4">4</a></li><li><a href="/search.html?s=%E6%90%9C%E7%8B%90&amp;sort=&amp;per_page=2"><i class="icon icon-gt"></i></a></li><li><a href="/search.html?s=%E6%90%9C%E7%8B%90&amp;sort=&amp;per_page=217"><i class="icon icon-last"></i></a></li></ul></nav>                    </div>
   </div>
</div>
<div style="clear:both;"></div>
  </section>
</template>
<script>
import {requestLogin, requestRegister,getInfoByDate} from '../api/api.js'
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
			userMail: "",
			userGroupId: 1
		},
		isLogined: false,
		isLoginShow: false,
        isRegisterShow: false,
        isSearchShow: false,

        searchContent:"",
        searchList:[]
	  }
  },
  components: {VHeader,VFooter},
  mounted(){
    this.init()
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
				console.log(requestLogin)
				if(res.status === 1){
					this.isLoginShow = false
					this.isLogined = true
					this.userInfo = res.result
					alert("登录成功!")
				}else if(res.status === -1){
					alert("用户名不存在")
				}
			})
		},
		registerConfirm () {
			let param = this.userInfo
			requestRegister(param).then(res => {
				console.log(res)
				if(res.status === 1){
					alert("已成功向您的邮箱发送帐号激活邮件,请确认")
				}else{
					alert("发送邮件失败")
				}
			})
		},
		logout () {
			this.isLogined = false
        },
        handleSearch(...data){
            if(data[0] === 0){//关闭
                this.isSearchShow = false
            }else if(data[0] === 1){
                this.isSearchShow = true
            }    
        },
        // requestSearch(...data){
        //     this.searchContent = data[0]
        //     console.log(this.searchContent+"dasdasdas")
        //     console.log(this.$route.params)
        //     this.init()
        // },
        init(){
            let p = this.$route.params.searchContent
            if(p!=undefined && p!=""){
                this.searchContent = p
            }
            getInfoByDate(1).then(res=>{
                if(res.status === 1){
                    this.searchList = res.result
                    for(let item of this.searchList){
                        item.description = item.description.replace(new RegExp(this.searchContent,'gm'),`<em>${this.searchContent}</em>`)
                    }
                    console.log(this.searchList)
                } 
            })
        }
  }
}
</script>
<style>
@import '../assets/bootstrap/css/bootstrap.min.css';
@import '../assets/css/build.css';
@import '../assets/css/login.css';
@import '../assets/css/dlzc.css';
@import '../assets/css/zzsc.css';
@import '../assets/css/search.css';

#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}
</style>


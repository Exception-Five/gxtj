<template>
	<section id="article">
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
<div class="article-section-wrap">
    <div class="article-section" data-aid="197460">
    <div class="container" id="article197460">
        <div class="nrtj-wrap" id="nrtj-wrap197460"></div>
        <div class="wrap-left pull-left">
            <!--文章内容页-->
            <div class="article-left-btn-group is-sticky" id="article-left-btn-group197460">
                <ul>
                                            <!--普通文章分享微博-->
                    <li><a href=""><i class="icon icon-article icon-article-wb js-weibo js-share-article" data-location="article" data-f="pc-weibo-article" aid="197460"></i></a></li>
                        <!--普通文章分享微信-->
                    <li class="weixin">
                        <div class="weixin-Qr-code "></div>
                        <a class="js-weixin" data-f="pc-friends-article"><i class="icon icon-article icon-article-pyq" ></i></a>
                    </li>
                        <!--普通文章分享支付宝 -->
                    <li class="zhifubao">
                        <div class="zhifubao-Qr-code"></div>
                        <a class="js-zhifubao" data-f="pc_alipay_article"><i class="icon icon-article icon-article-zfb" ></i></a>
                    </li>
                        <!--普通文章分享qq空间 -->
                    <li><a href=""><i class="icon icon-article icon-article-qzone js-qzone js-share-article" data-location="article" data-f="pc-qzone-article" aid="197460"></i></a></li>
                    <li><a class="js-article-pl-anchor"><i class="icon icon-article icon-article-pl">评论</i></a></li>
                                            <!--普通文章收藏-->
                    <li><a class="js-collection-article"><i class="icon icon-article icon-article-col">收藏</i></a></li>
                </ul>
            </div>
            <div class="article-wrap">
                <h1 class="t-h1">{{information.title}}</h1>
                <div class="article-author">
                <span class="author-name"><router-link :to="`#`" target="_blank">{{information.author}}</router-link></span>
                <div class="column-link-box">
                	<span class="article-time pull-left">{{information.publishDate | formatDate}}</span>
                    <span class="article-share pull-left">阅读量{{information.reads}}</span>
                    <span class="article-pl pull-left">点赞{{information.likes}}</span>
					<span class="article-pl pull-left" style="margin-left:14px">评论{{commentCount}}</span>
                    <a href="#" class="column-link" target="_blank">创业维艰</a> <i></i>
                </div>                     
            </div>
<!--管理员按钮-->
            <div class="article-manage-bar" id="article-manage-bar197460"></div>                                
            <!--文章头图-->
            <!-- <div class="article-img-box">
				<img src="https://img.huxiucdn.com/article/cover/201705/30/163018709897.jpg?imageView2/1/w/800/h/600/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="闪送、小罐茶：将单一元素推向极致的创业给我们什么启发？">
			</div> -->
            <div id="article_content197460" class="article-content-wrap">
                 <!-- <p>有些人和企业的厉害之处，在于从一个看似成熟、红海的领域，硬生生拓展出一片蓝海市场来，而且生意做到风生水起。</p><p><br/></p><p>而这种闯出一片新天地的方法，最常见的一种，就是将原有的产品或服务模式中的某个元素，推向极致，拓展出新的用户场景和产品价值，自然就拓展出了新的市场。</p><p><br/></p><p>今天来分析三个例子，来看看这种"单一元素推向极致"的手段有多厉害。</p><p><br/></p><p><strong>第一个例子，是前段时间非常火爆的电话亭式KTV。</strong></p><p><br/></p><p>我不知道现在还有多少人经常去KTV唱歌。我能看到的是，在一线城市，传统的量贩式KTV市场一再萎缩，以钱柜、麦乐迪为代表的老企业日渐衰败，新的主打小户型的唱吧麦颂半死不活。长盛不衰此起彼伏的KTV也有，但那是俗称商K的夜总会式KTV，你懂的。</p><p><br/></p><p>究其原因，现在娱乐的个性化和小群体化趋势日益明显，以前那种成群结队去唱歌，还要忍受别人五音不全的唱腔的娱乐形式，显得不够与时俱进。</p><p><br/></p><p>但是，朋友情侣三两出行，还是有唱歌娱乐的需求的。电话亭式KTV应运而生。</p><p><br/></p><p>电话亭式KTV，把时间和空间两个元素推向极致。仅容纳两到三个人的私密空间，少至一首歌或者一刻钟的欢唱时间，充分利用碎片化时间和空间，让唱歌这件事不那么仪式感和处心积虑，随时兴起就可以来一发，多么愉快。何况，曲库、音响效果并不亚于传统的KTV，甚至还有所超越。</p>                -->
				<div v-if="information.infoContent!=null" v-html="information.infoContent.content"></div>
                 <div class="neirong-shouquan">
                      <span class="c2">*文章为作者独立观点，不代表Oreo网立场<br></span>
                      <span>本文由 <a href="#" target="_blank">判官</a> 授权 <a href="/">Oreo网</a> 发表，并经Oreo网编辑。转载此文请于文首标明作者姓名，保持文章完整性（包括Oreo注及其余作者身份信息），并请附上出处</span>
                      <br />
                      <span><b>未按照规范转载者，Oreo保留追究相应责任的权利</b></span>
                 </div>
                 <div class="neirong-shouquan-public">
                      <span><b>未来面前，你我还都是孩子，还不去下载 <a href="#" target="_blank">OreoApp </a>猛嗅创新！</b></span>
                 </div>
            </div>
			<div class="Qr-code">
                                                    
                 <div class="praise-box transition js-like-article pull-right " :class="{'active': hasLike}" @click="likeArticle">
                      <i class="icon icon-article-zan"></i><span class="num">{{information.likes}}</span>
                 </div>
				 <span class="btn tool-tip  btn-exceptional js-qr-ds transition">打赏</span>
                 <div class="js-qr-img transition info-false">
                      <div class="article-zfb-wx-box" onmouseover="isOut=false" onmouseout="isOut=true">
                           <ul>
                               <li class="zhifb-mouseover">
                               	   <i class="icon icon-zhifb"></i>
                                   <div class="j-btm zfbdashang-wrap"><img src="https://mobilecodec.alipay.com/show.htm?code=rex021253evapgmoq9smla8" alt=""/><i class="c2">给 Ta打个赏</i></div>
                                </li>
                                <li class="weix-mouseover"><i class="icon icon-weix"></i>
                                    <div class="j-btm wxdashang-wrap"><img src="https://img.huxiucdn.com/author_qr/8/1373658_1496668398_weixin.jpg" alt=""/><i class="c2">给 Ta 打个赏</i></div>
                                </li>                                      
                           </ul>
                       </div>
                  </div>
             </div>
                    <!--管理员底部按钮-->
             <div class="article-manage-bar article-bottom-manage-bar" id="article-bottom-manage-bar197460"></div>
			 <div class="tag-box ">
                  <ul class="transition">
                      <a href="#" target="_blank"><li class="transition">投稿</li></a>
                      <a href="#" target="_blank"><li class="transition">创业</li></a>
                      <a href="#" target="_blank"><li class="transition">商业模式</li></a>
                   </ul>
              </div>
              <!--公共评论-->
              <div class="pl-wrap" id="pl-wrap-article197460" name="pl-wrap-article">
                   <div class="pl-form-wrap">
                        <span class="span-mark-author active">发表评论</span>
                        <div class="pl-form-box pl-article-wrap">
                             <div class="no-login-box" v-show="!isLogined"><a class="js-login" @click="handleForm(0)" >登录</a>后参与评论</div>
                             <textarea class="form-control" placeholder="客官，8个字起评，不讲价哟" v-show="isLogined" v-model="commentParam.content"></textarea>
                             <!--普通文章评论发表-->
                             <button class="btn btn-article js-login transition" @click="addComment(2,-1,-1,-1,-1)">发表</button>
                        </div>
                   </div>
                   <div id="pl-wrap197460" name="pl-wrap"></div>
                   <div class="pl-list-wrap">
                        <div class="pl-loading hide"><img src="/static_2015/img/pl-loading.gif"></div>
                        <a href="javascript:void(0)" class="span-mark-author active js-default-new-pl" data-type="agree">默认评论</a>
                        <i class="icon icon-line-pl"></i>
                        <a href="javascript:void(0)" class="span-mark-author new js-default-new-pl" data-type="dateline">最新评论</a>
                        <!-- <div class="pl-box-wrap">
                			<div class="pl-box-top">
            					<div class="dropdown pull-right">
                					<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                    					<span class="caret"></span>
                					</button>
            					</div>
            					<div class="author-info">
                					<div class="author-face"><img src="https://img.huxiucdn.com/auth/data/avatar/001/54/60/18_1479690318.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></div>
                					<span class="author-name"><a href="#">请叫我__宝器</a><a href="/vip" target="_blank"></a></span>
                					<span class="time">6天前</span>
            					</div>
            					<div class="pl-content">三个这么浅显的例子和分析就能让作者得出结论，这"一叶知秋"的本事我也是服的。</div>
                    		</div>
        					<div class="pl-box-btm">
                            	<div class="article-type pull-right">
                					<div class="icon-like-prompt">
                    					<i class="icon icon-like active"></i><span class="c1">+1</span>
                					</div>
                					<div class="icon-no-like-prompt">
                    					<i class="icon icon-no-like active"></i><span class="c1">+1</span>
                					</div>
                					<ul>
                    					<li class="js-icon-like" data-type="like"><i class="icon icon-like "></i><span class="like">2</span></li>
                    					<li class="js-no-icon-like" data-type="no-like"><i class="icon icon-no-like "></i><span class="like">1</span></li>
                					</ul>
            					</div>
            					<div class="btn-dp transition js-add-dp-box"><i class="icon icon-dp"></i>我要点评</div>
            					<div class="pl-form-box dp-article-box">
                					<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟"></textarea>
                					<button class="btn btn-article js-article-dp">发表</button>
            					</div>
        					</div>
                            
    					</div> -->
						<div class="pl-box-wrap" v-show="commentList.length === 0">
							<p style="padding: 50px 0;font-size:24px;">这里空空如也，期待你的发声</p>
						</div>
    					<div class="pl-box-wrap" data-pid="644658" id="g_pid644658" v-for="(comment,index) in commentList">
							<div class="pl-box-top">
								<div class="dropdown pull-right">
									<button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
										<span class="caret"></span>
									</button>
									<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
													<li class="pl-report js-report-pl" aid="197460" pid="644658">举报</li>
									</ul>
								</div>
								<div class="author-info">
									<div class="author-face"><img src="https://img.huxiucdn.com/auth/data/avatar/001/68/30/86_1496144520.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></div>
									<span class="author-name">
										<a href="#">{{comment.userInfo.nickname}}</a>
										<a href="#" target="_blank"></a>
									</span>
									<span class="time">{{comment.createTime | formatDateDiff}}</span>
								</div>
								<div class="pl-content">{{comment.content}}</div>
									<div class="dp-box" v-show="comment.hasSubComment"> 
									<span class="span-mark-author">点评</span>
											<div class="dl-user dl-user-list  " data-type="dl-user" style="display:block">
												
											</div>
								<div class="dp-list-box" style="display:block"  v-if="comment.subCommentList != null">
									<!-- 子评论 -->
									<div class="dl-user del-pl108924"  v-for="(subComment, subIndex) in comment.subCommentList">
										<ul>
											<li><a href="#" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/3.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a></li>
										</ul>
										<div class="one-pl-content">
											<div class="pull-right time">{{subComment.createTime | formatDateDiff}}</div>
											<p class="content">
												<span class="name" v-if="subComment.userInfo != null">{{subComment.userInfo.nickname}}</span>
												<a href="#" ></a>&nbsp;&nbsp;
													<span class="author-content">
													<a href="#" v-if="subComment.replyUser != null">@{{subComment.replyUser.nickname}}</a>
												{{subComment.content}}</span> 
											</p>
											<div class="js-hf-article-pl" @click="toComment(0, subIndex, index)"><span>回复</span></div>
											<div class="hu-pl-box" v-show="subComment.isCommentClick">
												<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟" v-model="commentParam.content"></textarea>
												<button class="btn btn-article js-article-dp" data-type="hf" @click="addComment(0,comment.id,subComment.userInfo.userId,index,subIndex)">发表</button>
											</div>
										</div>
									</div>
									<!-- <div class="close-dp-list-box js-show-hide-dp-box" data-buttom="true">收起</div> -->
								</div>
								</div>
							</div>
							<div class="pl-box-btm">
								<div class="article-type pull-right">
									<div class="icon-like-prompt">
										<i class="icon icon-like active"></i><span class="c1">+1</span>
									</div>
									<div class="icon-no-like-prompt">
										<i class="icon icon-no-like active"></i><span class="c1">+1</span>
									</div>
									<ul>
										<li class="js-icon-like" data-type="like" @click="updateComment(0, comment.id)"><i class="icon icon-like" :class="{'active':comment.isLikeClick}"></i><span class="like">{{comment.like}}</span></li>
										<li class="js-no-icon-like" data-type="no-like" @click="updateComment(1, comment.id)"><i class="icon icon-no-like" :class="{'active':comment.isDislikeClick}"></i><span class="like">{{comment.dislike}}</span></li>
									</ul>
								</div>
								<div class="btn-dp transition js-add-dp-box" @click="toComment(1, -1, index)"><i class="icon icon-dp"></i>我要点评</div>
								<div class="pl-form-box dp-article-box" v-show="comment.isCommentClick">
									<textarea class="form-control" placeholder="客官，8个字起评，不讲价哟" v-model="commentParam.content"></textarea>
									<button class="btn btn-article js-article-dp" @click="addComment(1,comment.id,comment.userInfo.userId,index,-1)">发表</button>
								</div>
							</div>
    					</div>
                    </div>
              	</div>
                    <!--相关文章位置-->
              <div id="related-article-wrap197460"></div>
		</div>
     </div>
     <div class="wrap-right pull-right">
     	<div class="box-author-info">
        	<div class="author-face">
        		<a href="#" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/37/36/58_avatar_big.jpg?|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
    		</div>
    		<div class="author-name">
        		<a href="#" target="_blank">判官</a>
        		<a href="#" target="_blank"><i class="i-vip icon-vip" title="Oreo黑卡会员"></i></a>
        		<i class="i-icon icon-auth3" title="Oreo认证作者"></i>    
        	</div>
    		<div class="author-one">产品老司机</div>
    		<div class="author-one">产品个体户</div>
    		<div class="author-article-pl">
        		<ul>
            		<li><a href="#" target="_blank">32篇文章</a></li>
        		</ul>
    		</div>
        	<div class="author-next-article">
        		<div class="author-one c2">最近文章</div>
        			<a href="#" target="_blank">冷眼看快手、陌陌们的"短视频社交"</a>
    			</div>
        	</div>
    		<div class="box-moder hot-tag">
        		<h3>热门标签</h3>
        		<span class="pull-right project-more"><a href="#" class="transition" target="_blank">全部</a></span>
        		<span class="span-mark"></span>
        		<div class="search-history search-hot">
            		<ul>
                   	 <li class="transition"><a href="#" target="_blank">阿里巴巴</a></li>
                    	<li class="transition"><a href="#" target="_blank">投稿</a></li>
                    	<li class="transition"><a href="#" target="_blank">创业</a></li>
                    	<li class="transition"><a href="#" target="_blank">头条</a></li>
                    	<li class="transition"><a href="#" target="_blank">马云</a></li>
                    	<li class="transition"><a href="#" target="_blank">大数据</a></li>
                    	<li class="transition"><a href="#" target="_blank">移动互联网</a></li>
                    	<li class="transition"><a href="#" target="_blank">电子商务</a></li>
                    	<li class="transition"><a href="#" target="_blank">微信</a></li>
                    	<li class="transition"><a href="#" target="_blank">Facebook</a></li>
            		</ul>
        		</div>
    		</div>
		<div class="placeholder"></div>
    		<div class="box-moder hot-article">
        		<h3>热文</h3>
        		<span class="span-mark"></span>
        		<ul>
                    <li>
                    	<div class="hot-article-img">
                        	<a href="#" target="_blank"><img src="https://img.huxiucdn.com/article/cover/201706/04/105715329877.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                    	</div>
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                    <li>
                    	<div class="hot-article-img">
                        	<a href="#" target="_blank"><img src="https://img.huxiucdn.com/article/cover/201706/04/191327154498.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                    	</div>
                    	<a href="#" class="transition" target="_blank">顺丰，菜鸟，令狐冲，岳不群</a>
               		</li>
                    <li>
                    	<div class="hot-article-img">
                        	<a href="#" target="_blank"><img src="https://img.huxiucdn.com/article/cover/201706/04/105715329877.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                    	</div>
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                    <li>
                    	<div class="hot-article-img">
                        	<a href="#" target="_blank"><img src="https://img.huxiucdn.com/article/cover/201706/04/191327154498.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                    	</div>
                    	<a href="#" class="transition" target="_blank">顺丰，菜鸟，令狐冲，岳不群</a>
               		</li>
                    <li>
                    	<div class="hot-article-img">
                        	<a href="#" target="_blank"><img src="https://img.huxiucdn.com/article/cover/201706/04/105715329877.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                    	</div>
                    	<a href="#" class="transition" target="_blank">3年了，我们的内容消费发生了什么变化？</a>
                	</li>
                </ul>
    		</div>
        </div>
    </div>
</div>
<div class="article-section article-section-last"></div>
</div>

<VFooter></VFooter>
  </section>
</template>

<script>
import {getInfoByInfoId, getPushInfo,getCommentsByInfoId,addComment,updateComment, updateInfo,getUserInfoById} from '../api/api.js'
import {GetDateDiff,formatDate} from '../utils/date.js';
import {requestLogin, requestRegister} from '../api/api.js'
import VFooter from '@/components/Footer.vue'

import VHeader from '@/components/Header.vue'

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
		infoId:"",
		isLogined: false,
		isLoginShow: false,
		isRegisterShow: false,
		isSearchShow: false,
		information:{},

		//已经点过赞
		hasLike: false,
		flag: false,
		commentList: [],
		commentCount: 0,
		commentParam: {
			content:""
		}
	  }
  },
  components: {VHeader,VFooter},
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
	this.infoId  = this.$route.params.id
	/* 绑定评论列表数据 */
	this.initCommentList(this.infoId)
	
	getInfoByInfoId(this.infoId).then(res=>{
		if(res.status === 1){
			console.log(res)
			this.information = res.result
			let param = new FormData()
			param.append("id",this.infoId)
			// getPushInfo(param).then(res => {
			// 	console.log(res)
			// 	console.log("推送"+res.result.title)
			// 	this.showTime(`<a href="http://localhost:8085/#/article/${res.result.id}">${res.result.description}</a><img src="https://mmbiz.qpic.cn/mmbiz_jpg/n9SYkDp4R65gpdLy7IJ1TGEHdib9zBF4KdYscAGLicDLibeY094DWNKib4jX2dyib0ibP6oiar5b6veW5dpOcALHQQniaA/640?wx_fmt=jpeg" width="100" height="100"></img>`)
			// 	this.resetOptions()
			// })
			//阅读量+1
			let param2 = {
				id: this.information.id,
				reads: ++this.information.reads
			}
			updateInfo(param2).then(res=>{
				console.log(res)
			})
		}else{
			// this.$router.push({path:'/404'})
		}
	})
  },
  methods:{
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
		initCommentList(id){
			this.commentList = []
			getCommentsByInfoId(id).then((res)=>{
				let receiveComments = res.result
				this.commentCount = receiveComments.length
				for(let i in receiveComments){
					if(receiveComments[i].parentCommentId == null){
						receiveComments[i].hasSubComment = false
						receiveComments[i].isCommentClick = false
						receiveComments[i].isLikeClick = false
						receiveComments[i].isDislikeClick = false
						receiveComments[i].subCommentList = null
						this.commentList.push(receiveComments[i])
					}
				}
				for(let i in this.commentList){
					this.commentList[i].subCommentList = []
					for(let j in receiveComments){
						if(receiveComments[j].id === this.commentList[i].id){
							continue
						}
						if(receiveComments[j].parentCommentId === this.commentList[i].id){
							this.commentList[i].hasSubComment = true
							receiveComments[j].isCommentClick = false
							this.commentList[i].subCommentList.push(receiveComments[j])
						}
					}
				}
				
				console.log(this.commentList)
			})
		},
		likeArticle () {
			if(!this.isLogined){
				this.showSuccessMsg({message: "此操作需要登录"});
				return
			}
			//如果没有点过赞
			let newLikes;
			if(!this.hasLike){
				newLikes = ++this.information.likes
				this.hasLike = true
			}else{
				newLikes = --this.information.likes
				this.hasLike = false
			}
			let param = {
				infoId: this.information.infoId,
				likes: newLikes
			}
			updateInfo(param).then((res)=>{
				console.log(res)
			})
		},
		/* 评论方法 */
		//flag=0 里面的评论框  flag=1 外面的评论框
		//subIndex子评论索引 index父评论索引
		toComment(flag, subIndex, index){
			if(!this.isLogined){
				this.showSuccessMsg({message: "此操作需要登录"});
				return
			}
			console.log("subIndex:"+subIndex +",index:"+index)
			for(let item of this.commentList){
				item.isCommentClick = false
			}
			for(let i in this.commentList){
				for(let j in this.commentList[i].subCommentList){
					this.commentList[i].subCommentList[j].isCommentClick = false
				}
			}
			if(flag === 0){
				
				this.commentList[index].subCommentList[subIndex].isCommentClick = true
			}else if(flag === 1){
				this.commentList[index].isCommentClick = true
			}
			console.log(this.commentList)
		},
		//flag=0 添加一条外部评论 flag=1 添加一条内部评论  flag=2添加一条父级评论
		addComment(flag,parentCommentId,replyUserId,index,subIndex){
			this.commentParam.infoId = this.infoId
			this.commentParam.userId = this.userInfo.userId
			this.commentParam.parentCommentId = parentCommentId
			this.commentParam.replyUserId = replyUserId
			if(flag === 0){
				addComment(this.commentParam).then((res)=>{
					if(res.status === 1){
						this.initCommentList(this.infoId)
						this.commentList[index].subCommentList[subIndex].isCommentClick = false
						this.commentParam.content = ""
					}
				})
			}else if(flag ===1){
				addComment(this.commentParam).then((res)=>{
					if(res.status === 1){
						this.initCommentList(this.infoId)
						this.commentList[index].isCommentClick = false
						this.commentParam.content = ""
					}
				})
			}else if(flag === 2){
				this.commentParam.parentCommentId = null
				this.commentParam.replyUserId = null
				addComment(this.commentParam).then((res)=>{
					if(res.status === 1){
						this.initCommentList(this.infoId)
						this.commentParam.content = ""
					}
				})
			}
		},
		//flag=0 点赞   flag=1点踩
		updateComment(flag, commentId){
			if(!this.isLogined){
				this.showErrorMsg({message: "此操作需要登录"});
				return
			}
			let param = {}
			for(let comment of this.commentList){
				if(commentId === comment.id){
					let clickState = comment.isLikeClick || comment.isDislikeClick
					if(flag === 0){//点赞
						// 01 10 00
						if(clickState){
							if(comment.isLikeClick){
								comment.like--
							}else{
								comment.like++
								comment.dislike--
							}
						}else{
							comment.like++
						}
						comment.isLikeClick = !comment.isLikeClick
					}else if(flag === 1){//点踩
						// 01 10 00
						if(clickState){
							if(comment.isDislikeClick){
								comment.dislike--
							}else{
								comment.dislike++
								comment.like--
							}
						}else{
							comment.dislike++
						}
						comment.isDislikeClick = !comment.isDislikeClick
					}
					param = {
						id: commentId,
						like: comment.like,
						dislike: comment.dislike
					}
				} 
			}
			updateComment(param).then(res=>{
				if(res.status === 1){
					console.log(this.commentList)
				}
			})
		}
  },
  metaInfo () {
	  const title = ""
	  return {
		  title: this.information.title,
		  meta:[{
			  vmid: 'referrer',
			  name: 'referrer',
			  content: 'never'
		  }]
	  }
  },
//   通知插件
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
  filters: {
		formatDate(time) {
			var date = new Date(time);
			return formatDate(date, "yyyy-MM-dd");
		},
		formatDateDiff(time) {
         return GetDateDiff(new Date(time));
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
#index{
    font-size: 14px;
}
li.nav-news.js-show-menu ul{position: absolute; visibility: hidden; background:#fff; width:250px;  top:60px; left:-50px; z-index:9999; box-shadow:0 1px 15px rgba(18,21,21,.2);padding:10px 5px;}
#jsddm ul li{ float:left; width:105px; padding-left:20px; line-height:40px;}
</style>

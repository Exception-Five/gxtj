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


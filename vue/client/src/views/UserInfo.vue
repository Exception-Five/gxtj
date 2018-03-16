<template>
  <section id="search">
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
<div class="edit-warp" id="per_center" style="text-align:left">
    <div class="user-container" style="min-height: 700px;">
        <div class="go-back"><router-link :to="`/`"><i class="icon icon-go-back"></i>返回我的个人中心主页</router-link></div>

        <div class="nav-warp">
            <ul>
                <li class=""><a href="#"></a></li>
                <li class="active"><a href="#">修改资料</a></li>
                <li class=""><a href="#"></a></li>
            </ul>
        </div>
                    <div class="section-box">
    <div class="user-face-box">
        <img src="https://img.huxiucdn.com/auth/data/avatar/2.jpg">
    </div>
    <a class="edit-face" href="/user/setting/account.html#mdf_head">点击更换头像</a>
</div>
<div class="form-warp ">
    <label class="control-label">真实姓名：</label>
    <input class="control-input" id="name" value="">
</div>
<div class="form-warp">
    <label class="control-label">性别：</label>

    <div class="sex-warp" id="sex">
        <label class="radio-inline ">
            <i class="icon icon-radio"></i>
            <input type="radio" name="sex" id="mdf_male" value="1">男
        </label>
        <label class="radio-inline ">
            <i class="icon icon-radio"></i>
            <input type="radio" name="sex" id="mdf_female" value="2">女
        </label>
        <label class="radio-inline active">
            <i class="icon icon-radio"></i>
            <input type="radio" name="sex" id="mdf_secret" value="0">保密
        </label>
    </div>

</div>
<div class="form-warp">
    <label class="control-label">出生日期：</label>

    <div class="js-form-group-birth form-group-birth">
        <div id="mdf_birthyear" class="pull-left btn-group has-feedback js-dropdown-menu">

            <span id="b_y_show" class="btn btn-default dropdown-show-birth btn-dropdown-show js-dropdown-show" value="1">0</span>
            <button type="button" class="btn btn-default dropdown-toggle dropdown-caret" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-birth" role="menu" id="b_y">
            <li class="menu-item js-menu-item">2018</li><li class="menu-item js-menu-item">2017</li><li class="menu-item js-menu-item">2016</li><li class="menu-item js-menu-item">2015</li><li class="menu-item js-menu-item">2014</li><li class="menu-item js-menu-item">2013</li><li class="menu-item js-menu-item">2012</li><li class="menu-item js-menu-item">2011</li><li class="menu-item js-menu-item">2010</li><li class="menu-item js-menu-item">2009</li><li class="menu-item js-menu-item">2008</li><li class="menu-item js-menu-item">2007</li><li class="menu-item js-menu-item">2006</li><li class="menu-item js-menu-item">2005</li><li class="menu-item js-menu-item">2004</li><li class="menu-item js-menu-item">2003</li><li class="menu-item js-menu-item">2002</li><li class="menu-item js-menu-item">2001</li><li class="menu-item js-menu-item">2000</li><li class="menu-item js-menu-item">1999</li><li class="menu-item js-menu-item">1998</li><li class="menu-item js-menu-item">1997</li><li class="menu-item js-menu-item">1996</li><li class="menu-item js-menu-item">1995</li><li class="menu-item js-menu-item">1994</li><li class="menu-item js-menu-item">1993</li><li class="menu-item js-menu-item">1992</li><li class="menu-item js-menu-item">1991</li><li class="menu-item js-menu-item">1990</li><li class="menu-item js-menu-item">1989</li><li class="menu-item js-menu-item">1988</li><li class="menu-item js-menu-item">1987</li><li class="menu-item js-menu-item">1986</li><li class="menu-item js-menu-item">1985</li><li class="menu-item js-menu-item">1984</li><li class="menu-item js-menu-item">1983</li><li class="menu-item js-menu-item">1982</li><li class="menu-item js-menu-item">1981</li><li class="menu-item js-menu-item">1980</li><li class="menu-item js-menu-item">1979</li><li class="menu-item js-menu-item">1978</li><li class="menu-item js-menu-item">1977</li><li class="menu-item js-menu-item">1976</li><li class="menu-item js-menu-item">1975</li><li class="menu-item js-menu-item">1974</li><li class="menu-item js-menu-item">1973</li><li class="menu-item js-menu-item">1972</li><li class="menu-item js-menu-item">1971</li><li class="menu-item js-menu-item">1970</li><li class="menu-item js-menu-item">1969</li><li class="menu-item js-menu-item">1968</li><li class="menu-item js-menu-item">1967</li><li class="menu-item js-menu-item">1966</li><li class="menu-item js-menu-item">1965</li><li class="menu-item js-menu-item">1964</li><li class="menu-item js-menu-item">1963</li><li class="menu-item js-menu-item">1962</li><li class="menu-item js-menu-item">1961</li><li class="menu-item js-menu-item">1960</li><li class="menu-item js-menu-item">1959</li><li class="menu-item js-menu-item">1958</li><li class="menu-item js-menu-item">1957</li><li class="menu-item js-menu-item">1956</li><li class="menu-item js-menu-item">1955</li><li class="menu-item js-menu-item">1954</li><li class="menu-item js-menu-item">1953</li><li class="menu-item js-menu-item">1952</li><li class="menu-item js-menu-item">1951</li><li class="menu-item js-menu-item">1950</li><li class="menu-item js-menu-item">1949</li><li class="menu-item js-menu-item">1948</li><li class="menu-item js-menu-item">1947</li><li class="menu-item js-menu-item">1946</li><li class="menu-item js-menu-item">1945</li><li class="menu-item js-menu-item">1944</li><li class="menu-item js-menu-item">1943</li><li class="menu-item js-menu-item">1942</li><li class="menu-item js-menu-item">1941</li><li class="menu-item js-menu-item">1940</li><li class="menu-item js-menu-item">1939</li><li class="menu-item js-menu-item">1938</li><li class="menu-item js-menu-item">1937</li><li class="menu-item js-menu-item">1936</li><li class="menu-item js-menu-item">1935</li><li class="menu-item js-menu-item">1934</li><li class="menu-item js-menu-item">1933</li><li class="menu-item js-menu-item">1932</li><li class="menu-item js-menu-item">1931</li><li class="menu-item js-menu-item">1930</li><li class="menu-item js-menu-item">1929</li><li class="menu-item js-menu-item">1928</li><li class="menu-item js-menu-item">1927</li><li class="menu-item js-menu-item">1926</li><li class="menu-item js-menu-item">1925</li><li class="menu-item js-menu-item">1924</li><li class="menu-item js-menu-item">1923</li><li class="menu-item js-menu-item">1922</li><li class="menu-item js-menu-item">1921</li><li class="menu-item js-menu-item">1920</li><li class="menu-item js-menu-item">1919</li><li class="menu-item js-menu-item">1918</li></ul>

        </div>
        <span class="birth-des">年</span>

        <div id="mdf_birthmonth" class="pull-left btn-group has-feedback js-dropdown-menu">

            <span id="b_m_show" class="btn btn-default btn-dropdown-show js-dropdown-show birthyear" value="1">0</span>
            <button type="button" class="btn btn-default dropdown-toggle dropdown-caret" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-birth" role="menu" id="b_m">
                <li><span class="trangle trangle-top"></span></li>
            <li class="menu-item js-menu-item">1</li><li class="menu-item js-menu-item">2</li><li class="menu-item js-menu-item">3</li><li class="menu-item js-menu-item">4</li><li class="menu-item js-menu-item">5</li><li class="menu-item js-menu-item">6</li><li class="menu-item js-menu-item">7</li><li class="menu-item js-menu-item">8</li><li class="menu-item js-menu-item">9</li><li class="menu-item js-menu-item">10</li><li class="menu-item js-menu-item">11</li><li class="menu-item js-menu-item">12</li></ul>

        </div>
        <span class="birth-des">月</span>

        <div id="mdf_birthday" class="pull-left btn-group has-feedback js-dropdown-menu">
            <span id="b_d_show" class="btn btn-default dropdown-show-birth btn-dropdown-show js-dropdown-show" value="1">0</span>
            <button type="button" class="btn btn-default dropdown-toggle dropdown-caret  js-dropdown-caret" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-birth" role="menu" id="b_d"><li><span class="trangle trangle-top"></span></li><li class="menu-item js-menu-item">1</li><li class="menu-item js-menu-item">2</li><li class="menu-item js-menu-item">3</li><li class="menu-item js-menu-item">4</li><li class="menu-item js-menu-item">5</li><li class="menu-item js-menu-item">6</li><li class="menu-item js-menu-item">7</li><li class="menu-item js-menu-item">8</li><li class="menu-item js-menu-item">9</li><li class="menu-item js-menu-item">10</li><li class="menu-item js-menu-item">11</li><li class="menu-item js-menu-item">12</li><li class="menu-item js-menu-item">13</li><li class="menu-item js-menu-item">14</li><li class="menu-item js-menu-item">15</li><li class="menu-item js-menu-item">16</li><li class="menu-item js-menu-item">17</li><li class="menu-item js-menu-item">18</li><li class="menu-item js-menu-item">19</li><li class="menu-item js-menu-item">20</li><li class="menu-item js-menu-item">21</li><li class="menu-item js-menu-item">22</li><li class="menu-item js-menu-item">23</li><li class="menu-item js-menu-item">24</li><li class="menu-item js-menu-item">25</li><li class="menu-item js-menu-item">26</li><li class="menu-item js-menu-item">27</li><li class="menu-item js-menu-item">28</li><li class="menu-item js-menu-item">29</li></ul>

        </div>
        <span class="birth-des">日</span>

    </div>

</div>
<div class="form-warp">
    <label class="control-label">所在公司：</label>
    <input class="control-input" id="company" value="" maxlength="30">

</div>
<div class="form-warp">
    <label class="control-label">职位：</label>
    <input class="control-input" id="position" value="" maxlength="30">

</div>
<div class="form-warp">
    <label class="control-label">居住地址：</label>
    <input class="control-input" id="address" value="">

</div>
<div class="form-warp">
    <label class="control-label">邮箱：</label>

    <div class="control-box" id="often_email"> <a href="/user/setting/account.html#mdf_email" target="_blank"><i class="icon icon icon-edit"></i></a></div>
</div>
<div class="form-warp">
    <label class="control-label">手机号码：</label>

    <div class="control-box" id="phone">18867833189<a href="/user/setting/account.html#mdf_mobile" target="_blank"><i class="icon icon icon-edit"></i></a></div>
</div>
<div class="form-warp">
    <label class="control-label">微博：</label>
    <input class="control-input" id="weibo" value="">
</div>
<div class="form-warp">
    <label class="control-label">微信：</label>
    <input class="control-input" id="weixin" value="">
</div>
<button class="btn btn-save js-user-section-save">保存</button>
            </div>
    <div style="height: 60px">

    </div>
</div>
<div style="clear:both;"></div>
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
        <span>Copyright © <a href="#">虎嗅网</a> <a href="#" target="_blank">京ICP备12013432号-1</a>
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
import VHeader from '@/components/Header.vue'

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
	  }
  },
  components: {VHeader},
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
				if(res.data.status === 1){
					this.isLoginShow = false
					this.isLogined = true
					this.userInfo = res.result
					alert("登录成功!")
				}else if(res.data.status === -1){
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
  }
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


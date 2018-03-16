<template>
  <section id="type-article-list">
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
    <!--顶部通栏广告-->
    
    <div class="wrap-left pull-left">
        <div class="column-wrap">
            <span>电商消费</span>
        </div>
        <!--文章列表-->
        <div class="mod-info-flow">
            <!--公共内容列表部分-->
                        <div class="mod-b mod-art clearfix" data-aid="235920">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="从王海到六六，中国消费者维权仍在地上爬行" href="/article/235920.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/212113941664.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="从王海到六六，中国消费者维权仍在地上爬行" src="https://img.huxiucdn.com/article/cover/201803/15/212113941664.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235920.html" class="transition msubstr-row2" target="_blank">从王海到六六，中国消费者维权仍在地上爬行</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1785733.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/78/57/33_1503660475.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1785733.html" target="_blank">
                            <span class="author-name">mrpuppybunny</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">11小时前</span>
                    <i class="icon icon-cmt"></i><em>18</em>
                    <i class="icon icon-fvr"></i><em>37</em>
                </div>

                <div class="mob-sub">非要把老百姓逼为“职业打假人”？</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235939">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="只有大众一家被直接点名……没意思丨直播 3·15 晚会" href="/article/235939.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/215812971458.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="只有大众一家被直接点名……没意思丨直播 3·15 晚会" src="https://img.huxiucdn.com/article/cover/201803/15/215812971458.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235939.html" class="transition msubstr-row2" target="_blank">只有大众一家被直接点名……没意思丨直播 3·15 晚会</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/19.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/000/00/00/19.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/19.html" target="_blank">
                            <span class="author-name">虎嗅</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                        <i class="i-icon icon-team-auth" title="虎嗅团队"></i>                                        <span class="time">12小时前</span>
                    <i class="icon icon-cmt"></i><em>7</em>
                    <i class="icon icon-fvr"></i><em>19</em>
                </div>

                <div class="mob-sub">大众或成唯一输家</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235935">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="接地气，带你逛逛上海最大蔬菜批发市场" href="/article/235935.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/191033476746.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="接地气，带你逛逛上海最大蔬菜批发市场" src="https://img.huxiucdn.com/article/cover/201803/15/191033476746.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235935.html" class="transition msubstr-row2" target="_blank">接地气，带你逛逛上海最大蔬菜批发市场</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1871590.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/33/78/39_1521112807.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1871590.html" target="_blank">
                            <span class="author-name">联商网©</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">13小时前</span>
                    <i class="icon icon-cmt"></i><em>0</em>
                    <i class="icon icon-fvr"></i><em>23</em>
                </div>

                <div class="mob-sub">别总盯着大企业，菜市场才是零售最早的发源地</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235836">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="蓝筹股携程回来了" href="/article/235836.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/130055405259.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="蓝筹股携程回来了" src="https://img.huxiucdn.com/article/cover/201803/15/130055405259.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235836.html" class="transition msubstr-row2" target="_blank">蓝筹股携程回来了</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/303086.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/000/30/30/86_avatar_big.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/303086.html" target="_blank">
                            <span class="author-name">Eastland</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                        <i class="i-icon icon-team-auth" title="虎嗅团队"></i>                                        <span class="time">20小时前</span>
                    <i class="icon icon-cmt"></i><em>2</em>
                    <i class="icon icon-fvr"></i><em>13</em>
                </div>

                <div class="mob-sub">血液中流淌的果然是盈利的基因</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235637">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="他借抖音“揩油”奶茶，拿下500加盟店，
但餐饮新零售“答案”在上道" href="/article/235637.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/121210150387.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="他借抖音“揩油”奶茶，拿下500加盟店，
但餐饮新零售“答案”在上道" src="https://img.huxiucdn.com/article/cover/201803/15/121210150387.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235637.html" class="transition msubstr-row2" target="_blank">他借抖音“揩油”奶茶，拿下500加盟店，
但餐饮新零售“答案”在上道</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1405886.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/40/58/86_1509681347.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1405886.html" target="_blank">
                            <span class="author-name">钱德虎</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                        <i class="i-icon icon-team-auth" title="虎嗅团队"></i>                                        <span class="time">20小时前</span>
                    <i class="icon icon-cmt"></i><em>0</em>
                    <i class="icon icon-fvr"></i><em>32</em>
                </div>

                <div class="mob-sub">做餐饮没有怕死的，只怕死得不明不白</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235783">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="马云“斩”卫哲：复原阿里史上最震撼的人事地震" href="/article/235783.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/15/004110666518.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="马云“斩”卫哲：复原阿里史上最震撼的人事地震" src="https://img.huxiucdn.com/article/cover/201803/15/004110666518.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235783.html" class="transition msubstr-row2" target="_blank">马云“斩”卫哲：复原阿里史上最震撼的人事地震</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1652056.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/65/20/56_1493206662.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1652056.html" target="_blank">
                            <span class="author-name">和阳的重读</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">1天前</span>
                    <i class="icon icon-cmt"></i><em>19</em>
                    <i class="icon icon-fvr"></i><em>428</em>
                </div>

                <div class="mob-sub">这是一次理想主义和现实主义的交锋</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235746">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="是什么让H&amp;M、ZARA们慢了下来？" href="/article/235746.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/14/190635426274.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="是什么让H&amp;M、ZARA们慢了下来？" src="https://img.huxiucdn.com/article/cover/201803/14/190635426274.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235746.html" class="transition msubstr-row2" target="_blank">是什么让H&amp;M、ZARA们慢了下来？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2012207.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/33/78/39_1519353047.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2012207.html" target="_blank">
                            <span class="author-name">零售前沿社©</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">1天前</span>
                    <i class="icon icon-cmt"></i><em>10</em>
                    <i class="icon icon-fvr"></i><em>80</em>
                </div>

                <div class="mob-sub">快品牌变慢</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235728">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="史努比都68岁了，这个IP为何仍如此受欢迎？" href="/article/235728.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/14/161907651188.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="史努比都68岁了，这个IP为何仍如此受欢迎？" src="https://img.huxiucdn.com/article/cover/201803/14/161907651188.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235728.html" class="transition msubstr-row2" target="_blank">史努比都68岁了，这个IP为何仍如此受欢迎？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2023903.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/002/02/39/03_1520850349.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2023903.html" target="_blank">
                            <span class="author-name">Lens</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">1天前</span>
                    <i class="icon icon-cmt"></i><em>1</em>
                    <i class="icon icon-fvr"></i><em>20</em>
                </div>

                <div class="mob-sub">史努比的创造者并不排斥商业化，但他也没被商业化冲昏头脑</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235687">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="京东有央视“国家品牌”护体，315还会上榜？" href="/article/235687.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201708/18/074450495391.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="京东有央视“国家品牌”护体，315还会上榜？" src="https://img.huxiucdn.com/article/cover/201708/18/074450495391.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235687.html" class="transition msubstr-row2" target="_blank">京东有央视“国家品牌”护体，315还会上榜？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1770148.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/77/01/48_1517402910.jpeg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpeg"></a>
                        </div>
                        <a href="/member/1770148.html" target="_blank">
                            <span class="author-name">范向东</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">1天前</span>
                    <i class="icon icon-cmt"></i><em>30</em>
                    <i class="icon icon-fvr"></i><em>21</em>
                </div>

                <div class="mob-sub">京东教你315安全闯关之道</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235613">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="李国庆夫妇回应“卖当当”：海航系只是可能性之一" href="/article/235613.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/13/195458386173.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="李国庆夫妇回应“卖当当”：海航系只是可能性之一" src="https://img.huxiucdn.com/article/cover/201803/13/195458386173.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235613.html" class="transition msubstr-row2" target="_blank">李国庆夫妇回应“卖当当”：海航系只是可能性之一</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1932107.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/93/21/07_1511360651.jpeg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpeg"></a>
                        </div>
                        <a href="/member/1932107.html" target="_blank">
                            <span class="author-name">—LR</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">2天前</span>
                    <i class="icon icon-cmt"></i><em>0</em>
                    <i class="icon icon-fvr"></i><em>25</em>
                </div>

                <div class="mob-sub">“我儿子大了，老婆还小，没有情人牵挂，正是我事业第二春！”</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235113">
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="初创公司如何获得有效用户？这个没资源的公司2年作出3亿规模" href="/article/235113.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/09/095334614016.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="初创公司如何获得有效用户？这个没资源的公司2年作出3亿规模" src="https://img.huxiucdn.com/article/cover/201803/09/095334614016.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235113.html" class="transition msubstr-row2" target="_blank">初创公司如何获得有效用户？这个没资源的公司2年作出3亿规模</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1454197.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/45/41/97_1513246454.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1454197.html" target="_blank">
                            <span class="author-name">虎嗅会员小秘书</span>
                        </a>
                        <a href="/vip" target="_blank"><i class="i-vip icon-vip" title="虎嗅黑卡会员"></i></a>
                                                                <span class="time">2天前</span>
                    <i class="icon icon-cmt"></i><em>1</em>
                    <i class="icon icon-fvr"></i><em>63</em>
                </div>

                <div class="mob-sub">解决用户信任问题是关键</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235586">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="在三四线城市做餐饮，怎么做才赚钱？（下）" href="/article/235586.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/13/172228820715.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="在三四线城市做餐饮，怎么做才赚钱？（下）" src="https://img.huxiucdn.com/article/cover/201803/13/172228820715.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235586.html" class="transition msubstr-row2" target="_blank">在三四线城市做餐饮，怎么做才赚钱？（下）</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2025392.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/002/02/53/92_1521009526.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2025392.html" target="_blank">
                            <span class="author-name">红餐网</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">2天前</span>
                    <i class="icon icon-cmt"></i><em>11</em>
                    <i class="icon icon-fvr"></i><em>275</em>
                </div>

                <div class="mob-sub">人人都梦想轻投入，高回报</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235524">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="在三四线城市做餐饮，怎么做才赚钱？（上）" href="/article/235524.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/13/112309634245.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="在三四线城市做餐饮，怎么做才赚钱？（上）" src="https://img.huxiucdn.com/article/cover/201803/13/112309634245.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235524.html" class="transition msubstr-row2" target="_blank">在三四线城市做餐饮，怎么做才赚钱？（上）</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2025392.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/002/02/53/92_1521009526.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2025392.html" target="_blank">
                            <span class="author-name">红餐网</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">2天前</span>
                    <i class="icon icon-cmt"></i><em>1</em>
                    <i class="icon icon-fvr"></i><em>262</em>
                </div>

                <div class="mob-sub">可以说是“秘籍”了</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235508">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="吴晓波：谢谢李国庆" href="/article/235508.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/13/095417897867.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="吴晓波：谢谢李国庆" src="https://img.huxiucdn.com/article/cover/201803/13/095417897867.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235508.html" class="transition msubstr-row2" target="_blank">吴晓波：谢谢李国庆</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1871973.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/33/78/39_1514032312.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1871973.html" target="_blank">
                            <span class="author-name">吴晓波频道©</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">2天前</span>
                    <i class="icon icon-cmt"></i><em>6</em>
                    <i class="icon icon-fvr"></i><em>41</em>
                </div>

                <div class="mob-sub">他从来没有过争夺“中国首富”的机会，也没有发表过引发热议的商业思想</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235497">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="91岁的法国时装大师辞世，奥黛丽·赫本曾说：是纪梵希创造了我" href="/article/235497.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/13/083100934554.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="91岁的法国时装大师辞世，奥黛丽·赫本曾说：是纪梵希创造了我" src="https://img.huxiucdn.com/article/cover/201803/13/083100934554.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235497.html" class="transition msubstr-row2" target="_blank">91岁的法国时装大师辞世，奥黛丽·赫本曾说：是纪梵希创造了我</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2023903.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/002/02/39/03_1520850349.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2023903.html" target="_blank">
                            <span class="author-name">Lens</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">3天前</span>
                    <i class="icon icon-cmt"></i><em>3</em>
                    <i class="icon icon-fvr"></i><em>31</em>
                </div>

                <div class="mob-sub">很多人都在感叹，纪梵希和赫本终于能在天堂重聚了</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235464">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="格局决定结局，当当网做错了什么？" href="/article/235464.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/12/205017815267.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="格局决定结局，当当网做错了什么？" src="https://img.huxiucdn.com/article/cover/201803/12/205017815267.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235464.html" class="transition msubstr-row2" target="_blank">格局决定结局，当当网做错了什么？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1871458.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/33/78/39_1508892538.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1871458.html" target="_blank">
                            <span class="author-name">点拾投资©</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">3天前</span>
                    <i class="icon icon-cmt"></i><em>10</em>
                    <i class="icon icon-fvr"></i><em>223</em>
                </div>

                <div class="mob-sub">我们总觉得当当有那么一点可惜</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235456">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="想夸麦当劳？别让汉堡王看见" href="/article/235456.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/12/202749259689.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="想夸麦当劳？别让汉堡王看见" src="https://img.huxiucdn.com/article/cover/201803/12/202749259689.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235456.html" class="transition msubstr-row2" target="_blank">想夸麦当劳？别让汉堡王看见</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/2023903.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/002/02/39/03_1520850349.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/2023903.html" target="_blank">
                            <span class="author-name">Lens</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">3天前</span>
                    <i class="icon icon-cmt"></i><em>14</em>
                    <i class="icon icon-fvr"></i><em>101</em>
                </div>

                <div class="mob-sub">多年的“广告战”让汉堡王成为品牌广告创意中的一道清奇风景线</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235452">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="【晚报】海航又要卖资产，孙接盘来了；董明珠：我的名字已经申请专利了" href="/article/235452.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201705/22/212816391413.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="【晚报】海航又要卖资产，孙接盘来了；董明珠：我的名字已经申请专利了" src="https://img.huxiucdn.com/article/cover/201705/22/212816391413.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235452.html" class="transition msubstr-row2" target="_blank">【晚报】海航又要卖资产，孙接盘来了；董明珠：我的名字已经申请专利了</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1991491.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/99/14/91_1517476746.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/1991491.html" target="_blank">
                            <span class="author-name">WANFEN</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">3天前</span>
                    <i class="icon icon-cmt"></i><em>6</em>
                    <i class="icon icon-fvr"></i><em>9</em>
                </div>

                <div class="mob-sub">孙大侠厉害啊</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235354">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="谁改写了当当网的命运轨迹？" href="/article/235354.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/11/233057029196.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="谁改写了当当网的命运轨迹？" src="https://img.huxiucdn.com/article/cover/201803/11/233057029196.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235354.html" class="transition msubstr-row2" target="_blank">谁改写了当当网的命运轨迹？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/31445.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/000/03/14/45_avatar_big.jpg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpg"></a>
                        </div>
                        <a href="/member/31445.html" target="_blank">
                            <span class="author-name">俊世太保</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                        <i class="i-icon icon-auth3" title="虎嗅认证作者"></i>                                        <span class="time">4天前</span>
                    <i class="icon icon-cmt"></i><em>8</em>
                    <i class="icon icon-fvr"></i><em>60</em>
                </div>

                <div class="mob-sub">一家公司的命运啊，既要靠自我奋斗，也要考虑到历史进程</div>
            </div>
        </div>
            <div class="mod-b mod-art clearfix" data-aid="235337">
                            <div class="mod-angle">热</div>
                        <!--栏目链接-->
            <div class="mod-thumb pull-left ">
                                <a class="transition" title="李国庆给当当网送来最后的祝福？" href="/article/235337.html" target="_blank">
                                            <img class="lazy" data-original="https://img.huxiucdn.com/article/cover/201803/11/201451200473.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" alt="李国庆给当当网送来最后的祝福？" src="https://img.huxiucdn.com/article/cover/201803/11/201451200473.jpg?imageView2/1/w/220/h/165/|imageMogr2/strip/interlace/1/quality/85/format/jpg" style="display: inline;">
                                    </a>
            </div>
            <div class="mob-ctt channel-list-yh">
                <h2>
                    <a href="/article/235337.html" class="transition msubstr-row2" target="_blank">李国庆给当当网送来最后的祝福？</a>
                </h2>
                <div class="mob-author">
                                            <div class="author-face">
                            <a href="/member/1770148.html" target="_blank"><img src="https://img.huxiucdn.com/auth/data/avatar/001/77/01/48_1517402910.jpeg?imageView2/1/w/40/h/40/|imageMogr2/strip/interlace/1/quality/85/format/jpeg"></a>
                        </div>
                        <a href="/member/1770148.html" target="_blank">
                            <span class="author-name">范向东</span>
                        </a>
                        <a href="/vip" target="_blank"></a>
                                                                <span class="time">4天前</span>
                    <i class="icon icon-cmt"></i><em>10</em>
                    <i class="icon icon-fvr"></i><em>25</em>
                </div>

                <div class="mob-sub">当当还能响多久</div>
            </div>
        </div>
            </div>

                    <div class="get-mod-more js-get-channel-more-list transition" data-url="/channel/ajaxGetMore" data-cur_page="1" data-catid="103" data-last_dateline="">
                点击加载更多
            </div>
                <!--底部通栏广告-->
        
    </div>

    <div class="wrap-right pull-right">
        <!--公共右侧部分-->
        
                    <div class="box-moder hot-tag">
                <h3>专题</h3>
                <span class="span-mark"></span>
                <div class="zt-article">
                                            <div class="zt-article-img">
                            <a href="/special/2800.html" target="_blank" title="霍金时间简史">
                                <img src="https://img.huxiucdn.com/special/201803/14/122154736347.jpg">
                            </a>
                        </div>
                                        <ul>
                                                    <li>
                                <a href="/special/2800.html">
                                    <span class="title"> # 霍金时间简史  #</span>
                                    <span class="time pull-right">22小时前</span>
                                </a>
                            </li>
                                                    <li>
                                <a href="/special/2789.html">
                                    <span class="title"> # 卖身活命的“当当”  #</span>
                                    <span class="time pull-right">2天前</span>
                                </a>
                            </li>
                                                    <li>
                                <a href="/special/2772.html">
                                    <span class="title"> # 抖音快手终有一战  #</span>
                                    <span class="time pull-right">3天前</span>
                                </a>
                            </li>
                                                    <li>
                                <a href="/special/2418.html">
                                    <span class="title"> # 比特币的车你赶上了吗  #</span>
                                    <span class="time pull-right">2018-03-07</span>
                                </a>
                            </li>
                                                    <li>
                                <a href="/special/2768.html">
                                    <span class="title"> # 小米IPO在即  #</span>
                                    <span class="time pull-right">2018-03-05</span>
                                </a>
                            </li>
                                                    <li>
                                <a href="/special/2447.html">
                                    <span class="title"> # 中国无人车第一案  #</span>
                                    <span class="time pull-right">2018-03-05</span>
                                </a>
                            </li>
                                            </ul>
                </div>
            </div>
        
        
                    <div class="placeholder"></div>
            <div class="box-moder hot-tag">
                <h3>频道</h3>
                <span class="span-mark"></span>
                <div class="search-history search-right search-hot">
                    <ul>
                                                    <li class="transition"><a href="/channel/112.html" target="_blank">社交通讯</a></li>
                                                    <li class="transition"><a href="/channel/4.html" target="_blank">生活腔调</a></li>
                                                    <li class="transition"><a href="/channel/21.html" target="_blank">车与出行</a></li>
                                                    <li class="transition"><a href="/channel/22.html" target="_blank">娱乐淘金</a></li>
                                                    <li class="transition"><a href="/channel/102.html" target="_blank">金融地产</a></li>
                                                    <li class="transition"><a href="/channel/104.html" target="_blank">人工智能</a></li>
                                            </ul>
                </div>
            </div>
                            <div class="placeholder"></div>
            <div class="box-moder hot-tag">
                <h3>专栏</h3>
                <span class="span-mark"></span>
                <ul class="wj-wrap">
                                    <li>
                        <a href="/collection/55.html">
                            <img src="https://img.huxiucdn.com/article/cover/201701/03/161103077371.png">
                            <div class="tag-name">
                                品牌放大镜                            </div>
                        </a>
                    </li>
                                    <li>
                        <a href="/collection/54.html">
                            <img src="https://img.huxiucdn.com/article/cover/201701/03/161103077371.png">
                            <div class="tag-name">
                                环球商业地理                            </div>
                        </a>
                    </li>
                                    <li>
                        <a href="/collection/53.html">
                            <img src="https://img.huxiucdn.com/article/cover/201701/03/161103077371.png">
                            <div class="tag-name">
                                回忆杀                            </div>
                        </a>
                    </li>
                                    <li>
                        <a href="/collection/42.html">
                            <img src="https://img.huxiucdn.com/article/cover/201701/03/161103077371.png">
                            <div class="tag-name">
                                行业地图                            </div>
                        </a>
                    </li>
                                </ul>
            </div>
                <div class="placeholder"></div>
            <!--右侧热文部分-->
        <div class="wrap-right pull-right">
            <div class="box-moder hot-article">
    <h3>电商消费-热文</h3>
    <span class="span-mark"></span>
    <ul>
                <li>
            <div class="hot-article-img">
                <a href="/article/235687.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201708/18/074450495391.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235687.html" class="transition" target="_blank">京东有央视“国家品牌”护体，315还会上榜？</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235746.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/14/190635426274.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235746.html" class="transition" target="_blank">是什么让H&amp;M、ZARA们慢了下来？</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235508.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/13/095417897867.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235508.html" class="transition" target="_blank">吴晓波：谢谢李国庆</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235524.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/13/112309634245.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235524.html" class="transition" target="_blank">在三四线城市做餐饮，怎么做才赚钱？（上）</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235728.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/14/161907651188.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235728.html" class="transition" target="_blank">史努比都68岁了，这个IP为何仍如此受欢迎？</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235497.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/13/083100934554.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235497.html" class="transition" target="_blank">91岁的法国时装大师辞世，奥黛丽·赫本曾说：是纪梵希创造了我</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235586.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/13/172228820715.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235586.html" class="transition" target="_blank">在三四线城市做餐饮，怎么做才赚钱？（下）</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235456.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/12/202749259689.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235456.html" class="transition" target="_blank">想夸麦当劳？别让汉堡王看见</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/221449.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201711/10/062427356288.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/221449.html" class="transition" target="_blank">咱这智商，基本告别双十一了</a>
        </li>
                <li>
            <div class="hot-article-img">
                <a href="/article/235113.html" target="_blank">
                                            <img src="https://img.huxiucdn.com/article/cover/201803/09/095334614016.jpg?imageView2/1/w/280/h/210/|imageMogr2/strip/interlace/1/quality/85/format/jpg">
                                    </a>
            </div>
            <a href="/article/235113.html" class="transition" target="_blank">初创公司如何获得有效用户？这个没资源的公司2年作出3亿规模</a>
        </li>
            </ul>
</div>

        </div>
        <div class="placeholder"></div>
    </div>

</div>
   <VFooter></VFooter>
  </section>
</template>
<script>
import {requestLogin, requestRegister,getInfoByDate} from '../api/api.js'
import VHeader from '@/components/Header.vue'
import VFooter from '@/components/Footer.vue'
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
        VHeader,VFooter
    },
    mounted(){
        let token = window.localStorage.getItem("token")
        if(token!=null&&token!=""){
            this.userInfo = JSON.parse(window.localStorage.getItem("user"))
            console.log(this.userInfo)
            this.isLogined = true
        }
    },
    methods:{
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
<style>
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

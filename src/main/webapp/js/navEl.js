class NavEl{
    constructor($div,datas){
        this.$div = $div;
        this.datas = datas;
        this.first = true;
    }
    build() {
        let html = `
              <div class="layui-header">
                <div class="layui-logo layui-bg-cyan" style="font-size: 40px;height: 60px">
                <!--            <img>-->
                <img src="../images/lostHeadWalk.png" alt="" style="height: 40%">
                <ul class="layui-nav layui-bg-cyan layui-layout-left">
                <!--           <i class="layui-icon layui-icon-picture-fine"/>-->
                <span>
                    <span id="city">#城市</span>
                    <li class="layui-nav-item">
                    <a href="javascript:;"">[切换城市]</a>
                    <dl class="layui-nav-child layui-bg-cyan">
                    <dd class="center layui-bg-cyan">
                    <select id="slt1" onChange="updateSelect()">
                    <option>省份</option>
                    <option value="1">湖南</option>
                    <option value="2">广东</option>
                    </select>
                    </dd>
                    <dd class="center layui-bg-cyan">
                    <select id="slt2" onChange="updateSelect()">
                   <option value="">城市</option>
                    </select>
                    </dd>
                    </dl>
                    </li>
                </span>
                </div>
                </ul>
                <ul class="layui-nav layui-layout-right layui-bg-cyan">
                <spen class="layui-form layui-show-lg-inline layui-hide-xs">
                <div class="layui-input-inline">
                <input type="text" name="searchKey" lay-verify="required" placeholder="人才辈出阿卡姆" autocomplete="off" class="layui-input">
                </div>
                <button type="submit" class="layui-btn layui-btn-primary" id="searchBtn"><i class="layui-icon layui-icon-search"></i></button>
                </spen>`
        if (this.datas !== null) {
            console.log(this.datas)
            html += `<li class="layui-nav-item">
                <a href="javascript:;"><img src="..${this.datas.image.imgUrl}" class="layui-nav-img">${this.datas.user.nickName}</a>
                    <dl class="layui-nav-child left">
                    <dd class="center"><img src="..${this.datas.image.imgUrl}" class="layui-nav-img"></dd>
                    <dd class="black center">
                    ${this.datas.user.nickName}
                    </dd>
                    <dd class="center black">
                    ${this.datas.identification.level}
                    </dd>
                    <dd>
                    <div class="layui-progress layui-bg-orange">
                    <div class="layui-progress-bar layui-bg-red" lay-percent="22%"></div>
                    </div>
                    </dd>
                    <dd><a href="personal.html" target="_blank">个人中心</a></dd>`
                if(false) {
                  html +=  `<dd><a href="javascript:;">我的观影团</a></dd>`;
                }
                 html += `<dd>
                    <a href="javascript:;">
                    账号设置
                    <i class="layui-icon layui-icon-set"></i></a>
                    </dd>
                    <dd><a href="/state/logout">退出登录</a></dd>
                    </dl>
                    </li>
                    <li class="layui-nav-item">
                    <a href="">历史<span class="layui-badge">7</span></a>
                    </li>
                    <li class="layui-nav-item">
                    <a href="">收藏<span class="layui-badge">7</span></a>
                    </li>
                    <li class="layui-nav-item">
                    <a href="">动态<span class="layui-badge">7</span></a>
                    </li>
                    <li class="layui-nav-item hidden">
                    <a href="">消息<span class="layui-badge-dot"></span></a>
                    <dl class="layui-nav-child left">
                    <dd>
                    <a href="javascript:;">公告
                    <span class="layui-badge">3</span>
                    </a>
                    </dd>
                    <dd>
                    <a href="javascript:;">
                    私信<span class="layui-badge">6</span>
                    </a>
                    </dd>
                    <dd>
                    <a href="javascript:;">存档</a>
                    </dd>
                    <dd>
                    <a href="javascript:;">
                    消息设置
                    <i class="layui-icon layui-icon-set"></i>
                    </a>
                    </dd>
                    </dl>
                    </li>
                    <li class="layui-nav-item">&emsp;&emsp;</li>`;
        }else{
            html += `<li class="layui-nav-item">
                    <a href="/html/register.html">注册/登陆</a>
                    </li>
                    <li class="layui-nav-item">&emsp;&emsp;</li>`;
        }
        html += `</ul></div>`;
        this.$div.append(html);
        if (this.user&&this.first) {
            $("#city").text(this.datas.user.address);
            // location.reload();
            console.log(1)
            this.first = false;
        }
    }
}
let $div = $("nav");
$.getJSON("/state/log",function (datas) {
    let nav = new NavEl($div,datas);
    nav.build();
    if(datas!==null){
        let jsonString = JSON.stringify(datas);
        sessionStorage.setItem("datas",jsonString);
    }
});
layui.define(['element','layer'], function(exports){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    //监听导航点击
    element.on('nav(demo)', function(elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });
    exports('nav',{}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
$("#searchBtn").click(function () {
    window.open("/seach.html");
});
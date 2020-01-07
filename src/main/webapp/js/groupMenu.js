class Menu{
    constructor($div,$master) {
        this.html = '';
        this.$div = $div;
        this.$master = $master;
    }
    build(){
        this.html = `<ul class="layui-bg-cyan layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
    <li class="layui-nav-item"><a href="viewMain.html">观影团主页</a></li>
    <li class="layui-nav-item layui-nav-itemed">
        <a href="javascript:;">活动管理</a>
        <dl class="layui-nav-child">
            <dd><a href="newActivity.html">发布新活动</a></dd>
            <dd><a href="javascript:;">进行中活动管理</a></dd>
            <dd><a href="javascript:;">历史活动回顾</a></dd>
        </dl>
    </li>
    <li class="layui-nav-item ">
        <a href="javascript:;">观影团消息</a>
        <dl class="layui-nav-child">
            <dd><a href="">公告</a></dd>
            <dd><a href="">私信</a></dd>
            <dd><a href="">申请</a></dd>
        </dl>
    </li>
</ul>`
        this.$div.append(this.html);
    }
}
let $div = $("#menu");
let $master = true;
new Menu($div,$master).build();

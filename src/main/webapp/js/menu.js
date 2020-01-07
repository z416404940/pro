class Menu{
    constructor($div,$master) {
        this.html = '';
        this.$div = $div;
        this.$master = $master;
    }
    build(){
        this.html = `
<ul class="layui-nav layui-nav-tree layui-inlin layui-bg-cyan" lay-filter="demo" style="margin-right: 10px;">
  <li class="layui-nav-item">
    <a href="personalMain.html" id="personaMain">个人首页</a>
  </li>
   <li class="layui-nav-item">
    <a href="applyViewing.html">申请观影团</a>
  </li>
  <li class="layui-nav-item">
    <a href="safeMain.html" id="editInfo">安全中心</a>
  </li>
  <li class="layui-nav-item">
  <a href="personalSet.html">我的信息</a>
  </li>
  <li class="layui-nav-item">
   <a href="trueName.html">实名认证</a>
  </li>`
        if($master){
            this.html+=`  <li class="layui-nav-item layui-bg-orange">
                         <span>
                            <a href="movieGroup.html" target="_blank">我的观影团</a>
                            </span>
                         </li>`
        }
        this.html += `</ul>`
        this.$div.append(this.html);
    }
}
let $div = $("#menu");
let $master = true;
new Menu($div,$master).build();
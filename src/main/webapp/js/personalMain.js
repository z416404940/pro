class personMain {
  //用户，账号实体类user
  constructor($div) {
    this.$div = $div;
    this.num = 25;
    // this.identification = identification;
  }

  build() {
    let html = `
      <div class="head"style="width: 90%;height: 82px;margin-top: 30px;margin-left: 20px">
          <div style="float:left;border-radius: 40px;width: 80px;height: 80px;border: solid 1px black;background-image: url('../img/3D2Y.jpg')">
          </div>
          <div style="float: left;width: 40%;margin-left: 20px">
          <div>
          <h1>666</h1>
          </div>
          <div style="margin-top: 5px">
          <span>12</span>
      </div>
      <div class="layui-progress layui-progress-big" lay-showpercent="true"style="margin-top: 5px">
          <div class="layui-progress-bar" lay-percent="70%"style="text-align: right"></div>
          </div>
          </div>
          <div style="margin-top: 30px;margin-right:50px;float: right">
          <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" id="editInfo">修改资料</button>
          <button type="button" class="layui-btn layui-btn-primary layui-btn-xs" id="personalSpace">个人空间></button>
          </div>
          </div>
          <div style="margin-left: 8%;margin-top: 10px;margin-bottom: 40px">
          <span class="layui-badge layui-bg-orange">实名认证用户</span>
          <span class="layui-badge layui-bg-green">终极骨灰</span>
          <span class="layui-badge layui-bg-cyan">狂热者</span>
          </div>
          <hr>
          <div class="day"style="width: 90%;height: 200px;margin-top: 30px;margin-left: 20px;margin-bottom: 10px">
          <i class="layui-icon layui-icon-find-fill" style="font-size: 30px; color: #1E9FFF;float: left;margin-right: 10px"></i>
          <h2><strong>每日任务</strong></h2>
      <div style="width: 100%">
          <div style="width: 30%;height:180px;float: left">
          <div style="float:left;width: 120px;height: 120px;margin-left: 35%;margin-top:5%;margin-right:30%;background-image: url('../img/yuan.png')">
          <div style="margin-left: 40%;margin-top: 30%">
          <h2><strong>10</strong></h2>
      <strong>EXP</strong>
      </div>
      </div>
      <center>
      <p style="width: 50%;height: 20px;margin-top: 10px">每日登录</p>
          </center>
          </div>
          <div style="width: 30%;height:180px;float: left">
          <div style="float:left;width: 120px;height: 120px;margin-left: 35%;margin-top:5%;margin-right:30%;background-image: url('../img/yuan.png')">
          <div style="margin-left: 40%;margin-top: 30%">
          <h2><strong>50</strong></h2>
      <strong>EXP</strong>
      </div>
      </div>
      <center>
      <p style="width: 50%;height: 20px;margin-top: 10px">发布动态</p>
          </center>
          </div>
          <div style="width: 30%;height:180px;float: left">
          <div style="float:left;width: 120px;height: 120px;margin-left: 35%;margin-top:5%;margin-right:30%;background-image: url('../img/yuan.png')">
          <div style="margin-left: 40%;margin-top: 30%">
          <h2><strong>20</strong></h2>
      <strong>EXP</strong>
      </div>
      </div>
      <center>
      <p style="width: 50%;height: 20px;margin-top: 10px">关注别人</p>
          </center>
          </div>
          </div>
          </div>
          <hr/>
          <div class="achievement" style="margin-left: 20px">
          <i class="layui-icon layui-icon-find-fill" style="font-size: 30px; color: #1E9FFF;float: left;margin-right: 10px"></i>
          <h2><strong>荣誉成就</strong></h2>
      <div style="margin-top: 20px">
          <center>
          <p style="margin-bottom: 20px">你还没有拿到任何荣誉勋章呦/(ㄒoㄒ)/~~</p>
          <button type="button" class="layui-btn layui-btn-sm layui-btn-normal">查看勋章详情</button>
          </center>
          </div>
          </div>
        `
    this.$div.append(html);
  }
}
//调用servlet实现动态呈现
let $div = $(".centerBox");
new personMain($div).build();
// $.getJSON("",function (identification) {
//   new NavEl($div,identification).build();
// });
$("#editInfo").click(function () {
  $("#iframeMain",window.parent.document).attr("src","personalSet.html");
  $("#editInfo",window.parent.document).click();
})
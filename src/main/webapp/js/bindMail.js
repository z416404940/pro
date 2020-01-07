class bindMail {
  //用户，账号实体类user
  constructor($div, user) {
    this.$div = $div;
    this.num = 25;
    this.user = user;
  }
  build() {
    let html = `
      <div class="boxHead"style="margin: 40px 10px">
          <span class="layui-breadcrumb" lay-separator="—">
          <a href="">账号安全</a>
          <a href="">设置邮箱</a>
          </span>
          </div>
          <div class="box"style="width:60%;margin-left: 20%">
          <center>
          <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief"style="width: 60%">
          <ul class="layui-tab-title">
          <li id="loadLI"class="layui-this">验证身份-></li>
      <li id="registerLi"style="display: none">绑定邮箱-></li>
      <li id="successLi"style="display: none">绑定成功</li><!--style="display: none"-->
          </ul>
          <div class="layui-tab-content"style="width: 80%;margin-left: 10%">
          <div class="layui-tab-item layui-show"style="margin-top: 30px">
          <div class="layui-form">
          <form class="layui-form layui-form-pane" action="">
          <div class="layui-form-item">
          <label class="layui-form-label">原手机号：</label>
      <div class="layui-input-block">
          <input type="text" name="tel" autocomplete="off" value="13812345678" class="layui-input"readonly/>
      </div>
      </div>
      <div class="layui-form-item">
          <button type="button" class="layui-btn layui-btn-primary">获取验证码</button>
          <div class="layui-input-inline">
          <input type="text" name="telVerification" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
      </div>
      </div>
      <div style="margin-bottom: 10px;margin-top: 10px">
          <span id="errTel"></span>
          </div>
          <button id="theTel"style="width: 100%" type="button" class="layui-btn">下一步</button>
          </form>
          </div>
          </div>
          <div class="layui-tab-item"style="margin-top: 30px">
          <div class="layui-form">
          <form class="layui-form layui-form-pane" action="">
          <div class="layui-form-item">
          <label class="layui-form-label">邮箱号：</label>
      <div class="layui-input-block">
          <input type="text" name="mail" autocomplete="off" placeholder="请输入邮箱号" class="layui-input"/>
      </div>
      </div>
      <div class="layui-form-item">
          <button type="button" class="layui-btn layui-btn-primary">获取验证码</button>
          <div class="layui-input-inline">
          <input type="text" name="mailVerification" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
          </div>
          </div>
          <div style="margin-bottom: 10px;margin-top: 10px">
          <span id="errMail"></span>
          </div>
          <button id="theMail" style="width: 100%" type="button" class="layui-btn">下一步</button>
          </form>
          </div>
          </div>
          <div class="layui-tab-item"style="margin-top: 30px">
          <center>
          <div class="layui-form">
          <img src="../img/luoji.png">
          </div>
          <div style="margin-bottom: 20px;margin-top: 10px">
          <h3 style="color: green">恭喜您，邮箱绑定成功！！</h3>
      </div>
      <button type="button" class="layui-btn" id="yesMail">确定</button>
          </center>
          </div>
          </div>
          </div>
          </center>
          </div>
        `
    this.$div.append(html);
  }
}
let $div = $(".centerBox");
new bindMail($div).build();


//模拟手机验证码验证
$("#theTel").click(function () {
  let tel = $("input[name='telVerification']").val() ;
  //console.log(tel);
  if(tel == 123456){
    $("#registerLi").css("display","inline");
    $("#errTel").css("color","green");
    $("#errTel").empty();
    $("#errTel").append("验证码正确！");
    $('#registerLi').click();
  }else {
    $("#errTel").css("color","red");
    $("#errTel").empty();
    $("#errTel").append("验证码错误！");
    //console.log("tel");
    //console.log(tel);
    /*$.getJSON("/text","tel="+tel,function (result) {
      if(result == true){
      }else {
      }
    });*/
  }
  setTimeout(function () {
    $("#errTel").empty();
  },2000);
});

//模拟邮箱验证
$("#theMail").click(function () {
  let mail = $("input[name='mailVerification']").val() ;
  //console.log(tel);
  if(mail == 123456){
    $("#successLi").css("display","inline");
    $("#errMail").css("color","green");
    $("#errMail").empty();
    $("#errMail").append("验证码正确！");
    $('#successLi').click();
  }else {
    $("#errMail").css("color","red");
    $("#errMail").empty();
    $("#errMail").append("验证码错误！");
    /*$.getJSON("/text","mail="+mail,function (result) {
      if(result == true){
        $("#successLi").css("display","inline");
        $("#errMail").css("color","green");
        $("#errMail").empty();
        $("#errMail").append("验证码正确！");
      }else {
        $("#errMail").css("color","red");
        $("#errMail").empty();
        $("#errMail").append("验证码错误！");
      }
    });*/
  }
  setTimeout(function () {
    $("#errMail").empty();
  },2000);
});
$("#yesMail").click(function () {
  $("#iframeMain",window.parent.document).attr("src","safeMain.html");
  console.log(132)
})
class changePassword {
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
          <a href="">修改密码</a>
          </span>
  </div>
  <div class="box"style="width:60%;margin-left: 20%">
    <center>
      <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief"style="width: 60%">
        <ul class="layui-tab-title">
          <li id="loadLI"class="layui-this">验证身份-></li>
          <li id="registerLi"style="display: none">修改密码-></li>
          <li id="successLi"style="display: none">设置成功</li><!--style="display: none"-->
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
                  <label class="layui-form-label">新密码：</label>
                  <div class="layui-input-block">
                    <input type="text" name="pass1" autocomplete="off" placeholder="请输入密码" class="layui-input"/>
                  </div>
                </div>
                <div class="layui-form-item">
                  <label class="layui-form-label">再次输入：</label>
                  <div class="layui-input-block">
                    <input type="text" name="pass2" autocomplete="off" placeholder="请再次输入密码" class="layui-input"/>
                  </div>
                </div>
                <div style="margin-bottom: 10px;margin-top: 10px">
                  <span id="errpass"></span>
                </div>
                <button id="theMail" style="width: 100%" type="button" class="layui-btn">下一步</button>
              </form>
            </div>
          </div>
          <div class="layui-tab-item"style="margin-top: 30px">
            <center>
              <div class="layui-form">
                <img src="../images/movieGroup/luoji.png">
              </div>
              <div style="margin-bottom: 20px;margin-top: 10px">
                <h3 style="color: green">恭喜您，密码修改成功！！</h3>666
              </div>
              <button type="button" class="layui-btn" id="yesPw">确定</button>
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
new changePassword($div).build();


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

//模拟密码设置验证
$("#theMail").click(function () {
  let pass1 = $("input[name='pass1']").val() ;
  let pass2 = $("input[name='pass2']").val() ;
  //console.log(tel);
  if(pass1 == pass2){
    $("#successLi").css("display","inline");
    $("#errpass").css("color","green");
    $("#errpass").empty();
    $("#errpass").append("密码输入一致。");
    $('#successLi').click();
  }else {
    $("#errpass").css("color","red");
    $("#errpass").empty();
    $("#errpass").append("两次密码输入不一致！");
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
$("#yesPw").click(function () {
  $("#iframeMain",window.parent.document).attr("src","safeMain.html");
})
class safeMain {
  //用户，账号实体类user
  constructor($div,user) {
    this.$div = $div;
    this.num = 25;
    this.user = user;
  }
  build() {
    let html = `
      <div class="picture"style="width: 70%;height: 200px;margin-left: 30%;margin-top: 50px">
      <img src="../images/movieGroup/teamer.png" alt="美国队长"style="float: left;width: 18%">
      <div style="background-image: url('../images/movieGroup/dunpai.png');min-width: 200px;min-height: 200px;float: left;background-size: cover">
        <P style="font-size: 500%;margin-left: 32%;margin-top: 27%"id="num"></P>
      </div>
      <img src="../images/movieGroup/eye.png" alt="鹰眼"style="float: left;width: 18%">
    </div>
  <div style="width:60%;height: 400px;margin: 40px auto">
    <div style="width:100%;height: 100px;border-top: solid 1px lightgray">
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span class="layui-badge-dot layui-bg-green"style="width: 17px;height: 17px"id="telSpan1">√</span>
        <span class="layui-badge-dot layui-bg-red"style="width: 17px;height: 17px"id="telSpan2">!</span>
        <span style=""><strong>绑定手机</strong></span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span style="color: red"class="telNum">
        <!-- 将“139****1258”替换成￥{user.tel}
    user.tel 如果为空，给一个"未绑定手机"-->
          ${this.user.tel}
        </span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <a href="bindTel.html" style=";color: royalblue"id="doTel">
          
        </a>
       <a href="bindTelByMail.html" style=";color: royalblue"id="doTel2">
       </a> 
      </div>
    </div>
    <div style="width:100%;height: 100px;border-top: solid 1px lightgray">
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span class="layui-badge-dot layui-bg-green"style="width: 17px;height: 17px"id="eSpan1">!</span>
        <span class="layui-badge-dot layui-bg-red"style="width: 17px;height: 17px"id="eSpan2">!</span>
        <span style=""><strong>绑定邮箱</strong></span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span style="color: red"class="ENum">
          
        </span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <a href="bindMail.html" style=";color: royalblue"id="doE">
          
        </a>
      </div>
    </div>
    <div style="width:100%;height: 100px;border-top: solid 1px lightgray">
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span class="layui-badge-dot layui-bg-green"style="width: 17px;height: 17px">√</span>
        <span style=""><strong>设置密码</strong></span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span style="color: "class="PassNum">
          已设置
        </span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <a href="changePassword.html" style=";color: royalblue"id="doPw">
          修改密码
        </a>
      </div>
    </div>
    <div style="width:100%;height: 100px;border-top: solid 1px lightgray">
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span class="layui-badge-dot layui-bg-orange"style="width: 17px;height: 17px"id="trueSpan1">!</span>
        <span class="layui-badge-dot layui-bg-green"style="width: 17px;height: 17px"id="trueSpan2">!</span>
        <span style=""><strong>实名认证</strong></span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <span style="color: orange"class="trueName">
          
        </span>
      </div>
      <div style="width: 33%;float: left;text-align: center;margin-top: 40px">
        <a href=""style=";color: royalblue">
          实名认证
        </a>
      </div>
    </div>
  </div>
    `
    this.$div.append(html);
  }
  //动态改变页面信息
  change(){
    //<!-- 将“x”替换成￥{this.user.tel}-->
    //更改电话颜色、内容、标签
    if(this.user.tel == null){
      $(".telNum").css("color","red");
      $(".telNum").text('未绑定手机号');
      $("#doTel2").text("绑定手机");
      $("#doTel").remove();
      $("#telSpan1").remove();
      $("#num").text(this.num);
    }else {
      $(".telNum").css("color","black");
      $("#doTel").text("更换手机");
      $("#doTel2").remove();
      $("#telSpan2").remove();
      this.num+=25;
      $("#num").text(this.num);
    }
    //更改邮箱颜色、内容、标签
    if(this.user.email == null){
      $(".ENum").css("color","red");
      $(".ENum").text('未绑定邮箱');
      $("#doE").text("绑定邮箱");
      $("#eSpan1").remove();
      $("#num").text(this.num);
    }else {
      $(".ENum").css("color","black");
      $(".ENum").text('已绑定');
      $("#doE").text("更换邮箱");
      $("#eSpan2").remove();
      this.num+=25;
    }
    // //更改密码颜色、内容、标签
    // let pass = null;
    // if(/*this.identification.password  替换*/pass  == null){
    //   $(".PassNum").css("color","red");
    //   $(".PassNum").text('未绑定密码');
    // }else {
    //   $(".PassNum").css("color","black");
    //   $(".PassNum").text('已绑定');
    // }
    //更改身份证号颜色、内容、标签
    if(this.user.idNum == null){
      $(".trueName").css("color","orange");
      $(".trueName").text('未实名认证');
      $("#trueSpan2").remove();
      $("#num").text(this.num);
    }else {
      $(".trueName").css("color","black");
      $(".trueName").text('已认证');
      $("#trueSpan1").remove();
      this.num+=25;
      $("#num").text(this.num);
    }
  }

}
let $div = $(".centerBox");
//传入的servlet
$.getJSON("/sett/safety",function (user) {
  var main = new safeMain($div,user);
  main.build();
  main.change();
});
$("#doTel").click(function () {
  $("#iframeMain",window.parent.document).attr("src",$(this).attr("href"));
});
$("#doE").click(function () {
  $("#iframeMain",window.parent.document).attr("src",$(this).attr("href"));
});
$("#doPw").click(function () {
  $("#iframeMain",window.parent.document).attr("src",$(this).attr("href"));
});
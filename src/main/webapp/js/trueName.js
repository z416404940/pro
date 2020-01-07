class trueName {
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
          <a href="">实名认证</a>
          </span>
          </div>
          <div class="care"style="margin-left: 20px">
          <h2 style="color:goldenrod">实名认证成功后,可获得申请观影团等权限!</h2>
      <br/>
      <p>注意事项</p>
      <p>1.每个证件只能绑定一个账号。</p>
      <p>2.证件照不清晰或与输入的信息不匹配,将导致实名认证被驳回。</p>
      <p>3.您提供的证件信息将受到严格保护,仅用于身份验证,未经本人许可不会用于其他用途。</p>
      <br/>
      <p>证件要求</p>
      <p>1.需上传本人露脸手持二代身份证背面照＋身份证正反面照片（不需手持）。</p>
      <p>2.证件必须在有效期内，有效期需在一个月以上。</p>
      <br/>
      <p>照片要求</p>
      <p>1.本人手持证件正面露脸，五官清晰可辨。</p>
      <p>2.证件照上信息需完整且清晰可辨（无反光、遮挡、水印、证件套、logo等）。</p>
      <p>3.申请人填写的“真实姓名”和“证件号码”需和提交证件照片信息一致。</p>
      <p>4.证件必须真实拍摄，不能使用复印件。</p>
      <p>5.确保照片完整（不缺边角），证件周围不允许加上边角框（如：加上红框等）。</p>
      <hr/>
      </div>
      <div class="text"style="margin-left: 20px">
          <div class="true">
          <strong>信息填写</strong>
          <form class="layui-form" action="">
          <div class="layui-form-item">
          <div class="layui-inline">
          <label class="layui-form-label">真实姓名：</label>
      <div class="layui-input-inline">
          <input type="text" name="trueName" lay-verify="required" autocomplete="off" class="layui-input">
          </div>
          </div>
          </div>
          <div class="layui-form-item">
          <div class="layui-inline"style="margin-right: 0px">
          <label class="layui-form-label">证件类型：</label>
      </div>
      <div class="layui-inline">
          <select name="papers" lay-verify="required">
          <option value="0">身份证</option>
          <option value="1">港澳居民通行证</option>
          <option value="2">护照（中国签发）</option>
      <option value="3">外国人永久居留证</option>
          </select>
          </div>
          </div>
          <div class="layui-form-item">
          <div class="layui-inline">
          <label class="layui-form-label">证件号码：</label>
      <div class="layui-input-inline">
          <input type="text" name="trueNum" lay-verify="required|identity" autocomplete="off" class="layui-input">
          </div>
          </div>
          </div>
          <div class="layui-form-item layui-col-space15">
          <div class="layui-col-xs4">
          <div class="layui-upload-drag" id="upload1">
          <i class="layui-icon"></i>
              <p>点击上传，或将文件拖拽到此处</p>
              </div>
              <p style="margin-left: 20px">上传手持证件照片</p>
          </div>
          <div class="layui-col-xs4">
          <div class="layui-upload-drag" id="upload2">
          <i class="layui-icon"></i>
      <p>点击上传，或将文件拖拽到此处</p>
      </div>
      <P>上传正面证件照片</P>
      </div>
      <div class="layui-col-xs4">
          <div class="layui-upload-drag" id="upload3">
          <i class="layui-icon"></i>
      <p>点击上传，或将文件拖拽到此处</p>
      </div>
      <P>上传反面证件照片</P>
      </div>
      </div>
      <strong>手机验证</strong>
      <div class="layui-form-item">
          <label class="layui-form-label">手机号：</label>
      <div class="layui-input-inline">
          <input type="text" name="tel" autocomplete="off" value="13812345678" class="layui-input"readonly/>
      </div>
      </div>
      <div class="layui-form-item">
          <button type="button" class="layui-btn layui-btn-primary">获取验证码</button>
          <div class="layui-input-inline">
          <input type="text" name="telVerification" lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
          </div>
          <div style="margin-bottom: 10px;margin-top: 10px">
          <span id="errTel"></span>
          </div>
          </div>
          <hr/>
          <div class="layui-form-item"style="margin-left: 150px">
          <div class="layui-input-block">
          <button id="yes" class="layui-btn" lay-submit lay-filter="formDemo">提交认证</button>
          </div>
          </div>
          </form>
          </div>
          </div>
    `
    this.$div.append(html);
  }
}
let $div = $(".centerBox");
new trueName($div).build();
//使用json传输数据
$.getJSON("/state/enter",function (tel) {
  if(telOrEml != null){
    $("input[name='tel']").text(tel);
  }
});
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
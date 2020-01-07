class personalSet {
  //用户，账号实体类user,identification,
  constructor($div) {
    this.$div = $div;
    //this.user = user;
    //this.identification = identification;
  }
  build(){
    let html = `
  <div class="centerBox">
        <div class="boxHead"style="margin: 10px 10px">
        <span>
        我的信息
        </span>
        </div>
        <hr>
        <div class="boxBody">
        <form class="layui-form"action="">
        <div class="layui-form-item">
        <label class="layui-form-label">昵称：</label>
    <div class="layui-input-inline">
    <!--将“我是占位符”替换成￥{this.identification.nickname}
    identification.nickname 如果是第一次设置，给一个默认值 -->
        <input type="text" name="nickname" lay-verify="required" value="我是占位符" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">花费Y币修改密码</div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">用户ID：</label>
        <!--将“我是占位符”替换成￥{this.uesr.userId}
        uesr.userId 是注册账号系统默认给的固定数字 -->
    <div class="layui-form-mid layui-word-aux">我是占位符</div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">我的生日：</label>
    <div class="layui-input-inline">
      <!--将“2020-01-01”替换成￥{this.user.birthday}
      user.birthday如果是第一次设置，给一个默认值 -->
        <input type="text" name="date" id="date" lay-verify="date" value="2020-01-01" autocomplete="off" class="layui-input">
        </div>
        </div>
        <div class="layui-form-item">
        <label class="layui-form-label">单选框：</label>
    <div class="layui-input-block">
        <input type="radio" name="sex" value="男" title="男" >
        <input type="radio" name="sex" value="女" title="女">
        <input type="radio" name="sex" value="保密" title="保密" checked="">
        </div>
        </div>
        <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">个性签名：</label>
    <div class="layui-input-block">
        <textarea name="autograph" placeholder="设置您的个性签名～(￣▽￣～)(～￣▽￣)～" class="layui-textarea"style="width: 80%"></textarea>
        </div>
        </div>
        <div class="layui-form-item">
        <div class="layui-input-block">
        <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">保存</button>
        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
new personalSet($div).build();
//传入的servlet
/*$.getJSON("/tlt",function (user,identification) {
  new personalSet(user,identification,$div).build();
});*/
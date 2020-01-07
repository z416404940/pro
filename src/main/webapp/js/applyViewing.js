class applyViewing {
  constructor($div,) {
    this.$div = $div;
  }
  build(){
    let html = `
      <div class="boxHead"style="margin: 10px 10px">
        <span class="layui-breadcrumb" lay-separator="—">
          <a href="">申请观影团</a>
          <a href="">填写申请表</a>
        </span>
    </div>
    <hr>
    <div class="boxBody">
      <form class="layui-form"action="">
        <div class="layui-form-item">
          <label class="layui-form-label">团名称：</label>
          <div class="layui-input-inline">
            <input type="text" name="teamName" lay-verify="required" placeholder="XX观影团" autocomplete="off" class="layui-input">
          </div>
          <div class="layui-form-mid layui-word-aux">为你的观影团起一个好听的名字吧</div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">团头像：</label>
          <div class="layui-upload">
            <button type="button" class="layui-btn layui-btn-normal" id="find">选择文件</button>
          </div>
        </div>
        <div class="layui-form-item">
          <label class="layui-form-label">签名：</label>
          <div class="layui-input-inline">
            <input type="text" name="autograph" autocomplete="off" class="layui-input">
          </div>
        </div>
        <div class="layui-form-item layui-form-text">
          <label class="layui-form-label">团简介：</label>
          <div class="layui-input-block">
            <textarea name="autograph" placeholder="简单的介绍一下您的观影团吧～(￣▽￣～)(～￣▽￣)～" class="layui-textarea"style="width: 80%"></textarea>
          </div>
        </div>
        <div class="layui-form-item">
          <div class="layui-input-block">
            <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">申请</button>
          </div>
        </div>
      </form>
    </div>`
    this.$div.append(html);
  }
}
let $div = $(".centerBox");
new applyViewing($div).build();
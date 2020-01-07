class search {
  //用户，账号实体类user
  constructor($div, user) {
    this.$div = $div;
    this.num = 25;
    this.user = user;
  }

  build() {
    let html = `
      <div class="layui-col-xs10 layui-col-xs-offset1">
    <center>
      <div class="layui-input-block">
        <div class="layui-input-inline">
          <input type="tel" name="phone" lay-verify="required" autocomplete="off" class="layui-input"placeholder="请输入查找的名字"style="width: 600px">
        </div>
        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon layui-icon-search"></i></button>
      </div>
    </center>
  </div>
  <div class="layui-col-xs8 layui-col-xs-offset2">
    <div class="layui-tab layui-tab-brief " lay-filter="docDemoTabBrief">
      <ul class="layui-tab-title">
        <li class="layui-this">全部</li>
        <li>用户</li>
        <li>观影团</li>
        <li>活动</li>
      </ul>
      <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">
        <div id="all"></div>
          <footer class="layui-col-md-offset2 layui-col-xs-offset0 layui-col-xs8" style="min-width: 1000px">
            <div id="pageAll"></div>
          </footer>
        </div>
        <div class="layui-tab-item">
        <div id="user"></div>
          <footer class="layui-col-md-offset2 layui-col-xs-offset0 layui-col-xs8" style="min-width: 1000px">
            <div id="pageUser"></div>
          </footer>
        </div>
        <div class="layui-tab-item">
        <div id="view"></div>
          <footer class="layui-col-md-offset2 layui-col-xs-offset0 layui-col-xs8" style="min-width: 1000px">
            <div id="pageViewing"></div>
          </footer>
        </div>
        <div class="layui-tab-item">
        <div id="activity"></div>
          <footer class="layui-col-md-offset2 layui-col-xs-offset0 layui-col-xs8" style="min-width: 1000px">
            <div id="pageActivity"></div>
          </footer>
        </div>
      </div>
    </div>
  </div>
    `
    this.$div.append(html);
  }
}
let $div = $(".centerBox");
new search($div).build();
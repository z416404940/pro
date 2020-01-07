class viewMain {
  //movie_group_info(观影团信息)movie_group（观影图案账号）user_movie_group（用户观影团关联）movieGroupInfo,movieGroup,identification
  constructor($div,mapJson) {
    this.$div = $div;
    this.mapJson = mapJson;
  }

  build() {
    let html = `
      <br/>
  <div class="layui-col-xs10 layui-col-xs-offset1"style="background-image: url('../img/fengjing.jpg');height: 150px;background-color: #3F3F3F">
      <div class="layui-col-xs10"style="height: 70px;margin-top: 80px;margin-left: 15px">
        <div class="layui-col-xs5 grid-demo-bg5" style="background: pink;width: 50px;height: 50px;border-radius: 30px;background-image: url('../img/3D2Y.jpg')">
        </div>
        <div class="layui-col-xs5 grid-demo-bg5"style="color: whitesmoke">
          <h1>
          <strong>666</strong>
            <span style="font-size: 20px">Lv.1</span>
            </h1>
          <p>666</p>
        </div>
      </div>
    <div class="layui-col-xs1 grid-demo-bg5"style="color: whitesmoke;margin-top: 80px">
      <button type="button" class="layui-btn layui-btn-warm"id="follow">关注</button>
    </div>
  </div>
  <div class="layui-col-xs10 layui-col-xs-offset1"style="border: solid 1px lightgray;border-radius: 5px;margin-top: 10px;margin-bottom: 10px;height: 50px;padding-top: 5px">
    <span>活跃城市：</span>
    <span style="margin-right: 20%">666</span>
    <div class="layui-inline">
      <div class="layui-input-inline">
        <input type="tel" name="phone" lay-verify="required" autocomplete="off" class="layui-input"placeholder="请输入查找的活动名">
      </div>
    </div>
    <button type="button" class="layui-btn layui-btn-primary layui-btn-sm"><i class="layui-icon layui-icon-search"></i></button>
    <div class="layui-layout-right layui-show-lg-inline layui-hide-xs" style="line-height: 50px">
      <span>活动数：</span>
      <span style="color: #1E9FFF">5</span>
      &emsp;
      <span>粉丝数：</span>
      <span style="color: #1E9FFF">777</span>
      &emsp;
    </div>
  </div>
  <div class="layui-row layui-col-xs-offset1">
    <div class="layui-col-xs7 ">
      <div style="margin-top: 10px">
        <div style="border: solid 1px lightgray;border-radius:5px;margin: 10px;height: 30px">
          <h2>正在进行的活动</h2>
        </div>
        <div id="newActivity"style="border: solid 1px lightgray;border-radius: 5px;margin: 10px">

        </div>
      </div>
      <div style="margin-top: 20px">
        <div style="border: solid 1px lightgray;border-radius:5px;margin: 10px;height: 30px">
          <h2>往期活动回顾</h2>
        </div>
        <div  id="oldActivity"style="border: solid 1px lightgray;border-radius: 5px;margin: 10px">

        </div>
      </div>
    </div>
    <div class="layui-col-xs4 ">
      <div style="border: solid 1px lightgray;border-radius:5px;margin: 10px;height: 50px;padding-top: 10px">
        <center>
          <span style="color: goldenrod">官网认证明星观影团</span>
        </center>
      </div>
      <div style="border: solid 1px lightgray;border-radius:5px;margin: 10px;height: 200px">
        <center>
          <h2>团长</h2>
          <p>666</p>
          <br/>
          <h2>管理员</h2>
          <p>吴老二</p>
          <br/>
          <p>赵铁柱</p>
        </center>
      </div>
    </div>
  </div>
    `
    this.$div.append(html);
  }
}
let $div = $(".centerBox");
//从servlet中获取Map集合
//movie_group_info(观影团信息)movie_group（观影图案账号）identification（账号）
// $.getJSON("/viewMain",function (mapJson) {
//   console.log(mapJson.leaders[0].nickName);
//
// });

new viewMain($div).build();
let activityList = [
  {title:"《叶问-4》组织观影",content:"要吃饭的嘛",strartTime:"2019-02-05",name:"泡泡观影团"},
  {title:"《小丑》偷映",content:"悄悄的",strartTime:"2017-10-12",name:"泡泡观影团"},
  {title:"白色情人节观影",content:"情侣快来哦！！",strartTime:"2019-12-25",name:"泡泡观影团"},
];

class searchGetData {
  //activityList是一个搜索结果的集合，需要3个集合这里只写了一个
  constructor($divAll,$divUser,$divViewing ,$divActivity,activityList) {
    this.$divAll = $divAll;
    this.$divUser = $divUser;
    this.$divViewing = $divViewing;
    this.$divActivity= $divActivity;
    this.activityList = activityList;
  }
//将this.activityList.length更换成从servlet接过来的数据，是每页显示的数据条数
  build() {
    //生成用户搜所页
    for (let i = 0; i < this.activityList.length; i++) {
      let htmlUser = `
    <div style="height: 100px;width:100%;border-bottom: dashed 1px lightgray;padding: 10px">
            <div class="layui-col-xs8 ">
              <p>
                <span style="color: grey;">[用户]</span>
                <a style="color: #1E9FFF" href="">范伟用户（用户昵称）</a>
              </p>
              <p style="margin-top: 10px">
                <span>5</span><span>人关注</span>
              </p>
              <p style="margin-top: 10px">
                //我是范伟。（用户简介）
              </p>
              <hr/>
            </div>
            <div class="layui-col-xs4 ">
              <div style="width: 80px;height: 80px;background-image: url('../img/3D2Y.jpg')">
                //用户头像
              </div>
            </div>
          </div>
    `
      this.$divUser.append(htmlUser);
      this.$divAll.append(htmlUser);
    }
    //生成观影团搜索页
    for (let i = 0; i < this.activityList.length; i++) {
     let htmlViewing = `
    <div style="height: 100px;width:100%;border-bottom: dashed 1px lightgray;padding: 10px">
            <div class="layui-col-xs8 ">
              <p>
                <span style="color: grey;">[观影团]</span>
                <a style="color: #1E9FFF" href="">范伟观影团（观影团昵称）</a>
              </p>
              <p style="margin-top: 10px">
                <span>5</span><span>粉丝</span>
              </p>
              <p style="margin-top: 10px">
                //我是观影团。（观影团简介）
              </p>
              <hr/>
            </div>
            <div class="layui-col-xs4 ">
              <div style="width: 80px;height: 80px;background-image: url('../img/3D2Y.jpg')">
                //观影团头像
              </div>
            </div>
          </div>
    `
      this.$divViewing.append(htmlViewing);
      this.$divAll.append(htmlViewing);
    }

    //生成活动搜索页
    for (let i = 0; i < this.activityList.length; i++) {
     let htmlActivity = `
    <div style="height: 100px;width:100%;border-bottom: dashed 1px lightgray;padding: 10px">
            <div class="layui-col-xs8 ">
              <p>
                <span style="color: grey;">[活动]</span>
                <a style="color: #1E9FFF" href="">活动名（活动标题title）</a>
              </p>
              <p style="margin-top: 10px">
                <span>所在城市</span>
              </p>
              <p style="margin-top: 10px">
                已结束/未结束（显示活动时间）
              </p>
            </div>
            <div class="layui-col-xs4 ">
              //活动宣传海报（图片宽高只适应长图，宽图会变形）
              <div style="width: 80px;height: 80px">
                <img src="../img/3D2Y.jpg"style="height: 80px;width: 60px">
              </div>
            </div>
          </div>
    `
      this.$divActivity.append(htmlActivity);
      this.$divAll.append(htmlActivity);

    }
  }
}
//获取每个分页标签的父级元素
let $divAll = $("#all");
let $divUser = $("#user");
let $divViewing = $("#view");
let $divActivity = $("#activity");
new searchGetData($divAll,$divUser,$divViewing,$divActivity,activityList).build();
layui.define(['element', 'carousel','laypage','layer','upload'], function(exports){
  var laypage = layui.laypage
      ,layer = layui.layer;
  laypage.render({
    elem: 'pageAll'
    ,count: 1000
    ,prev: '<em>&lt;</em>'
    ,next: '<em>&gt;</em>'
    ,layout: ['prev', 'page', 'next', 'skip', 'count']
    ,jump: function(obj){
      console.log(1)
    }
  });
  laypage.render({
    elem: 'pageUser'
    ,count: 1000
    ,prev: '<em>&lt;</em>'
    ,next: '<em>&gt;</em>'
    ,layout: ['prev', 'page', 'next', 'skip', 'count']
    ,jump: function(obj){
      console.log(12)
    }
  });
  laypage.render({
    elem: 'pageViewing'
    ,count: 1000
    ,prev: '<em>&lt;</em>'
    ,next: '<em>&gt;</em>'
    ,layout: ['prev', 'page', 'next', 'skip', 'count']
    ,jump: function(obj){
      console.log(13)
    }
  });
  laypage.render({
    elem: 'pageActivity'
    ,count: 1000
    ,prev: '<em>&lt;</em>'
    ,next: '<em>&gt;</em>'
    ,layout: ['prev', 'page', 'next', 'skip', 'count']
    ,jump: function(obj){
      console.log(14)
    }
  });
});

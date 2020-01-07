let newActivity = [
  {title:"《宠爱》观影活动",content:"新片倾情放松",strartTime:"2020-01-2",name:"泡泡观影团"},
  {title:"《海上钢琴师》放映活动",content:"经典回顾。",strartTime:"2020-02-2",name:"泡泡观影团"},
  {title:"跨年观影活动",content:"跨年啦！",strartTime:"2019-12-31",name:"泡泡观影团"},
];
let oldActivity = [
  {title:"《叶问-4》组织观影",content:"要吃饭的嘛",strartTime:"2019-02-05",name:"泡泡观影团"},
  {title:"《小丑》偷映",content:"悄悄的",strartTime:"2017-10-12",name:"泡泡观影团"},
  {title:"白色情人节观影",content:"情侣快来哦！！",strartTime:"2019-12-25",name:"泡泡观影团"},
];
class viewMainData {
  constructor($div,activityList) {
    this.$div = $div;
    this.activityList = activityList;
  }
  build(){
    for (let i = 0; i < this.activityList.length; i++) {
      let html = `<hr>
                  <div class="layui-row"style="width: 90%;margin-left: 5%">
                  <div class="layui-col-xs12 out postSize">
                  <img src="" alt="">{海报}
                  </div>
                  <div class="layui-col-xs10" style="height: 161px">
                  <div class="" style="font-size: 20px;height: 20%">
                  <a href="javascript:;">
                  &emsp;${this.activityList[i].title}
                  </a>
                  </div>
                  <div class="center" style="height: 70%">${this.activityList[i].content}</div>
                  <div class="right" style="height: 10%">
                  <span>${this.activityList[i].name}</span>
                  <span>${this.activityList[i].strartTime}</span>
                  </div>
                  </div>
                    </div>`
      this.$div.append(html);

    }
  }
}
let $new = $("#newActivity");
new viewMainData($new,newActivity).build();
let $old = $("#oldActivity");
new viewMainData($old,oldActivity).build();
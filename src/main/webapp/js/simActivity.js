class Activity {
    constructor($div,activityList) {
        this.$div = $div;
        this.activityList = activityList;
    }
    build(){
        for (let i = 0; i < this.activityList.path.length; i++) {
            let html = `<hr>
                <div class="out" style="padding-left: 100px">
                <div class="layui-row" >
<!--                <img src="${this.activityList.path[i]}" alt="" style="width: 100%;">-->
                </div>
                <div class="layui-col-xs10" style="height: 161px">
                <div class="" style="font-size: 20px;height: 20%">
                活动名
                <a href="" style="color: #1E9FFF;text-decoration:none">
                &emsp;${this.activityList.activities[i].title}
                </a>
                </div>
<!--            <div class="center" style="height: 70%">${this.activityList.activities[i].content}</div>-->
                <div class="right" style="height: 10%">
            <span>活动发布时间：${this.activityList.activities[i].strartTime}</span>
            <span>活动结束时间：${this.activityList.activities[i].endTime}</span>
            </div>
            </div>
            </div>`
            this.$div.append(html);
        }
    }
}
export {Activity};
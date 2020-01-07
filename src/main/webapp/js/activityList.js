class Activity {
    constructor($div,activityList) {
        this.$div = $div;
        this.activityList = activityList;
    }
    build(){
        for (let i = 0; i < this.activityList.path.length; i++) {
            let html = `<hr>
                <div class="layui-row" >
                <div class="layui-col-xs12 out postSize">
                <img src="${this.activityList.path[i]}" alt="">{海报}
                </div>
                <div class="layui-col-xs10" style="height: 161px">
                <div class="" style="font-size: 20px;height: 20%">
                <a href="javascript:;">
                &emsp;${this.activityList.activities[i].title}
        </a>
            </div>
            <div class="center" style="height: 70%">${this.activityList.activities[i].content}</div>
                <div class="right" style="height: 10%">
                <a href=""><span>${this.activityList.moveInfo[i].name}</span></a>
            <span>${this.activityList.activities[i].strartTime}</span>
            </div>
            </div>
            </div>`
            this.$div.append(html);
        }
    }
}
export {Activity};
// $.getJSON("/home/show",function(data) {
//     console.log(data)
//     console.log(data.length)
//     new Activity($div,data).build();
// })

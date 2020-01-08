import {datas} from "./data.js"

class Table {
    constructor($div,$popup,datas){
        this.$div = $div;
        this.$popup = $popup;
        this.datas = datas;
    }
    loading(){
        this.$tableTitle = this.loadTitle();
        this.$tableBody = this.loadBody();
        this.loadTitleData();
        this.loadBodyData();
    }
    loadTitle(){
        let titleCode = [];
        this.datas.titles.forEach(title=>{
            titleCode.push(title);
        });
        return titleCode;
    }
    loadBody(){
        let bodyCode = [];
        this.pageArray.forEach(datas=>{
            let temp = [];
            temp.push(datas["sign"]);
            this.datas.titles.forEach(title=>{
                temp.push(datas[title.columnName]);
            })
            bodyCode.push(temp);
        });
        return bodyCode;
    }
    loadAssembly(){
        this.isFind = false;
        this.$table = $("<table></table>");
        this.$caption = $("<caption>宝可梦图鉴</caption>");
        this.$thead = $("<thead></thead>");
        this.$tbody = $("<tbody></tbody>");
        this.$tfoot = $("<tfoot></tfoot>");
        this.$center = $("<center></center>");
        this.$add = $("<button>添加</button>");
        this.$remove = $("<button>删除</button>");
        this.$sort = $("<button>排序</button>");
        this.$table.append(this.$caption);
        this.$table.append(this.$thead);
        this.$table.append(this.$tbody);
        this.$up = $("<button>上一页</button>");
        this.$down = $("<button>下一页</button>");
        this.$home = $("<button>首页</button>");
        this.$end = $("<button>尾页</button>");
        this.$findText = $("<input type='text' placeholder='请输入查找内容'></input>");
        this.$findButton = $("<button>查找</button>");
        let $tr = $("<tr></tr>");
        $tr.append(this.$home);
        $tr.append(this.$up);
        $tr.append(this.$down);
        $tr.append(this.$end);
        $tr.append(this.$findText);
        $tr.append(this.$findButton);
        this.$table.append(this.$tfoot);
        this.$center.append(this.$table);
        this.$div.append(this.$center);
        this.$div.append(this.$add);
        this.$div.append(this.$remove);
        this.$div.append(this.$sort);
        this.$div.append($tr);
    }
    loadTitleData(){
        let $tr = $("<tr></tr>");
        this.$tableTitle.forEach(title=>{
            let $th = $("<th></th>");
            $th.text(title.displayName);
            $tr.append($th);
            }
        )
        this.$thead.append($tr);
    };
    loadBodyData(){
        this.bodyTrEl = [];
        this.$tableBody.forEach((data,index)=>{
        this.bodyTrEl[index] = $("<tr></tr>");
        for(let i = 1;i<data.length;i++){
            let $td = $("<td></td>").text(data[i]);
            this.bodyTrEl[index].append($td);
        }
        this.$tbody.append(this.bodyTrEl[index]);
        });
    };
    page(){
        this.currentPage = 1;
        this.numOfPage = 3;
        this.pageArray = [];
        this.changePage();
    }
    changePage(){
        this.costPageNum = this.datas.datas.length%this.numOfPage==0?
            this.datas.datas.length/this.numOfPage:
            Math.floor(this.datas.datas.length/this.numOfPage)+1;
        this.startData = (this.currentPage-1)*this.numOfPage;
        this.endData = this.currentPage*this.numOfPage<this.datas.datas.length?
            this.currentPage*this.numOfPage:this.datas.datas.length;
        this.datas.datas.forEach((prop,index)=>{
            if(index>=this.startData&&index<this.endData){
                this.pageArray.push(this.datas.datas[index]);
            }
        });
    }
    loadListener(){
        for(let i=0;i<this.bodyTrEl.length;i++){
            this.bodyTrEl[i].click(()=>{
                this.bodyTrEl[i].toggleClass("remove");
            });
            this.bodyTrEl[i].dblclick(()=>{
                this.choiceIndex = this.startData+i;
                this.choiceData = this.datas.datas[this.choiceIndex];
                this.$popup.css("display","block");
                this.inputEl[0].val(this.choiceData.regionID);
                this.inputEl[1].val(this.choiceData.nationalID);
                this.inputEl[2].val(this.choiceData.chName);
                this.inputEl[3].val(this.choiceData.jpName);
                this.inputEl[4].val(this.choiceData.enName);
                this.inputEl[5].val(this.choiceData.attribute);
                this.isAdd = false;
            });
        }
    }
    loadbuttonListener() {
        this.$home.click(() => {
            this.currentPage = 1;
            this.isFind = false;
            this.return();
        });
        this.$up.click(() => {
            this.currentPage = this.currentPage > 1 ? this.currentPage - 1 : 1;
            this.isFind = false;
            this.return();
        });
        this.$down.click(() => {
            this.currentPage = this.currentPage < this.costPageNum ? this.currentPage + 1 : this.costPageNum;
            this.isFind = false;
            this.return();
        });
        this.$end.click(() => {
            this.currentPage = this.costPageNum;
            this.isFind = false;
            this.return();
        });
        this.$add.click(() => {
            this.isAdd = true;
            this.$popup.slideDown(500);
        })
        this.$remove.click(() => {
            this.bodyTrEl.forEach((tr, index) => {
                if ($(tr).hasClass("remove")) {
                    this.datas.datas.splice(index + this.startData, 1);
                    this.return();
                }
            })
        })
        this.$findButton.click(() => {
            let findArray = [];
            this.isFind = true;
            this.datas.datas.forEach((data, index) => {
                if (-1 != (data.regionID.indexOf(this.$findText.val()))
                    || -1 != (data.nationalID.indexOf(this.$findText.val()))
                    || -1 != (data.chName.indexOf(this.$findText.val()))
                    || -1 != (data.jpName.indexOf(this.$findText.val()))
                    || -1 != (data.enName.indexOf(this.$findText.val()))
                    || -1 != (data.attribute.indexOf(this.$findText.val()))
                ) {
                    findArray.push(data);
                    this.pageArray = findArray;
                    this.return();
                }else {

                }
            });
        });
        this.$sort.click(() => {
            this.isFind = false;
            this.datas.datas.sort(function (a, b) {
                return a.regionID - b.regionID
            });
            this.return();
        });
    }
    return(){
        this.$tbody.empty();
        this.$thead.empty();
        if(!this.isFind){
            this.pageArray.splice(0,this.pageArray.length);
            this.changePage();
        }
        this.loading();
        this.loadListener();
        // console.log(this.isPass.form())
    }
    loadPupop(){
        this.isAdd = true;
        this.inputEl = [];
        this.$formEl = $("<form></form>");
        this.$formEl.attr("id","formEl");
        let $pEl = $("<p>添加</p>");
        this.$close = $("<input type='button' value='X'/>");
        $pEl.append(this.$close);
        this.$formEl.append($pEl);
        this.datas.titles.forEach((title,index)=>{
            let $divEl = $("<div></div>");
            let $lableEl = $("<lableEl></lableEl>");
            $lableEl.text($(title).prop("displayName"));
            this.inputEl[index] = $("<input type='text'>");
            this.inputEl[index].attr("name",$(title).prop("columnName"));
            $divEl.append($lableEl);
            $divEl.append(this.inputEl[index]);
            this.$formEl.append($divEl)
        });
        this.$submit = $("<input type='button' value='确定'/>");
        this.$formEl.append(this.$submit);
        this.$windowEl = $("<div></div>");
        this.$windowEl.append(this.$formEl);
        this.$popup.append(this.$windowEl);
        this.$popup.css("display","none");
    }
    formListener(){
        this.$submit.click(()=>{
            let pokemonMsg = {
                sign:10,
                regionID:this.inputEl[0].val(),
                nationalID:this.inputEl[1].val(),
                chName:this.inputEl[2].val(),
                jpName:this.inputEl[3].val(),
                enName:this.inputEl[4].val(),
                attribute:this.inputEl[5].val()
            };
            if(this.isAdd){
                this.datas.datas.push(pokemonMsg);
            }else {
                this.datas.datas.splice(this.choiceIndex,1,pokemonMsg);
            }
            this.return();
        })
        this.$close.click(()=>{
            this.$popup.slideUp(500);
        })
    }
    render(){
        this.loadAssembly();
        this.page();
        this.loading();
        this.loadListener();
        this.loadPupop();
        this.formListener();
        this.loadbuttonListener();
        this.isPass();
    }
    isPass(){
        this.isPass = this.$formEl.validate({
            rules:{
                regionID:{
                    required:true,
                    regionID:true
                },
                nationalID:{
                    required:true,
                },
                chName:{
                    required:true,
                },
                jpName:{
                    required:true,
                },
                enName:{
                    required:true,
                },
                attribute:{
                    required:true,
                }
            },
            massages:{
                regionID:{
                    required:"请输入地区编号",
                },
                nationalID:{
                    required:"请输入地区编号",
                },
                chName:{
                    required:"请输入地区编号",
                },
                jpName:{
                    required:"请输入地区编号",
                },
                enName:{
                    required:"请输入地区编号",
                },
                attribute:{
                    required:"请输入地区编号",
                }
            }
        })
    }
}
let $div = $(".table");
let $popup = $(".popup");
let table = new Table($div,$popup,datas);
table.render();
var judgeHead = 'judge';
var judgeNum = 1;
var judgeName = judgeHead+judgeNum;

var questionHead = 'question';
var questionNum = 1;
var questionName = questionHead+questionNum;
$("#addJudge").click(function () {
  if(judgeNum <= 4){
      let judge = `
        <div class="layui-form-item">
        <div class="layui-inline">
          <label class="layui-form-label">题目：</label>
          <div class="layui-input-inline">
            <input type="tel" name="${judgeName}" lay-verify="required" autocomplete="off" class="layui-input">
          </div>
        </div>
    `
      $("#judge").append(judge);
      judgeNum = judgeNum+1
      judgeName = judgeHead+judgeNum;
  }else{
  }
});
$("#addQuestion").click(function () {
  if(questionNum <= 4){
    let question = `
      <div class="layui-form-item">
      <div class="layui-inline">
        <label class="layui-form-label">题目：</label>
        <div class="layui-input-inline">
          <input type="tel" name="${questionName}" lay-verify="required" autocomplete="off" class="layui-input">
        </div>
      </div>
  `
    $("#question").append(question);
    questionNum = questionNum+1;
    questionName = questionHead+questionNum;
  }
});
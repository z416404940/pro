//切换标签自动获得焦点
var $inputs = $("input[type=text]");
$inputs[0].focus(event);
$("#loadLI").click(function () {
  $("#registerForm")[0].reset();
  setTimeout(function () {
    $("#tel1").focus();
  },200)
});
$("#registerLi").click(function () {
  $("#loadForm")[0].reset();
  setTimeout(function () {
    $("#tel2").focus();
  },200);
});

//注册失去焦点事件
$("#tel2").blur(function () {
  function callAjax() {
    alert("2");
    $.ajax({
      "url":"",
      "method":"POST",
      "data": "name="+$(".loadName").val(),
      "dataType":"text",
      "success":function f(data) {
        if(data.trim() == true){
          $('#err').append("该手机/邮箱已被使用！");
          $('#err').css("color","red");
        }else {
          $('#err').append("可用的手机/邮箱。");
          $('#err').css("color","green");
        }
      },
    });
  }
});
//更新注册后登录value
$.getJSON("/state/enter",function (telOrEml) {
  if(telOrEml != null){
    $('#tel1').val(telOrEml);
  }
});


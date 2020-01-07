layui.config({
    base: '../js/'
}).use('nav');
layui.use('element', function(){
    var element = layui.element;
});
layui.use(['form', 'layedit', 'laydate','upload'], function(){
    // var $ = layui.jquery
    //     ,upload = layui.upload;
    // upload.render({
    //     elem: '#upload1'
    //     , url: "/activity/post"
    //     , accept: 'file'
    //     , auto: false
    //     // , bindAction: '#upfile' //关闭的上传按钮   html中此id所在元素也被注释
    //     ,multiple: true
    //     , done: function (res) {
    //         alert("上传成功1");
    //     }
    // });
    // function fsubmit(aData) {
    //     console.log(aData);
    //     $.ajax({
    //         url: "/activity/post",
    //         type: "POST",
    //         data: aData,
    //         dataType: "formData",
    //         async : false,
    //         contentType: false,   //jax 中 contentType 设置为 false 是为了避免 JQuery 对其操作，从而失去分界符，而使服务器不能正常解析文件
    //         processData: false,   //当设置为true的时候,jquery ajax 提交的时候不会序列化 data，而是直接使用data
    //         error : function(request) {
    //             parent.layer.alert("网络超时");
    //         },
    //         success: function (data) {
    //             alert("上传成功！");
    //         }
    //     });
    //     return false;
    // }
    // $("#yes").on("click",function () {
    //     var formSatellite = $(".layui-form");//获取所要提交form的id
    //     var aData = new FormData(formSatellite);  //用所要提交form做参数建立一个formdata对象
    //     fsubmit(aData);//调用函数
    // })
    // form.on('submit(demo1)', function (data) {
    //     let jsonData = JSON.stringify(data.field);
    //     layer.alert(data, {
    //         title: 'JSON格式'
    //     })
    //     $.ajax({
    //         url:"/activity/post",
    //         method:"POST",
    //         data: data.field,
    //         dataType:"json",
    //         success:function f(data) {
    //             if(data.trim() == true){
    //                 layer.alert(("2"));
    //             }else {
    //                 layer.alert(("3"));
    //             }
    //         },
    //     });
    //     return false;
    // });
    layui.$('#LAY-component-form-setval').on('click', function(){
        form.val('example', {
            "m_id":""
            ,"title":"123"
            ,"file":"",
            "movie_name":"213",
            "intro":"",
            "strart_time":"",
            "end_time":"",
            "strart_apply_time":"",
            "end_apply_time":""
            ,"movie_strart_time":""
            ,"move_end_time":""
            ,"date":""
            ,"quiz1":"浙江"
            ,"quiz2":""
            ,"address":"213"
            ,"type[free]":true
            ,"visible":true
            ,"username":"213"
            ,"content":"",
            "phone":"12312312312"
        });
    });
    var form = layui.form
        ,layer = layui.layer
        ,layedit = layui.layedit
        ,laydate = layui.laydate;
    //日期
    laydate.render({
        type: 'datetime',
        elem: '#datetime1,#datetime2,#datetime3,#datetime4,#datetime5,#datetime6',
    });

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');
});

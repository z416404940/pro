layui.define(['element', 'carousel','laypage','layer','upload'], function(exports){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var upload = layui.upload;
    //分开上传
    upload.render({
        elem: '#find'
        ,url: ''
        ,auto: false
        //,multiple: true
        ,bindAction: '#yes'
        ,done: function(res){
            console.log(res)
        }
    });
    upload.render({
        elem: '#upload1'
        ,url: ''
        ,auto: false
        //,multiple: true
        ,bindAction: '#yes'
        ,done: function(res){
            console.log(res)
        }
    });
    upload.render({
        elem: '#upload2'
        ,url: ''
        ,auto: false
        //,multiple: true
        ,bindAction: '#yes'
        ,done: function(res){
            console.log(res)
        }
    });
    upload.render({
        elem: '#upload3'
        ,url: ''
        ,auto: false
        //,multiple: true
        ,bindAction: '#yes'
        ,done: function(res){
            console.log(res)
        }
    });
    //监听导航点击
    element.on('nav(demo)', function(elem) {
        //console.log(elem)
        layer.msg(elem.text());
    });
    var carousel = layui.carousel;
    carousel.render({
        elem: '#test1'
        ,width: '100%' //设置容器宽度
        ,arrow: 'always' //始终显示箭头
        ,height: '400px'
        //,anim: 'updown' //切换动画方式
    });
    exports('homePage',{}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
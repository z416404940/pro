layui.define(['element', 'carousel','laypage','layer'], function(exports){
    var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

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
        //,anim: 'updown' //切换动画方式
    });
    var laypage = layui.laypage
        ,layer = layui.layer;
    laypage.render({
        elem: 'pageDiv'
        ,count: 1000
        ,prev: '<em>&lt;</em>'
        ,next: '<em>&gt;</em>'
        ,layout: ['prev', 'page', 'next', 'skip', 'count']
        ,jump: function(obj){
            console.log(obj)
        }
    });
    exports('homePage',{}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
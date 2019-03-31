layui.define(['layer', 'form'], function(exports) {
    var layer = layui.layer,
        form = layui.form;
    $(function(){
    	getPlayers(layui);
    	$("#addPlayer").click(function(){
    		window.location.href="/nba/player/setPlayer";
    	});
    });

    exports('playerList', {}); //注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
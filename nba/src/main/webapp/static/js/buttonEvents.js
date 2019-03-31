/*按钮动态绑定事件*/

var buttonEventBinding = function(layui){
	$(".mine-remove").on("click",function(){
		var $tr = $(this).parents("tr");
		var playerId = $tr.find("td:first").html();
		var jsonString = '{"playerId":"' + playerId + '"}';
		layer.confirm('Remove this player?', {
			btn : [ 'Yes', 'Nope' ]
		}, function(index, layero) {
			removePlayer(jsonString);
		});
	});
	
	$(".mine-modify").on("click",function(){
		var $tr = $(this).parents("tr");
		var playerId = $tr.find("td:first").html();
		layui.sessionData("playerInfo", {key : "playerId", value : playerId});
		window.location.href = "/nba/player/modifyPlayer";
		
	});
}


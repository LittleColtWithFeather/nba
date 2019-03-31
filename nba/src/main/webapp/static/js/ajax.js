/*所有的ajax方法*/

var getPlayers = function(layui){
	$.ajax({
		url:"/nba/player/getPlayers",
		type:"get",
		success:function(result){
			var $table = $(".layui-table").find("tbody");
			$table.empty();
			var jsonObj = JSON.parse(result);
			if(jsonObj.msg){
				//如果没有结果打印信息
				$("table").parent().append("<h1>" + jsonObj.msg + "</h1>");
				$("table").remove();
			} else {
				//有结果则打印结果
				for(var i = 0; i < jsonObj.length; i++){
					$table.append("<tr>"
										+"<td style='display: none;'>" + jsonObj[i].playerId + "</td>"
				                        +"<td>" + jsonObj[i].playerName + "</td>"
				                        +"<td>" + jsonObj[i].playerAge + "</td>"
				                        +"<td>" + jsonObj[i].playerHeight + "</td>"
				                        +"<td>" + jsonObj[i].playerTeam + "</td>"
				                        +"<td>"
				                            +"<button class='mine-modify layui-btn'>modify</button>"
				                            +"<button class='mine-remove layui-btn'>remove</button>"
				                        +"</td>"
				                   +"</tr>");
				}
			}
			buttonEventBinding(layui);
		}
	});
};

var addPlayer = function(jsonPost){
	$.ajax({
		url:"/nba/player/addPlayer",
		type:"post",
		contentType: "application/json",
		data:jsonPost,
		success:function(result){
			var resultJson = JSON.parse(result);
			layer.msg(resultJson.msg);
			window.location.href = "/nba/player/playerList";
		}
	});
};

var removePlayer = function(jsonString){
	$.ajax({
		url:"/nba/player/deletePlayer",
		type:"post",
		data:jsonString,
		contentType: "application/json",
		success:function(result){
			var resultJson = JSON.parse(result);
			layer.msg(resultJson.msg);
			getPlayers(layui);
		}
	});
}

var getPlayerById = function(jsonString, form){
	$.ajax({
		url:"/nba/player/getPlayerById",
		type:"post",
		data:jsonString,
		contentType: "application/json",
		success:function(result){
			var resultJson = JSON.parse(result);
			if(resultJson.msg){
				layer.msg(resultJson.msg);
			}else{
				completeModifyPage(resultJson, form);
			}
		}
	});
}

var modifyPlayer = function(jsonPost){
	$.ajax({
		url:"/nba/player/modifyPlayer",
		type:"post",
		contentType: "application/json",
		data:jsonPost,
		success:function(result){
			var resultJson = JSON.parse(result);
			layer.msg(resultJson.msg);
			window.location.href = "/nba/player/playerList";
		}
	});
}
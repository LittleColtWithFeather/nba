/*给modifyPlayer.html填充页面用的*/

var completeModifyPage = function(resultJson, form){
	$('input[name="playerId"]').val(resultJson.playerId);
	$('input[name="playerName"]').val(resultJson.playerName);
	$('input[name="playerAge"]').val(resultJson.playerAge);
	$('input[name="playerHeight"]').val(resultJson.playerHeight);
	$('select[name="playerTeam"]').find("option:contains('"+ resultJson.playerTeam +"')").attr("selected",true);
	form.render();//select需要渲染 别忘了
};
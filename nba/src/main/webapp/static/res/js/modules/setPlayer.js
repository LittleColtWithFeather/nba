layui.define([ 'layer', 'form' ], function(exports) {
	var layer = layui.layer, form = layui.form;

	// 监听提交
	form.on('submit(submitform)', function(data) {
		var jsonPost = JSON.stringify(data.field);
		layer.confirm('Submission confirmed?', {
			btn : [ 'Yes', 'Wait a minute...' ]
		}, function(index, layero) {
			addPlayer(jsonPost);
		});

		return false;
	});

	form.verify({
		playerName : function(value, item) { // value：表单的值、item：表单的DOM对象
			if (!/^[a-zA-Z]{1}[a-zA-Z ]{0,28}[a-zA-Z]{1}$/.test(value)) {
				return 'Please enter a valid name...(at most 30 letters)';
			}
		},
		playerAge : function(value, item) { // value：表单的值、item：表单的DOM对象
			if (!/^(?:[1-9]?\d|100)$/.test(value)) {
				return 'Please enter a valid age... (range : 1~100)';
			}
		},
		playerHeight : function(value, item) { // value：表单的值、item：表单的DOM对象
			if (!/^[1-2]{1}\.{1}[0-9]{2}$/.test(value)) {
				return 'Please enter a valid height... (Unit : meters, like : 1.91)';
			}
		}

	});

	exports('setPlayer', {}); // 注意，这里是模块输出的核心，模块名必须和use时的模块名一致
});
/**
 * 序列化表单数据为json格式
 * @param form
 * @return
 */
function serializeObject(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
}

/**
 * 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串
 * 
 * @returns list
 */
function stringToList(value) {
	if (value != undefined && typeof (value) != 'string') {
		return value;
	}
	if (value != undefined && value != '') {
		var values = [];
		var t = value.split(',');
		for ( var i = 0; i < t.length; i++) {
			values.push('' + t[i]);/* 避免他将ID当成数字 */
		}
		return values;
	} else {
		return [];
	}
};

/**
 * 获取项目路径
 * @return
 */
function getProjectLocation() {
	var curLocation = window.location.href;
	var pathName = window.location.pathname;
	var pos = curLocation.indexOf(pathName);
	var curhostPath = curLocation.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	
	return curhostPath + projectName;
}


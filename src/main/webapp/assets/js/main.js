//текущая позиция в сценарии
let i = 0;

// кнопка дальше по сценарию
function next() {
	// если не завершили предыдущий диалог
	if (dialogCount > 0) {
		nextDialog(arr[i - 1]);
		return;
	}

	var temp = arr[i];
	console.log(arr[i]);
	
	//пропускаем не обработанные комманды
	if (temp == null) {
		while(temp==null){
			i++;
			temp = arr[i];
		}
	} 
	
	parse(temp);
	i++;
	
}

//!!!!!!!!!!!!!!!!!!!!!!Parse
// в зависимости от комманды вызываем нужный метод-обработчик
function parse(temp){
	if (temp["type"] == "char")
		addChar(temp);
	else if (temp["type"] == "dialog")
		addDialog(temp);
	else if (temp["type"] == "scene")
		addScene(temp);
	else if (temp["type"] == "sound")
		addSound(temp);
	else if (temp["type"] == "window")
		windowww(temp);
	else if (temp["type"] == "hide")
		hide(temp);
	else if (temp["type"] == "variable")
		addVariable(temp);
	else if (temp["type"] == "jump")
		jump(temp);
	else if (temp["type"] == "menu")
		menu(temp);
}



// !!!!!!!!!!!!!!!!!!!!!!!
// получение пути по entity
// !!!!позже обновить до передачи параметров не в строке
function objectToUrl(obj, url) {
	var tempSrc = url + "?";
	for ( var i in obj) {
		tempSrc += i + "=" + obj[i] + "&";
	}
	tempSrc = tempSrc.substring(0, tempSrc.length - 1);
	return tempSrc;
}
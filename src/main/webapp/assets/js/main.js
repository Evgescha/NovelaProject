//текущая позиция в сценарии
let i = 0;

// текущие позиции в тексте диалога
let dialogCount = 0;
let dialogCurrent = 0;

// счетчики увеличения/уменьшения громкости звука
var intervalUp, intervalDown;

// массив переменных
var variables = new Map();

// кнопка дальше по сценарию
function next() {
	// если не завершили предыдущий диалог
	if (dialogCount > 0) {
		nextDialog(arr[i - 1]);
		return;
	}
	var temp = arr[i];
	console.log(arr[i]);
	if (temp["type"] == "char")
		addChar(temp);
	if (temp["type"] == "dialog")
		addDialog(temp);
	if (temp["type"] == "scene")
		addScene(temp);
	if (temp["type"] == "sound")
		addSound(temp);
	if (temp["type"] == "window")
		windowww(temp);
	if (temp["type"] == "hide")
		hide(temp);
	if (temp["type"] == "variable")
		addVariable(temp);
	i++;
}




//!!!!!!!!!!!!!!!!!!!!РАБОТА С ПЕРЕМЕННЫМИ
// чтение переменных
function addVariable(vrbl) {
	console.log("Add variable "+vrbl["key"]+":"+vrbl["value"]);
	variables.set(vrbl["key"], vrbl["value"]);
}
// изменение переменной на заданное значение
function updateNumericVariable( key,  value){
	console.log("Update variable "+key+", old:"+variables[key]+", add:"+value);
	var val = variables.get(key);
		val = Number.parseInt(val); // Теперь будет числом
		variables.set(key, val+value);
		console.log("new value: "+variables.get(key));
// if (val.match(/^\d+$/)) {
// }
}
// изменение не числовых переменных
function updateNonNumericVariable( key,  value){
	console.log("Update variable "+key+", old:"+variables[key]+", to:"+value);
	variables.set(key, value);
	console.log("new value: "+variables.get(key));
}




//!!!!!!!!!!!!!РАБОТА С ДИАЛОГОВЫМ ОКНОМ
// показ и сокрытие окна диалога
function windowww(wnd) {
	if (wnd["show"] == true) {
		console.log("window show");
		$(".window").removeClass("hide").addClass("show");
	} else {
		console.log("window hide");
		$(".window").removeClass("show").addClass("hide");
		$(".textAuthor").text("");
		$(".textContent").text("");
	}
}



//!!!!!!!!!!!!РАБОТА С АУДИО
function addSound(snd) {
	console.log("add sound");
	if (snd["play"] == true) {
		var url = objectToUrl(snd, "/sound/get");
		getSound(url, snd);
	} else {
		let vol = 0;
		if (snd["fade"] != 0) {
			vol = 100 / snd["fade"];
		}
		clearInterval(intervalDown);
		intervalDown = setInterval(soundVolumeDown, 500, vol / 2);
	}
}

// получаем путь до музыки и включаем ее
function getSound(urls, snd) {
	$.ajax({
		url : urls,
		method : "GET", // Что бы воспользоваться POST методом, меняем
		// данную строку на POST
		success : function(data) {

			console.log(data); // Возвращаемые данные выводим в консоль
			$("audio").attr("src", data);
			// произведение музыки при заданных условиях
			if (snd["sound_loop"] == true)
				document.getElementById("myAudio").loop = true;
			else
				document.getElementById("myAudio").loop = false;

			let vol = 0;
			$(".audio").prop("volume", 1);
			if (snd["fade"] != 0) {
				$(".audio").prop("volume", 0);
				vol = 100 / snd["fade"];
			}
			$('audio').trigger("play");
			clearInterval(intervalUp);
			intervalUp = setInterval(soundVolumeUp, 500, vol / 2);

		}
	});
}

// увеличиваем громкость музыки
function soundVolumeUp(vol) {
	var volume = $(".audio").prop("volume") + vol / 100;
	if (volume > 1)
		volume = 1;
	console.log("Volume sound: " + volume);
	$(".audio").prop("volume", volume);
	if (volume > 0.99) {
		clearInterval(intervalUp);

	}
}

// уменьшаем громкость и выключаем музыку
function soundVolumeDown(vol) {
	var volume = $(".audio").prop("volume") - vol / 100;
	if (volume < 0)
		volume = 0;
	console.log("Volume sound: " + volume);
	$(".audio").prop("volume", volume);
	if (volume <= 0.05) {
		clearInterval(intervalDown);
		$('audio').trigger("stop");
	}
}




//!!!!!!!!!!РАБОТА С ФОНОМ
// выводим сцену на экран
function addScene(scn) {
	console.log("add Scene");
	var url = "url(\"" + objectToUrl(scn, "/scene/get") + "\")";
	console.log(url);
	$(".background2").css("background-image", url);
	$(".sprite").remove();
}



//!!!!!!!!!!!!!!РАБОТА С ДИАЛОГОМ
// начать вывод диалога на экран
function addDialog(dlg) {
	console.log("add dialog");
	dialogCount = dlg["text"].length;
	dialogCurrent = 0;
	$(".textAuthor").text(dlg["name"]);
	var text = dlg["text"];
	$(".textContent").text(text[dialogCurrent]);
	dialogCount--;
	dialogCurrent++;
}

// продолжить вывод диалога, если он состоит более чем из одной части
function nextDialog(dlg) {
	console.log("next dialog");
	var text = dlg["text"];
	$(".textContent").text($(".textContent").text() + text[dialogCurrent]);
	dialogCount--;
	dialogCurrent++;
}




//!!!!!!!!!!!!РАБОТА С СПРАЙТОМ
// добавляем персонажа на экран
function addChar(chr) {
	console.log("add char");
	var imageUrl = objectToUrl(chr, "/images/char");
	var div = `<img class="sprite ${chr["name"]} ${chr["position"]} ${chr["location"]}"  src="${imageUrl}">`;
	// если персонаж существует, заменить
	if ($("." + chr["name"]).length > 0) {
		$("." + chr["name"]).replaceWith(div);
	}
	// если до этого персонажа не было, просто добавить на экран
	else
		$(".sprites").append(div);
}

//удаление персонажей с экрана
function hide(hd) {
	console.log("Char "+hd["name"]+" hide");
	$("." + hd["name"]).remove();
}



//!!!!!!!!!!!!!!!!!!!!!!!
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
//проходим каждый элемент json-массива
let i = 0;
//
let dialogCount = 0;
let dialogCurrent = 0;

var intervalID;

// кнопка дальше по сценарию
function next() {
	// если не завершили предыдущий диалог
	if (dialogCount > 0) {
		nextDialog(arr[i - 1]);
		return;
	}
	var temp = arr[i];
	if (temp["type"] == "char")
		addChar(temp);
	if (temp["type"] == "dialog")
		addDialog(temp);
	if (temp["type"] == "scene")
		addScene(temp);
	if (temp["type"] == "sound")
		addSound(temp);
	i++;
}

function addSound(snd) {
	console.log("add sound");
	if (snd["play"] == true) {
		var url = objectToUrl(snd, "/sound/get");
		getSound(url, snd);
	}else{
		let vol=0;
		if (snd["fade"] != 0) {
			vol = 100 / snd["fade"];
		}
		intervalID = setInterval(soundVolumeDown, 500,vol/2);
	}
}
//получаем путь до музыки и включаем ее
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

			let vol=0;
			$(".audio").prop("volume", 1);
			if (snd["fade"] != 0) {
				$(".audio").prop("volume", 0);
				vol = 100 / snd["fade"];
			}
			$('audio').trigger("play");
			intervalID = setInterval(soundVolumeUp, 500,vol/2);

		}
	});
}
//увеличиваем громкость музыки
function soundVolumeUp(vol) {
	var volume = $(".audio").prop("volume") + vol / 100;
	if (volume > 1)
		volume = 1;
	console.log("Volume sound: "+volume);
	$(".audio").prop("volume", volume);
	if (volume == 1)
		clearInterval(intervalID);
}

//уменьшаем громкость и выключаем музыку
function soundVolumeDown(vol) {
	var volume = $(".audio").prop("volume") - vol / 100;
	if (volume < 0)
		volume = 0;
	console.log("Volume sound: "+volume);
	$(".audio").prop("volume", volume);
	if (volume == 0){
		clearInterval(intervalID);
		$('audio').trigger("stop");		
	}
}

//выводим сцену на экран
function addScene(scn) {
	console.log("add Scene");
	var url = "url(\"" + objectToUrl(scn, "/scene/get") + "\")";
	console.log(url);
	$(".background2").css("background-image", url);
}

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

// добавляем персонажа на экран
function addChar(chr) {
	console.log("add char");
	// alert(chr["type"]);
	var imageUrl = objectToUrl(chr, "/images/char");
	var div = `<img class="sprite ${chr["position"]} ${chr["name"]} ${chr["location"]}"  src="${imageUrl}">`;
	// если персонаж существует, заменить
	if ($("." + chr["name"]).length > 0) {
		$("." + chr["name"]).replaceWith(div);
	}
	// если до этого персонажа не было, просто добавить на экран
	else
		$(".sprites").append(div);
}

// получение пути к фону
// !!!!позже обновить до передачи параметров не в строке
function objectToUrl(obj, url) {
	var tempSrc = url + "?";
	for ( var i in obj) {
		tempSrc += i + "=" + obj[i] + "&";
	}
	tempSrc = tempSrc.substring(0, tempSrc.length - 1);
	return tempSrc;
}
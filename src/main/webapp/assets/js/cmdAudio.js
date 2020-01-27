// !!!!!!!!!!!!РАБОТА С АУДИО

// счетчики увеличения/уменьшения громкости звука
var intervalUp, intervalDown;
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

// получаем музыку
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
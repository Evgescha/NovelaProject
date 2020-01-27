// !!!!!!!!!!!!!!РАБОТА С ДИАЛОГОМ

// текущие позиции в тексте диалога
let dialogCount = 0;
let dialogCurrent = 0;

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
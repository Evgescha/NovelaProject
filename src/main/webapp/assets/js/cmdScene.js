// !!!!!!!!!!РАБОТА С ФОНОМ
// выводим сцену на экран
function addScene(scn) {
	console.log("add Scene");
	var url = "url(\"" + objectToUrl(scn, "/scene/get") + "\")";
	console.log(url);
	$(".background2").css("background-image", url);
	$(".sprite").remove();
}
// !!!!!!!!!!!!!РАБОТА С ДИАЛОГОВЫМ ОКНОМ
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
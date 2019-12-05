	//проходим каждый элемент json-массива
	let i = 0;
	//
	let dialogCount=0;
	let dialogCurrent=0;
	//кнопка дальше по сценарию 
	function next(){
		//если не завершили предыдущий диалог
		if(dialogCount>0){
			nextDialog(arr[i-1]);
			return;
		}
		var temp=arr[i];
	 	if(temp["type"]=="char")addChar(temp);
	 	if(temp["type"]=="dialog")addDialog(temp);
	 	
	
		i++;
	}
	
	
	//начать вывод диалога на экран
	function addDialog(dlg){
		console.log("add dialog");
		dialogCount=dlg["text"].length;
		dialogCurrent=0;
		$(".textAuthor").text(dlg["name"]);
		var text = dlg["text"];
		console.log(text);
		$(".textContent").text(text[dialogCurrent]);
		dialogCount--;		
		dialogCurrent++;
	}
	//продолжить вывод диалога, если он состоит более чем из одной части
	function nextDialog(dlg){
		console.log("next dialog");
		var text = dlg["text"];
		console.log(dialogCurrent);
		console.log(dialogCurrent);
		$(".textContent").text($(".textContent").text()+text[dialogCurrent]);
		dialogCount--;
		dialogCurrent++;
	}
	
	//добавляем персонажа на экран
	function addChar(chr){
		console.log("add char");
// 		alert(chr["type"]);
		var imageUrl=chrToImage(chr);	
		var div = `<img class="sprite ${chr["position"]} ${chr["name"]} ${chr["location"]}"  src="${imageUrl}">`;
		// если персонаж существует, заменить
		if($("."+chr["name"]).length>0) {
			$("."+chr["name"]).replaceWith(div);
		}
		//если до этого персонажа не было, просто добавить на экран
		else $(".sprites").append(div);
	}

	
	//получаем изображение персонажа по прямой ссылке, преобразуя поля json в запрос на сервер
	//!!!!!позже обновить до метода через скрытые параметры
	function chrToImage(chr){
		var tempSrc="/images/char?";
		for (var i in chr) {
			tempSrc+=i +"="+chr[i]+"&";
	    }
		tempSrc=tempSrc.substring(0, tempSrc.length - 1)
		return tempSrc;
	}
	
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!JUMP
function jump(jmp){
	console.log("Go to label: "+jmp["label"]);
	document.location.href ="/runGame?gameName=summer&labelName="+jmp["label"];
}
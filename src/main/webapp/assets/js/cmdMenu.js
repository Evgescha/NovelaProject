//переменная, хранящая действия при выборе пунктов меню
var menus;

function menu(mn){
    console.log("add menu");
    menus = mn;
    var menuFront = $(".menuChoose");
    var liS = "";
    for(let j=0; j<mn.items.length;j++){
        liS+="<li onclick='menuItem("+j+")'>"+mn.items[j].choose+"</li>"
    }
    menuFront.html(liS);
    $(".menu").css("display","block");
    
}

function menuItem(index){
    arr= arr.slice(i);
    i=0;
    console.log(arr);
    arr=menus.items[index].commands.concat(arr);
    $(".menu").css("display","none");
    $(".window").removeClass("hide").addClass("show");
}
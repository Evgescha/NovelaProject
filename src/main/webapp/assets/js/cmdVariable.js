// !!!!!!!!!!!!!!!!!!!!РАБОТА С ПЕРЕМЕННЫМИ
// массив переменных
var variables = new Map();

// чтение переменных
function addVariable(vrbl) {
	console.log("Add variable " + vrbl["key"] + ":" + vrbl["value"]);
	variables.set(vrbl["key"], vrbl["value"]);
}
// изменение переменной на заданное значение
function updateNumericVariable(key, value) {
	console.log("Update variable " + key + ", old:" + variables[key] + ", add:"
			+ value);
	var val = variables.get(key);
	val = Number.parseInt(val); // Теперь будет числом
	variables.set(key, val + value);
	console.log("new value: " + variables.get(key));
	// if (val.match(/^\d+$/)) {
	// }
}
// изменение не числовых переменных
function updateNonNumericVariable(key, value) {
	console.log("Update variable " + key + ", old:" + variables[key] + ", to:"
			+ value);
	variables.set(key, value);
	console.log("new value: " + variables.get(key));
}

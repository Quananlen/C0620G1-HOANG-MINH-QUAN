function openbracket(){
    let result = document.getElementById('result');
    result.innerText += "(";
}
function closebracket(){
    let result = document.getElementById('result');
    result.innerText += ")";
}
function modulus(){
    let result = document.getElementById('result');
    result.innerText += "%";
}
function reset(){
    let result = document.getElementById('result');
    result.innerText = "";
}
function seven() {
    let result = document.getElementById('result');
    result.innerText += "7";
}
function eight() {
    let result = document.getElementById('result');
    result.innerText += "8";
}
function nine() {
    let result = document.getElementById('result');
    result.innerText += "9";
}
function divide() {
    let result = document.getElementById('result');
    result.innerText += "/";
}
function four() {
    let result = document.getElementById('result');
    result.innerText += "4";
}
function five() {
    let result = document.getElementById('result');
    result.innerText += "5";
}
function six() {
    let result = document.getElementById('result');
    result.innerText += "6";
}
function multi() {
    let result = document.getElementById('result');
    result.innerText += "*";
}
function one() {
    let result = document.getElementById('result');
    result.innerText += "1";
}
function two() {
    let result = document.getElementById('result');
    result.innerText += "2";
}
function three() {
    let result = document.getElementById('result');
    result.innerText += "3";
}
function minus() {
    let result = document.getElementById('result');
    result.innerText += "-";
}
function zero() {
    let result = document.getElementById('result');
    result.innerText += "0";
}
function dot() {
    let result = document.getElementById('result');
    result.innerText += ".";
}
function equal() {
    let result = document.getElementById('result').innerText;
    let temp = result.substring(0);
    temp = eval(temp);
    document.getElementById('result').innerText = temp;
}
function plus() {
    let result = document.getElementById('result');
    result.innerText += "+";
}
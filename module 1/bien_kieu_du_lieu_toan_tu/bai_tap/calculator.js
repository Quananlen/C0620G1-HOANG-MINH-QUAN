function addition() {
    let first = parseInt(document.getElementById('first-num').value);
    let second = parseInt(document.getElementById('second-num').value);
    let total = first + second;
    document.getElementById('result').innerText = 'Result Addition: ' + total;
}
function subtraction() {
    let first = parseInt(document.getElementById('first-num').value);
    let second = parseInt(document.getElementById('second-num').value);
    let result = first - second;
    document.getElementById('result').innerText = 'Result Subtraction: ' + result;
}
function multiplication() {
    let first = parseInt(document.getElementById('first-num').value);
    let second = parseInt(document.getElementById('second-num').value);
    let result = first * second;
    document.getElementById('result').innerText = 'Result Multiplication: ' + result;
}
function divide() {
    let first = parseInt(document.getElementById('first-num').value);
    let second = parseInt(document.getElementById('second-num').value);
    let result = first / second;
    document.getElementById('result').innerText = 'Result Division: ' + result;
}
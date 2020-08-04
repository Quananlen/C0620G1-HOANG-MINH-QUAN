function converter() {
    // variable for calculation
    let usd = 1;
    let vnd = 23000;
    let eur = 0.89;
    let yen = 108;
    let num1;
    let num2;

    // chọn 3 id bên html
    let amount = document.getElementById('amount').value;
    let from = document.getElementById('from');
    let to = document.getElementById('to');

    // lấy value từ from và to để xác định cặp tiền
    let fromValue = from[from.selectedIndex].value;
    let toValue = to[to.selectedIndex].value;
    switch (fromValue) {
        case 'vnd': num1 = vnd; break;
        case 'usd': num1 = usd; break;
        case 'eur': num1 = eur; break;
        case 'yen': num1 = yen;
    }
    switch (toValue) {
        case 'vnd': num2 = vnd; break;
        case 'usd': num2 = usd; break;
        case 'eur': num2 = eur; break;
        case 'yen': num2 = yen;
    }

    // tính toán
    let result = amount * (num2/num1);
    document.getElementById('result').innerText = 'Result: ' + result.toLocaleString();
}


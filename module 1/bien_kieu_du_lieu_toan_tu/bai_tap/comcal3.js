function input() {
    let divId = event.srcElement.id;
    switch (divId) {
        case 'clear': document.getElementById('result').innerText = ""; break
        case 'equal':
        {
            let equal = document.getElementById('result').innerText;
            let temp = eval(equal);
            document.getElementById('result').innerText = temp;
        }; break
        default: document.getElementById('result').innerText += divId;
    }
}
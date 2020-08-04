function input() {
    let idOfDiv = event.srcElement.id;
    let result = document.getElementById('result');
    switch (idOfDiv) {
        case 'open': result.innerText += '('; break
        case 'close': result.innerText += ')'; break
        case 'mod': result.innerText += '%'; break
        case 'clear': result.innerText =""; break
        case 'seven': result.innerText += 7; break
        case 'eight': result.innerText += 8; break
        case 'nine': result.innerText += 9; break
        case 'divide': result.innerText += '/'; break
        case 'four': result.innerText += 4; break
        case 'five': result.innerText += 5; break
        case 'six': result.innerText += 6; break
        case 'multi': result.innerText += '*'; break
        case 'one': result.innerText += 1; break
        case 'two': result.innerText += 2; break
        case 'three': result.innerText += 3; break
        case 'minus': result.innerText += '-'; break
        case 'zero': result.innerText += 0; break
        case 'dot': result.innerText += '.'; break
        case 'equal':
        {
            let equal = document.getElementById('result').innerText;
            let temp = equal.substring(0);
            temp = eval(temp);
            document.getElementById('result').innerText = temp;
        }; break
        case 'plus': result.innerText += '+'; break
    }
}
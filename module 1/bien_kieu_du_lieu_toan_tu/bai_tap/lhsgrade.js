let inputl = prompt('Điểm lí là: ');
let inputh = prompt('Điểm hoá là: ');
let inputs = prompt('Điểm sinh là: ');

let l = parseFloat(inputl);
let h = parseFloat(inputh);
let s = parseFloat(inputs);

let total = l + h + s;

document.write('Tổng điểm là: ' + total);
document.write('<br>');
document.write('Điểm trung bình là: ' + total/3);
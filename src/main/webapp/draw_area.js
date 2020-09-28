alert("HBF");
let canvas = document.getElementById('area');
let context = canvas.getContext('2d');
context.fillStyle = "bisque";
context.fillRect(0, 0, canvas.width, canvas.height);
//Прямоугольник
context.fillStyle = "cadetblue";
context.fillRect(50, 150, 100, 100);
//Треугольник
context.beginPath();
context.moveTo(150, 150);
context.lineTo(200, 150);
context.lineTo(150, 200);
context.closePath();
context.fill();
//Сектор
context.beginPath();
context.moveTo(150,150);
context.lineTo(100,150);
context.arc(150, 150, 50,  Math.PI, -Math.PI/2, false);
context.closePath();
context.fill();

context.beginPath();
context.moveTo(0, 150);
context.lineTo(300, 150);
context.moveTo(150, 0);
context.lineTo(150, 300);
context.moveTo(150, 0);
context.lineTo(145, 15);
context.moveTo(150, 0);
context.lineTo(155, 15);
context.moveTo(300, 150);
context.lineTo(285, 145);
context.moveTo(300, 150);
context.lineTo(285, 155);

context.moveTo(145, 50);
context.lineTo(155, 50);
context.moveTo(145, 100);
context.lineTo(155, 100);
context.moveTo(145, 200);
context.lineTo(155, 200);
context.moveTo(145, 250);
context.lineTo(155, 250);
context.moveTo(50, 145);
context.lineTo(50, 155);
context.moveTo(100, 145);
context.lineTo(100, 155);
context.moveTo(200, 145);
context.lineTo(200, 155);
context.moveTo(250, 145);
context.lineTo(250, 155);
context.stroke();
//Текст
context.fillStyle = "black";
context.font = "10pt Arial";
context.fillText("Y",160,15);
context.fillText("R",160,55);
context.fillText("R/2",160,105);
context.fillText("-R/2",160,205);
context.fillText("-R",160,255);
context.fillText("X",285,140);
context.fillText("R/2",195,140);
context.fillText("R",245,140);
context.fillText("-R",45,140);
context.fillText("-R/2",95,140);
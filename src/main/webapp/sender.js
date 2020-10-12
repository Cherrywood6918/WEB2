function sendRequest(x,y,r,flag) {
    $.ajax({
        method: "GET",
        url: "/web2-1.0-SNAPSHOT/controller?coordinateX=" + x + "&coordinateY="
            + y + "&radius=" + r + "&flag=" + flag,
    }).done(function (data) {
        console.log(toTable(data));
        $(".table-data tbody").append(toTable(data));
    });
}

function toTable(data) {
    let x =  toDouble(data.x);
    let y = toDouble(data.y);
    let r =  toDouble(data.r);
    let date = new Date(data.date);
    let time = toTime(date.getHours()) + ":" + toTime(date.getMinutes()) + ":" + toTime(date.getSeconds());
    let res = data.res;
    toDouble(x);
    point_draw(x,y,r,res);
    return "<tr><td>" + x + "</td><td>" + y + "</td><td>" + r + "</td><td>" + time + "</td><td>" + res + "</td></tr>";
}

function toDouble(num) {
    return (num - Math.trunc(num)) === 0? (num + ".0") : num;
}
 function toTime(time) {
     return (time <= 9)? ("0" + time) : time;
 }
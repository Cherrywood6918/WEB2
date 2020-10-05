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
    let x = data.x;
    let y = data.y;
    let r = data.r;
    let date = new Date(data.date);
    let time = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
    let res = data.res;
    point_draw(x,y,r,res);
    return "<tr><td>" + x + "</td><td>" + y + "</td><td>" + r + "</td><td>" + time + "</td><td>" + res + "</td></tr>";
}
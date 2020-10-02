function sendRequest(x,y,r,flag) {
    $.ajax({
        method: "GET",
        url: "/web2-1.0-SNAPSHOT/controller?coordinateX=" + x + "&coordinateY="
            + y + "&radius=" + r + "&flag=" + flag,
    }).done(function (data) {
        console.log(data);
        console.log(toTable(data));
        $(".table-data tbody").append(toTable(data));
        point_draw();
    });
}

function toTable(data) {
    let x = data.x;
    let y = data.y;
    let r = data.r;
    let date = data.date;
    let res = data.res;
    return "<tr><td>" + x + "</td><td>" + y + "</td><td>" + r + "</td><td>" + date + "</td><td>" + res + "</td></tr>";
}
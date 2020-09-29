function sendRequest(x,y,r,flag) {
    $.ajax({
        method: "GET",
        url: "/web2-1.0-SNAPSHOT/controller?coordinateX=" + x + "&coordinateY="
            + y + "&radius=" + r + "&flag=" + flag,
    }).done(function (data) {
        console.log(data);
        $(".table-data tbody").append(data);
        point_draw();
    });
}
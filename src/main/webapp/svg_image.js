$(document).ready(function () {
    point_draw()
});


function show_coords(event) {
    if (validateR()) {
        let rect = event.currentTarget.getBoundingClientRect();
        let x = event.clientX - rect.left;
        let y = event.clientY - rect.top;
        let r = $("#field_R").val();
        let basis = 100 / r;
        let cx = ((x - 150) / basis);
        let cy = ((150 - y) / basis);
        console.log("X coords: " + x + ", Y coords: " + y + ",R: " + basis);
        console.log("X coords: " + cx + ", Y coords: " + cy);
        sendRequest(cx, cy, r, "canvas");

    }
}

function point_draw() {
    let data = Array();
    $("table tbody tr").each(function(i){
        data[i] = Array();
        $(this).children('td').each(function(j){
            data[i][j] = $(this).text();
        });
    });

    data.forEach(function (value, index, array) {
        let cx = array[index][0];
        let cy = array[index][1];
        let r = array[index][2];
        let flag = array[index][4];

        let canvas = document.getElementById('area');
        let context = canvas.getContext('2d');
        let x = cx * 100 / r + 150;
        let y = 150 - cy * 100 / r;
        if (flag === "True") context.fillStyle = "green";
        if (flag === "False") context.fillStyle = "red";
        context.beginPath();
        context.arc(x, y, 2, 0, Math.PI * 2, false);
        context.fill();
        context.stroke();
    });
}
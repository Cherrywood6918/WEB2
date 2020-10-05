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

function point_draw(x_value, y_value, r, flag) {
        let canvas = document.getElementById('area');
        let context = canvas.getContext('2d');
        let x = x_value * 100 / r + 150;
        let y = 150 - y_value * 100 / r;
        if (flag) context.fillStyle = "green";
        if (!flag) context.fillStyle = "red";
        context.beginPath();
        context.arc(x, y, 2, 0, Math.PI * 2, false);
        context.fill();
        context.stroke();
}
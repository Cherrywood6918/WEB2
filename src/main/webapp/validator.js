"use strict";

function validateY() {
    let y = $('#field_Y').val().match(/^[0-4][,|.]\d+$|^-[0-3][,.]\d+$|^[0-5]$|^-[0-3]$/);
    if (y == null || y[0] === "-0") {
        $('#field_Y').addClass('input-invalid');
        return false;
    } else {
        $('#field_Y').removeClass();
        return true;
    }

}

function validateR() {
    let r = $('#field_R').val().match(/^(([2-4][,|.]\d+)|[2-5])$/);
    if (r == null) {
        $('#field_R').addClass('input-invalid');
        return false;
    } else {
        $('#field_R').removeClass();
        return true;
    }
}

function checkButton() {
    return validateY() & validateR();
}

$(document).ready(function () {
    $("form").submit(function (event) {
        event.preventDefault();
        if(checkButton()){
            const x = $('#field_X').val().replace(',', '.');
            const y = $('#field_Y').val().replace(',', '.');
            const r = $('#field_R').val().replace(',', '.');
            sendRequest(x,y,r, "button");
        }
    });
});




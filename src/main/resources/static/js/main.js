function switchDisable() {
    if (arguments.length > 1) {
        for (let i = 1; i < arguments.length; i++) {
            switchDisable(arguments[i]);
        }
    }

    let id = arguments[0];

    if ($("#"+id).hasClass("disabler")) {
        $("#"+id).removeClass("disabler");
    } else {
        $("#"+id).addClass("disabler");
    }
}

function ajaxSender(path, formID, tableID) {
    $.ajax({
        url:     path,
        type:     "POST", //метод отправки
        dataType: "html", //формат данных
        data: $("#"+formID).serialize(),  // Сеарилизуем объект
        success: function(response, textStatus, xhr) { //Данные отправлены успешно
            if (tableID != "") {

            } else {
                alert("Ответ от сервера: " + response.text);
            }

        },
        error: function(response, textStatus, xhr) { // Данные не отправлены
            alert("Код ошибки: " + response.status + "\n"
            + "Ответ от сервера: " + response.responseText);
        }
    });
}
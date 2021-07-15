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

function ajaxSender(path, formID, outputID) {
    $.ajax({
        url:     path,
        type:     "POST", //метод отправки
        dataType: "html", //формат данных
        data: $(formID).serialize(),  // Сеарилизуем объект
        success: function(response, textStatus, xhr) { //Данные отправлены успешно
            if (outputID != null) {
                $(outputID).empty();
                $(outputID).append(response);
            } else {
                alert("Ответ от сервера: " + response);
            }

        },
        error: function(response, textStatus, xhr) { // Данные не отправлены
            alert("Код ошибки: " + response.status + "\n"
            + "Ответ от сервера: " + response.responseText);
        }
    });
}

function requestDelete(id, confirmarion) {
    if (!confirmarion) {
        return;
    }
    $.ajax({
        url:     "/requestDelete",
        type:     "POST", //метод отправки
        dataType: "html", //формат данных
        data: {"id": id},  // Сеарилизуем объект
        success: function(response, textStatus, xhr) { //Данные отправлены успешно
            alert("Ответ от сервера: " + response);
            ajaxSender('/requestNotes', '#searchNotes', '#tableOutput');
        },
        error: function(response, textStatus, xhr) { // Данные не отправлены
            alert("Код ошибки: " + response.status + "\n"
            + "Ответ от сервера: " + response.responseText);
        }
    });

}
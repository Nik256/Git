function validateForm() {
    if ($('#password').val() != $('#confirm-password').val()) {
        $("#msg").text("Пароли не совпадают");
        return false;
    }
}

function validateFlight() {
    if ($('#departure').val() >= $('#arrival').val()) {
        $("#msg").text("Дата указана неправильно");
        return false;
    }
    if ($('#from').val() == $('#to').val()) {
        $("#msg").text("Указан один и тот же аэропорт");
        return false;
    }
}
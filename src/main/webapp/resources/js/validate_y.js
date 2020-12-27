function selectY(checkBox, value) {
    let boxes = document.getElementsByClassName("y-box");
    for (let box of boxes) {
        box.checked = false;
    }
    checkBox.checked = true;
    document.getElementById("computation-form:y").value = value;
}
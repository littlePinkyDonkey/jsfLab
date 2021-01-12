function selectY(checkBox, value) {
    let count = 0;
    let boxes = document.getElementsByClassName("y-box");
    for (let box of boxes) {
        if (box.checked === true) {
            count++;
        }
        box.checked = false;
    }
    if (count > 0) {
        document.getElementById("warning-container-Y").innerText = "";
    }
    checkBox.checked = true;
    document.getElementById("computation-form:y").value = value;
}

window.onload = () => {
    let count = 0;
    let boxes = document.getElementsByClassName("y-box");
    for (let box of boxes) {
        if (box.checked === true) {
            count++;
        }
    }
    if (count > 0) {
        document.getElementById("warning-container-Y").innerText = "";
    }
};
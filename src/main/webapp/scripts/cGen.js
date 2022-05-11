const generateChart = (wealth, debt) => {
    let stats = [
    ];
    let xhr = new XMLHttpRequest();
    stats.push({"debt": debt, "wealth": wealth});
    let image = document.getElementById("captchaImg2");
    image.classList.add("invisible");
    xhr.open("POST", "cGenerator", true);
    xhr.responseType = "arraybuffer";
    xhr.setRequestHeader("Content-type", "image/png");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            image.classList.remove("invisible");
            image.setAttribute('src', 'data:image/png;base64,' + btoa(String.fromCharCode.apply(null, new Uint8Array(xhr.response))));
            console.log(xhr.response);
        }
    }
    xhr.send(JSON.stringify(stats));
}

const removeTool = id => {
    let el = document.getElementById(id);
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "cRemover", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            console.log("removed");
            el.parentNode.removeChild(el);
        }
    }
    xhr.send(id);
}


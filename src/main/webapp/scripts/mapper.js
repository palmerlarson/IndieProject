//json array
let worth = [
];

//adds to json arr and
const addToArray = () => {
    let name = document.querySelector("#name").value;
    let amount = document.querySelector("#amount").value;
    let type = document.querySelector("#type").value;
    let displayList = document.querySelector(".list");
    let debtT = document.querySelector(".debtT");
    let wealthT = document.querySelector(".wealthT");
    let totalW = Number(document.querySelector(".monthly").textContent);
    let totalD = 0;

    //error checking
    if (name == null || amount == null) {
        alert("You must enter values for both fields");
    } else {
        worth.push({"name": name, "amount": amount, "type": type});
    }

    //display
    if (type === "wealth") {
        displayList.innerHTML += `<li id='${name}'><button id="btnStatus" class="btn" 
        onclick="deleteItem('${name}')"><i class="fa-solid fa-trash text-lg"></i></button><span> ${name}</span> - <span class="text-lime-500">$ ${amount}</span></li>`;
    } else {
        displayList.innerHTML += `<li id='${name}'><button id="btnStatus" class="btn" 
        onclick="deleteItem('${name}')"><i class="fa-solid fa-trash text-lg"></i></button><span> ${name}</span> - <span class="text-rose-600">$ ${amount}</span></li>`;
    }

    //total display
    for (let x in worth) {
        if (worth[x].type === "debt") {
            totalD += Number(worth[x].amount);
        } else {
            totalW += Number(worth[x].amount);
        }
    }

    debtT.innerHTML = `Debt: $${totalD}`;
    wealthT.innerHTML = `Wealth: $${totalW}`;

}
//deletes item from json arr
const deleteItem = item => {
    let listItem = document.getElementById(item);
    listItem.parentNode.removeChild(listItem);

    const indexOfObject = worth.findIndex(object => {
        return object.name === `${item}`;
    });

    worth.splice(indexOfObject, 1);

    console.log(worth);
}

//sends the json arr to servlet
//https://stackoverflow.com/questions/42924898/when-trying-to-put-the-image-png-response-of-an-xmlhttprequest-i-am-getting-garb
const submit = () => {
    let imgDiv = document.querySelector(".imgOutput");
    let image = document.getElementById("captchaImg");
    let configBtn = document.querySelector(".configBtn");
    let tips = document.querySelector(".tips");
    imgDiv.classList.add("invisible")
    image.classList.add("invisible");
    tips.classList.add("invisible");
    configBtn.classList.add("hidden");
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "wealthMapper", true);
    xhr.responseType = "arraybuffer";
    xhr.setRequestHeader("Content-type", "image/png");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            image.classList.remove("invisible");
            imgDiv.classList.remove("invisible");
            tips.classList.remove("invisible");
            configBtn.classList.remove("hidden");
            image.setAttribute('src', 'data:image/png;base64,' + btoa(String.fromCharCode.apply(null, new Uint8Array(xhr.response))));
            console.log(xhr.response);
        }
    }
    xhr.send(JSON.stringify(worth));
}

//saves the chart params to rdb
const save = () => {
    let saveBtn = document.querySelector(".saveBtn");
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "graphs", true);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            console.log("saved");
            saveBtn.parentNode.removeChild(saveBtn);
        }
    }
    xhr.send(JSON.stringify(worth));
}

//locks up button
const btn = document.querySelector(".infoBtn");
btn.addEventListener("click", function() {
    let div = document.querySelector(".infoDiv");
    btn.disabled = true;
    div.innerHTML += `<h3 class="text-red-600">Your information has been updated</h3>`;
});
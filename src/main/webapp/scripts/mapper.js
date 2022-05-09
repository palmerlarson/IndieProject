let worth = [
];

//adds to json arr and
const addToArray = () => {
    let name = document.querySelector("#name").value;
    let amount = document.querySelector("#amount").value;
    let type = document.querySelector("#type").value;
    let displayList = document.querySelector(".list");

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


    console.log(worth);
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
    let xhr = new XMLHttpRequest();
    let image = document.getElementById("captchaImg");
    xhr.open("POST", "wealthMapper", true);
    xhr.responseType = "arraybuffer";
    xhr.setRequestHeader("Content-type", "image/png");
    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            image.classList.remove("invisible");
            image.setAttribute('src', 'data:image/png;base64,' + btoa(String.fromCharCode.apply(null, new Uint8Array(xhr.response))));
            console.log(xhr.response)
        }
    }
    xhr.send(JSON.stringify(worth));
}

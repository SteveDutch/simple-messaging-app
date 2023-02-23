// TODO refactor - mehr Funktionen für die Übersichtlichkeit und maintenance -alle JS-Files
let sentMessage;
let chat = document.getElementById("chat");

let userMessage = {};

console.log(
  sessionStorage.getItem("user") +
    "    printed from beginning of channel.js line 1"
);

let user = sessionStorage.getItem("user");
if (user == null) {
  /*   XXX Note: The difference between href and replace, is that replace() removes the URL of the current document from the document history, meaning that it is not possible to use the "back" button to navigate back to the original document. Thanks to w3school*/
  location.replace("http://127.0.0.1:8080/welcome");
}
document.getElementById("username").innerHTML = user;

let submitBtn = document.getElementById("submit");
submitBtn.addEventListener("click", function () {
  console.log("hooray! submit was clicked");
  enterMessage();
});

let messageField = document.getElementById("message");
messageField.addEventListener("keypress", function (event) {
  if (event.key === "Enter") {
    console.log("hooray! enterkey pressed");
    enterMessage();
  }
});

function enterMessage () {
  sentMessage = document.getElementById("message").value;
  console.log("gesendet: " + sentMessage);
  document.getElementById("message").value = "";
  // would put message into chat:
  //chat.innerHTML += '<br>' + user + '   :   ' + sentMessage;
  userMessage.messageText =sentMessage; 
  userMessage.user = sessionStorage.getItem("user");
  console.log(userMessage);
  console.log("als JSON:  " + JSON.stringify(userMessage));
  messageToJava();
}

function messageToJava() {
  fetch(`http://127.0.0.1:8080/channel`, {
    method: "POST",
    headers: {
      "Access-Control-Allow-Origin": "http://127.0.0.1:8080",
      //mode: "no-cors", nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      "Content-Type": "application/json",
    },
    body: JSON.stringify(userMessage),
  });
}

setInterval(getLast10MessagesFromServer, 500)
function getLast10MessagesFromServer() {
fetch("http://127.0.0.1:8080/channel/messages", {
  method: "GET",
  headers: {
    "Access-Control-Allow-Origin": "http://127.0.0.1:8080",
    //mode: "no-cors", nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
    "Content-Type": "application/json",
  },
}) // chtGPL
  .then((response) => response.json())
  .then((data) => {
    let html = "";
    data.forEach((item) => {
      html += `${item.username}: ${item.messageText}<br>`;
    });
    document.querySelector("#chat").innerHTML = html;
  })
  .catch((error) => {
    console.error(error);
  });
}
/* HOW IZ IS WORKING
let submitBtn = document.getElementById("submit");
submitBtn.addEventListener("click", function() {
    let textareaValue = document.getElementById("textarea").value;
     
    console.log(textareaValue);
    
}); */

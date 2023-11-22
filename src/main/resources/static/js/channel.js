// TODO refactor - mehr Funktionen für die Übersichtlichkeit und maintenance -alle JS-Files

const user = sessionStorage.getItem("user");
if (user == null) {
  /*   XXX Note: The difference between href and replace, 
	is that replace() removes the URL of the current document 
	from the document history, meaning that it is not possible 
	to use the 'back' button to navigate back to the original document. Thanks to w3school*/
  location.replace("http://localhost:8080/welcome");
}

document.getElementById("username").innerHTML = user;

const submitBtn = document.getElementById("submit");
submitBtn.addEventListener("click", function () {
  console.log("hooray! submit was clicked");
  enterMessage();
});

const messageField = document.getElementById("message");

messageField.addEventListener("keydown", function (event) {
  if (event.key === "Enter") {
    event.preventDefault();
    console.log("hooray! enterkey pressed");
    enterMessage();
  }
});

function enterMessage() {
  const chat = document.getElementById("chat");
  const userMessage = {};
  const sentMessage = document.getElementById("message").value;
  if (sentMessage === "" || sentMessage === null) {
  } else {
    console.log("gesendet: " + sentMessage);
    document.getElementById("message").value = "";
    // would put message into chat:
    // chat.innerHTML += '<br>' + user + '   :   ' + sentMessage;
    userMessage.messageText = sentMessage;
    userMessage.user = sessionStorage.getItem("user");
    console.log(userMessage);
    console.log("als JSON:  " + JSON.stringify(userMessage));
    messageToJava(userMessage);
  }
}

function messageToJava(userMessage) {
  fetch(`http://localhost:8080/channel`, {
    method: "POST",
    headers: {
      "Access-Control-Allow-Origin": "http://localhost:8080",
      /*	 nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen,
			die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
			but seems to cause trouble if missing at other computers or 
			maybe esp. at macs */
      mode: "no-cors",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(userMessage),
  });
}

setInterval(getLast10MessagesFromServer, 500);
function getLast10MessagesFromServer() {
  fetch("http://localhost:8080/channel/messages", {
    method: "GET",
    headers: {
      "Access-Control-Allow-Origin": "http://localhost:8080",
      //mode: 'no-cors', nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      let html = "";
      data.forEach((item) => {
        html += `<br><b>${item.username}:</b> ${item.messageText}`;
      });
      document.querySelector("#chat").innerHTML = html;
    })
    .catch((error) => {
      console.error(error);
    });
}

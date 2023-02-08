// TODO refactor - mehr Funktionen für die Übersichtlichkeit und maintenance -alle JS-Files
let sentMessage;
let chat = document.getElementById("chat");

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
  // code to be executed when button is clicked
  console.log("hooray! clicked");
  sentMessage = document.getElementById("message").value;
  console.log("gesendet: " + sentMessage);
  // document.getElementById("chat").innerHTML = sentMessage;
  document.getElementById("message").value = "";
  let addText = document.createTextNode(sentMessage);
  // chat.appendChild(addText);
  chat.innerHTML += '<br>' + sentMessage;
  messageToJava();
})

  let messageField = document.getElementById("message");
  messageField.addEventListener('keypress', function (event) {
    if (event.key === "Enter") {
      console.log("hooray! enterkey pressed");
      sentMessage = document.getElementById("message").value;
      console.log("gesendet: " + sentMessage);
      // document.getElementById("chat").innerHTML = sentMessage;
      document.getElementById("message").value = "";
      let addText = document.createTextNode(sentMessage);
      // chat.appendChild(addText);
      chat.innerHTML += '<br>' + sentMessage;
      messageToJava();
    
    }})

  function messageToJava () {  
  fetch(`http://127.0.0.1:8080/channel`, {
    method: "POST",
    headers: {
      "Access-Control-Allow-Origin": "http://127.0.0.1:8080",
      //mode: "no-cors", nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      "Content-Type": "application/json",
    },
    body: JSON.stringify(sentMessage),
  })};


/* HOW IZ IS WORKING
let submitBtn = document.getElementById("submit");
submitBtn.addEventListener("click", function() {
    let textareaValue = document.getElementById("textarea").value;
     
    console.log(textareaValue);
    
}); */

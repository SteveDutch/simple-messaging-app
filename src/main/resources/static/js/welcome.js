let start = Date.now(); 
console.log("her's SessionStorage-Inhalt:" + sessionStorage.getItem("user"));
// XXX theoretisch könnte ich hier auch null abfangen. Das tritt auf, wenn abgebrochen wird. 

document.addEventListener('DOMContentLoaded', () => {
  let username = document.getElementById('username').innerHTML;
  // let userId = document.querySelector("#userId")
  console.log(username + "1 / ");
  let user = {
    "username": username,
    //"userID": null
  }
  console.log("im fetch! " + user.username);
  fetch(`http://127.0.0.1:8080/welcome`, {
    method: "POST",
    headers: {
      
      "Access-Control-Allow-Origin": "http://127.0.0.1:8080",
      //mode: "no-cors", nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      "Content-Type": "application/json"
    },
    body: JSON.stringify(user)
  }
  )
// brauche ich nicht, weil ich keine Antwort brauch ;)
  /*         .then((response) => response.json())
  .then((data) => {
    console.log(data)
  }) */
})

// XXX theoretisch könnte ich hier auch null abfangen. Das tritt auf, wenn abgebrochen wird. 
    let user = prompt("Hei, velkommen! Hva er navnet ditt?", "mitt navn er: ");
      document.getElementById('username').innerHTML = user;
      // thanks to https://stackoverflow.com/questions/17616624/detect-if-string-contains-any-spaces#17616646
    if (/^ *$/.test(user)) {
        let user = prompt("Come on, enter your name", "nobody");
        if (/^ *$/.test(user)) {
            user = "nemo" + start.toString()/1000;
            document.getElementById('username').innerHTML = user;
        }    
        document.getElementById('username').innerHTML = user;
    };

  sessionStorage.setItem("user", user); 
    

console.log(user);
console.log(start);
console.log(sessionStorage.getItem("user"));

const start = Date.now();
let user = sessionStorage.getItem("user");

if (user == null) {
  user = newUser();
}

console.log("here's SessionStorage-Inhalt:" + sessionStorage.getItem("user"));

document.addEventListener("DOMContentLoaded", () => {
  let username = document.getElementById("username").innerHTML;

  console.log(username + "1 / ");
  let user = {
    username: username,
  };
  console.log("im fetch! " + user.username);
  fetch(`http://localhost:8080/welcome`, {
    method: "POST",
    headers: {
      "Access-Control-Allow-Origin": "http://locahost:8080",
      //mode: 'no-cors', nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      "Content-Type": "application/json",
    },
    body: JSON.stringify(user),
  });
  // brauche ich nicht, weil ich keine Antwort brauch ;)
  /*         .then((response) => response.json())
  .then((data) => {
    console.log(data)
  }) */
});

console.log(user);
console.log(start);
console.log("user = " + sessionStorage.getItem("user"));

/* functions */
function newUser() {
  while (!user) {
    user = prompt("Hei, velkommen! Hva er navnet ditt?", "mitt navn er: ");
  }
  displayUser(user);

  sessionStorage.setItem("user", user);
  return user;
}

function displayUser(user) {
  document.getElementById("username").innerHTML = user;
}

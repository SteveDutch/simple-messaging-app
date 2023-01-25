//alert("Hei, velkommen! Hva er navnet ditt?");
let start = Date.now(); 
console.log("her's seso:" + sessionStorage.getItem("user"));
// XXX theoretisch könnte ich hier auch null abfangen. Das tritt auf, wenn abgebrochen wird
    let user = prompt("Hei, velkommen! Hva er navnet ditt?", "mitt navn er");
      document.getElementById('username').innerHTML = user;
    if (user === "") {
        let user = prompt("Come on, enter your name", "nobody");
        if (user === "") {
            user = "nemo" + start.toString()/1000;
            document.getElementById('username').innerHTML = user;
        }    
        document.getElementById('username').innerHTML = user;
    };

  sessionStorage.setItem("user", user); 
    

console.log(user);
console.log(start);
console.log(sessionStorage.getItem("user"));

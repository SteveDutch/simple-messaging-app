let start = Date.now(); 
 
let user = sessionStorage.getItem('user');
displayUser(user);
if (sessionStorage.getItem('user') == null)   {
  user = newUser();
}


console.log('here\'s SessionStorage-Inhalt:' + sessionStorage.getItem('user'));

document.addEventListener('DOMContentLoaded', () => {
  let username = document.getElementById('username').innerHTML;
  //document.getElementById('username').innerHTML = user;

  console.log(username + '1 / ');
  let user = {
    'username': username,

  }
  console.log('im fetch! ' + user.username);
  fetch(`http://127.0.0.1:8080/welcome`, {
    method: 'POST',
    headers: {
      
      'Access-Control-Allow-Origin': 'http://127.0.0.1:8080',
      //mode: 'no-cors', nicht nötig, da fetch & a-c-a-o jetzt übereinstimmen, die abweichung localhost zu 127.0.0.1 war schon zuviel ;)
      'Content-Type': 'application/json'
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

   
console.log(user);
console.log(start);
console.log('user = ' + sessionStorage.getItem('user'));
function newUser() {
  let user = prompt('Hei, velkommen! Hva er navnet ditt?', 'mitt navn er: ');
  document.getElementById('username').innerHTML = user;
  // thanks to https://stackoverflow.com/questions/17616624/detect-if-string-contains-any-spaces#17616646
  if (/^ *$/.test(user)) {
    user = prompt('Come on, enter your name', 'nobody');
    //document.getElementById('username').innerHTML = user;
  }
    if (/^ *$/.test(user)) {
      user = 'nemo\'s epoch seconds' + start.toString() / 1000;
    }
   
  else if (user === null) {
    user = 'nobody\'s epoch seconds ' + start.toString() / 1000000;
  }
  displayUser(user);

  sessionStorage.setItem('user', user);
  return user;
}

function displayUser(user) {
  document.getElementById('username').innerHTML = user;
}


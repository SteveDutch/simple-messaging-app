console.log(sessionStorage.getItem('user'));

let user = sessionStorage.getItem('user');
if (user == null) {
  /*   XXX Note: The difference between href and replace, is that replace() removes the URL of the current document from the document history, meaning that it is not possible to use the "back" button to navigate back to the original document. Thanks to w3school*/
    location.replace("http://127.0.0.1:8080/welcome");
}
document.getElementById('username').innerHTML = user;

function myFunction() {
    location.replace("https://www.w3schools.com")
  }
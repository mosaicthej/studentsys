const usnmInp = document.querySelector('#username_inp');
const usnmDisplay = document.querySelector('#username_disp');
var	usernameStr = usnmInp.value;

usnmInp.addEventListener('input', function(e){
    usernameStr = e.target.value;
    if (usernameStr.length != 0){
        usnmDisplay.innerText = "Welcome! " + usernameStr;
    } else {usnmDisplay.innerHTML = "<br>";}
})
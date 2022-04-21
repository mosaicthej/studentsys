// JavaScript Document

const userGenderInp = document.querySelector('#genderInp');
var userGenderStr = userGenderInp.value;

userGenderInp.addEventListener("change",
    //							   userGenderListener);
    // userGenderListener:: event -> String
    event => {
        //	add your method here
        let g = event.target.value;
//        console.log("userGender changed!");
        console.log(g);
        userGenderStr = g;

    })

//console.log("userGender.js loaded");

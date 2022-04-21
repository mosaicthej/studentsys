// JavaScript Document
const userBdayInp = document.querySelector('#bdayInp');
const userZodiacDisp = document.querySelector('#zodiacDisp');
var userBdayStr = userBdayInp.value; // access bday by userBdayStr anywhere of script (defined after user changed it)
var userZodiacStr;
//console.log("js userBirthdayZodiac loaded");

var userLuckyZodiacJSON;

userBdayInp.addEventListener("change",
    // userBdayListener:: event -> String
    event => {
        // your additional handler here
        console.log("birthday changed!");
        let b = event.target.value;
        userBdayStr = b;
        userZodiacStr = dateStr_to_zodiac_sign(userBdayStr);
        userZodiacDisp.innerHTML = userZodiacStr;

        //		console.log("fetching luckyZodiac...");
        //  not accurate as fetchLuckyZodiac is async;
        fetchLuckyZodiac(userZodiacStr.toLowerCase()).then(userLuckyZodiacJSON => {
            console.log("got lucky zodiac!");
            console.log(userLuckyZodiacJSON);

            const luckyList = document.getElementById("luckyZodiac");
            luckyList.innerText = "";
            userLuckyZodiacJSON.newslist.forEach(({ type, content }) => {
                const luckyListItem = document.createElement("li");
                luckyListItem.innerText = `${type}: ${content}`;
                luckyList.appendChild(luckyListItem);

            })
        });
    });


// str_to_ymdArr:: String -> [Number]
function str_to_ymdArr(sDate) {
    let strArr = sDate.split("-");

    let strArrTointArr = (strArr, toNum = s => parseInt(s)) => strArr.map(toNum);

    return strArrTointArr(strArr);
}

// dateStr_to_zodiac_sign:: String -> [Number] -> String
function dateStr_to_zodiac_sign(dateStr) {
    const ymdArr = str_to_ymdArr(dateStr);
    const month = ymdArr[1];
    const day = ymdArr[2];

    //	alert(`d-t-zs called\n day = ${day}_${typeof day} and month = ${month}_${typeof month}\n you are ${zodiac_sign(day, month)}`); // making sure are numbers here;
    return zodiac_sign(day, month);
}


// JavaScript program to display astrological sign
// or Zodiac sign for given date of birth

// Function to calculate sum
// digits of n
// zodiac_sign :: (int, int) -> String
function zodiac_sign(day, month) {
    let astro_sign = "";

    // checks month and date within the
    // valid range of a specified zodiac
    if (month == 12) {

        if (day < 22)
            astro_sign = "Sagittarius";
        else
            astro_sign = "Capricorn";
    } else if (month == 1) {
        if (day < 20)
            astro_sign = "Capricorn";
        else
            astro_sign = "Aquarius";
    } else if (month == 2) {
        if (day < 19)
            astro_sign = "Aquarius";
        else
            astro_sign = "Pisces";
    } else if (month == 3) {
        if (day < 21)
            astro_sign = "Pisces";
        else
            astro_sign = "Aries";
    } else if (month == 4) {
        if (day < 20)
            astro_sign = "Aries";
        else
            astro_sign = "Taurus";
    } else if (month == 5) {
        if (day < 21)
            astro_sign = "Taurus";
        else
            astro_sign = "Gemini";
    } else if (month == 6) {
        if (day < 21)
            astro_sign = "Gemini";
        else
            astro_sign = "Cancer";
    } else if (month == 7) {
        if (day < 23)
            astro_sign = "Cancer";
        else
            astro_sign = "Leo";
    } else if (month == 8) {
        if (day < 23)
            astro_sign = "Leo";
        else
            astro_sign = "Virgo";
    } else if (month == 9) {
        if (day < 23)
            astro_sign = "Virgo";
        else
            astro_sign = "Libra";
    } else if (month == 10) {
        if (day < 23)
            astro_sign = "Libra";
        else
            astro_sign = "Scorpio";
    } else if (month == 11) {
        if (day < 22)
            astro_sign = "Scorpio";
        else
            astro_sign = "Sagittarius";
    }

    return astro_sign;
}

// wrap below inside datepicker change listener
//console.log("fetching luckyZodiac...");
//const userLuckyZodiacJSON = fetchLuckyZodiac(userZodiacStr);
//console.log("fetched luckyZodiac!!");
//console.log("%j",userLuckyZodiacJSON);


//function loadLuckyZodiac(zodiacJSON) {
//
//    let list = document.getElementById("luckyZodiac");
//    list.innerText = "";
//    zodiacJSON.newslist.forEach(({
//        type,
//        content
//    }) => {
//        let listItem = document.createElement("li");
//        listItem.innerText = `${type}: ${content}`;
//        list.appendChild(listItem);
//    });
//
//}

//const zodiacApiHttpUrl =  "http://api.tianapi.com/star/index?key=6292c8dc89486f84e435358844b69a4e&astro=";
//
//// fetchLuckyZodiac :: String -> JSON object
//async function fetchLuckyZodiac(zodiac_str) {
//	console.log("fetching luckyZodiac....");
//  try {
//	console.log("api requested: " + zodiacApiHttpUrl + zodiac_str);
//    const response = await fetch(zodiacApiHttpUrl + zodiac_str);
//	const body = await response.json();
//	return body;
//
////    const list = document.getElementById("luckyZodiac");
////    list.innerText = "";
////    body.newslist.forEach(({ type, content }) => {
////      const listItem = document.createElement("li");
////      listItem.innerText = `${type}: ${content}`;
////      list.appendChild(listItem);
////    });
////	  console.log("received lucky data!");
////	  return body;
//  } catch (err) {
//    console.error(err);
//  }
//}

// loadLuckyZodiac(userZodiacStr);// JavaScript Document

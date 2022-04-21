const zodiacApiHttpUrl =  "http://api.tianapi.com/star/index?key=6292c8dc89486f84e435358844b69a4e&astro=";

// fetchLuckyZodiac :: String -> JSON object
async function fetchLuckyZodiac(zodiac_str) {
    console.log("fetching luckyZodiac....");
    try {
        const response = await fetch(zodiacApiHttpUrl + zodiac_str);
        const body = await response.json();
//    const list = document.getElementById("luckyZodiac");
//    list.innerText = "";
//    body.newslist.forEach(({ type, content }) => {
//      const listItem = document.createElement("li");
//      listItem.innerText = `${type}: ${content}`;
//      list.appendChild(listItem);
//    });
        console.log("received lucky data!");
        return body;
    } catch (err) {
        console.error(err);
    }
}

// loadLuckyZodiac(userZodiacStr);// JavaScript Document
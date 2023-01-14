function sendMessage(id) {

    let input = document.getElementById(id.name).value
    if(input.substring(0,2) == "/r"){
        input = parseRoll(input.substring(2));
    }

    const request = new XMLHttpRequest();
    request.open("POST", "https://discordapp.com/api/webhooks/1063212486121234443/WnujW9t76JO5ogf-RUbhrjHlVerXMmsHYfJ2VD-R0rACP9DOOsYmemSqwp1TbdPJy2bW");
    request.setRequestHeader('Content-type', 'application/json');
    const params = {
        username: "Steve the Helpful Pirate",
        avatar_url: "https://cdn-icons-png.flaticon.com/512/6545/6545894.png",
        content: input
    }

    request.send(JSON.stringify(params));

}

function sendMessageTo(id, target) {


    let input
    let url

    if(id.name != null){
        input = document.getElementById(id.name).value
    }else{
        input = document.getElementById(id.id).value
    }
    if(input == null){
        input = document.getElementById(id.id).innerHTML
    }

    if(target.name != null){
        url = document.getElementById(target.name).value
    }else{
        url = document.getElementById(target.id).value
    }
    if(url == null){
        url = document.getElementById(target.id).innerHTML
    }

    if(input.substring(0,2) == "/r"){
        input = parseRoll(input.substring(2));
    }

    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.setRequestHeader('Content-type', 'application/json');
    const params = {
        username: "Steve the Helpful Pirate",
        avatar_url: "https://cdn-icons-png.flaticon.com/512/6545/6545894.png",
        content: input
    }

    request.send(JSON.stringify(params));

}

function sendMultiMessageTo(idList, target) {

    console.log(idList);

    let input = ""
    let url

    idList.forEach(id => {
        input += document.getElementById(id.id).innerText + "\n"
    })

    if(target.name != null){
        url = document.getElementById(target.name).value
    }else{
        url = document.getElementById(target.id).value
    }
    if(url == null){
        url = document.getElementById(target.id).innerText
    }

    if(input.substring(0,2) == "/r"){
        input = parseRoll(input.substring(2));
    }

    const request = new XMLHttpRequest();
    request.open("POST", url);
    request.setRequestHeader('Content-type', 'application/json');
    const params = {
        username: "Steve the Helpful Pirate",
        avatar_url: "https://cdn-icons-png.flaticon.com/512/6545/6545894.png",
        content: input
    }

    request.send(JSON.stringify(params));

}

function parseRoll(input) {

    const set = input.split("&");

    let out = "Rolling: **"+input+"**\n";

    set.forEach(element => {

        let sum = 0;

        const list = element.split("+");

        list.forEach(element => {
            element.trim();

            list2 = element.split("d");
            let count = parseInt(list2[0], 10);

            if(Number.isNaN(count)){
                count = 1;
            }

            if(list2.length == 1){

            sum += count;
            out += count + ": " + count + ",\n"

            }else{

            let size = parseInt(list2[1], 10);
            let flag = "n"
            let fCount = 0;

            list3 = list2[1].split("k");
            if(list3.length > 1){
                flag = list3[1].substring(0,1);
                size = list3[0];
                fCount = parseInt(list3[1].substring(1));
            }

            let results = [];
            let rand = getRandom(count, size);
            let randList = rand.split("\n");

            for(let i = 0; i < count; i++){
                results.push(parseInt(randList[i]));
            }

            out += count + "d" + size;

            let i = 0

            if(flag == "h") {
                out += "kh" + fCount + ": "
                results.sort((a, b) => a < b ? 1 : a > b ? -1 : 0);
                for(i; i < fCount && i < count; i++){
                    out += results[i] + ", "
                    sum += results[i]
                }
                for(i; i < count; i++){
                    out += "~~" + results[i] +"~~, "
                    console.log(results[i])
                }

            }else if(flag == "l"){
                out += "kl" + fCount + ": "
                results.sort((a, b) => a < b ? -1 : a > b ? 1 : 0);
                for(let i = 0; i < fCount && i < count; i++){
                    out += results[i] + ", "
                    sum += results[i]
                }
                for(let i = fCount; i < count; i++){
                    out += "~~" + results[i] +"~~, "
                }

            }else{
                out += ": "
                for(i; i < results.length; i++){
                    out += results[i] + ", ";
                    sum += results[i]
                }
            }
            out += "\n";

    }

    });

    out += "Total: **" + sum +"**\n\n";

    });
    
    return out;
}

function getRandom(count, size)
{
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "https://www.random.org/integers/?num=" + count + "&min=1&max=" + size + "&col=1&base=10&format=plain&rnd=new", false); // false for synchronous request
    xmlHttp.send( null );
    return xmlHttp.responseText;
}
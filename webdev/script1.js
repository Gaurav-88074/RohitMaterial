window.onload = function() {
    // console.log("linked");
    document.getElementById("btn").addEventListener('click',(event)=>{
        let preValue = document.getElementById("value").innerText
        preValue = Number(preValue);
        preValue+=1;
        document.getElementById("value").innerText = preValue
    })
    
}
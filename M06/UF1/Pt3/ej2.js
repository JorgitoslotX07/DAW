let myWindow;

function openWin(ancho = 300, altura = 200) {
    myWindow = window.open("", "", "width=" + ancho + ",height=" + altura);
}

function closeWin() {
    myWindow.close();
}

function moveRandomWin() {
    randomWidth = Math.floor(Math.random() * screen.width);
    randomHeight = Math.floor(Math.random() * screen.height);

    console.log(randomWidth + " " + randomHeight);
    
    myWindow.moveTo(randomWidth, randomHeight);
}
function moveMyWindow() {
    openWin();
    setInterval(moveRandomWin, 1000);
    setTimeout(closeWin, 4000);
    
}

setTimeout(moveMyWindow, 5000);

window.onload = function() {
    openWin();
};

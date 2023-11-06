
function validacionNum() {

    var num = document.getElementById("num").value

    var numVal = parseInt(num, 10);
    // console.log(numVal );
    // console.log(typeof numVal )

    if (numVal) {
        if (numVal <= 0) {
            alert("El numero insertado no puede se negativo");
        }
        else {
            // console.log('ok')
            this.factorial(numVal);
        }
    }
    else {
        alert("El valor introducido deve ser un numero");
    }

}

function factorial(num) {
    var sumNum = num;
    var numFor = num
    for (var i = 1; i != numFor; i++) {
        num--;
        // console.log(sumNum , num, i);
        sumNum *= num;
    }
    // console.log(sumNum);
    var p = document.createElement("p");
    p.innerHTML = sumNum;

    document.body.appendChild(p);
}
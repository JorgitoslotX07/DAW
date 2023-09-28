var lista1 = [4,0,3,4,7,5,3,8,1,2,3,4,4,0,7,3,9,6,2,1]
 
let result = lista1.filter((valor,index)=>{
    console.log('item -> ' + valor);
    console.log('index -> ' +index);
    return lista1.indexOf(valor) === index;
})
console.log(result.sort(function(a,b){return a-b}));

function validarNumeroFlutuante(event, valor) {
    var digito = event.which;
    var quantidadePonto = valor.split(".").length - 1;
    if ((digito > 47 && digito < 58) || (digito === 8) || (digito === 0)){
        return true;
    } else if (digito === 46 && quantidadePonto === 0 ) {
        return true;
    }
    return false;    
}

function validarNumeroInteiro(event){
    var digito = event.which;

    if ((digito > 47 && digito < 58) || (digito === 8)){
        return true;
    }
    return false;
}
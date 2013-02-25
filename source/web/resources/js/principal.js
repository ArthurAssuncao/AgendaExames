$(document).ready(function () {
    $('#conteudo').slideDown('slow', function() {
        //animacao completa
    });
});
function add_atributo_form(formulario, elemento, atributo, valor){
    var campo = $("#" + formulario + "\\:" + elemento);
    campo.attr(atributo, valor);
}
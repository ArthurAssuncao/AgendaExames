$(document).ready(function () {
    //slide das paginas
    $('#conteudo').slideDown('slow', function() {
        //animacao completa
    });
    //ordenacao das tabelas
    $(".tabela_ordenada").tablesorter();
});
function add_atributo_form(formulario, elemento, atributo, valor){
    var campo = $("#" + formulario + "\\:" + elemento);
    campo.attr(atributo, valor);
}
function add_mascara_form(formulario, elemento, mascara){
    var campo = $("#" + formulario + "\\:" + elemento);
    campo.mask(mascara);
}
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {
    $("#pretaga").keyup(function () {
        var value = $(this).val();
        if (value != "")
            $.ajax({
                url: 'services/NadjiSobu?ime=' + value,
                data: {
                    ime: value
                },
                success: function (data) {
                    $('#info').empty();
                    $('#info').append(data);
                }
            });
    });
});
/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    var faculty = $('#faculty');
    var branch = $('#branch');
    var branchOptions = branch.children();

    faculty.on('change', function () {

        branchOptions.detach();
        branchOptions.filter(function () {
            return this.value.indexOf(faculty.val() + "-") === 0;
        }).appendTo(branch);

        branch.children("option:first").attr('selected', true);

        $("#faculty").val() == 0 ? $("#branch").attr("hidden", true) : $("#branch").attr("hidden", false)

    });

    $("#register-form, #login-form").submit(function (e) {
        e.preventDefault();
        this.submit();
    });

    var status = $('#status');
    status.on('change', function () {

        if ($("#status").val() == 'public') {
            $("#code").attr("hidden", true)
        }
        if ($("#status").val() == 'private') {
            $("#code").attr("hidden", false)
            var code = makeid(6);
            document.getElementById("code-value").placeholder = code;
            document.getElementById("code-value").value = code;
        }

    });

    function makeid(length) {
        var result = '';
        var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
        var charactersLength = characters.length;
        for (var i = 0; i < length; i++) {
            result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        return result;
    }


    var generate = $('#generate');
    generate.on('click', function () {

        var code = makeid(6);

        document.getElementById("code-value").placeholder = code;
        document.getElementById("code-value").value = code;
    });

    var countChoice = 5;
    var x = 1;

    $(function ()
    {
        $(document).on('click', '.btn-add-c', function (e)
        {
            e.preventDefault();

            if (x < countChoice) {

                x++;

                var controlForm = $('.controls-c fieldset:first'),
                        currentEntry = $(this).parents('.entry-c:first'),
                        newEntry = $(currentEntry.clone()).appendTo(controlForm);

                newEntry.find('input').val('');
                controlForm.find('.entry-c:not(:last) .btn-add-c')
                        .removeClass('btn-add-c').addClass('btn-remove-c')
                        .removeClass('btn-success').addClass('btn-danger')
                        .html('<i class="fas fa-minus"></i>');
            }

        }).on('click', '.btn-remove-c', function (e)
        {
            x--;
            $(this).parents('.entry-c:first').remove();

            e.preventDefault();
            return false;

        });
    });

});

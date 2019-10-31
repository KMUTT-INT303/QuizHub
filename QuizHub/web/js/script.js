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

});
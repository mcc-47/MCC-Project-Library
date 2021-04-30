//function formValidation(action) {
//    
//    var forms = document.getElementsByClassName('needs-validation');
//    var validation = Array.prototype.filter.call(forms, function (form) {
//        if (form.checkValidity()) {
//            action();
//        }
//        form.classList.add('was-validated');
//    });
//}
//
//var $disabledResults = $(".js-example-disabled-results");
//$disabledResults.select2();

function formValidation(action) {
    var forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
            .forEach(function (form) {
                    if (form.checkValidity()) {
                        action();
                    };
                    form.classList.add('was-validated');
                });
}
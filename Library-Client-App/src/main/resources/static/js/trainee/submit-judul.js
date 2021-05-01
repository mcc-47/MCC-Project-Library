let submitJudul = new Object();
let table = null;
$(document).ready(() => {

    $("#submitJudul").submit((e) => {
//e.preventDefault();
        create();
        //formValidation(create());
    });
});

function create() {
    project = {
        judul: $("#judul").val(),
        deskripsi: $("#deskripsi").val(),
        idMccSatu: $("#idMccSatu").val(),
        idMccDua: $("#idMccDua").val(),
        idMccTiga: $("#idMccTiga").val()

    };
};

$.ajax({
    url: "/project/trainee",
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(project),
    success: (res) => {
        table.ajax.reload();
        successAlert("Title Project Created");
        $("#create-judul").modal("hide");
        console.log("cetak");
    },
    error: (err) => {
        errorAlert("Title Project failed created");
    }
});



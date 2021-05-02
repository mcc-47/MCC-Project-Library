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
    console.log("tambah data");
    $.ajax({
        url: `/project/trainee`,
        type: "POST",
        data: JSON.stringify({
        judul: $("#judul").val(),
        deskripsi: $("#deskripsi").val(),
        idMccSatu: $("#idMccSatu").val(),
        idMccDua: $("#idMccDua").val(),
        idMccTiga: $("#idMccTiga").val()
        }),
        contentType: 'application/json; charset=UTF-8',
        success: (res) => {
//            table.ajax.reload();
            successAlert("District Created");
            console.log(res);
            $("#create-judul").modal("hide");
        },
        error: (err) => {
            errorAlert("District Failed to Created");
            console.log(err);
        }

    })
};


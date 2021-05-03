let project = new Object();
let table = null;
$(document).ready(() => {

    $("#submitJudul").submit((e) => {
        e.preventDefault();
        validationForm(create);
    });
});

//function create() {
////    project = {
//        judul: $("#judul").val(),
//        deskripsi: $("#deskripsi").val(),
//        idMccSatu: $("#idMccSatu").val(),
//        idMccDua: $("#idMccDua").val(),
//        idMccTiga: $("#idMccTiga").val()
//
//    };
//};
//console.log("tambah data");
//$.ajax({
//    url: `/project/trainee`,
//    type: "POST",
//    contentType: 'application/json',
//    data: JSON.stringify(project),
//    success: (res) => {
//        table.ajax.reload();
//        successAlert("Title Project Created");
//        $("#create-judul").modal("hide");
//        console.log("cetak");
//    },
//    error: (err) => {
//        errorAlert("Title Project failed created");
//    }
//});
//function create() {
//    console.log("tambah data");
//    $.ajax({
//        url: `/project/trainee`,
//        type: "POST",
//        data: JSON.stringify({
//        judul: $("#judul").val(),
//        deskripsi: $("#deskripsi").val(),
//        idMccSatu: $("#idMccSatu").val(),
//        idMccDua: $("#idMccDua").val(),
//        idMccTiga: $("#idMccTiga").val()
//        }),
//        contentType: 'application/json; charset=UTF-8',
//        success: (res) => {
////            table.ajax.reload();
//            successAlert("District Created");
//            console.log(res);
//        },
//        error: (err) => {
//            errorAlert("District Failed to Created");
//            console.log(err);
//        }
//
//    })
//};

function create() {
    project = {
        judul: $("#judul").val(),
        deskripsi: $("#deskripsi").val(),
        idMccSatu: $("#idMccSatu").val(),
        idMccDua: $("#idMccDua").val(),
        idMccTiga: $("#idMccTiga").val()

    };
    console.log(project);
    
    $.ajax({
        url: `/project/trainee`,
        type: 'POST',
        data: JSON.stringify(project),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: (res) => {
            console.log("Success");
            errorAlert();
            
//            $("#exampleModalLong").modal("hide");
            document.getElementById("createForm").reset();
            window.location.href = `/dashboard`;
        },
        error: function (err) {
            console.log("gagal");
            
            createSuccessAlert();
            table.ajax.reload();
            $("#create-judul").modal("hide");
        }
    });
}


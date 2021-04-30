let submitJudul = new Object();
        let table = null;
        $(document).ready(() => {
//getAll();
//create();

$("#submitJudul").submit((e) => {
//e.preventDefault();
create();
        //formValidation(create());
});
        });
//function getAll() {
//    table = $('#cariTabel').DataTable({
//        filter: true,
//        orderMulti: true,
//        ajax: {
//            url: "/project/cari",
//            datatype: "json",
//            dataSrc: ""
//        },
//        columns: [
//            {
//                data: "idProject", name: "ID Project", autoWidth: true
//            },
//            {
//                data: "judul", name: "Judul", autoWidth: true
//            },
//            {
//                data: "deskripsi", name: "Deskripsi", autoWidth: true
//            },
//            {
//                data: "idMcc", name: "Nama Anggpta 1", autoWidth: true
//            },
//            {
//                data: "idMcc", name: "Nama Anggota 2", autoWidth: true
//            },
//            {
//                data: "idMcc", name: "Nama Anggota 3", autoWidth: true
//            }
//            
//        ]
//    });
//}

        function create() {
//        project = {
//        idProject : $("#idProject").val(),
//                judul : $("#judul").val(),
//                deskripsi : $("#deskripsi").val(),
//                idMcc1 : $("#idMcc").val(),
//                idMcc2 : $("#idMcc[1]").val(),
//                idMcc3 : $("#idMcc[2]").val()
//        };
                project = {
                idProject : $("#idProject").val(),
                        judul : $("#judul").val(),
                        deskripsi : $("#deskripsi").val(),
                        mcc : [ $("#idMcc1").val().$("#idMcc2").val(), $("#idMcc3").val() ]
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
        },
                error: (err) => {
        errorAlert("Title Project failed created");
        }
        });
                }


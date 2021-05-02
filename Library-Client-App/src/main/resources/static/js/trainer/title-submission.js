let title = new Object();
let table = null;

$(document).ready(() => {
    getAll();
    
    console.log("update");
    $("#detailTitle").submit((e) => {
        e.preventDefault();
        //formValidation(update);
        update();
    });

});
function getAll() {
    table = $('#titleSubmission').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/title",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
//            {
//                data: "id", name: "No", autoWidth: true,
//                render: function (data, type, row, meta) {
//                    return meta.row + meta.settings._iDisplayStart + 1;
//                }
//            },
            {
                data: "idProject", name: "ID Project", autoWidth: true
            },
            {
                data: "judul", name: "Judul Project", autoWidth: true
            },
            {
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "trainer", name: "Trainer", autoWidth: true
            },

            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                           data-target="#update-title"
                            onclick="getBySubmission('${row.idProject}')"
                            <i class='fas fa-sm fa-pencil-alt'></i> Detail
                        </button>
                    
                     
                            <select class="btn btn-sm btn-primary" id="statusMcc" required>
                                <option value="" selected>Status</option>
                                <option value="1" >Diterima</option>
                                <option value="2">Ditolak</option>
                            </select>
                            

                    `;
                }
            }
        ]
    });


}

function getBySubmission(id) {
    this.idProject = id;
    console.log(id);
    $.ajax({
        url: `/project/id`,
        type: 'GET',
        success: (set) => {
            console.log(set.judul1);
            setForm(set);
        }
    });
}

//function update() {
//    project = {
////        idProject: $("#idProject").val(),
//        judul: $("#judul").val(),
//        deskripsi: $("#deskripsi").val(),
////        batch: $("#batch").val(),
////        nama: $("#nama[, ]").val(),
//        trainer: $("#trainer").val()
//    };
//    let id = $("#idProject").val();
//    $.ajax({
//        url: `/project/${id}`,
//        type: 'PUT',
//        contentType: 'application/json',
//        data: JSON.stringify(project),
//        success: (res) => {
//            //table.ajax.reload();
//            successAlert("Project Updated");
//            $("#update-title").modal("hide");
//        },
//        error: (err) => {
//            errorAlert("Project failed updated");
//        }
//    });
//}

function update() {
    project = {
         idProject: $("#idProject").val(),
        judul1: $("#judul1").val(),
        deskripsi1: $("#deskripsi1").val(),
        batch: $("#batch").val(),
        nama: $("#nama[, ]").val(),
        trainer1: $("#trainer1").val()
    };
    console.log(project);
    let id = $("#idProject").val();
    $.ajax({
        url: `/project/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(project),
        success: (res) => {
            table.ajax.reload();
            successAlert("Trainee Updated");
            $("#update-title").modal("hide");
        },
        error: (err) => {
            errorAlert("Trainee failed updated");
        }
    });
}

//function setForm(set) {
//    $("#judul1").val(set.judul);
//    $("#deskripsi1").val(set.deskripsi);
//    $("#trainer1").val(set.trainer);
//}

function setForm(data) {
    //$("#idProject").val(data.idProject);
    $("#judul").val(data.judul);
    $("#deskripsi").val(data.deskripsi);
    //$("#batch").val(data.batch);
    //$("#nama[, ]").val(data.nama);
    $("#trainer").val(data.trainer);
}


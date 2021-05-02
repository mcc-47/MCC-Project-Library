let title = new Object();
let table = null;

$(document).ready(() => {
    getAll();

    $("#detailTitle").submit((e) => {
//        e.preventDefault();
//        formValidation(update);
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
            {
                data: "id", name: "No", autoWidth: true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
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
                            class='btn btn-sm btn-warning'
                             data-toggle="modal" 
                             data-target="#modal-detail-project"
                            onclick="getById('${row.idProject}')">
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

function getById(id) {
    this.idProject = id;
    $.ajax({
        url: `/project/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
            console.log(res);
        }
    });
}

function update() {
    project = {
        idProject: $("#idProject").val(),
        judul: $("#judul").val(),
        deskripsi: $("#deskripsi").val(),
        batch: $("#batch").val(),
        nama: $("#nama[, ]").val(),
        trainer: $("#trainer").val()
    };
    let id = $("#idProject").val();
    $.ajax({
        url: `/project/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(project),
        success: (res) => {
            table.ajax.reload();
            successAlert("Project Updated");
            $("#form-update").modal("hide");
        },
        error: (err) => {
            errorAlert("Project failed updated");
        }
    });
}

function setForm(data) {
    $("#idProject").val(data.idProject);
    $("#judul").val(data.judul);
    $("#deskripsi").val(data.deskripsi);
    $("#batch").val(data.batch);
    $("#nama[, ]").val(data.nama);
    $("#trainer").val(data.trainer);
}
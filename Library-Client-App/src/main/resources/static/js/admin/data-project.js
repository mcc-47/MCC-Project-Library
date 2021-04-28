let project = new Object();
let table = null;

$(document).ready(() => {
    getAll();
    $("#projectUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
});
function getAll() {
    table = $('#projectTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "idProject", name: "ID Project", autoWidth: true
            },
            {
                data: "judul", name: "Judul", autoWidth: true
            },
            {
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "erd", name: "Deskripsi", autoWidth: true
            },
            {
                data: "uml", name: "Deskripsi", autoWidth: true
            },
            {
                data: "skema", name: "Deskripsi", autoWidth: true
            },
            {
                data: "link", name: "Spesialis", autoWidth: true
            },
            {
                data: "traineeList", name: "Spesialis", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-project"
                            onclick="getById('${row.idProject}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.idProject}')">
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
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
        }
    });
}

function update() {
    project = {
        idProject: $("#idProject").val(),
        judul: $("#judul").val(),
        deskripsi: $("#deskripsi").val(),
        erd: $("#erd").val(),
        uml: $("#uml").val(),
        skema: $("#skema").val(),
        link: $("#link").val(),
        traineeList: $("#traineeList").val()
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

function deleteById(id) {

    questionAlert("Are you sure?", "Do you want to delete this data?", function () {
        $.ajax({
            url: `/project/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Project sucess deleted");
            },
            error: (err) => {
                errorAlert("Project failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#idProject").val(data.idProject);
    $("#judul").val(data.judul);
    $("#deskripsi").val(data.deskripsi);
    $("#erd").val(data.erd);
    $("#uml").val(data.uml);
    $("#skema").val(data.skema);
    $("#link").val(data.link);
    $("#traineeList").val(data.traineeList);
}

    
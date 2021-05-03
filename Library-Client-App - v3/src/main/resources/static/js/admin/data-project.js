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
                data: "id", name: "No", autoWidth: true,
                render: function (data, type, row, meta) {
                    return meta.row + meta.settings._iDisplayStart + 1;
                }
            },
            {
                data: "judul", name: "Judul", autoWidth: true
            },
            {
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "erd", name: "ERD", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.erd) {
                        $(nTd).html("<a target='_blank' href=' " + oData.erd + "'>" + "click here" + "</a>");
                    }
                }

            
            },
            {
                data: "uml", name: "UML", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.uml) {
                        $(nTd).html("<a target='_blank' href=' " + oData.uml + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "skema", name: "Skema", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.skema) {
                        $(nTd).html("<a target='_blank' href=' " + oData.skema + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "link", name: "Link Full Project", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.link) {
                        $(nTd).html("<a target='_blank' href=' " + oData.link + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "nama[, ]", name: "Nama Trainee", autoWidth: true
            },
            {
                data: "trainer", name: "Nama Trainer", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary mb-1'
                            data-toggle="modal" 
                            data-target="#update-project"
                            onclick="getById('${row.idProject}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i>
                        </button>
                    
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.idProject}')">
                            <i class='fas fa-sm fa-trash'></i>
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
    $("#nama[, ]").val(data.nama);
    $("#trainer").val(data.trainer);
}

    
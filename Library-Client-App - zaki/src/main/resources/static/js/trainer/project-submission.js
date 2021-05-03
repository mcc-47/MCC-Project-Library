let project = new Object();
let table = null;
$(document).ready(() => {
    getAll();

    $("#detailProject").submit((e) => {
//        e.preventDefault();
//        formValidation(update);
        update();
    });
});

function getAll() {
    table = $('#projectSubmission').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/full-project",
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
                data: "erd", name: "ERD", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.link) {
                        $(nTd).html("<a target='_blank' href=' " + oData.link + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "link", name: "Link Project", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.link) {
                        $(nTd).html("<a target='_blank' href=' " + oData.link + "'>" + "click here" + "</a>");
                    }
                }
            },
             {
                data: "trainer", name: "Nama Trainer", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#full-project"
                            onclick="getById('${row.idProject}')"
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
        }
    });
}

function update() {
    project = {
        idProject: $("#idProject").val(),
        batch: $("#batch").val(),
        nama: $("#nama[, ]").val(),
        trainer: $("#trainer").val(),
        judul: $("#judul").val(),
        erd: $("#erd").val(),
        uml: $("#uml").val(),
        skema: $("#skema").val(),
        link: $("#link").val(),
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
            $("#full-project").modal("hide");
        },
        error: (err) => {
            errorAlert("Project failed updated");
        }
    });
}

function setForm(data) {
    $("#idProject").val(data.idProject);
    $("#batch").val(data.batch);
    $("#nama[, ]").val(data.nama);
    $("#trainer").val(data.trainer);
    $("#judul").val(data.judul);
    $("#erd").val(data.erd);
    $("#uml").val(data.uml);
    $("#skema").val(data.skema);
    $("#link").val(data.link);
}


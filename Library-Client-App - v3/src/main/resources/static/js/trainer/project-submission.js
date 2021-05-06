let title = new Object();
let table = null;
let validasi = new Object();
let projectData = new Object();

$(document).ready(() => {
    getAll();

    $("#detailProject").submit((e) => {
        e.preventDefault();
        validationForm(create);
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
                            onclick="getById('${row.idProject}')">
                            <i class="fas fa-clipboard-check"></i> Detail
                        </button>
                     
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    this.idProject = id;
    console.log(id);
    $.ajax({
        url: `/project/get-project/${id}`,
        type: 'GET',
        success: (res) => {
            console.log(res);
            projectData = res;
            setFormProject(res);
        }
    });
}

function create() {
    validasi = {
        status: $("#statusApproved").val(),
        pesan: $("#pesan").val()
    };
    console.log(validasi);
    console.log(projectData.idProject);

    $.ajax({
        url: `/project/validasi-link/${projectData.idProject}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(validasi),
        success: (res) => {
            table.ajax.reload();
            successAlert("Project Created");
            $("#full-project").modal("hide");
        },
        error: (err) => {
            errorAlert("Project failed created");
        }
    });
}

function setFormProject(data) {
    console.log(data);
    $("#nama_trainee").val(data.nama);
    $("#judul_trainee").val(data.judul);
    $("#deskripsi_trainee").val(data.deskripsi);
    $("#erd_trainee").val(data.erd);
    $("#uml_trainee").val(data.uml);
    $("#skema_trainee").val(data.skema);
    $("#link_trainee").val(data.link);
}


function rejectTitle() {
    validasi = {
        status: $("#statusRejected").val(),
        pesan: $("#pesan").val()
    };
    console.log(validasi.status);

    $.ajax({
        url: `/project/validasi-link/${projectData.idProject}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(validasi),
        success: (res) => {
            table.ajax.reload();
            successAlert("Project Created");
            $("#full-project").modal("hide");
        },
        error: (err) => {
            errorAlert("Project failed created");
        }
    });
}
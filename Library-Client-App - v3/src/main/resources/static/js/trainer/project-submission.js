let project = new Object();
let table = null;
let validasi = new Object();
let projectData = new Object() ;


$(document).ready(() => {
    getAll();

    $("#detailProject").submit((e) => {
        e.preventDefault();
        formValidation(create);
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
                data: "deskripsi", name: "Deskripsi", autoWidth: true
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
                data: "uml", name: "UML", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.link) {
                        $(nTd).html("<a target='_blank' href=' " + oData.link + "'>" + "click here" + "</a>");
                    }
                }
            },
             {
                data: "skema", name: "Skema", autoWidth: true,
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
                data: "nama", name: "Nama Trainee", autoWidth: true
            },
             {
                data: "batch", name: "Batch", autoWidth: true
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

function create() {
    validasi = {
        idProject: $(projectData.idProject),
        status: $("#statusApproved").val(),
        pesan: $("#pesan").val()
    };
    console.log(validasi);
     console.log(projectData.idProject);

    $.ajax({
        url: `/project/validasi-link/${projectData.idProject}`,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(project),
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

function rejectTitle() {
    validasi = {
        status: $("#statusRejected").val(),
        pesan: $("#pesan").val()
    };
    console.log(validasi.status);

    $.ajax({
        url: `/project/validasi-judul/${projectData.idProject}`,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(project),
        success: (res) => {
            table.ajax.reload();
            successAlert("Project Created");
            $("#pesan-project").modal("hide");
        },
        error: (err) => {
            errorAlert("Project failed created");
        }
    });
}


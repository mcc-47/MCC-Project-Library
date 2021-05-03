let title = new Object();
let table = null;
let validasi = new Object();
let projectData = new Object() ;

$(document).ready(() => {
    getAll();
    
    $("#detailTitle").submit((e) => {
        e.preventDefault();
        validationForm(create);
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
              data: "nama", name: "Trainee", autoWidth: true  
            },
            {
              data: "batch", name: "Batch", autoWidth: true  
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
                            data-target="#pesan-project"
                            onclick="getById('${row.idProject}')">
                            
                            <i class="fas fa-clipboard-check"></i>Approval
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
            console.log(res);
            projectData = res;
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
        url: `/project/validasi-judul/${projectData.idProject}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(validasi),
        success: (res) => {
            $("#pesan-project").modal("hide");
            table.ajax.reload();
            successAlert("Project Created");
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
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(validasi),
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


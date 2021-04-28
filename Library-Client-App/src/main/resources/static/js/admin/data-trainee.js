let trainee = new Object();
let table = null;
let id = 0;
$(document).ready(() => {
    getAll();
    $("#traineeUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
});
function getAll() {
    table = $('#traineeTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/trainee/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "idMcc", name: "ID MCC", autoWidth: true
            },
            {
                data: "nama", name: "Nama Trainee", autoWidth: true
            },
            {
                data: "batch", name: "Batch", autoWidth: true
            },
            {
                data: "email", name: "Email", autoWidth: true
            },
            {
                data: "jabatan", name: "Jabatan", autoWidth: true
            },
            {
                data: "statusMcc", name: "Btatus", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-trainee"
                            onclick="getById('${row.idMcc}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.idMcc}')">
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
                    `;
                }
            }
        ]
    });
}

function getById(id) {
    this.idMcc = id;
    $.ajax({
        url: `/trainee/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function update() {
    trainee = {
        idMcc: $("#idMcc").val(),
        nama: $("#nama").val(),
        batch: $("#batch").val(),
        email: $("#email").val(),
        jabatan: $("#jabatan").val(),
        statusMcc: $("#statusMcc").val()

    };
    let id = $("#idMcc").val();
    $.ajax({
        url: `/trainee/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(trainee),
        success: (res) => {
            table.ajax.reload();
            successAlert("Trainee Updated");
            $("#form-update").modal("hide");
        },
        error: (err) => {
            errorAlert("Trainee failed updated");
        }
    });
}

function deleteById(id) {

    questionAlert("Are you sure?", "Do you want to delete this data?", function () {
        $.ajax({
            url: `/trainee/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Trainee sucess deleted");
            },
            error: (err) => {
                errorAlert("Trainee failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#idMcc").val(data.idMcc);
    $("#nama").val(data.nama);
    $("#batch").val(data.batch);
    $("#email").val(data.email);
    $("#jabatan").val(data.jabatan);
    $("#statusMcc").val(data.statusMcc);
}

    
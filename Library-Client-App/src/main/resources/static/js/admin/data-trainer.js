let trainer = new Object();
let table = null;

$(document).ready(() => {
    getAll();
    $("#trainerUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });
});


function getAll() {
    table = $('#trainerTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/trainer/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "idMcc", name: "ID MCC", autoWidth: true
            },
            {
                data: "nama", name: "Nama Trainer", autoWidth: true
            },
            {
                data: "email", name: "Email", autoWidth: true
            },
            {
                data: "namaKelas", name: "Keahlian", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-trainer"
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
        url: `/trainer/${id}`,
        type: 'GET',
        success: (res) => {
            setForm(res);
        }
    });
}

function update() {
    trainer = {
        idMcc: $("#idMcc").val(),
        nama: $("#nama").val(),
        email: $("#email").val(),
        namaKelas: $("#namaKelas").val()
    };
    let id = $("#idMcc").val();
    $.ajax({
        url: `/trainer/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(trainer),
        success: (res) => {
            table.ajax.reload();
            successAlert("Trainer Updated");
            $("#form-update").modal("hide");
        },
        error: (err) => {
            errorAlert("Trainer failed updated");
        }
    });
}

function deleteById(id) {

    questionAlert("Are you sure?", "Do you want to delete this data?", function () {
        $.ajax({
            url: `/trainer/${id}`,
            type: 'DELETE',
            success: (res) => {
                table.ajax.reload();
                successAlert("Trainer sucess deleted");
            },
            error: (err) => {
                errorAlert("Trainer failed deleted");
            }
        });
    });
}

function setForm(data) {
    $("#idMcc").val(data.idMcc);
    $("#nama").val(data.nama);
    $("#email").val(data.email);
    $("#namaKelas").val(data.namaKelas);
}

    
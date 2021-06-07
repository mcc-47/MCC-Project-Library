let alumni = new Object();
let table = null;

$(document).ready(() => {
    getAll();
    $("#traineeUpdate").submit((e) => {
        e.preventDefault();
        formValidation(update);
    });

});
function getAll() {
    table = $('#alumniTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/alumni/get-alumni",
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
                data: "status", name: "Btatus", autoWidth: true
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
        status: $("#status").val()

    };
    let id = $("#idMcc").val();
    $.ajax({
        url: `/trainee/${id}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(trainee),
        success: (res) => {
            successAlert("Trainee Updated");
            table.ajax.reload();
            $("#update-trainee").modal("hide");
        },
        error: (err) => {
            errorAlert("Trainee failed updated");
        }
    });
}

function deleteById(id) {
    questionAlert("Are you sure?", "Do you want to delete this data?", () => {
        $.ajax({
            url: `/trainee/${id}`,
            type: 'DELETE',
            success: (res) => {
                successAlert("Trainee success deleted");
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
    $("#status").val(data.status);
}
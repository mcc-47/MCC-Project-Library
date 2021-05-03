let myHistory = new Object();
let table = null;

$(document).ready(() => {
    getAll();
});

function getAll() {
    table = $('#myHistory').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/history/trainee",
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
                data: "idProject", name: "Project", autoWidth: true
            },
            {
                data: "info", name: "Batch", autoWidth: true
            },
            {
                data: "waktu", name: "Nama Trainee", autoWidth: true,
                render: function (data) {
                    return moment(data).format('ddd, MMMM Do, YYYY');
                }
            },
            {
                data: "pesan", name: "Nama Trainer", autoWidth: true
            },
            {
                data: "status", name: "Deskripsi", autoWidth: true
            }
            
        ]
    });
}
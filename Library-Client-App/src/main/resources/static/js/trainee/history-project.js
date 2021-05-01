let history = new Object();
let table = null;
$(document).ready(() => {
    getAll();
});
function getAll() {
    table = $('#historyProject').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/history/mcc",
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
                data: "info", name: "Info", autoWidth: true
            },
            {
                data: "waktu", name: "Waktu", autoWidth: true
            },
            {
                data: "pesan", name: "Pesan", autoWidth: true
            },
            {
                data: "status", name: "status", autoWidth: true
            }  
        ]
    });
}
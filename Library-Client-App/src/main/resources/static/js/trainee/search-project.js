let searchProject = new Object();
let table = null;

$(document).ready(() => {
    getAll();
});

function getAll() {
    table = $('#cariTabel').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/cari",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
            {
                data: "idProject", name: "ID Project", autoWidth: true
            },
            {
                data: "judul", name: "Judul", autoWidth: true
            },
            {
                data: "batch", name: "Batch", autoWidth: true
            },
            {
                data: "nama", name: "Nama Trainee", autoWidth: true
            },
            {
                data: "trainer", name: "Nama Trainer", autoWidth: true
            },
            {
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "skema", name: "Deskripsi", autoWidth: true
            },
            {
                data: "link", name: "Link Full Project", autoWidth: true
            },
            
        ]
    });
}
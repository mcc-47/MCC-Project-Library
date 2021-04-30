let title = new Object();
let table = null;

$(document).ready(() => {
    getAll();


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
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#detail-title"
                            onclick="detailTitle('${row.id}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> 
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.id}')">
                            <i class='fas fa-sm fa-trash'></i> Terima
                        </button>
                    <button class='btn btn-sm btn-danger' onclick="deleteById('${row.id}')">
                            <i class='fas fa-sm fa-trash'></i> Tolak
                        </button>
                    
                    `;
                }
            }
        ]
    });


}

function detailTitle() {
    table = $('#detailTitle').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/get-all",
            datatype: "json",
            dataSrc: ""
        },
        columns: [
           
            {
                data: "judul", name: "Judul Project", autoWidth: true
            },
            {
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "batch", name: "Batch", autoWidth: true
            },
            {
                data: "nama[, ]", name: "Nama Trainee", autoWidth: true
            }
        ]
    });


}



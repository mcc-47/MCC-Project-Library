let project = new Object();
let table = null;
$(document).ready(() => {
    getAll();
});
function getAll() {
    table = $('#projectSubmission').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/full",
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
                data: "erd", name: "ERD", autoWidth: true
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
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#detail-project"
                            onclick="detailProject('${row.id}')">
                            
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

function detailProject() {
    table = $('#detailProject').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/full",
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
                data: "nama[, ]", name: "Nama Trainee", autoWidth: true
            },
            {
                data: "erd", name: "ERD", autoWidth: true
            },
            {
                data: "uml", name: "UML", autoWidth: true
            },
            {
                data: "skema", name: "Skema", autoWidth: true
            },
            {
                data: "link", name: "Link Project", autoWidth: true
            }
        ]
    });
}
function getAll() {
    table = $('#projectTable').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/get-all",
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
                data: "deskripsi", name: "Deskripsi", autoWidth: true
            },
            {
                data: "erd", name: "Deskripsi", autoWidth: true
            },
            {
                data: "uml", name: "Deskripsi", autoWidth: true
            },
            {
                data: "skema", name: "Deskripsi", autoWidth: true
            },
            {
                data: "link", name: "Link Full Project", autoWidth: true
            },
            {
                data: "traineeList", name: "Keahlian", autoWidth: true
            },
            {
                render: (data, type, row, meta) => {
                    return `
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-project"
                            onclick="getById('${row.idProject}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Update
                        </button>
                        <button class='btn btn-sm btn-danger' onclick="deleteById('${row.idProject}')">
                            <i class='fas fa-sm fa-trash'></i> Delete
                        </button>
                    `;
                }
            }
        ]
    });
}
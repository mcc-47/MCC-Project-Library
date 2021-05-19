let myProject = new Object();
let table = null;
let projectData = new Object();
let projectDataJudul = new Object();
let idJudul = "";
let historyStatus = null;
let link = null;

$(document).ready(() => {
    getAll();
    getHistoryData();
    console.log(getAll);
    
    $("#myProjectUpdate").submit((e) => {
        e.preventDefault();
        validationForm(update);
    });
    
    $("#myProjectJudul").submit((e) => {
        e.preventDefault();
        validationForm(updateJudul);
    });
});

function getAll() {
    table = $('#myProject').DataTable({
        filter: true,
        orderMulti: true,
        ajax: {
            url: "/project/myProject",
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
                data: "judul", name: "Judul", autoWidth: true
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
                data: "erd", name: "erd", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.erd) {
                        $(nTd).html("<a target='_blank' href=' " + oData.erd + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "uml", name: "uml", autoWidth: true,
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.uml) {
                        $(nTd).html("<a target='_blank' href=' " + oData.uml + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "skema", name: "Skema", autoWidth: true,
               
                fnCreatedCell: function (nTd, sData, oData, iRow, iCol) {
                    if (oData.skema) {
                        $(nTd).html("<a target='_blank' href=' " + oData.skema + "'>" + "click here" + "</a>");
                    }
                }
            },
            {
                data: "link", name: "Link Full Project", autoWidth: true,
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
                            data-target="#update-my-project"
                            onclick="getById('${row.idProject}')">
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> Link
                        </button>
                        <br><br>
                        <button 
                            class='btn btn-sm btn-primary'
                            data-toggle="modal" 
                            data-target="#update-judul-project"
                            onclick="getByIdJudul('${row.idProject}')"> Judul
                            
                            <i class='fas fa-sm fa-pencil-alt'></i> 
                        </button>
                        
                    
                    `;
                }
            }
            
        ]
    });
}

function getByIdForUpdateJudul() {
    this.idProject = $("#btn-submitJudul").val();
    console.log(idProject);
    $.ajax({
        url: `/project/${idProject}`,
        type: 'GET',
        success: (res) => {
            console.log(res);
            projectData = res;
            setForm(res);
            
        }
    });
}

function getByIdForSubmitLink() {
    this.idProject = $("#btn-submitProject").val();
    console.log(idProject);
    $.ajax({
        url: `/project/${idProject}`,
        type: 'GET',
        success: (res) => {
            console.log(res);
            projectData = res;
            setForm(res);
        }
    });
}

function getByIdForUpdateJudul2() {
    this.idProject = $("#btn-submitJudul2").val();
    console.log(idProject);
}

function update() {
    project = {
        erd: $("#erd").val(),
        uml: $("#uml").val(),
        skema: $("#skema").val(),
        link: $("#link").val(),
        idProject: projectData.idProject
    };
    
    console.log(projectData.idProject);
   
    let id = $("#idProject").val();
    
    $.ajax({
        url: `/project/update-link/${projectData.idProject}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(project),
        success: (res) => {
             console.log(project);
            console.log(res);
            $("#update-my-project").modal("hide");
            window.location.href =  "/history/my-history";
        },
        error: (err) => {
            errorAlert("Project failed updated");
            console.log("update error");
        }
    });
}

function setForm(data) {
    $("#judul").val(data.judul);
    $("#nama").val(data.nama);
    $("#trainer").val(data.trainer);
    $("#deskripsi").val(data.deskripsi);
    $("#erd").val(data.erd);
    $("#uml").val(data.uml);
    $("#skema").val(data.skema);
    $("#link").val(data.link);
}

function getByIdJudul(id) {
    this.idProject = id;
    console.log(id);
    $.ajax({
        url: `/project/judul/${id}`,
        type: 'GET',
        success: (res) => {
            console.log(res);
            projectDataJudul = res;
            idJudul = id;
            setFormJudul(res);
        }
    });
}

function updateJudul() {
    project = {
        judul: $("#judul1").val(),
        deskripsi: $("#deskripsi1").val(),
        idProject: idJudul
    };
    console.log(projectData.idProject);
   
    $.ajax({
        url: `/project/update-judul/${projectData.idProject}`,
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(project),
        success: (res) => {
             console.log(project);
            console.log(res);
            $("#update-judul-project").modal("hide");
            window.location.href =  "/history/my-history";
        },
        error: (err) => {
            errorAlert("Project failed updated");
            console.log("update error");
        }
    });
}

function setFormJudul(lala) {
    $("#nama1").val(lala.nama);
    $("#trainer1").val(lala.trainer);
     $("#judul1").val(lala.judul);
    $("#deskripsi1").val(lala.deskripsi);
}

function gotoHistory() {
    window.location.href= "/history/my-history";
}

function getHistoryData() {
    $.ajax({
        url: `/history/myHistory/`,
        type: 'GET',
        success: (res) => {
            hideElement(res);
        }
    });
}

function hideElement(res) {
    console.log(res);
    
    
    historyStatus = res.splice(res.length - 1);
    console.log(historyStatus[0].status);
    
    
    
    if(historyStatus[0].status === "Menunggu approval judul" || historyStatus[0].status === "Menunggu approval link project") {
        $("#btn-submitProject").remove();
        $("#btn-submitJudul").remove();
        
    } else if(historyStatus[0].status === "Judul ditolak") {
        $("#btn-submitProject").remove();
    }  else if(historyStatus[0].status === "Development") {
        $("#btn-submitJudul").remove();
    } else if (historyStatus[0].status === "Link project ditolak") {
        $("#btn-submitJudul").remove();
    } else {
        $("#btn-submitProject").remove();
        $("#btn-submitJudul").remove();
    }
    
//    historyStatus = getHistoryData
    
}


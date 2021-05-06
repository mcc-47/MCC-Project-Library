let projectUser = null;

$(document).ready(() => {
    getData();
});

function getData() {
    $.ajax({
        url: "/project/myProject",
        datatype: "json",
        dataSrc: "",
        success: (res) => {
            console.log(res);
            projectUser = res[0].deskripsi;
            console.log(projectUser);
            hideCard();
        }
    });
}

function hideCard() {
    console.log(projectUser);
    (projectUser === null) ? $("#hideMyProject").remove()  : $("#submitProject").remove();
//    if(projectUser === null) {
////        $("#cardProject").hide();
//    } else {
//        $("#submitProject").hide();
//    }
}
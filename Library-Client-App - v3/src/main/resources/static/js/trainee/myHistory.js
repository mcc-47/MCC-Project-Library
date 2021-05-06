let myHistory = new Object();
let dataTime = null;

$(document).ready(() => {

    getHistoryData();
    test();
});



function getHistoryData() {
    $.ajax({
        url: `/history/myHistory/`,
        type: 'GET',
        success: (res) => {
            coloringStatus(res);
        }
    });
}

function coloringStatus(res) {
//    console.log(res);
    historyStatus = res;
//    console.log(historyStatus[1].status);
    
    for(let i=0; i < historyStatus.length; i++) {
        if (historyStatus[i].status === "Menunggu approval judul" || historyStatus[i].status === "Menunggu approval link project") {
            $(".statusHistory").addClass("text-secondary");
            console.log(historyStatus[i].status);

        } else if (historyStatus[i].status === "Judul ditolak") {
            $(".statusHistory").addClass("text-secondary").removeClass("text-danger");
        } else if (historyStatus[i].status === "Development") {
            $(".statusHistory").addClass("text-secondary");
        } else if (historyStatus[i].status === "Link project ditolak") {
            $(".statusHistory").addClass("text-secondary");
        } else {
            console.log(historyStatus);
            $(".statusHistory").addClass("text-secondary");
        }
    }
}

function test() {
    dataTime = $("#waktuHistory").val();
    console.log(dataTime);
}
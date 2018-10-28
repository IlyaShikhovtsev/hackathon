var form;

function makeEditable() {
    form = $('#detailsForm');
    $(document).ajaxError(function (event, jqXHR, options, jsExc) {
        failNoty(jqXHR);
    });
    $.ajaxSetup({cache: false});
}

function add() {
    $("#modalTitle").html("Would you like to create a ticket?");
    form.find(":input").val("");
    $("#addRow").modal();
}

function deleteRow(id) {
    $.ajax({
        url: ajaxUrl + id,
        type: "DELETE",
        success: function () {
            updateTable();
            successNoty("Deleted");
        }
    });
}

function updateTableByData(data) {
    datatableApi.clear().rows.add(data).draw();
}

function changeUser() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "changeUser",
    });
}

function check() {
    $.ajax({
        type: "GET",
        url: ajaxUrl + $('#checkSiteName').valueAsString,
        success: function (ticket) {
            if(ticket.state == true) {
                successNoty("common.allowed");
            } else {
                deniedNoty("common.denied");
                add();
            }
        }
    });
}

function save() {
    $.ajax({
        type: "POST",
        url: ajaxUrl,
        data: form.serialize(),
        success: function () {
            $("#addRow").modal("hide");
            updateTable();
            successNoty("Ticket was created");
        }
    });
}

var failedNote;

function closeNoty() {
    if (failedNote) {
        failedNote.close();
        failedNote = undefined;
    }
}

function successNoty(key) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-ok'></span> &nbsp;Successful",
        type: 'success',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function deniedNoty(key) {
    closeNoty();
    new Noty({
        text: "<span class='glyphicon glyphicon-ok'></span> &nbsp;Denied",
        type: 'error',
        layout: "bottomRight",
        timeout: 1000
    }).show();
}

function failNoty(jqXHR) {
    closeNoty();
    var errorInfo = JSON.parse(jqXHR.responseText);
    failedNote = new Noty({
        text: "<span class='glyphicon glyphicon-exclamation-sign'></span> &nbsp;Error status: " + jqXHR.status + "<br>" + errorInfo.type + "<br>" + errorInfo.detail,
        type: "error",
        layout: "bottomRight"
    }).show();
}
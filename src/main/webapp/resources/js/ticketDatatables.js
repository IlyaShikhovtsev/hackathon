var ajaxUrl = "ajax/profile/ticket/";
var datatableApi;

function updateTable() {
    $.ajax({
        type: "POST",
        url: ajaxUrl + "filter",
        data: $("#filter").serialize(),
        success: updateTableByData
    });
}

$(function () {
    datatableApi = $("#datatable").DataTable({
        "ajax": {
            "url": ajaxUrl,
            "dataSrc": ""
        },
        "paging": false,
        "info": true,
        "columns": [
            {
                "data": "dateTime",
            },
            {
                "data": "description"
            },
            {
                "data": "site"
            }
        ],
        "order": [
            [
                0,
                "desc"
            ]
        ],
        "initComplete": makeEditable
    });
});
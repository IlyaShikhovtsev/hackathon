var ajaxUrl = "ajax/profile/ticket/";
var datatableApi;

function updateTable() {
    $.ajax({
        type: "GET",
        url: ajaxUrl,
        // data: $("#filter").serialize()
    }).done(updateTableByData);
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
                "render": function (date, type, row) {
                    if (type === 'display') {
                        return date.replace('T', ' ').substr(0, 16);
                    }
                    return date;
                }
            },
            {
                "data": "description"
            },
            {
                "data": "site.name"
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
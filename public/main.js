function getLists(listsData) {
    for (var i in listsData) {
        var elem = $("<a>");
        elem.attr("href", "lists/" + filesData[i].filename);
        elem.text(filesData[i].originalFilename);
        $("#fileList").append(elem);
        var elem2 = $("<br>");
        $("#fileList").append(elem2);
    }
}

$.get("/lists", getLists);
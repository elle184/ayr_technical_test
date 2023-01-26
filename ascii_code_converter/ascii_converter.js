window.onload = function() {
    var textAsArray = new Array();
    var index = 0;

    document.getElementById("actionConvertText").onclick = function() {
        let stringToAscii = null;
        let arrayOfStrings = document.getElementById("textToConvert").value.split("");
        let index = 0;
        let tableBodyAsciiList = document.getElementById("asciiList").tBodies[0];

        deleteTableRows(tableBodyAsciiList);

        for (let s of arrayOfStrings) {
            stringToAscii += s.charCodeAt();
            stringToAscii += (index < (arrayOfStrings.length - 1)) ? "." : "";
            index++;

            let row = document.createElement("tr");
            let cellString = document.createElement("td");
            cellString.appendChild(document.createTextNode(s));
            let cellAscii = document.createElement("td");
            cellAscii.appendChild(document.createTextNode(s.charCodeAt()));
            row.appendChild(cellString);
            row.appendChild(cellAscii);
            tableBodyAsciiList.appendChild(row);
        }

        document.getElementById("textConverted").innerText = stringToAscii;
    }

    document.getElementById("actionCleanAll").onclick = function() {
        let tableBodyAsciiList = document.getElementById("asciiList").tBodies[0];
        document.getElementById("textToConvert").value = null;
        document.getElementById("textConverted").innerText = null;
        let rowsAmount = tableBodyAsciiList.rows.length;

        deleteTableRows(tableBodyAsciiList);
    }

    function deleteTableRows(tableBody) {
        for (let i = 0; i < tableBody.rows.length; i++) {
            tableBody.deleteRow(i);
        }

        if (tableBody.rows.length > 0) {
            deleteTableRows(tableBody);
        }
    }
}
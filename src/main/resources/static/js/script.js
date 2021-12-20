const submitButton = document.getElementById("submit");
const form = document.getElementById("form");
submitButton.addEventListener("click", onSubmit);

enableTab("Array");

async function onSubmit(e){
    e.preventDefault();
    const formData = new FormData(form);
    const sortType = formData.get("SortType");
    const reverse = formData.get("Reverse");
    const array = formData.get("Array");
    const sortAttrib = formData.get("SortAttrib");

    if (sortType === null) {
        alert("Nie wybrano typu sortowania");
        return;
    }

    if (sortAttrib === null) {
        alert("Nie wybrano atrybutu sortowania");
        return;
    }

    let json;
    try {
        json = JSON.parse(array);
        if (!Array.isArray(json)) {
            alert("Przekazany JSON nie jest tablicą");
            return;
        }

        if (sortAttrib === "Number") {
            for (var k of Object.keys(json)) {
                console.log(json[k]);
                if (!json[k] instanceof Number) {
                    alert("Nie wszystkie obiekty w tablicy są typu liczbowego");
                    return;
                }
            }
        } else if (sortAttrib === "String") {
            for (var k of Object.keys(json)) {
                console.log(json[k]);
                if (!json[k] instanceof String) {
                    alert("Nie wszystkie obiekty w tablicy są typu String");
                    return;
                }
            }
        } else {
            for (var k of Object.keys(json)) {
                console.log(json[k]);
                if (!json[k].hasOwnProperty(sortAttrib)) {
                    alert("Wybrany atrybut sortowania nie występuje we wszystkich obiektach");
                    return;
                }
            }
        }

    } catch (e) {
        alert("Przekazano niepoprawny JSON");
        return;
    }

    const postData = {
        "SortType": sortType,
        "Reverse": reverse !== null,
        "Array": json,
        "SortAttrib": sortAttrib
    };
    const result = await fetch("/result", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(postData)
    })
    console.log(result);
}

// from https://jsfiddle.net/2wAzx/13/
function enableTab(id) {
    var el = document.getElementById(id);
    el.onkeydown = function(e) {
        if (e.keyCode === 9) { // tab was pressed

            // get caret position/selection
            var val = this.value,
                start = this.selectionStart,
                end = this.selectionEnd;

            // set textarea value to: text before caret + tab + text after caret
            this.value = val.substring(0, start) + '\t' + val.substring(end);

            // put caret at right position again
            this.selectionStart = this.selectionEnd = start + 1;

            // prevent the focus lose
            return false;

        }
    };
}


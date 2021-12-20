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

        console.log(sortAttrib);
        if (sortAttrib === "Number") {
            for (const k of json) {
                console.log(k);
                if (!(typeof k === "number")) {
                    alert("Nie wszystkie obiekty w tablicy są typu liczbowego");
                    return;
                }
            }
        } else if (sortAttrib === "String") {
            for (const k of json) {
                console.log(k);
                if (!(typeof k === "string")) {
                    alert("Nie wszystkie obiekty w tablicy są typu String");
                    return;
                }
            }
        } else {
            for (const k of json) {
                console.log(k);
                if (!k.hasOwnProperty(sortAttrib)) {
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
    try {
        const result = await fetch("/result", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(postData)
        })
        const responseJSON = await result.json();
        console.log(responseJSON);
        renderResult(responseJSON['ResultArray'], responseJSON['Time']);
    } catch (e) {
        alert("Wystąpił błąd");
        return;
    }

}

function renderResult(resultArray, time) {
    const b = resultArray.map(e => {
        if (typeof e === "object") return e.jsonstring;
        return e;
    })
    output.innerHTML = `<p>${JSON.stringify(b).replaceAll('"',"").replaceAll('=',':')}</p><p>${time/1000} μs</p>`;
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


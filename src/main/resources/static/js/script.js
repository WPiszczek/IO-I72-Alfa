const submitButton = document.getElementById("submit");
const form = document.getElementById("form");
submitButton.addEventListener("click", onSubmit);

async function onSubmit(e){
    e.preventDefault();
    const formData = new FormData(form);
    const sortType = formData.get("SortType");
    const reverse = formData.get("Reverse");
    const array = formData.get("Array");

    if (sortType === null) {
        alert("Nie wybrano typu sortowania");
        return;
    }
    let json;
    try {
        json = JSON.parse(array);
        if (!Array.isArray(json)) {
            alert("Przekazany JSON nie jest tablicą");
            return;
        }
    } catch (e) {
        alert("Przekazano niepoprawny JSON");
        return;
    }

    const postData = {
        "SortType": sortType,
        "Reverse": reverse !== null,
        "Array": json
    };
    const result = await fetch("/result", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(postData)
    })
    console.log(result);
};



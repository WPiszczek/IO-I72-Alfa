import axios from 'axios';
import { useState } from 'react';

function InputData() {

    // TODO SortAttrib

    const [dataType, setDataType] = useState("");
    const [sortAttrib, setSortAttrib] = useState("");
    const [array, setArray] = useState([]);
    const [file, setFile] = useState([]);
    const [formData, setFormData] = useState({"dataType":dataType, "arraySize":"", "sortAttrib":sortAttrib})
    const [responseData, setResponseData] = useState("");

    const [arrayError, setArrayError] = useState("");
    const [fileError, setFileError] = useState("");
    const [sortAttribError, setSortAttribError] = useState("");
    const [disableSubmit, setDisableSubmit] = useState(false);
    

    function handleDataType(_dataType) {
        setDataType(_dataType);
    }

    function handleSortAttrib(_sortAttrib) {
        setSortAttrib(_sortAttrib);
    }

    function handleArray(_array) {
        try {
            const a = JSON.parse(_array);
            if (Array.isArray(a) && validArrayType(a)) {
                if (dataType === "JSON" || dataType === "File") {
                    if (validSortAttrib(a, sortAttrib)) {
                        setArray(a);
                        setDisableSubmit(false);
                        setArrayError("");
                    }
                    else {
                        throw Error;
                    }
                }
                
            } else {
                throw Error;
            }  
            
        }
        catch {
            console.log("Cannot parse");
            setArrayError("Wprowadź tablicę w formacie JSON z wartościami oczekiwanego typu.");
            setDisableSubmit(true);
        }
    }

    function handleFile(_file) {
        try {
            const f = JSON.parse(_file);
            if (Array.isArray(f)) {
                setFile(f);
                setDisableSubmit(false);
                setFileError("");
            } else {
                throw Error;
            }            
        }
        catch {
            console.log("Cannot parse");
            setFileError("Wybierz plik z poprawną tablicą w formacie JSON.");
            setDisableSubmit(true);
        }
    }

    function handleFormData(e) {
        setFormData({...formData, [e.target.id]:e.target.value})
    }

    function handleResponseData(_responseData) {
        setResponseData(_responseData);
    }


    function validArrayType(array) {
        if (dataType === "Number") {
            for (const k of array) {
                console.log(k);
                if (!(typeof k === "number")) {
                    return false;
                }
            }
        } else if (dataType === "String") {
            for (const k of array) {
                console.log(k);
                if (!(typeof k === "string")) {
                    return false;
                }
            }
        }
        return true;
    }


    function validSortAttrib(array, sortAttrib) {
        for (const k of array) {
            console.log(k);
            if (!k.hasOwnProperty(sortAttrib)) {
                setSortAttribError("Wybrany atrybut sortowania nie występuje we wszystkich obiektach w tablicy.");
                return false;
            }
        }
        return true;
    }
  

    async function sendData(data) {
        try {
            console.log(data);
            console.log(dataType);
            const response = await axios.post(`http://localhost:8080/inputData/${dataType}`, data);
            console.log(response.data);
            handleResponseData(response.data);
        } catch (error) {
            console.log(error);
        }
    }  


    function handleForm(e) {
        e.preventDefault();
        console.log(formData);
        if (dataType === "File") {
            formData.array = file;
        } else if (dataType !== "Random") {
            formData.array = array;
        }
        sendData(formData);
    }


    function handleInputArrayChange(e) {
        console.log(e.target.value);
        handleArray(e.target.value);
        handleFormData(e);
    }


    async function showFile(e) {
        e.preventDefault();
        const reader = new FileReader();
        reader.onload = async (e) => {
            const text = (e.target.result);
            handleFile(text);
        };

        reader.readAsText(e.target.files[0]);
    }

    function reloadPage() {
        window.location.href = '/';
    }

    function goToSortTypePage() {
        ;
    }


    function isDisabled() {
        if (responseData !== "") return true;
        return false;
    }


    return (
    <>
    <div className="info">
        <header>Wybierz rodzaj danych {(dataType !== "" ? `- ${dataType}` : "")}</header>
    </div>

    <div className="yourChoice">
        <button onClick={() => handleDataType("Random") } className="myButton" name="dataType" disabled={isDisabled()}>Random</button>
        <button onClick={() => handleDataType("Number") } className="myButton" name="dataType" disabled={isDisabled()}>Number</button>
        <button onClick={() => handleDataType("String") } className="myButton" name="dataType" disabled={isDisabled()}>String</button>
        <button onClick={() => handleDataType("JSON") } className="myButton" name="dataType" disabled={isDisabled()}>JSON</button>
        <button onClick={() => handleDataType("File") } className="myButton" name="dataType" disabled={isDisabled()}>File</button>
    </div>

    {responseData === "" && 
    <>

    {dataType === "Random" && 
    <>
        <div className="yourChoice">
            <form onSubmit={(event) => handleForm(event)}>
                <label htmlFor="arraySize">Podaj długość tablicy do wygenerowania:</label>
                <input type="number" 
                    id="arraySize"
                    name="arraySize"
                    value={formData.arraySize} 
                    min="2" 
                    onChange={(event) => handleFormData(event)} 
                    placeholder="Podaj długość tablicy"
                    className="myButton"
                    required/>
                <input type="submit" id="submit" name="submit" value="Generuj" className="myButton"/>
            </form>
        </div>
    </>}

    {(dataType === "Number" || dataType === "String") &&
    <>
        <div className="inputTable">
            <form onSubmit={(event) => handleForm(event)}>
                <label htmlFor="array">Wpisz tablicę do posortowania:</label>
                <span className="error">{arrayError}</span>
                <input 
                type="text" 
                className="inputSortData" 
                placeholder="Tablica do posortowania" 
                name="array" 
                id="array" 
                onChange={(event) => handleInputArrayChange(event)} />
                <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={disableSubmit}/>
            </form>
        </div>
    </>}

    {dataType === "JSON" &&
    <>
        <form onSubmit={(event) => handleForm(event)}>
            <div className="inputTable">
                <label htmlFor="array">Wpisz tablicę do posortowania:</label>
                <span className="error">{arrayError}</span>
                <input 
                type="text" 
                className="inputSortData" 
                placeholder="Tablica do posortowania" 
                name="array" 
                id="array" 
                onChange={(event) => handleInputArrayChange(event)} />
            </div>
            <div className="yourChoice">
                <label htmlFor="sortAttrib">Podaj atrybut, po którym chcesz sortować:</label>
                <span className="error">{sortAttribError}</span>
                <input type="text" 
                    id="sortAttrib"
                    name="sortAttrib"
                    value={formData.sortAttrib}
                    onChange={(event) => handleFormData(event)} 
                    placeholder="Podaj atrybut sortujący"
                    className="myButton"
                    required/>
                <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={disableSubmit}/>
            </div>
        </form>       
    </>} 

    {dataType === "File" &&
    <>
        <div className="yourSpaces">
            <form onSubmit={(event) => handleForm(event)}>
                <span className="error">{fileError}</span>
                <input type="file" accept=".json" name="array" onChange={(event) => showFile(event)}/>
                {file !== [] && fileError === "" && 
                <>
                <ol>
                    {file.map((element, index) => {
                    return (<li key={index}>{JSON.stringify(element)}</li>);
                    })}
                </ol>
                </>
                }

                <label htmlFor="sortAttrib">Podaj atrybut, po którym chcesz sortować:</label>
                <span className="error">{sortAttribError}</span>
                    <input type="text" 
                        id="sortAttrib"
                        name="sortAttrib"
                        value={formData.sortAttrib}
                        onChange={(event) => handleSortAttrib(event)} 
                        placeholder="Podaj atrybut sortujący"
                        className="myButton"
                        required/>
                <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={disableSubmit}/>
            </form>
        </div>
    </>}


    </>
    }

    {responseData !== "" && 
    <>
    <div className="center"><h2>Twoja tablica:</h2></div>
    <div className="showArray">
        <ol>
        {responseData.array.map((item) => {
            return (<li key={item}>{JSON.stringify(item)}</li>);
        })}
        </ol>
    </div>
    <div className="buttons">
        <button onClick={() => reloadPage()} className="myButton" name="reload">Zacznij od nowa</button>
        <button onClick={() => goToSortTypePage()} className="myButton" name="reload">Przejdź dalej</button>
    </div>
    </>}
    
    </>
    );
}

export default InputData;
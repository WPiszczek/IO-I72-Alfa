import axios from 'axios';
import { useState } from 'react';

function InputData() {

    const [dataType, setDataType] = useState("");
    const [sortAttrib, setSortAttrib] = useState("");
    const [array, setArray] = useState([]);
    const [file, setFile] = useState([]);
    const [fileDataType, setFileDataType] = useState("");
    const [formData, setFormData] = useState({"dataType":dataType, "arraySize":"", "sortAttrib":sortAttrib})
    const [responseData, setResponseData] = useState("");

    const [arrayError, setArrayError] = useState("");
    const [fileError, setFileError] = useState("");
    const [sortAttribError, setSortAttribError] = useState("");
    const [disableSubmit, setDisableSubmit] = useState(false);

    

    function handleDataType(_dataType) {
        setDataType(_dataType);
    }


    function handleArray(_array) {
        try {
            const a = JSON.parse(_array);
            if (Array.isArray(a) && validArrayType(a)) {
                setArray(a);
                setDisableSubmit(false);
                setArrayError("");
                
            } else {
                console.log("Error");
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
            } 
            else {
                throw Error;
            }

            if (validArrayType(f, "Number")) {
                console.log("Number 1234");
                setFileDataType("Number");
                return;
            }
            else if (validArrayType(f, "String")) {
                setFileDataType("String");
                console.log("String 1234");
                return;
            } 
            else if (validArrayType(f, "JSON")) {
                setFileDataType("JSON");
                console.log("JSON 1234");
                return;
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


    function validArrayType(array, _dataType=dataType) {
        if (_dataType === "Number") {
            for (const k of array) {
                console.log(k);
                if (!(typeof k === "number")) {
                    return false;
                }
            }
        } else if (_dataType === "String") {
            for (const k of array) {
                console.log(k);
                if (!(typeof k === "string")) {
                    return false;
                }
            }
        } else if (_dataType === "JSON") {
            for (const k of array) {
                console.log(k);
                if (!(typeof k === "object")) {
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
        setSortAttribError("");
        return true;
    }
  

    async function sendData(data) {
        try {
            let currentDataType;
            if (dataType === "File") {
                currentDataType = fileDataType;
            } else {
                currentDataType = dataType;
            }
            const response = await axios.post(`http://localhost:8080/inputData/${currentDataType}`, data);
            console.log("Response Data");
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
            formData.dataType = fileDataType;
            console.log(formData.dataType);
            console.log("SIEMANDERO");
        } else if (dataType !== "Random") {
            formData.array = array;
        }

        if (formData.sortAttrib !== '') {
            if (validSortAttrib(formData.array, formData.sortAttrib)) {
                sendData(formData);
            }
            else {

            }
        } else {
            sendData(formData);
        }
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

    function reload() {
        window.location.href = '/';
    }

    function goToSortTypePage() {
        window.location.href = '/sortType';
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
                <label htmlFor="array">Wpisz tablicę do posortowania:</label><br/>
                
                <textarea
                className="inputSortData" 
                placeholder="Tablica do posortowania" 
                name="array" 
                id="array" 
                onChange={(event) => handleInputArrayChange(event)} /><br/>
                <span className="error">{arrayError}</span><br/>
                <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={disableSubmit}/>
            </form>
        </div>
    </>}

    {dataType === "JSON" &&
    <>
        <form onSubmit={(event) => handleForm(event)}>
            <div className="inputTable">
                <label htmlFor="array">Wpisz tablicę do posortowania:</label><br/>
                <textarea
                className="inputSortData" 
                placeholder="Tablica do posortowania" 
                name="array" 
                id="array" 
                onChange={(event) => handleInputArrayChange(event)} /><br/>
                <span className="error">{arrayError}</span><br/>
            
                <label htmlFor="sortAttrib">Podaj atrybut, po którym chcesz sortować:</label>
                
                <input type="text" 
                    id="sortAttrib"
                    name="sortAttrib"
                    value={formData.sortAttrib}
                    onChange={(event) => handleFormData(event)} 
                    placeholder="Podaj atrybut sortujący"
                    className="myButton"
                    required/><br/>
                <span className="error">{sortAttribError}</span><br/>

                <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={disableSubmit}/>
            </div>           
        </form>       
    </>} 

    {dataType === "File" &&
    <>
        <div className="inputTable">
            <form onSubmit={(event) => handleForm(event)}>
                <input type="file" accept=".json" name="array" onChange={(event) => showFile(event)}/><br/>
                <span className="error">{fileError}</span><br/>
                {file !== [] && fileError === "" && 
                <>
                <div className="showArray">
                    <div className="center">
                    <ul>
                        {file.map((element, index) => {
                        return (<li key={index}>{JSON.stringify(element)}</li>);
                        })}
                    </ul>
                    </div>
                </div>
                </>
                }

                {fileDataType === "JSON" && 
                <>
                    <label htmlFor="sortAttrib">Podaj atrybut, po którym chcesz sortować:</label>
                    <input type="text" 
                        id="sortAttrib"
                        name="sortAttrib"
                        value={formData.sortAttrib}
                        onChange={(event) => handleFormData(event)} 
                        placeholder="Podaj atrybut sortujący"
                        className="myButton"
                        required/><br/>
                    <span className="error">{sortAttribError}</span><br/>
                </>}

                
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
            <div className="center">
                <ul>
                {responseData.array.map((value, index) => {
                    return (<li key={index}>{JSON.stringify(value)}</li>);
                })}
                </ul>
            </div>
        </div>
        <div className="center">
            {responseData.hasOwnProperty("sortAttrib") && responseData.sortAttrib !== '' && 
            <>
                Sortujesz po atrybucie: {responseData.sortAttrib}
            </>}
        </div>

        <div className="buttons">
            <button onClick={() => reload()} className="myButton" name="reload">Zacznij od nowa</button>
            <button onClick={() => goToSortTypePage()} className="myButton" name="forward">Przejdź dalej</button>
        </div>
    </>}
    
    </>
    );
}

export default InputData;
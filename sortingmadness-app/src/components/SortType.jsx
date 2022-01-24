import axios from 'axios';
import { useState } from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCheck } from '@fortawesome/free-solid-svg-icons'

function SortType() {
    
    const [sortType, setSortType] = useState("");
    const [reverse, setReverse] = useState(false);
    const [formData, setFormData] = useState({"sortType":sortType, "reverse":reverse})
    const [responseData, setResponseData] = useState("");

    function handleSortType(_sortType) {
        setSortType(_sortType);
    }

    function handleReverse() {
        setReverse(!reverse);
    }

    function handleResponseData(_responseData) {
        setResponseData(_responseData);
    }

    function handleForm(e) {
        e.preventDefault();
        console.log("Zmiana");
        formData.sortType = sortType;
        formData.reverse = reverse;
        console.log(formData);
        sendData(formData);
        goToResult();
    }

    async function sendData(data) {
        try {
            console.log(data);
            const response = await axios.post(`http://localhost:8080/sortType`, data);
            console.log("Response Data");
            handleResponseData(response.data);
            console.log(responseData);
        } catch (error) {
            console.log(error);
        }
    }  

    function isDisabledSubmit() {
        if (sortType !== "") return false;
        return true;
    }

    function reload() {
        window.location.href = '/';
    }

    function goToResult() {
        window.location.href = `/result/${sortType}`;
    }
    
    return (
    <>
        <div className="info">
            <header>Wybierz rodzaj sortowania {(sortType !== "" ? `- ${sortType}` : "")}</header>
        </div>

        <div className="center">
            <form onSubmit={(event) => handleForm(event)}>
                <div className="yourChoice">
                    <button type="button" onClick={() => handleSortType("BubbleSort") } className="myButton" name="sortType">BubbleSort</button>
                    <button type="button" onClick={() => handleSortType("HeapSort") } className="myButton" name="sortType">HeapSort</button>
                    <button type="button" onClick={() => handleSortType("InsertionSort") } className="myButton" name="sortType">InsertionSort</button>
                    <button type="button" onClick={() => handleSortType("QuickSort") } className="myButton" name="sortType">QuickSort</button>
                    <button type="button" onClick={() => handleSortType("SelectionSort") } className="myButton" name="sortType">SelectionSort</button>
                    <button type="button" onClick={() => handleSortType("ShellSort") } className="myButton" name="sortType">ShellSort</button>
                </div>

                <div className="center">
                    <div className="centerButton">
                        <button type="button" onClick={() => handleReverse() } className="myButton" name="reverse">Reverse</button>
                        {reverse ? <FontAwesomeIcon icon={faCheck} size="lg" className="checkIcon" /> : '' }
                    </div>
                </div>
                <br/>

                <div className="buttons">
                    <button type="button" onClick={() => reload()} className="myButton" name="reload">Zacznij od nowa</button>
                    <input type="submit" id="submit" name="submit" value="Zatwierdź" className="myButton" disabled={isDisabledSubmit()}/>
                </div>
          
            </form>
        </div>
    </>
    );
}

export default SortType;
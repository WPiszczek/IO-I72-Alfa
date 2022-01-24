import axios from 'axios';
import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';

function Result() {

    const {sortType} = useParams();

    const [responseData, setResponseData] = useState({"sortType":"", "unsortedArray":[], "sortedArray":[], "time":""});


    function handleResponseData(_responseData) {
        setResponseData(_responseData);
    }

    async function getData() {
        try {
            const response = await axios.get(`http://localhost:8080/result/${sortType}`);
            console.log("Response Data");
            // console.log(response.data);
            handleResponseData(response.data);
            // console.log(responseData);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getData();
    }, []);

    function reload() {
        window.location.href = '/';
    }

    function goToSortTypePage() {
        window.location.href = '/sortType';
    }

    return (
    <>
        <div className="info"><header>Posortowane dane: {sortType}</header></div>
        

        {responseData !== {} && 
        <>
            <div className="center">
                <h2>Czas wykonania: {responseData.time / 1000000.0} ms</h2> 
            </div>

            <div className="yourSpaces">
                <div>
                    <div className="center"><h2>Przed sortowaniem:</h2></div><br/>
                    <div className="showArray">
                        <ul>
                        {responseData.unsortedArray.map((value, index) => {
                            return (<li key={index}>{value}</li>);
                        })}
                        </ul>
                    </div>
                </div>

                <div>
                    <div className="center"><h2>Po sortowaniu:</h2></div><br/>
                    <div className="showArray">
                        <ul>
                        {responseData.sortedArray.map((value, index) => {
                            return (<li key={index}>{value}</li>);
                        })}
                        </ul>
                    </div>
                </div>
            
            </div>          
            
            <div className="buttons">
                <button type="button" onClick={() => reload()} className="myButton" name="reload">Zacznij od nowa</button>
                <button type="button" onClick={() => goToSortTypePage()} className="myButton" name="forward">Wybierz inny typ sortowania</button>
            </div>
        </>}
    </>
    );
}

export default Result;
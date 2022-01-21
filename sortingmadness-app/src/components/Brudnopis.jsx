{dataType !== "" && <>
        <Input dataType={dataType}/> 

        <div className="singleInput">
            <label for="reverse"></label>
            <input onClick={() => handleReverse()} type="checkbox" name="reverse" id="reverse"/>
        </div>
        <div className="yourChoice">
            <button onClick={() => setSortType("BubbleSort") } className="myButton" name="sortType">BubbleSort</button>
            <button onClick={() => setSortType("HeapSort") } className="myButton" name="sortType">HeapSort</button>
            <button onClick={() => setSortType("InsertionSort") } className="myButton" name="sortType">InsertionSort</button>
            <button onClick={() => setSortType("QuickSort") } className="myButton" name="sortType">QuickSort</button>
            <button onClick={() => setSortType("SelectionSort") } className="myButton" name="sortType">SelectionSort</button>
            <button onClick={() => setSortType("ShellSort") } className="myButton" name="sortType">ShellSort</button>
        </div>
</>}
import React, { useState } from 'react';
import axios from 'axios';

const FibApp = () =>{
    const[inputValue, setInputValue] = useState('');
    const[result, setResult] = useState({});

    const handleInputChange = (e) =>{
        setInputValue(e.target.value);
    };

    const handleGenFib = async () => {
        try{
            const response = await axios.get(`http://localhost:8080/fibonacci/api?elements=${inputValue}`)
            setResult(response.data);       
        }catch(error){
            console.error("Fail to fetch Fibonacci Sequence", error);
        }
    };

    return(
        <div>
            <input type="number" value={inputValue} onChange={handleInputChange} />
            <button onClick={handleGenFib}>Generate Fibonacci</button>

      {result && (
        <div>
          <h3>Fibonacci Sequence</h3>
          <div>{JSON.stringify(result.fib, null, 2)}</div>


          <h3>Sorted Fibonacci Sequence</h3>
          <pre>{JSON.stringify(result.fibSort, null, 2)}</pre>
        </div>
      )}
        </div>
    );
};

export default FibApp;
import {useEffect, useState} from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import axios from "axios";

function App() {
  const [count, setCount] = useState(0)
    const [apiResult, setApiResult] = useState('');
    // 컴포넌트가 마운트 될 때 API를 호출합니다.
  useEffect(() => {
    // API 호출
    axios.get('http://localhost:8080/api')
        .then((res) => {
          console.log(res.data);
          setApiResult(res.data); // API 결과를 state에 저장합니다.
        })
        .catch(err => console.error(err)); // 에러 핸들링
  }, []); // 빈 배열을 dependency로 전달하여 한 번만 실행하게 합니다.

  useEffect(() => {
    // API 호출
    axios.get('http://localhost:8080/cors')
        .then((res) => {
          console.log(res.data);
        })
        .catch(err => console.error(err)); // 에러 핸들링
  }, []); // 빈 배열을 dependency로 전달하여 한 번만 실행하게 합니다.

  useEffect(() => {
    // API 호출
    axios.get('http://localhost:8080/api/users')
        .then((res) => console.log(res.data))
        .catch(err => console.error(err)); // 에러 핸들링
  }, []); // 빈 배열을 dependency로 전달하여 한 번만 실행하게 합니다.

    return (
    <>
      <div>
        <a href="https://vitejs.dev" target="_blank">
          <img src={viteLogo} className="logo" alt="Vite logo" />
        </a>
        <a href="https://react.dev" target="_blank">
          <img src={reactLogo} className="logo react" alt="React logo" />
        </a>
      </div>
      <div>
        Api Result(GET /): <u style={{color: 'greenyellow'}}>{apiResult}</u>
      </div>
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App

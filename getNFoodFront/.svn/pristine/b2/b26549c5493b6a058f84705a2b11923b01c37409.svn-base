import React, { useState } from 'react';
import '../css/Login.css';
import { Link } from 'react-router-dom';
import NavbarComponents from './Navbar';
import axios from 'axios';
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const [userId, setUserId] = useState('');


  const loginSuccess = () => {

    setTimeout(() => {
      navigate("/#")
    }, 1000)
  }

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!id.trim() && !password.trim()) {
      setError('아이디와 비밀번호를 입력하지 않았습니다.');
    } else if (!id.trim()) {
      setError('아이디를 입력하지 않았습니다.');
    } else if (!password.trim()) {
      setError('비밀번호를 입력하지 않았습니다.');
    } else if (password.length < 3) {  // 2자가 아니라 8자 미만일 때 검사
      setError('비밀번호는 8자 이상이어야 합니다.');
    } else {
      axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/login`, {
        "loginId": id,
        "password": password,
      }, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
      })
        .then((response) => {
          console.log(response.data);
          const userId = response.data;
          if (userId) {
            localStorage.setItem('userId', userId);  // 응답을 직접 사용하여 localStorage 설정
            setUserId(userId);  // 앱의 다른 부분에서 필요한 경우 상태 업데이트
            setTimeout(() => {
              window.location.reload();
            }, 1000)

          }
        })
        .catch(error => {
          console.error('Error fetching data:', error);
          setError('로그인 실패: 서버 에러가 발생했습니다.');
        });
    }
  };


  let loginUserId = localStorage.getItem('userId')
  console.log(loginUserId)


  return (
    <>
      <NavbarComponents />
      <div className="login-box">

        <form onSubmit={handleSubmit}>
          <div className="user-box">
            <input
              type="text"
              name="id"
              value={id}
              onChange={(e) => setId(e.target.value)}
              required
            />
            <label>아이디</label>
          </div>
          <div className="user-box">
            <input
              type="password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
            <label>패스워드</label>
          </div>

          <button type="submit" className='submit' onClick={loginSuccess}>로그인</button>
          <span></span>
          <span></span>
          <span></span>
          <span></span>


          <a href='Register' className='register'>회원가입</a>
        </form>
        {error && <p className="error">{error}</p>}
      </div>
    </>
  )
}

export default Login;
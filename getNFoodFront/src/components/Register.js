import React, { useState } from 'react';
import '../css/Register.css'
import { Link } from 'react-router-dom';
import NavbarComponents from './Navbar';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  const navigate = useNavigate();
  const [loginId, setLoginId] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [userName, setUserName] = useState('');
  const [error, setError] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();

    // 여기에 회원가입 로직을 구현합니다.
    // 입력값 유효성 검사 등을 수행할 수 있습니다.
  };


  const signUp = () => {
    const response = axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/signup`, {
      "loginId": loginId,
      "password": password,
      "email": email,
      "userName": userName,
      "usePhone": phoneNumber
    })
      .then((response) => {
        console.log(response.data)
        navigate("http://localhost:3000")
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  }
  return (
    <>
      <NavbarComponents />
      <div className='content-wrap storeList-wrap main-logo-noToggle'>
        <a href="/#"><p className='main-logo storeList-logo'>Get & Food</p></a>
      </div>
      <div className="register-container">
        <p style={{ fontSize: '40px', fontWeight: 'bold' }}>회원가입</p>
        <form>
          <div className="form-group">
            <label htmlFor="loginId">아이디 : </label>
            <input
              type="text"
              id="loginId"
              name="loginId"
              value={loginId}
              onChange={(e) => setLoginId(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="email">Email : </label>
            <input
              type="email"
              id="email"
              name="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="password">비밀번호 : </label>
            <input
              type="password"
              id="password"
              name="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="confirmPassword">비밀번호 확인 : </label>
            <input
              type="password"
              id="confirmPassword"
              value={confirmPassword}
              onChange={(e) => setConfirmPassword(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="userName">닉네임 : </label>
            <input
              type="userName"
              id="userName"
              name="userName"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="phoneNumber">전화번호 : </label>
            <input
              type="tel"
              id="usePhone"
              name="usePhone"
              value={phoneNumber}
              onChange={(e) => setPhoneNumber(e.target.value)}
              required
            />
          </div>

          <button onClick={signUp} type="button" className='button-rg'>가입하기</button>
          {error && <p className="error">{error}</p>}
          <p>
            이미 회원이신가요? <Link to="/login">로그인</Link>
          </p>
        </form>
      </div>
    </>
  );
};

export default Register;
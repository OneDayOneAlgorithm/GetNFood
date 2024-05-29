import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/CustomerMyPage.css'; // CSS 파일 불러오기
import { NavbarCollapse } from 'react-bootstrap';
import NavbarComponents from './Navbar';
import { height } from '@fortawesome/free-brands-svg-icons/faDAndD';

const CustomerMyPage = (props) => {
  const [isEditing, setIsEditing] = useState(false); // 수정 모드 상태
  const [editedUser, setEditedUser] = useState({
    userId: 'exampleUser123',
    nickname: '예시 닉네임',
    address: '예시 주소',
    email: 'example@example.com',
    phoneNumber: '010-1234-5678',
    password: '********', // 보안상 이 부분은 비밀번호를 표시하는 것이 아니라 가려져야 합니다.
    profileImage: 'https://via.placeholder.com/150', // 예시 프로필 이미지 URL
  }); // 수정된 사용자 정보 상태


  const userId = localStorage.getItem('userId')
  console.log(userId)

  useEffect(() => {
    props.loadMyPage(userId)
    console.log(props.profile)
  }, [])

  console.log(props.profile)

  // 수정 모드로 변경하는 함수
  const handleEdit = () => {
    setIsEditing(true);
  };

  // 입력 필드의 값을 변경하는 함수
  const handleChange = (e) => {
    const { name, value } = e.target;
    setEditedUser(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  // 프로필 이미지를 선택하고 변경하는 함수
  const handleImageChange = (e) => {
    const imageFile = e.target.files[0];
    if (imageFile) {
      const reader = new FileReader();
      reader.onload = () => {
        setEditedUser(prevState => ({
          ...prevState,
          profileImage: reader.result // 이미지 URL로 설정
        }));
      };
      reader.readAsDataURL(imageFile);
    }
  };

  // 입력 필드를 저장하는 함수
  const handleSave = () => {
    setIsEditing(false);
    // 여기에 수정된 사용자 정보를 저장하는 로직 추가
  };

  return (
    <>
      <NavbarComponents />
      <div style={{ "height": "150px" }}></div >
      <div className="customer-my-page">
        <h1>마이 페이지</h1>
        <div className="user-info">
          <div className="profile-image-container">
            <span className="profile-image-label"></span>
            {isEditing ? (
              <div className="profile-image-edit-container">
                <img style={{ "height": "200px" }} src={props.profile && props.profile.userPhotoUrl} alt="프로필 이미지" className="profile-image" />
                <input type="file" accept="image/*" onChange={handleImageChange} />
              </div>
            ) : (
              <img style={{ "height": "300px" }} src={props.profile && props.profile.userPhotoUrl} alt="프로필 이미지" className="profile-image" />
            )}
          </div>
          <div className="user-info-details">
            <div className="info-item">
              <span className="label">아이디 :</span>
              {isEditing ? (
                <input type="text" name="userId" value={props.profile && props.profile.loginId} onChange={handleChange} />
              ) : (
                <span className="value">{props.profile && props.profile.loginId}</span>
              )}
            </div>
            <div className="info-item">
              <span className="label">주소 :</span>
              {isEditing ? (
                <input type="text" name="address" value={props.profile && props.profile.address} onChange={handleChange} />
              ) : (
                <span className="value">{props.profile && props.profile.address}</span>
              )}
            </div>
            <div className="info-item">
              <span className="label">이메일 :</span>
              {isEditing ? (
                <input type="email" name="email" value={props.profile && props.profile.email} onChange={handleChange} />
              ) : (
                <span className="value">{props.profile && props.profile.email}</span>
              )}
            </div>
            <div className="info-item">
              <span className="label">휴대번호 :</span>
              {isEditing ? (
                <input type="tel" name="phoneNumber" value={props.profile && props.profile.userPhone} onChange={handleChange} />
              ) : (
                <span className="value">{props.profile && props.profile.userPhone}</span>
              )}
            </div>
            <div className="info-item">
              <span className="label">비밀번호 :</span>
              {isEditing ? (
                <input type="password" name="password" value={editedUser.password} onChange={handleChange} />
              ) : (
                <span className="value">{editedUser.password}</span>
              )}
            </div>
          </div>
          <hr className="line" />
        </div>
        <div className="btn-container">
          {isEditing ? (
            <button className="btn save-btn" onClick={handleSave}>저장</button>
          ) : (
            <>
              <Link to="/customermypage/orders">
                <button className="btn orders-btn">주문내역</button>
              </Link>
              <Link to="/customermypage/address/add">
                <button className="btn address-add-btn">주소추가</button>
              </Link>
              <button className="btn edit-btn" onClick={handleEdit}>수정</button>
              <button className="btn withdraw-btn">회원탈퇴</button>
            </>
          )}
        </div>
      </div>
    </>
  );
};

export default CustomerMyPage;

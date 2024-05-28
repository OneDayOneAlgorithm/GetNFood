import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import '../css/OwnerMyPage.css'; // CSS 파일 불러오기
import { faDAndD } from '@fortawesome/free-brands-svg-icons/faDAndD';
import NavbarComponents from './Navbar';

const OwnerMyPage = (props) => {
  const [storeInfo, setStoreInfo] = useState({
    storeName: '',
    phoneNumber: '',
    address: '',
    openingHours: '',
    closingDays: '',
    introduction: '',
    storeImage: '',
    category: ''
  });



  useEffect(() => {
    const userId = localStorage.getItem("userId")
    console.log(userId)
    props.loadMyStore(userId)
    console.log(props.myStore)
  }, [])

  const [editMode, setEditMode] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStoreInfo({ ...storeInfo, [name]: value });
  };

  //  수정 버튼을 누르면 수정 모드를 활성화 하는 함수
  const handleEdit = () => {
    setEditMode(true);
  };

  // 저장 버튼을 누르면 수정 모드를 비활성화하고 변경된 데이터를 처리하는 함수
  const handleSave = () => {
    setEditMode(false);
    // 여기서 필요한 로직을 추가하여 수정된 데이터를 처리할수 있습니다.
  };

  return (
    <>
      <NavbarComponents />
      <div style={{ "height": "150px", "position": "relative", "left": "60px" }}></div>
      <p className='ownerManagement'>가게관리</p>
      <div className="owner-mypage-container-wjh">
        <form onSubmit={(e) => e.preventDefault()}>
          <div className="left-section-wjh">
            <div className="form-group-wjh">
              <label htmlFor="storeName">가게이름: </label>
              <input
                className={`owinputbutton-wjh ${editMode ? 'editable' : ''}`}
                type="text"
                id="storeName"
                placeholder={props.myStore && props.myStore.storeName}
                name="storeName"
                value={storeInfo.storeName}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정
              />
            </div>
            <div className="form-group-wjh">
              <label htmlFor="phoneNumber">전화번호: </label>
              <input
                className={`owinputbutton-wjh ${editMode ? 'editable' : ''}`}
                type="text"
                id="phoneNumber"
                placeholder={props.myStore && props.myStore.phoneNumber}
                name="phoneNumber"
                value={storeInfo.phoneNumber}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              />
            </div>
            <div className="form-group-wjh">
              <label htmlFor="address">가게주소: </label>
              <input
                className={`owinputbutton-wjh ${editMode ? 'editable' : ''}`}
                type="text"
                id="address"
                name="address"
                placeholder={props.myStore && props.myStore.storeAddr}
                value={storeInfo.address}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              />
            </div>
            <div className="form-group-wjh">
              <label htmlFor="openingHours">운영시간: </label>
              <input
                className={`owinputbutton-wjh ${editMode ? 'editable' : ''}`}
                type="text"
                id="openingHours"
                name="openingHours"
                placeholder={props.myStore && props.myStore.operationTime}
                value={storeInfo.openingHours}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              />
            </div>
            <div className="form-group-wjh">
              <label htmlFor="closingDays">가게휴무: </label>
              <input
                className={`owinputbutton-wjh ${editMode ? 'editable' : ''}`}
                type="text"
                id="closingDays"
                name="closingDays"
                placeholder={props.myStore && props.myStore.dayOff}
                value={storeInfo.closingDays}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              />
            </div>
          </div>


          <div className="right-section-wjh">
            <div className="form-group-wjh">
              <label htmlFor="introduction">가게 소개: </label>
              <div>
                <textarea
                  className='owtextarea-wjh'
                  id="introduction"
                  name="introduction"
                  value={storeInfo.introduction}
                  placeholder={props.myStore && props.myStore.storeContent}
                  onChange={handleChange}
                  readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

                ></textarea>
              </div>
            </div>
            <div className="form-group-wjh">
              <label htmlFor="storeImage">가게 사진: </label>
              <input
                type="file"
                id="storeImage"
                name="storeImage"
                accept="image/*"
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              />
            </div>
            <div className="form-group-wjh">
              <label htmlFor="category">카테고리: </label>
              <select
                id="category"
                name="category"
                value={storeInfo.category}
                onChange={handleChange}
                readOnly={!editMode} //  수정 모드가 아닐때 입력 필드를 읽기 전용으로 설정

              >
                <option value="">카테고리 선택</option>

                <option value="KOREAN">한식</option>
                <option value="CHINESE">중식</option>
                <option value="JAPANESE">일식</option>
                <option value="WESTERN">양식</option>
                <option value="CHICKEN">치킨</option>
                <option value="PIZZA">피자</option>
                <option value="BURGER">패스트푸드</option>
                <option value="MEAT">육류</option>
                <option value="BREAD">빵</option>
                <option value="DESSERTS">디저트</option>
                <option value="VEGETABLE">채소</option>
                <option value="FRUITS">과일</option>
                {/* 다른 카테고리도 필요한 경우에 옵션을 추가하세요 */}
              </select>
            </div>
          </div>
          {editMode ? (
            <button type="button" className="edit-button-wjh" onClick={handleSave}>
              저장
            </button>
          ) : (
            <button style={{ "marginTop": "81px" }} type="button" className="edit-button-wjh" onClick={handleEdit}>
              수정
            </button>
          )}
        </form>
      </div>
    </>
  );
};

export default OwnerMyPage;

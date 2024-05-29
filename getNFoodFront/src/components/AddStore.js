import NavbarComponents from "./Navbar";
import Footer from "./Footer";
import { useState } from "react";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const AddStore = () => {
    const navigate = useNavigate()

    const [storeInfo, setStoreInfo] = useState({
        storeName: '',
        phoneNumber: '',
        address: '',
        openingHours: '',
        businessNumber: '',
        introduction: '',
        storeImage: '',
        category: ''
    });

    console.log(storeInfo.phoneNumber)
    console.log(storeInfo.category)

    const userId = localStorage.getItem('userId')

    const handleChange = (e) => {
        const { name, value } = e.target;
        setStoreInfo({ ...storeInfo, [name]: value });
    };

    const addOwnerStore = async () => {
        try {
            const response = await axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/stores`, {
                "userId": userId,
                "phoneNumber": storeInfo.phoneNumber,
                "storeName": storeInfo.storeName,
                "storeAddr": storeInfo.address,
                "foodCategory": storeInfo.category,
                "businessNumber": storeInfo.businessNumber,
            });
            console.log(response.data); // 결과 확인
            alert("가게 추가가 완료되었습니다.")
            navigate("/")

        } catch (error) {
            console.error('Error adding store:', error);
        }
    };

    return (
        <>
            <NavbarComponents />
            <div style={{ "height": "150px" }}></div>
            <p className='ownerManagement'>가게관리</p>
            <div className="owner-mypage-container-wjh">
                <form onSubmit={(e) => {
                    e.preventDefault();
                    addOwnerStore();
                }}>
                    <div className="left-section-wjh">
                        { /* 각 입력 필드에 readOnly 속성을 제거하고, 항상 편집 가능하게 설정 */}
                        <div className="form-group-wjh">
                            <label htmlFor="storeName">가게이름 :</label>
                            <input style={{ marginLeft: "15px" }} type="text" id="storeName" name="storeName" value={storeInfo.storeName} onChange={handleChange} />
                        </div>
                        <div className="form-group-wjh">
                            <label htmlFor="phoneNumber">전화번호 :</label>
                            <input style={{ marginLeft: "15px" }} type="text" id="phoneNumber" name="phoneNumber" value={storeInfo.phoneNumber} onChange={handleChange} />
                        </div>
                        <div className="form-group-wjh">
                            <label htmlFor="address">가게주소 :</label>
                            <input style={{ marginLeft: "15px" }} type="text" id="address" name="address" value={storeInfo.address} onChange={handleChange} />
                        </div>
                        <div className="form-group-wjh">
                            <label htmlFor="openingHours">운영시간 :</label>
                            <input style={{ marginLeft: "15px" }} type="text" id="openingHours" name="openingHours" value={storeInfo.openingHours} onChange={handleChange} />
                        </div>
                        <div style={{ "position": "relative", "left": "-19px" }} className="form-group-wjh">
                            <label htmlFor="closingDays" >사업자번호 :  </label>
                            <input style={{ marginLeft: "15px" }} type="text" id="closingDays" name="businessNumber" value={storeInfo.businessNumber} onChange={handleChange} />
                        </div>
                    </div>
                    <div className="right-section-wjh">
                        <div className="form-group-wjh">
                            <label htmlFor="introduction">가게 소개 :</label>
                            <div> <textarea id="introduction" name="introduction" value={storeInfo.introduction} onChange={handleChange}></textarea></div>
                        </div>
                        <div className="form-group-wjh">
                            <label htmlFor="storeImage">가게 사진 :</label>
                            <input style={{ "marginLeft": "440px", "position": "relative", "bottom": "155px" }} type="file" id="storeImage" name="storeImage" accept="image/*" onChange={handleChange} />
                        </div>
                        <div className="form-group-wjh">
                            <label style={{ "position": "relative", "left": "440px", "bottom": "150px" }} htmlFor="category">카테고리 :</label>
                            <select style={{ "position": "relative", "left": "350px", "bottom": "110px" }} id="category" name="category" value={storeInfo.category} onChange={handleChange}>
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
                    <button type="submit" className="edit-button-wjh">추가</button>
                </form>
            </div>
        </>
    );
}

export default AddStore;

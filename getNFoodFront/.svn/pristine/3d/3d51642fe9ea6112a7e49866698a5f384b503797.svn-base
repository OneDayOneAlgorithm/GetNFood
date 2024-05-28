// MenuManagement.js

import React, { useState, useEffect } from 'react';
import '../css/MenuManagement.css';

const MenuManagement = () => {
  const [menuItems, setMenuItems] = useState([]);
  const [newMenuItem, setNewMenuItem] = useState({ 
    name: '', 
    price: '', 
    stock: '', 
    pickupTime: '', 
    image: null 
  });
  const [storeName, setStoreName] = useState('');
  const [editedStoreName, setEditedStoreName] = useState(''); // 가게 이름 수정을 위한 state
  const [isSaved, setIsSaved] = useState(false); // 저장 상태를 나타내는 상태 추가
  
  const addMenuItem = () => {
    if (newMenuItem.name && newMenuItem.price) {
      const newItem = { ...newMenuItem };
      setMenuItems([newItem, ...menuItems]);
      setNewMenuItem({ name: '', price: '', stock: '', pickupTime: '', image: null });
    } else {
      alert('메뉴 이름과 가격을 입력해주세요!');
    }
  };

  const deleteMenuItem = (index) => {
    const updatedMenuItems = [...menuItems];
    updatedMenuItems.splice(index, 1);
    setMenuItems(updatedMenuItems);
  };

  const handleInputChange = (e, index) => {
    const { name, value } = e.target;
    const updatedMenuItems = [...menuItems];
    updatedMenuItems[index][name] = value;
    setMenuItems(updatedMenuItems);
  };

  // 이미지 파일 선택 시 호출되는 함수
  const handleImageChange = (e, index) => {
    const file = e.target.files[0];
    if (!file) return; // 파일을 선택하지 않은 경우 처리
    const reader = new FileReader();
    reader.onload = () => {
      setNewMenuItem({ ...newMenuItem, image: reader.result });
    };
    reader.readAsDataURL(file);
  };

  const handleStoreNameChange = (e) => {
    setEditedStoreName(e.target.value);
  };

  const saveStoreName = () => {
    if (editedStoreName.trim() !== '') {
      setStoreName(editedStoreName.trim());
      setEditedStoreName(''); //가게 이름 저장후 입력 필드 초기화
      setIsSaved(true); // 저장되었다는 상태를 true로 변경
    } else {
      alert('가게 이름을 입력하세요!');
    }
  };

  useEffect(() => {
    let timer;
    if (isSaved) {
      timer = setTimeout(() => setIsSaved(false), 2000);
    }
    return () => clearTimeout(timer); // 컴포넌트가 unmount될 때 타이머 해제
  }, [isSaved]);

  return (
    <div className="menu-management-wjh">
      <div className='menu-boxdesign-wjh'>
      <h4 style={{ textAlign: 'center' }}>메뉴 관리 </h4>
      <div className='storeName-wjh'>
        <p style={{color:'black', fontSize: '2rem', fontWeight: '550'}}>가게명:</p>
        {/* <input
          type="text"
          value={editedStoreName !== '' ? editedStoreName : storeName} // 수정된 가게 이름이 있으면 표시, 아니면 기존 가게 이름 표시
          onChange={handleStoreNameChange}
          style={{ marginLeft: '0.5rem' }}
        /> */}
        <p style={{fontSize:'30px', color:'black'}}>지용국밥부</p>
        
        
      </div>
      <p style={{fontSize:'20px'}}>12345678 | 카페 · 디저트</p>
      </div>
     

      <div style={{ borderBottom: '5px solid #DBDBDB', marginTop: '4rem' }}></div>
      <p style={{ textAlign: 'left', fontWeight: 'bold', fontSize: '40px'}}>메뉴추가</p>

      <div className="menu-form">
        <div className='menu-form1'>
        <input
          type="text"
          placeholder="메뉴 이름"
          name="name"
          value={newMenuItem.name}
          onChange={(e) => setNewMenuItem({ ...newMenuItem, name: e.target.value })}
        />
        </div>
        <div className='menu-form2'>
        <input
          type="text"
          placeholder="가격"
          name="price"
          value={newMenuItem.price}
          onChange={(e) => setNewMenuItem({ ...newMenuItem, price: e.target.value })}
        />
        </div>
        <div className='menu-form3'>
        <input
          type="text"
          placeholder="재고"
          name="stock"
          value={newMenuItem.stock}
          onChange={(e) => setNewMenuItem({ ...newMenuItem, stock: e.target.value })}
        />
        </div>
        <div className='menu-form4'>
        <input
          type="text"
          placeholder="픽업시간"
          name="pickupTime"
          value={newMenuItem.pickupTime}
          onChange={(e) => setNewMenuItem({ ...newMenuItem, pickupTime: e.target.value })}
        />
        </div>
        <div className='menu-form5'>
        <input
          type="file"
          accept="image/*"
          onChange={(e) => handleImageChange(e, menuItems.length)}
        />
        <button onClick={addMenuItem}>추가</button>
        </div>
      </div>
      <div style={{ borderBottom: '15px solid #DBDBDB', marginTop: '4rem' }}></div>

      <p style={{ textAlign: 'left', fontWeight: 'bold', fontSize: '40px'}}>인기메뉴</p>
      <ul>
        {menuItems.map((item, index) => (
          <li key={index} className="new-menu-item"> {/* 여기에 클래스 추가 */}
            <input
            className='menu--1'
              type="text"
              value={item.name}
              onChange={(e) => handleInputChange(e, index)}
              name="name"
            />
            
          <div>
            <input
            className='menu--2'
              type="text"
              value={item.price}
              onChange={(e) => handleInputChange(e, index)}
              name="price"
            />
          </div>

          <div>
            <input
            className='menu--3'
              type="text"
              value={item.stock}
              onChange={(e) => handleInputChange(e, index)}
              name="stock"
            />
          </div>

          <div>
            <input
            className='menu--4'
              type="text"
              value={item.pickupTime}
              onChange={(e) => handleInputChange(e, index)}
              name="pickupTime"
            />
          </div>

     
            {item.image && <img className='menu--5-1' src={item.image} alt="메뉴 이미지" style={{ width: '200px', height: '200px' }} />}
            <button className='menu--5-2' onClick={() => deleteMenuItem(index)}>삭제</button>

          </li>
        ))}
      </ul>
    </div>
  );
};

export default MenuManagement;

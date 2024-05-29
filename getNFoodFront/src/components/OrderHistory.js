import React from 'react';

// Mock data for order history
const orders = [
  {
    date: '4.3 (수)',
    storeName: '대왕보쌈 하양점',
    image: '../logoImg/FOOD_JOCKBAL.jpeg', // Replace with actual image URL
    menu: '보쌈족 + 소(막국수 없음) 1개',
    price: '31,000원',
    discount: '3,000원 할인 받음',
  },
  {
    date: '4.1 (월)',
    storeName: 'BHC 하양점',
    image: '../logoImg/FOOD_CHICKEN.jpeg', // Replace with actual image URL
    menu: '맛초킹 1개',
    price: '21,000원',
    discount: '2,000원 할인 받음',
  }
];

const OrderHistory = () => {
  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <p style={{fontSize:'3rem', fontWeight:'550', textAlign:'center'}}>주문내역</p>
      <div style={{ marginBottom: '20px', backgroundColor:'#E7E5E5', width:'35rem', height:'4rem',textAlign:'center', borderRadius:'3rem', display:'flex', alignItems:'center', justifyContent:'center'}}>
        <img style={{width:'3rem'}} src="../logoImg/loading.png" />
        <label style={{fontWeight:'550', marginLeft:'1rem', fontSize:'25px'}} htmlFor="searchPastOrders"> 주문했던 메뉴와 가게를 검색해보세요</label>
      </div>
      {orders.map((order, index) => (
        <div key={index} style={{ border: '1px solid #ccc', borderRadius: '8px', marginBottom: '20px', padding: '10px', backgroundColor: '#f9f9f9' }}>
          <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '10px' }}>
            <span>{order.date} 배달완료</span>
            <button style={{ padding: '5px 10px', border: '1px solid #ccc', borderRadius: '5px', backgroundColor: '#fff' }}>주문상세</button>
          </div>
          <div style={{ display: 'flex', alignItems: 'center' }}>
            <img src={order.image} alt={order.storeName} style={{ width: '150px', height: '150px', marginRight: '10px', borderRadius: '8px' }} />
            <div style={{ flex: 1 }}>
              <h3 style={{ margin: '0 0 5px 0' , fontWeight:'550'}}>{order.storeName}</h3>
              <p style={{ margin: '0 0 5px 0' }}>{order.menu} {order.price}</p>
              <button style={{ padding: '5px 10px', border: '1px solid #ccc', borderRadius: '5px', backgroundColor: '#D5B5E9', color:'white' }}>{order.discount}</button>
            </div>
            
          </div>
          <button style={{ marginTop:'1rem',marginLeft: '10px', padding: '5px 10px', border: '1px solid #00c896', borderRadius: '5px', backgroundColor: '#fff', color: '#00c896', width:'100rem', height:'3.5rem' }}>같은 메뉴 담기</button>
        </div>
      ))}
    </div>
  );
};

export default OrderHistory;
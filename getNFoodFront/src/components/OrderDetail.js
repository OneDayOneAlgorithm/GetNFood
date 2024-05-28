import React from 'react';
import context from 'react-bootstrap/esm/AccordionContext';

const OrderDetail = () => {
  const order = {
    status: '메뉴를 준비 중이에요',
    storeName: '대왕보쌈 하양점',
    menu: '보쌈족 + 소 (막국수 없음) 1개',
    discount: '3,000원 할인 받음',
    orderDate: '2024년 04월 10일 오전 07:51',
    orderNumber: '202404100751',
    items: [
      {
        name: '보쌈족 + 소 (막국수 없음)',
        quantity: 1,
        price: '31,000원',
        options: '단품 / 2-3인분 추가반찬 (31,000원)'
      }
    ],
    totalAmount: '31,000원',
    discountAmount: '3,000원',
    finalAmount: '28,000원',
    paymentMethod: '토스페이',
    contact: '010-1234-5678',
    address: '경상북도 경산시 하양읍금락3길 18-16 1층 (서부, 진주스 치킨V, 타치U)',
    context: '(수저, 포크 X)(김치, 단무지 O)'
  };

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
      <p style={{ fontSize: '50px', fontWeight: '550', textAlign: 'center' }}>주문상세</p>
      <p style={{ fontSize: '30px', fontWeight: '550', color: '#2CCBA5' }}>{order.status}</p>
      <p style={{ fontSize: '30px', fontWeight: '550', color: 'black' }}>{order.storeName}</p>
      <p>{order.menu}</p>
      <button style={{ padding: '5px 10px', border: '1px solid #ccc', borderRadius: '3rem', backgroundColor: '#D5B5E9', marginBottom: '20px', color: '#fff' }}>{order.discount}</button>
      {/* <p>주문번호: {order.orderNumber}</p> */}
      <p>주문일시: {order.orderDate}</p>
      <button style={{backgroundColor:'#2CCBA5'}}>
        <img style={{ width: '30px', marginRight: '0.25rem' }} src="../logoImg/eye.png" alt="" />
        가게보기
      </button>
      <hr />
      {order.items.map((item, index) => (
        <div key={index} style={{ marginBottom: '20px' }}>
          <p style={{ fontSize: '25px', fontWeight: '550' }}>{item.name} {item.quantity}개</p>
          <p>{item.options}</p>
          {/* <p>{item.price}</p> */}
        </div>
      ))}
      <hr />
      <div style={{ marginBottom: '20px' }}>
        <p style={{ fontSize: '25px', fontWeight: '550' }}>결제금액</p>

        <div style={{ display: 'flex' }}>
          <p>주문금액:</p>
          <p style={{marginLeft:'auto'}}>{order.totalAmount}</p>
        </div>
        <div style={{ display: 'flex' }}>
          <p>할인금액: </p>
          <p style={{marginLeft:'auto'}}> {order.discountAmount}</p>
        </div>

        <div style={{ display: 'flex' }}>
          <p style={{ fontSize: '25px', fontWeight: '550' }}>총 결제금액: </p>
          <p style={{ fontSize: '25px', fontWeight: '550', marginLeft:'auto' }}>{order.finalAmount}</p>
        </div>

        <div style={{display: 'flex'}}>
          <p>결제방법: </p>
          <p style={{marginLeft:'auto'}}>{order.paymentMethod}</p>
        </div>
      </div>
      <hr />
      <div style={{ marginBottom: '20px' }}>
        <p style={{ fontSize: '16px', fontWeight: '550', margin: '0px' }}>연락처</p>
        <p style={{ margin: '3px' }}>{order.contact}</p>
        <p style={{ fontSize: '16px', fontWeight: '550', margin: '0px' }}>가게사장님께</p>
        <p style={{ margin: '3px' }}>{order.context}</p>
      </div>
      <hr />
      <div style={{ display: 'flex', justifyContent: 'space-between' }}>
        <button style={{ padding: '10px 20px', border: 'none', borderRadius: '5px', backgroundColor: 'white', color: 'red', fontWeight: '550', fontSize: '20px', margin: 'auto' }}>주문내역 삭제</button>
      </div>
      <div style={{ display: 'flex', justifyContent: 'space-between' }}>
        <button style={{ width: '100rem', height: '3.5rem', padding: '10px 20px', border: '1px solid #00c896', borderRadius: '5px', backgroundColor: '#00c896', color: '#fff', fontSize: '20px', fontWeight: '550', margin: 'auto' }}>같은 메뉴 담기</button>
      </div>
    </div>
  );
};

export default OrderDetail;
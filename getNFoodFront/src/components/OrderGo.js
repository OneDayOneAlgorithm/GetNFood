import React, { useState } from 'react';
import '../css/OrderGo.css';
import { width } from '@fortawesome/free-brands-svg-icons/faDAndD';

const OrderGo = () => {


    return (
        <>
            <div style={{ padding: '20px', fontFamily: 'Arial, sans-serif' }}>
                <p style={{ fontSize: '40px', fontWeight: '550' }}>주문하기</p>
                <div style={{ marginBottom: '20px', float: 'left' }}>
                    <img style={{ width: '35px' }} src="../logoImg/milkBox.png" alt="박스디자인" />
                    <label style={{ fontWeight: '550' }} htmlFor="pickup"> 포장해서 직접 가져갈게요</label>
                </div>
                <div style={{ textAlign: 'right' }}>
                    <img style={{ width: '30px' }} src="../logoImg/clock.png" alt="" />
                    <span style={{ fontWeight: '550', }}> 11 ~ 21분 후 픽업</span>
                </div>
                <div className='boldline-wjh'></div>
                <div style={{ marginBottom: '20px' }}>
                    <p style={{ fontSize: '20px', fontWeight: '550' }}>가게주소</p>
                    <p>경상북도 경산시 하양읍금락3길 18-16 1층</p>
                </div>
                <div className='boldline-wjh'></div>
                <div style={{ marginBottom: '20px' }}>
                    <div style={{ display: 'flex' }}>
                        <p style={{ fontSize: '20px', fontWeight: '550' }}>내 연락처 </p>
                        <button style={{ marginLeft: 'auto', fontWeight: '550', backgroundColor:'white', border:'none'}}>번호변경 ▷</button>
                    </div>
                    <input
                        type="text"
                        //   value={contact} 
                        //   onChange={handleContactChange}  
                        style={{ width: '100%', padding: '10px', fontSize: '16px' }}
                    />
                </div>
                <div className='boldline-wjh'></div>
                <div style={{ marginBottom: '20px' }}>
                    <div style={{ display: 'flex' }}>
                        <p style={{ fontSize: '20px', fontWeight: '550' }}>가게 사장님께</p>
                        <button style={{ marginLeft: 'auto', fontWeight: '550', backgroundColor:'white', border:'none'}}>요청입력 ▷</button>
                    </div>
                    <textarea
                        //   value={notes} 
                        //   onChange={handleNotesChange} 
                        style={{ width: '100%', padding: '10px', fontSize: '16px' }}
                        placeholder="요청사항 입력"
                    />
                    <p>일회용품X</p>
                    <div className='boldline-wjh'></div>
                </div>
                <div style={{ marginBottom: '20px' }}>
                    <p style={{ fontSize: '20px', fontWeight: '550' }}>결제수단</p>
                    <div>
                        <input
                            type="radio"
                            id="card"
                            name="payment"
                            value="신용/체크카드"
                        // checked={paymentMethod === '신용/체크카드'} 
                        // onChange={handlePaymentChange} 
                        />
                        <label htmlFor="card"> 신용/체크카드</label>
                    </div>
                    <div>
                        <input
                            type="radio"
                            id="tosspay"
                            name="payment"
                            value="토스페이"
                        // checked={paymentMethod === '토스페이'} 
                        // onChange={handlePaymentChange} 
                        />
                        <label htmlFor="tosspay"> 토스페이</label>
                    </div>
                    <div>
                        <input
                            type="radio"
                            id="other"
                            name="payment"
                            value="기타 결제수단"
                        // checked={paymentMethod === '기타 결제수단'} 
                        // onChange={handlePaymentChange} 
                        />
                        <label htmlFor="other"> 기타 결제수단</label>
                    </div>
                </div>
                <div className='boldline-wjh'></div>
                <div style={{ marginBottom: '0px',display:'flex'}}>
                    <p style={{ fontSize: '20px', fontWeight: '550',margin:'0px'}}>결제금액</p>
                    <p style={{marginLeft:'auto', fontSize:'30px', fontWeight:'550'}}>22,000원</p>
                </div>
                <div style={{ marginBottom: '20px',display:'flex', margin:'0px'}}>
                    <p style={{ fontSize: '20px', fontWeight: '550',margin:'0px' }}>주문금액</p>
                    <p style={{marginLeft:'auto', fontWeight:'550'}}>23,000원</p>
                </div>

                <div style={{ marginBottom: '20px',display:'flex', margin:'0px'}}>
                    <p style={{ fontSize: '20px', fontWeight: '550' ,margin:'0px', color:'#A374DB'}}>할인금액</p>
                    <p style={{marginLeft:'auto', fontWeight:'550', color:'#A374DB'}}>-1,000원</p>
                </div>

                <div style={{width:'18rem', height:'4rem', backgroundColor:'#D5B5E9', borderRadius:'2rem',display:'flex',alignItems:'center',justifyContent:'center'}}>
                    <img style={{width:'3rem', marginRight:'1rem'}} src="../logoImg/discount.png" alt="" />
                    <p style={{fontWeight:'550',textAlign:'center', fontSize:'20px'}}>1,000원 할인 받았어요!</p>
                </div>
                <button style={{marginTop:'1rem', width: '100%', padding: '15px', backgroundColor: '#00c896', color: '#fff', fontSize: '18px', border: 'none', cursor: 'pointer' }}>
                    22,000원 결제하기
                </button>
            </div>

        </>
    );
};

export default OrderGo;

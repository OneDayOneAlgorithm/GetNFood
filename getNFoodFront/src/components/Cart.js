import React from 'react';
import NavbarComponents from "./Navbar";
import Footer from "./Footer";
import { useParams } from 'react-router-dom';
import { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import 'bootstrap/dist/css/bootstrap.min.css';
import '../css/Cart.css';

const Cart = (props) => {
    const { id } = useParams();
    const [count, setCount] = useState([1, 1, 1, 1, 1, 1]);
    const [amount, setAmount] = useState([1, 1, 1, 1, 1, 1]);
    const [orderPrice, setOrderPrice] = useState(props.orderList && props.orderList.notDiscountPrice);
    const [discountPrice, setDiscountPrice] = useState(props.orderList && props.orderList.discount);
    const [totalPrice, setTotalPrice] = useState(props.orderList && props.orderList.totalPrice);

    useEffect(() => {
        if (id) {
            props.loadOrderList(id);
            console.log(props.orderList && props.orderList)
        }
    }, [id]);

    console.log(props.orderList && props.orderList)
    console.log(props.orderList && orderPrice)



    const updatePrices = (orderList) => {
        setOrderPrice(orderList.notDiscountPrice);
        setDiscountPrice(orderList.discount);
        setTotalPrice(orderList.totalPrice);
    };

    return (
        <>
            <NavbarComponents />
            <div className="cart-background">
                <div className="cart-title" style={{ marginTop: "70px" }}>장바구니</div>
                {props.orderList ? (
                    <div className="cart-main">
                        <div className="store-name">{props.orderList.storeName}</div>
                        {props.orderList.orderDetails && props.orderList.orderDetails.map((orderDetail, index) => (
                            <div key={index} className="menu-box">
                                <div className="cart-menu-name">{orderDetail.menu.menuName}</div>
                                <div style={{ marginLeft: "2vw" }}>
                                    가격: <span style={{ textDecoration: "line-through", marginRight: "10px" }}>{orderDetail.menu.price}원</span>
                                    <span className="cart-menu-price">{orderDetail.menu.nowPrice}원</span>
                                    <span>
                                        <Button
                                            style={{ marginLeft: "30vw" }}
                                            variant="primary"
                                            className="counter-button btn btn-dark"
                                            onClick={() => {
                                                let copy = [...count];
                                                copy[index]--;
                                                setCount(copy);
                                                if (count[index] === 0) {
                                                    copy[index] = 0;
                                                    alert("최소 주문수량은 1개입니다.");
                                                }
                                                props.minusOrderDetail(orderDetail.orderDetailId)
                                            }}
                                        >
                                            ▼
                                        </Button>
                                        <span className="counter-value">{count[index]}</span>
                                        <Button
                                            className="counter-button btn btn-dark"
                                            onClick={() => {
                                                let copy = [...count];
                                                copy[index]++;
                                                setCount(copy);
                                                props.plusOrderDetail(orderDetail.orderDetailId)
                                            }}
                                        >
                                            ▲
                                        </Button>
                                    </span>
                                </div>
                                <hr />
                                <div className="cart-add-menu">
                                    <button type="button" className='btn btn-dark'>삭제</button>
                                </div>
                            </div>
                        ))}
                    </div>
                ) : (
                    <></>
                )}
                <div>
                    <div className="cart-price">결제금액을 확인해주세요.</div>
                    <div className="payment-box">
                        <div className="order-price">주문금액<span style={{ marginLeft: "40vw" }}>{props.orderList ? (props.orderList && props.orderList.notDiscountPrice) * count[0] : <span></span>}원</span></div>
                        <div className="discount-price">할인금액<span style={{ marginLeft: "40.7vw" }}>{props.orderList && props.orderList.discount * count[0]}<span style={{ "position": "relative", "right": "1px" }}>원</span></span></div>
                        <hr />
                        <div className="expected-price">결제예정금액<span style={{ marginLeft: "38vw" }}>{props.orderList && props.orderList.totalPrice * count[0]}<span style={{ "position": "relative", "left": "2px" }}>원</span></span></div>
                    </div>
                    <div className="cart-total-price">
                        <a href={`/ordergo/${id}`}><button className=" cart-order-btn">{props.orderList && props.orderList.totalPrice * count[0]}원 포장주문하기</button></a>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    );
}

export default Cart;

import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../App.css"; // CSS 파일 경로 확인
import { FaCartPlus } from "react-icons/fa";

const TodaySale = (props) => {
    const [imgContainer, setImgContainer] = useState(new Array(8).fill('/StoreListImg/food-image1.png'));
    const data =
        [
            {
                "menu_id": 1,
                "create_date": "2024-05-09 16:30",
                "discount": 1000,
                "inventory": 10,
                "menu_name": "후라이드 치킨",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%ED%9B%84%EB%9D%BC%EC%9D%B4%EB%93%9C%EC%B9%98%ED%82%A8.jpg?alt=media&token=2d02b139-8cd1-46b9-9a83-fb31d7ad9b22",
                "now_price": 17000,
                "pickup_time": "12:00~15:00",
                "price": 18000,
                "menu_store_id": 1
            },
            {
                "menu_id": 2,
                "create_date": "2024-05-09 16:40",
                "discount": 800,
                "inventory": 5,
                "menu_name": "양념 치킨",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%EC%96%91%EB%85%90%EC%B9%98%ED%82%A8.jpg?alt=media&token=8d03ef34-0710-4c19-a597-cab68e78a421",
                "now_price": 19000,
                "pickup_time": "12:00~15:00",
                "price": 19800,
                "menu_store_id": 1
            },
            {
                "menu_id": 3,
                "create_date": "2024-05-09 16:50",
                "discount": 500,
                "inventory": 8,
                "menu_name": "간장 치킨",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%EA%B0%84%EC%9E%A5%EC%B9%98%ED%82%A8.jpg?alt=media&token=d4833c9c-b026-4e58-832d-8b9a837afc97",
                "now_price": 18500,
                "pickup_time": "12:00~15:00",
                "price": 19000,
                "menu_store_id": 1
            },
            {
                "menu_id": 4,
                "create_date": "2024-05-09 17:00",
                "discount": 700,
                "inventory": 6,
                "menu_name": "마르게리타 피자",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%EB%A7%88%EB%A5%B4%EA%B2%8C%EB%A6%AC%ED%83%80%20%ED%94%BC%EC%9E%90.jpg?alt=media&token=f99a13d4-da17-42b5-a862-30ebf47b555d",
                "now_price": 22000,
                "pickup_time": "17:00~20:00",
                "price": 22700,
                "menu_store_id": 2
            },
            {
                "menu_id": 5,
                "create_date": "2024-05-09 17:10",
                "discount": 600,
                "inventory": 7,
                "menu_name": "페퍼로니 피자",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%ED%8E%98%ED%8D%BC%EB%A1%9C%EB%8B%88%20%ED%94%BC%EC%9E%90.jpg?alt=media&token=66084fbe-c606-4491-a666-b925f92c1581",
                "now_price": 21000,
                "pickup_time": "17:00~20:00",
                "price": 21600,
                "menu_store_id": 2
            },
            {
                "menu_id": 6,
                "create_date": "2024-05-09 17:20",
                "discount": 800,
                "inventory": 4,
                "menu_name": "하와이안 피자",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%ED%95%98%EC%99%80%EC%9D%B4%EC%95%88%20%ED%94%BC%EC%9E%90.jpg?alt=media&token=2a0707e6-d6de-4dec-ae4c-bf462c1eaf06",
                "now_price": 21500,
                "pickup_time": "17:00~20:00",
                "price": 22300,
                "menu_store_id": 2
            },
            {
                "menu_id": 7,
                "create_date": "2024-05-09 17:30",
                "discount": 1000,
                "inventory": 9,
                "menu_name": "짜장면",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%EC%A7%9C%EC%9E%A5%EB%A9%B4.jpg?alt=media&token=47454f10-92b7-4c15-bdf4-de23bf9db7d4",
                "now_price": 12000,
                "pickup_time": "11:00~14:00",
                "price": 13000,
                "menu_store_id": 3
            },
            {
                "menu_id": 8,
                "create_date": "2024-05-09 17:40",
                "discount": 1200,
                "inventory": 10,
                "menu_name": "짬뽕",
                "menu_picture_url": "https://firebasestorage.googleapis.com/v0/b/webkit-test-c9faa.appspot.com/o/%EC%A7%AC%EB%BD%95.jpg?alt=media&token=fee5f392-142f-4d6b-b9d8-0de5697d993a",
                "now_price": 13000,
                "pickup_time": "11:00~14:00",
                "price": 14200,
                "menu_store_id": 3
            }
        ]

    console.log(props.loadMenu)
    useEffect(() => {
        props.loadMenu(1)
        console.log(props.menuData)
    }, [])


    return (
        <div className="container-fluid sale-container">
            <div className="sale-row">
                {data.map((menu, index) => (
                    <div key={index} className="sale-card">
                        <Card>
                            <Card.Img style={{ "height": "190px" }} variant="top" src={menu.menu_picture_url} />
                            <Card.Body>
                                <Card.Title className="menuList-menuname">{menu.menu_name}</Card.Title>
                                <Card.Text>
                                    <div className="menu-price">{menu.price}원</div>
                                    <span style={{ marginLeft: "0.7vw", fontWeight: "bold" }}>{menu.now_price}원</span>
                                    <div><span style={{ color: "red", fontWeight: "bold" }}>{menu.discount}원</span> 할인</div>
                                    <div>{menu.pickup_time}</div>
                                </Card.Text>
                                <Button style={{ "marginLeft": "145px" }} variant="primary"><FaCartPlus size="26" /></Button>
                            </Card.Body>
                        </Card>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default TodaySale;

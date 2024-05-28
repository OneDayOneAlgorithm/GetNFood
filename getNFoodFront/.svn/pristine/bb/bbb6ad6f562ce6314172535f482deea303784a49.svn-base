import "../css/MenuList.css"
import { useEffect, useState } from "react";
import NavbarComponents from "./Navbar";
import Footer from "./Footer";
import 'bootstrap/dist/css/bootstrap.min.css';
import { useParams } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import React from "react";
import { FaCartPlus } from "react-icons/fa";

const MenuList = (props) => {
    let [count, setCount] = useState([0, 0, 0, 0, 0, 0]);
    const { id } = useParams()
    const { categoryName } = useParams()
    const decodedName = decodeURIComponent(categoryName);

    useEffect(() => {
        props.loadMenu(id)
        props.loadStoreDetail(id)
        console.log(props.menuData)
    }, [id])

    // useEffect(() => {
    //     props.loadStoreList(name)


    console.log(props.menuData)
    console.log(props.storeDetail)
    // }, [name])

    const orderListId = props.orderList && props.orderList.orderListId

    return (
        <>
            <NavbarComponents />
            <div className='main-bg'>

                <div style={{ "height": "100px" }}></div>

            </div>

            <div className="store-name-menuList">{decodedName}</div>
            {

                props.storeDetail ? <>

                    <div style={{ backgroundColor: '', border: '1px solid #D3D3D3', width: '35rem', height: '6rem', margin: 'auto', borderRadius: '1rem' }}>
                        <div style={{ display: 'flex', alignItems: 'center' }}> {/* 글자 위치*/}
                            <img style={{ width: '1.5rem', height: '1.5rem', marginRight: '0.5rem', marginLeft: '1rem', marginTop: '0rem' }} src="/logoImg/store.png" alt="" />
                            <p style={{ margin: '0.5rem', fontSize: '1.2rem', fontWeight: '550', marginTop: '0.5rem' }}>매장소개 </p>

                        </div>
                        <p style={{ margin: '0.5px', marginLeft: '3.5rem', marginTop: '0rem' }}>{props.storeDetail.storeContent}</p>
                    </div>


                    <div style={{ display: 'flex', margin: '0 auto', justifyContent: "center", marginTop: '2rem', marginBottom: '2rem' }}> {/* 두번째 라인 묶는 div*/}

                        <div style={{ border: '1px solid #D3D3D3', width: '30rem', height: '10rem', borderRadius: '1rem' }}> {/* 테두리 div*/}

                            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'left', backgroundColor: '', marginTop: '1rem', marginLeft: '1rem' }}>
                                <img style={{ width: '1.5rem', height: '1.5rem', marginRight: '0.5rem' }} src="/logoImg/watch.png" alt="" />
                                <p style={{ margin: '0.5rem' }}>영업시간 :</p>
                                <p style={{ margin: '0.5rem', marginLeft: '1rem' }}>{props.storeDetail.operationTime}</p>
                            </div>

                            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'left', marginLeft: '1rem' }}>
                                <img style={{ width: '1.3rem', height: '1.5rem', marginRight: '0.5rem' }} src="/logoImg/address.png" alt="" />
                                <p style={{ margin: '0.5rem' }}>가게주소 :</p>
                                <p style={{ margin: '0.5rem', marginLeft: '1.2rem' }}>{props.storeDetail.storeAddr}</p>
                            </div>

                            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'left', marginLeft: '1rem' }}>
                                <img style={{ width: '1.3rem', height: '1.5rem', marginRight: '0.5rem' }} src="/logoImg/phone.png" alt="" />
                                <p style={{ margin: '0.5rem' }}>연락번호 :</p>
                                <p style={{ margin: '0.5rem', marginLeft: '1.4rem' }}>{props.storeDetail.phoneNumber}</p>
                            </div>

                        </div>


                    </div>



                </> : <> <div className="text-center">
                    <div className="spinner-border" role="status">
                        <span className="visually-hidden">Loading...</span>
                    </div>
                </div></>
            }

            <div className="container">
                <div className="row" >
                    {
                        props.menuData && props.menuData.map((menu, index) => {
                            return (<React.Fragment key={index}>
                                <div className="col-md-4">
                                    <Card style={{ width: '18rem' }}>
                                        <Card.Img variant="top" style={{ "height": "200px" }} src={menu.menuPictureUrl} />
                                        <Card.Body>
                                            <Card.Title className="menuList-menuname">{menu.menuName}</Card.Title>
                                            <Card.Text>
                                                <div className="menu-price">
                                                    <span>{menu.price}원</span></div>
                                                <span style={{ "marginLeft": "0.7vw", "fontWeight": "bold" }}>{menu.nowPrice}원</span>
                                                <div><span style={{ "color": "red", "fontWeight": "bold" }}>{menu.discount}원</span> 할인</div>
                                                <div>{menu.pickupTime}</div>
                                                <div>남은개수 : {menu.inventory}개</div>
                                            </Card.Text>
                                            <Button style={{ "block": "inline", "marginLeft": "175px" }} variant="primary"
                                                onClick={
                                                    () => {
                                                        if (!orderListId) {
                                                            props.createOrderList(id, 3, menu.menuId)
                                                        }
                                                        else {
                                                            props.transmitOrderList(menu.menuId, orderListId)
                                                        }
                                                    }
                                                }
                                            ><FaCartPlus size="26" /></Button>
                                        </Card.Body>
                                    </Card>
                                    <div style={{ "height": "7vh" }}></div>
                                </div >
                            </React.Fragment>)
                        })
                    }
                </div>
            </div >

            <Footer />

        </>
    )
}

export default MenuList
import '../css/StoreList.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import NavbarComponents from './Navbar';
import { useState, useEffect } from 'react';
import Footer from './Footer';
import { useParams } from 'react-router-dom';
import axios from 'axios';
import React from "react";


const StoreList = (props) => {

    let mainImg = ""

    let { name } = useParams()
    name = name.toUpperCase()
    console.log(name)
    useEffect(() => {
        props.loadStoreList(name)
    }, [name])

    console.log(props.storeData)

    let ctgName = ""

    if (name === "CHINESE") { ctgName = "중식" }
    else if (name === "KOREAN") { ctgName = "한식" }
    else if (name === "JAPANESE") { ctgName = "일식" }
    else if (name === "WESTERN") { ctgName = "양식" }
    else if (name === "CHICKEN") { ctgName = "치킨" }
    else if (name === "PIZZA") { ctgName = "피자" }
    else if (name === "BURGER") { ctgName = "버거" }
    else if (name === "MEAT") { ctgName = "육류" }
    else if (name === "BREAD") { ctgName = "빵" }
    else if (name === "DESSERTS") { ctgName = "디저트" }
    else if (name === "VEGETABLE") { ctgName = "채소" }
    else if (name === "FRUITS") { ctgName = "과일" }

    if (name === "CHINESE") { mainImg = "/chinese-main.png" }
    else if (name === "KOREAN") { mainImg = "/korean-main.png" }
    else if (name === "JAPANESE") { mainImg = "/japanese-main.png" }

    return (


        <>
            <NavbarComponents />

            <div className="container">
                <div style={{ "marginTop": "44vh" }} className='category-main-name'>{ctgName}</div>

                <div className="row" >
                    <div><img className='category-img-main' src={mainImg}  ></img></div>
                    {
                        props.storeData && props.storeData.map((store, index) => {
                            return (<React.Fragment key={index}>
                                <div className="col-md-4" >
                                    <div style={{ "marginTop": "6vh" }}> <a href={`/menuList/${store.storeId}/${encodeURIComponent(store.storeName)}`}><img style={{ "width": "300px", "height": "300px", "marginTop": "80px" }} src={store.storePhotoUrl} /></a></div>
                                    <a href={`/menuList/${store.storeId}/${encodeURIComponent(store.storeName)}`}>  <div style={{ "fontSize": "1.6em", "marginTop": "10px" }} className='storeList-name'>{store.storeName}</div></a>
                                    <div style={{ "color": "#444", "letter-spacing": "-.50px;" }} className >{store.address}</div>
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



export default StoreList
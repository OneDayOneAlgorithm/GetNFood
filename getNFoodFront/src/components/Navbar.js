import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import axios from 'axios';
import "../css/Main.css"
import { Navigate } from 'react-router-dom';
import { FaShoppingCart } from "react-icons/fa";
import { CgProfile } from "react-icons/cg";
import { IoLogOut } from "react-icons/io5";
import { IoLogIn } from "react-icons/io5";
import { FaSearch } from "react-icons/fa";

function NavbarComponents(props) {

    const navigate = useNavigate()

    const [saveOrderListId, setSaveOrderListId] = useState(null);
    const [userId, setUserId] = useState();
    const [searchName, SetSearchName] = useState();

    const Sendsearch = () => {
        props.searchApi(searchName)
        navigate(`/searchResult/${searchName}`)
    }
    console.log(searchName)

    useEffect(() => {
        if (props.orderListId !== null) {
            setSaveOrderListId(props.orderListId);
        }
    }, [props.orderListId]);


    let loginUserId = localStorage.getItem('userId')
    console.log(loginUserId)

    useEffect(() => {
        setUserId(localStorage.getItem('userId'))
    }, [userId])

    const removeUserId = () => {
        localStorage.removeItem('userId')
        setUserId(null)
        alert("로그아웃 완료")
        navigate("/#")
    }


    return (
        userId ? < Navbar expand="lg" className="bg-body-tertiary fixed-top nav-bar-bg" >
            <Container fluid>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <a href='/#'><img style={{ "width": "170px" }} src="/new-logo2.png"></img></a>
                    <div className='search-container'>
                        <Form style={{ "width": "30vw" }} className="d-flex ml-5" onSubmit={Sendsearch}>
                            <Form.Control
                                type="search"
                                placeholder="지역,음식 또는 식당명 입력"
                                className='ml-3'
                                aria-label="Search"
                                value={searchName}
                                onChange={(e) => SetSearchName(e.target.value)}
                            />
                        </Form>
                        <Button style={{ "backgroundColor": "white" }} type="submit"><FaSearch style={{ color: "black", "zIndex": 6, "position": "absolute", "right": "50px", "top": "11px" }} /></Button>
                    </div>
                    <div className="new-nav-bar">
                        <a href={`/cart/${saveOrderListId}`} style={{ "color": "black" }} className='nav-cart'><FaShoppingCart size="35" /></a>
                        <a href='/customerMyPage'><CgProfile size="35" /></a>

                        <a href="/login" style={{ "color": "black" }} className='logout-nav' onClick={removeUserId}><IoLogOut size="39" /></a>
                    </div>


                </Navbar.Collapse>
                {/* <searchContent searchValue={searchValue} /> */}
            </Container>
        </Navbar > : < Navbar expand="lg" className="bg-body-tertiary fixed-top nav-bar-bg" >
            <Container fluid>
                <Navbar.Toggle aria-controls="navbarScroll" />
                <Navbar.Collapse id="navbarScroll">
                    <a href='/#'><img style={{ "width": "170px" }} src="/new-logo2.png"></img></a>
                    <div className='search-container'>
                        <Form style={{ "width": "30vw" }} className="d-flex ml-5" onSubmit={Sendsearch}>
                            <Form.Control
                                type="search"
                                placeholder="지역,음식 또는 식당명 입력"
                                className='ml-3'
                                aria-label="Search"
                                value={searchName}
                                onChange={(e) => SetSearchName(e.target.value)}
                            />
                        </Form>
                        <Button style={{ "backgroundColor": "white" }} type="submit"><FaSearch style={{ color: "black", "zIndex": 6, "position": "absolute", "right": "50px", "top": "11px" }} /></Button>
                    </div>
                    <div className="new-nav-bar">
                        <a href='/login' onClick={() => { alert("로그인 안됨") }} style={{ "color": "black" }} className='nav-cart'><FaShoppingCart size="35" /></a>
                        {props.toggle ? <a onClick={() => { alert("로그인 안됨") }} href='/login'><CgProfile size="35" /></a> : <a href='/login' onClick={() => { alert("로그인 안됨") }}> <CgProfile size="35" /></a>}

                        <a href="/login" style={{ "color": "black" }} className='logout-nav' ><IoLogIn size="39" /></a>
                    </div>


                </Navbar.Collapse>
                {/* <searchContent searchValue={searchValue} /> */}
            </Container>
        </Navbar >

    );
}

export default NavbarComponents;

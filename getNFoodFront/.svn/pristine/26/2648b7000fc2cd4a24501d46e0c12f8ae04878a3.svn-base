import Main from './components/Main';
import Login from './components/Login';
import Register from './components/Register';
import CustomerMyPage from './components/CustomerMyPage';
import Cart from './components/Cart';
import { Router, Routes, Route } from 'react-router-dom'
import StoreList from "./components/StoreList"
import MenuList from './components/MenuList';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useEffect, useState } from "react";
import axios from 'axios';
import OwnerMyPage from './components/OwnerMyPage';
import DeleteAccountComplete from './components/DeleteAccountComplete';
import NavbarComponents from './components/Navbar';
import OrderGo from './components/OrderGo';
import MenuManagement from './components/MenuManagement';
import AddStore from './components/AddStore';
import SearchResult from './components/SearchResult';
import OrderHistory from './components/OrderHistory';
import OrderDetail from './components/OrderDetail';
import KakaoMapCsv from './components/kakaoMapCsv';

import { useDispatch, useSelector } from "react-redux"
import { CgNametag } from 'react-icons/cg';

function App() {

  const [menuData, setMenuData] = useState()
  const [orderList, setOrderList] = useState()
  const [storeData, setStoreData] = useState()
  const [orderListId, setOrderListId] = useState()
  const [orderData, setOrderData] = useState()
  const [storeDetail, setStoreDetail] = useState()
  const [searchList, setSearchList] = useState()
  const [myStore, setMyStore] = useState()
  const [profile, setProfile] = useState()
  const [orderListData, setOrderListData] = useState()
  const [orderId, setOrderId] = useState()


  const loadMenu = (storeId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/menu/store/${storeId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        setMenuData(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };




  const loadStoreList = (categoryName) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/category/${categoryName}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        console.log(data)
        setStoreData(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };

  const loadStoreDetail = (storeId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/stores/${storeId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        console.log(data)
        setStoreDetail(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };



  const transmitOrderList = async (menuId, orderListId) => {
    try {
      const response = await axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orderDetail`, {
        menuId: menuId,
        orderListId: orderListId
      });
      console.log(response);
      console.log(response.data);
      alert("장바구니에 음식이 추가되었습니다.");  // 메뉴 추가 시에만 이 메시지 호출
    } catch (error) {
      console.error('Error adding to order list:', error);
    }
  };

  const createOrderList = async (storeId, userId, menuId) => {
    try {
      const response = await axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orderList`, {
        storeId: storeId,
        userId: userId
      });
      setOrderList(response.data);
      console.log(response.data);


      // 장바구니 ID 사용하여 메뉴 추가
      const orderListId = response.data.orderListId;
      setOrderListId(orderListId)
      console.log(orderListId)
      await transmitOrderList(menuId, orderListId);
    } catch (error) {
      console.error('Error creating order list:', error);
    }
  };


  const loadOrderList = (orderListId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orderList/${orderListId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        console.log(data)
        setOrderList(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };

  const plusOrderDetail = (orderDetailId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orderDetail/plus/${orderDetailId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        console.log("dsad" + data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };

  const minusOrderDetail = (orderDetailId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orderDetail/minus/${orderDetailId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        console.log("mimi" + data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };

  const orderProducts = (userId, storeId, orderListId, paymentMethod, requests) => {
    const response = axios.post(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/orders`, {
      "userId": userId,
      "storeId": storeId,
      "orderListId": orderListId,
      "paymentMethod": paymentMethod,
      "requests": requests
    })
      .then((response) => {
        console.log(response.data.orderId)
        setTimeout(() => {
          setOrderData(response.data)
        }, 1000)
        const orderId = response.data.orderId;
        console.log(orderId)
        setOrderId(orderId)
        localStorage.setItem("orderId", 7521)

      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  }

  const searchApi = (name) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/search/${name}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        setSearchList(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  };

  const loadMyStore = (userId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/stores/user/${userId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        setMyStore(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  }


  const loadMyPage = (userId) => {
    axios.get(`http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/mypage/${userId}`)
      .then(response => {
        // 응답 데이터 처리
        const data = response.data;
        setProfile(data)
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      })
  }




  // const loadOrderList = (orderListId) => {
  //   axios.get(`http://172.30.67.130:8080/orderDetail/plus/${orderListId}`)
  //     .then(response => {
  //       // 응답 데이터 처리
  //       const data = response.data;
  //       console.log(data)
  //       setOrderList(data)
  //     })
  //     .catch(error => {
  //       console.error('Error fetching data:', error);
  //     })
  // };




  return (
    <>
      <Routes>
        <Route path='/' element={<Main menuData={menuData} loadMenu={loadMenu} />}></Route>
        <Route path='/login' element={<Login />}> </Route>
        <Route path='/register' element={<Register />}> </Route>
        <Route path='/ordergo/:id' element={<OrderGo profile={profile} loadMyPage={loadMyPage} orderList={orderList} loadOrderList={loadOrderList} orderProducts={orderProducts} orderData={orderData} />}></Route>
        <Route path='/category/:name' element={<StoreList storeData={storeData} loadStoreList={loadStoreList} />}></Route>
        <Route path='/cart/:id' element={<Cart loadOrderList={loadOrderList} orderList={orderList} plusOrderDetail={plusOrderDetail} minusOrderDetail={minusOrderDetail}
          orderProducts={orderProducts} />}></Route>
        <Route path='/searchResult/:name' element={<SearchResult searchApi={searchApi} searchList={searchList} />}> </Route>
        <Route path='/addStore' element={<AddStore />}> </Route>
        <Route path='/customermypage' element={<CustomerMyPage loadMyPage={loadMyPage} profile={profile} />}> </Route>
        <Route path='/menumanagement' element={<MenuManagement loadMyStore={loadMyStore} myStore={myStore} />}> </Route>
        <Route path='/menulist/:id/:categoryName' element={<MenuList loadStoreDetail={loadStoreDetail} storeDetail={storeDetail} menuData={menuData} storeData={storeData} loadStoreList={loadStoreList}
          loadMenu={loadMenu} createOrderList={createOrderList} transmitOrderList={transmitOrderList} orderList={orderList} />}></Route>
        <Route path='/ownermypage' element={<OwnerMyPage loadMyStore={loadMyStore} myStore={myStore} />}> </Route>
        <Route path='/deleteaccountcomplete' element={<DeleteAccountComplete />}> </Route>
        <Route path='/orderHistory' element={<OrderHistory />}> </Route>
        <Route path='/orderDetail' element={<OrderDetail orderData={orderData} orderId={orderId} orderListData={orderListData} />}> </Route>
        <Route path='/kakaoMapCsv' element={<KakaoMapCsv />}> </Route>
      </Routes >
      <NavbarComponents orderListId={orderListId} searchApi={searchApi} />
    </>
  );
}

export default App;

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { FaArrowRight } from "react-icons/fa";
import { useNavigate } from "react-router-dom";

const KakaoMap = () => {
    const [stores, setStores] = useState([]);
    const [error, setError] = useState(null);
    const [infoWindows, setInfoWindows] = useState({});

    const navigate = useNavigate()

    useEffect(() => {
        const fetchStores = async () => {
            try {
                const response = await axios.get('http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/maps');
                setStores(response.data);
            } catch (error) {
                setError('가게 정보를 불러오는 중 오류가 발생했습니다.');
            }
        };

        fetchStores();
    }, []);

    useEffect(() => {
        navigator.geolocation.getCurrentPosition(
            (position) => {
                const latitude = position.coords.latitude;
                const longitude = position.coords.longitude;
                const userLatLng = new window.kakao.maps.LatLng(latitude, longitude);

                const mapContainer = document.getElementById('map');
                const mapOption = {
                    center: userLatLng,
                    level: 5,
                };

                const map = new window.kakao.maps.Map(mapContainer, mapOption);

                const newInfoWindows = {};

                stores.forEach((store, index) => {
                    const geocoder = new window.kakao.maps.services.Geocoder();
                    geocoder.addressSearch(store.address, function (result, status) {
                        if (status === window.kakao.maps.services.Status.OK) {
                            const coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);

                            const marker = new window.kakao.maps.Marker({
                                map: map,
                                position: coords,
                            });

                            const content = `<div>
                                ${store.storePhotoUrl ? `<img src="${store.storePhotoUrl}" alt="${store.storeName}" style="max-width:200px; max-height:400px;"/>` : ''}
                                <h3>${store.storeName}</h3>
                                <p>가게 번호 : ${store.phoneNumber}</p>
                                <p>운영 시간 : ${store.pickupTime}</p>
                                <div style="margin-bottom: 40px;"></div>
                                <!-- 여백 추가 -->
                               </div>`;

                            const infowindow = new window.kakao.maps.InfoWindow({
                                content: content,
                            });

                            newInfoWindows[store.storeId] = infowindow;

                            window.kakao.maps.event.addListener(marker, 'click', function () {
                                if (infowindow.getMap()) {
                                    infowindow.close();
                                } else {
                                    // 모든 정보 창을 닫습니다.
                                    Object.values(newInfoWindows).forEach((iw) => iw.close());
                                    infowindow.open(map, marker);
                                }
                            });
                        }
                    });
                });

                setInfoWindows(newInfoWindows);
            },
            (error) => {
                console.error('Error getting user location:', error);
            }
        );
    }, [stores]);

    return (
        <div>
            <p style={{
                marginLeft: "auto",
                marginRight: "auto",
                textAlign: "center",
                fontWeight: "bold",
                marginTop: "1vh",
                paddingBottom: "6vh",
                fontSize: "1.7em",
                backgroundColor: "#EB601F",
                borderRadius: "20rem",
                width: "210px",
                height: "50px",
                color: "white",
                paddingTop: "5px",
                marginBottom: "7vh"

            }}>내 주변 가게</p><div onClick={() => { navigate("/kakaoMapCsv") }} className='my-region-store'>내 지역 가게 전체 보기<FaArrowRight className='right-arrow' /></div>
            {error && <p>{error}</p>}
            <div id="map" style={{ width: '85%', height: '600px', "margin": "0 auto" }}></div>
        </div>
    );
};

export default KakaoMap;
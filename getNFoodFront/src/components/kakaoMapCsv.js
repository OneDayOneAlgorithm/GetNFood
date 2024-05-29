import React, { useState, useEffect } from 'react';
import axios from 'axios';

const KakaoMapCsv = () => {
    const [stores, setStores] = useState([]);
    const [error, setError] = useState(null);
    const [infoWindows, setInfoWindows] = useState({});

    useEffect(() => {
        const fetchStores = async () => {
            try {
                const response = await axios.get('http://ec2-13-58-97-107.us-east-2.compute.amazonaws.com:8080/mapsAll');
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
                    level: 7,
                };

                const map = new window.kakao.maps.Map(mapContainer, mapOption);

                const newInfoWindows = {};

                const processStores = (index) => {
                    if (index >= stores.length) return;

                    const store = stores[index];
                    const geocoder = new window.kakao.maps.services.Geocoder();

                    geocoder.addressSearch(store.address, function (result, status) {
                        if (status === window.kakao.maps.services.Status.OK) {
                            const coords = new window.kakao.maps.LatLng(result[0].y, result[0].x);

                            const marker = new window.kakao.maps.Marker({
                                map: map,
                                position: coords,
                            });

                            const infowindow = new window.kakao.maps.InfoWindow({
                                content: `<div>
                            <h3>${store.storeName}</h3>
                            <p>Phone: ${store.phoneNumber}</p>
                            <p>Address: ${store.address}</p>
                          </div>`,
                            });

                            newInfoWindows[store.storeId] = infowindow;

                            window.kakao.maps.event.addListener(marker, 'click', function () {
                                if (infowindow.getMap()) {
                                    infowindow.close();
                                } else {
                                    // Close all other info windows
                                    Object.values(newInfoWindows).forEach((iw) => iw.close());
                                    infowindow.open(map, marker);
                                }
                            });
                        }

                        // Process the next store after a short delay
                        setTimeout(() => processStores(index + 1)); // 300ms delay between each geocoding request
                    });
                };

                processStores(0); // Start processing stores
                setInfoWindows(newInfoWindows);
            },
            (error) => {
                console.error('Error getting user location:', error);
            }
        );
    }, [stores]);

    return (
        <div>
            <h1 className='map-main' style={{ marginTop: "90px" }}>구미시 가게 전체 보기</h1>
            {error && <p>{error}</p>}
            <div id="map" style={{ width: '85%', height: '500px', "marginLeft": "auto", "marginRight": "auto" }}></div>
        </div>
    );
};

export default KakaoMapCsv;
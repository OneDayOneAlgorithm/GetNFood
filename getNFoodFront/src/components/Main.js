import '../css/Main.css';
import { useState } from 'react';
import Category from './Category';
import OwnerMain from './OwnerMain';
import ToggleBntn from './ToggleBtn';
import NavbarComponents from './Navbar';
import Footer from './Footer';
import TodaySale from './TodaySale';
import KakaoMap from './KakaoMap';
import KakaoMapCsv from './kakaoMapCsv';
import { useEffect } from 'react';

const Main = (props) => {


    const [isToggled, setIsToggled] = useState(() => {
        const saved = localStorage.getItem('isToggled');
        return saved === 'true' ? true : false;
    });

    // 토글 상태가 변경될 때마다 로컬 스토리지에 저장
    useEffect(() => {
        localStorage.setItem('isToggled', isToggled.toString());
    }, [isToggled]);

    // 버튼 클릭 이벤트 핸들러
    const handleToggle = () => {
        setIsToggled(!isToggled);
    };

    // 페이지 로드 시 로컬 스토리지에서 'isToggled' 값을 가져오고 boolean으로 변환


    // 이제 isToggledlog는 새로고침 후에도 true 또는 false의 정확한 boolean 값으로 유지됩니다.





    return (
        <>

            {isToggled ?
                <>
                    <div className='main-bg'>
                        <NavbarComponents isToggled={isToggled} />

                        <ToggleBntn toggleSwitch={handleToggle} isToggled={isToggled} />
                    </div>
                    <KakaoMapCsv />
                    <KakaoMap />
                    <h3 className='today-sale'>오늘의 특가</h3>
                    <TodaySale menuData={props.menuData} loadMenu={props.loadMenu} />
                    <hr></hr>
                    <p className='ctg-ctg-name'>카테고리</p>
                    <Category />
                    <Footer />
                </> :
                <OwnerMain isToggled={isToggled} toggleSwitch={handleToggle} />
            }
        </>
    )
}

export default Main;

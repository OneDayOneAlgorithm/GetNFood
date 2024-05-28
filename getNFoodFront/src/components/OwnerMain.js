import '../css/OwnerMain.css'
import Footer from './Footer'
import NavbarComponents from './Navbar'
import ToggleBntn from './ToggleBtn'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { Navigate, useNavigate } from 'react-router-dom';

const OwnerMain = (props) => {

    const navigate = useNavigate()

    return (
        <>
            <>
                <NavbarComponents toggle={props.isToggled} />
                <input type="checkbox" id="toggle" hidden onChange={props.toggleSwitch} />
                <label for="toggle" class="toggleSwitch">{props.isToggled ? <div className='customer-mode'>소비자</div>
                    : <div className='owner-mode'>자영업자</div>}
                    <span class="owner-toggleButton"></span>
                </label>
                <div className='addstore-WJH'>
                    <button className='addbtn-WJH' onClick={() => { navigate("/addStore") }}>
                        <img style={{ width: '8rem' }} src="../logoImg/addstore.png" alt="" />
                    </button>
                    <div className='addwirter-WJH'>
                        <p style={{ fontSize: '2rem', fontWeight: '550' }}>가게 추가하기</p>
                        <p style={{ color: 'gray', fontWeight: '550' }}>보유하신 가게에 적용됩니다.</p>
                    </div>
                </div>
                <div className='all-menu'>전체메뉴</div>
                <div className="container">
                    <div className="row">
                        <div className="col-md-3">
                            <Card style={{ width: '18rem' }}>
                                <a href="/ownermypage"><Card.Img className='owner-menu-img store-owner-img' variant="top" src="/OwnerMainImg/StoreManagement.png" /></a>
                                <Card.Body>
                                    <Card.Title className='owner-menu-name'>가게관리</Card.Title>

                                </Card.Body>
                            </Card>
                        </div>
                        <div className="col-md-3">
                            <Card style={{ width: '18rem' }}>
                                <Card.Img className='owner-menu-img' variant="top" src="/OwnerMainImg/MenuManagement.png" onClick={() => [navigate("/menuManagement")]} />
                                <Card.Body>
                                    <Card.Title className='owner-menu-name'>메뉴관리</Card.Title>

                                </Card.Body>
                            </Card>
                        </div>
                        <div className="col-md-3">
                            <Card style={{ width: '18rem' }}>
                                <Card.Img className='owner-menu-img' variant="top" src="/OwnerMainImg/OrderRecieve.png" />
                                <Card.Body>
                                    <Card.Title className='owner-menu-name'>주문접수</Card.Title>

                                </Card.Body>
                            </Card>
                        </div>
                        <div className="col-md-3">
                            <Card style={{ width: '18rem' }}>
                                <Card.Img className='owner-menu-img' vvariant="top" src="/OwnerMainImg/SalesManagement.png" />
                                <Card.Body>
                                    <Card.Title className='owner-menu-name'>매출관리</Card.Title>
                                </Card.Body>
                            </Card>
                        </div>
                    </div>
                </div>
                <Footer />
            </>
        </>
    )
}

export default OwnerMain
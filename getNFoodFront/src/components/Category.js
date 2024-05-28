import "../css/Category.css"
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import 'bootstrap/dist/css/bootstrap.min.css';
import { useParams } from "react-router-dom";

const Category = () => {



    return (
        <>
            <div className="title"></div>
            <Container>
                <Row className="category-row1">
                    <Col className="col"><a href="/category/KOREAN"><img src="./CategoryImg/korean-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">한식</p></Col>
                    <Col><a href="/category/CHINESE"><img src="./CategoryImg/chinese-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">중식</p></Col>
                    <Col><a href="/category/JAPANESE"><img src="/CategoryImg/japanese-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">일식</p></Col>
                    <Col><a href="/category/WESTERN"><img src="/CategoryImg/western-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">양식</p></Col>
                    <Col><a href="/category/CHICKEN"><img src="/CategoryImg/chicken-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">치킨</p></Col>
                    <Col><a href="/category/PIZZA"><img src="/CategoryImg/pizza-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">피자</p></Col>
                </Row>
                <Row>
                    <Col><a href="/category/BURGER"><img src="/CategoryImg/burger-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">패스트푸드</p></Col>
                    <Col><a href="/category/MEAT"><img src="/CategoryImg/meat-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">육류</p></Col>
                    <Col><a href="/category/BREAD"><img src="/CategoryImg/bread-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">빵</p></Col>
                    <Col><a href="/category/DESSERTS"><img src="/CategoryImg/desserts-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">디저트</p></Col>
                    <Col><a href="/category/VEGETABLE"><img src="/CategoryImg/vegetable-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">채소</p></Col>
                    <Col><a href="/category/FRUITS"><img src="./CategoryImg/fruit-ctg2.png" className="category-img" alt=""></img></a>
                        <p className="category-name">과일</p></Col>
                </Row>
            </Container>

        </>
    )
}

export default Category
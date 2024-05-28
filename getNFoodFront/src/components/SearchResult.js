import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import React from 'react';
import Footer from './Footer';

const SearchResult = (props) => {

    const [searchContent, setSearchContent] = useState()
    console.log(props.searchList)
    console.log(searchContent)

    const { name } = useParams()
    console.log(name)

    useEffect(() => {
        props.searchApi(name)
        setSearchContent(props.searchList)
    }, [])


    return (
        <>
            props.searchList ? <><div className="container">
                <div className="row" >
                    <div style={{ "height": "100px" }}></div>
                    <div style={{ "textAlign": "center", "fontWeight": "bold", "fontSize": "1.5rem" }} className='search-main'>"{name}"에 대한 검색결과</div>
                    {
                        props.searchList && props.searchList.map((store, index) => {
                            return (<React.Fragment key={index}>
                                <div style={{ "marginLeft": "8vw" }} className="col-md-4" >
                                    <div style={{ "marginTop": "6vh" }}> <a href={`/menuList/${store.storeId}/${encodeURIComponent(store.storeName)}`}><img style={{ "width": "300px", "height": "300px" }} src={store.storePhotoUrl} /></a></div>
                                    <a href={`/menuList/${store.storeId}/${encodeURIComponent(store.storeName)}`}>  <div className='storeList-name'>{store.storeName}</div></a>
                                    <div className >{store.address}</div>
                                </div >
                            </React.Fragment>)
                        })
                    }
                </div>
            </div></> : <div style={{ "textAlign": "center", "fontWeight": "bold", "fontSize": "1.6rem" }}></div>

            <Footer />
        </>
    )
}


export default SearchResult
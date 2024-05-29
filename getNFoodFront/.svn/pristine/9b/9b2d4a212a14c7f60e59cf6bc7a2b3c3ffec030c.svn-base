import NavbarComponents from "./Navbar"
import { changeState } from "./store"
import { useDispatch, useSelector } from "react-redux"



const ToggleBntn = (props) => {
    return (<>
        <input type="checkbox" id="toggle" hidden onChange={props.toggleSwitch} />
        <label for="toggle" class="toggleSwitch">{props.isToggled ? <div className='customer-mode'>소비자</div>
            : <div className='owner-mode'>자영업자</div>}
            <span class="toggleButton"></span>
        </label>
    </>
    )
}

export default ToggleBntn
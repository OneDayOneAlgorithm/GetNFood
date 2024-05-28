import { configureStore, createSlice } from '@reduxjs/toolkit'


let isToggled2 = createSlice({
    name: "isToggled2",
    initialState: true,
    reducers: {
        changeState(state) {
            return !state
        }
    }
})


export default configureStore({
    reducer: {
        isToggled2: isToggled2.reducer
    }
})

export let { changeState } = isToggled2.actions
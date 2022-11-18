
import './App.css';

import {FrontPage} from "./frontpage";
import {UserPage} from "./userpage";
import {HashRouter, Route, Router, Routes, useNavigate} from "react-router-dom";
import {createHashHistory} from 'history';
import {useEffect, useState} from "react";
import {EditUser} from "./edituser.jsx";
import {NewChat} from "./newchat.jsx";


const history = createHashHistory();






function App() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [activeUserId, setActiveUserId] = useState(0);
    const [activeChat, setActiveChat] = useState(0);
    const [activeUserName, setActiveUserName] = useState("");
    const [update, setUpdate] = useState(false);
    useEffect( () => {
        const test= async ()=>{
            const res = await fetch("/api/users");

            setUsers(await res.json());
            setLoading(false);
        }
        test();
    }, [update]);

    if (loading) {
        return (
            <div>Loading...</div>
        )
    }
    const setUserTo = (e)=>{
        setActiveUserId(e.target.value)
        setActiveUserName(users[e.target.value])

    }
    return (
        <div className="App">

            <Router basename="/" history={history} location={"/"}></Router>
            <HashRouter>
                <Routes>
                    <Route path={"/"} element={<FrontPage users={users} setUserTo={setUserTo}/> }/>
                    <Route path={"/user"} element={<UserPage setActiveChat={setActiveChat} activeUserId={activeUserId} activeUserName={activeUserName}/>}/>
                    <Route path={"/edituser"} element={<EditUser activeUserId={activeUserId} />}/>
                    <Route path={"/newchat"} element={<NewChat activeChat={activeChat} users={users} activeUserId={activeUserId}/>}/>
                    <Route path={"/newuser"} element={<EditUser activeUserId={-1} setUpdate={setUpdate}/>}/>
                </Routes>
            </HashRouter>


        </div>

    )

}

export default App

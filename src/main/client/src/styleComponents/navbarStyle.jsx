import styled from "styled-components";

export  const MainNavBar = styled("div")`
 
  font-family: sans-serif;
  display: flex;
  margin: 0.5rem;
  padding: 1rem;
  justify-content: space-around;
  background: #f0f0f0;
  height: 5vh;
  
  .button{
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    cursor:pointer;
    font-size: 16px;
  }
`;
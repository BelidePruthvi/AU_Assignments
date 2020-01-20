import React, { useState, useEffect, Fragment } from 'react';
import './App.css';
import ButtonAppBar from './components/app-bar'
import UserList from './components/user-lists' 
import { Container } from '@material-ui/core';
import AddUser from './components/add-user'
import EditUser from './components/edit-user'
import * as _ from 'lodash'


function App() {

  // const initusers =[
  //   {
  //     name : 'pru',
  //     age : 20
  //   },
  //   {
  //     name : 'abc',
  //     age : 19
  //   }
  // ];

  const initusers=[]
  
  const [users,updateUsers]=useState(initusers)
  const [curuser,setCurrent]=useState('')
  const [edit,changeButton]=useState(false);

  useEffect(()=>{
    setTimeout(()=>{
    fetch('https://jsonplaceholder.typicode.com/users')
      .then(response => response.json())
      .then(data => updateUsers(data))
    },3000);
      //.then(updateUsers) since there is only single parameter

  },[]);
  
  const addUser = newuser =>{
      newuser.id=users.length+1
      updateUsers([...users,newuser])
  }

  const deleteUser = id =>{
    if(window.confirm("Are u sure want to delete this record"))
    {
    changeButton(false);
    updateUsers(users.filter(user=>user.id!==id))
    }
  }

  const updateUser = (id,changeduser) =>
  {
      changeButton(false);
      updateUsers(users.map(user => (user.id === id ? changeduser : user)))
  }

  const editRow = user =>{
    changeButton(true);
    setCurrent({ id: user.id, name: user.name, email: user.email })
  }

  const sortname = () =>{
    updateUsers(_.sortBy(users,'name'));
    console.log(users);
  }
  const sortemail = () =>{
    updateUsers(_.sortBy(users,'email'));
  }

  return (
    <div>
      <ButtonAppBar/>
      {
          !!users.length?
      <Fragment>
      <Container maxWidth="md">
      <UserList users={users} editRow={editRow} deleteUser={deleteUser} sortname={sortname} sortemail={sortemail}/>
      </Container>
      {edit ? (
							
							<Container >
							<Fragment>
							<h2>Edit user</h2>
							<EditUser
								curuser={curuser}
								updateUser={updateUser}
							/>
							</Fragment>
							</Container>
					) : (
						<Container >
						<Fragment >
							<h2>Add user</h2>
							<AddUser addUser={addUser} />
						</Fragment>
						</Container>
					
					)}
      <br/>
      {/* <Container>
      <AddUser onuserUpdateClicked={onuserUpdateClicked}/>
      </Container> */}
      </Fragment>:
      <p>Loading fetching data...</p>
    }
    </div>
  )
}

export default App;

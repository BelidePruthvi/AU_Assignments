import React,{Fragment,useState} from 'react'
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const AddUser = ({addUser})=>{

    const [newname,onNewName]=useState('');
    const [newemail,onNewEmail]=useState('');
  
  return (
   
    <Fragment>
		<TextField id="name" label="Name"  value={newname}  onChange={e=>onNewName(e.currentTarget.value)} variant="outlined" />
		<TextField id="username" label="Email"  value={newemail}  onChange={e=>onNewEmail(e.currentTarget.value)} variant="outlined" />
        <Button variant="contained" color="primary" onClick={() =>addUser({name:newname,email:newemail})}>Add User</Button>
      </Fragment>
  )
}

export default AddUser;
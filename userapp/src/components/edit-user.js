import React,{useState,Fragment} from 'react'
import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';

const EditUser = props => {
    const [ user] = useState(props.curuser)
    const [newname,onNewName]=useState(user.name);
    const [newemail,onNewEmail]=useState(user.email);

  return (
   
    <Fragment>
		<TextField id="name" label="Name"  value={newname}  onChange={e=>onNewName(e.currentTarget.value)} variant="outlined" />
		<TextField id="username" label="Email"  value={newemail}  onChange={e=>onNewEmail(e.currentTarget.value)} variant="outlined" />
        <Button variant="contained" color="primary" onClick={() =>props.updateUser(user.id,{name:newname,email:newemail})}>Edit User</Button>
      </Fragment>
  )
}

export default EditUser
import React from 'react'
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import Button from '@material-ui/core/Button';

const useStyles = makeStyles({
    table: {
      minWidth: 650,
    },
  });

const UserList = props =>{
    const classes = useStyles();

    return(
        <TableContainer component={Paper}>
      <Table className={classes.table} aria-label="simple table">
        <TableHead>
        <TableRow>
            <TableCell align="center" onClick={()=> props.sortname()}>Name</TableCell>
            <TableCell align="center" onClick={()=> props.sortemail()}>Email</TableCell>
        </TableRow>
        </TableHead>
        <TableBody>
            {
                props.users.map(user => (
                    <TableRow key={user.name}>
              <TableCell align="center">{user.name} </TableCell>
              <TableCell align="center">{user.email}</TableCell>
              <TableCell align="center" component="th" scope="row">
                 <Button variant="contained" color="default"  onClick={() => {props.editRow(user)}}>Edit</Button>
                 </TableCell>
                <TableCell align="center" component="th" scope="row"> 
                <Button variant="contained" color="default" onClick={() => props.deleteUser(user.id)}>Delete</Button>
                </TableCell>
              
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

  );

}

export default UserList
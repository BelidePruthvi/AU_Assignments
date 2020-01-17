import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms'
import {Validators} from '@angular/forms'
import {Router} from '@angular/router'

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {

  UserForm;
  key : any;
  users :any;
  temp : any;
  constructor(private router : Router ) { }

  ngOnInit() {

    
  this.key=sessionStorage.getItem('editkey');
  console.log(this.key);
  this.users=JSON.parse(sessionStorage.getItem('users'));
  console.log(this.users)


    this.UserForm = new FormGroup({
      firstname :new FormControl(this.users[this.key]['firstname'],Validators.required),
      lastname :new FormControl(this.users[this.key]['lastname'],Validators.required),
      age :new FormControl(this.users[this.key]['age'],Validators.required),
      dob :new FormControl(this.users[this.key]['dob'],Validators.required),
      phonenumber :new FormControl(this.users[this.key]['phonenumber'],Validators.required) 
  });


  }

  onSubmit() {

    
    console.warn(this.UserForm.value);
    console.warn('working');
    console.log('working');
    this.temp=JSON.parse(sessionStorage.getItem('users'));
    if(!this.temp)
      this.temp={};
    delete this.temp[this.key];
    this.temp[this.UserForm.value.phonenumber]=this.UserForm.value;
    sessionStorage.setItem('users',JSON.stringify(this.temp));
    console.log(this.temp);
    this.router.navigate(['/listusers']);   
  }


}

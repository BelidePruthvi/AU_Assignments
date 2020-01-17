import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms'
import {Validators} from '@angular/forms'
import {Router} from '@angular/router'

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  UserForm;
  temp : any;

  constructor(private router:Router) {
    if(!sessionStorage.getItem('users'))
    {
      sessionStorage.setItem('users',JSON.stringify({}));
      //sessionStorage.setItem('users',JSON.stringify({}));
    }

   }

  ngOnInit() {
        this.UserForm = new FormGroup({
        firstname :new FormControl('',Validators.required),
        lastname :new FormControl('',Validators.required),
        age :new FormControl('',Validators.required),
        dob :new FormControl('',Validators.required),
        phonenumber :new FormControl('',Validators.required) 
    });


  }

  onSubmit() {
    
    console.warn(this.UserForm.value);
    console.warn('working');
    console.log('working');
    this.temp=JSON.parse(sessionStorage.getItem('users'));
    if(!this.temp)
      this.temp={};
    this.temp[this.UserForm.value.phonenumber]=this.UserForm.value;
    sessionStorage.setItem('users',JSON.stringify(this.temp));
    console.log(this.temp);
    this.router.navigate(['/listusers']);   
  }



}

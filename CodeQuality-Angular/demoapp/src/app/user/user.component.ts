import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import {Validators} from '@angular/forms';
import {Router} from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';

const endpoint = 'http://localhost:5678/api/adduser';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  UserForm;
  temp: any;

  constructor(private router: Router, private http: HttpClient) {
    if ( !sessionStorage.getItem('users')) {
      sessionStorage.setItem('users', JSON.stringify({}));
    }

   }

  ngOnInit() {
        this.UserForm = new FormGroup({
        firstname: new FormControl('', Validators.required),
        lastname: new FormControl('', Validators.required),
        age: new FormControl('', Validators.required),
        // dob: new FormControl('', Validators.required),
        phonenumber: new FormControl('', Validators.required)
    });


  }

  onSubmit() {
    console.warn(this.UserForm.value);
    console.warn('working');
    console.log('working');
    this.temp = JSON.parse(sessionStorage.getItem('users'));
    if ( !this.temp) {
      this.temp = {};
    }
    this.temp[this.UserForm.value.phonenumber] = this.UserForm.value;
    sessionStorage.setItem('users', JSON.stringify(this.temp));
    this.http.post<any>(endpoint, this.UserForm.value, httpOptions)
    .subscribe();
    this.router.navigate(['/listusers']);
  }



}

import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import * as _ from 'lodash';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-listusers',
  templateUrl: './listusers.component.html',
  styleUrls: ['./listusers.component.css']
})


export class ListusersComponent implements OnInit {

  userlist :any;
  userkeys :any;
  uservalues : any;
  sortedlist : any;
  userform : any;
  val : any;
  inp1 :any;
  term :any;
  values :any;


  constructor(private router :  Router) {
      this.userlist=JSON.parse(sessionStorage.getItem('users'));
      if(this.userlist)
      {
        this.userkeys=Object.keys(this.userlist);
        this.values=Object.values(this.userlist);
      }
      else
      {
        this.userkeys=[]
        this.uservalues=[]
      }
      console.log(this.userlist);
   }

  ngOnInit() {
    this.userform =new FormGroup({
        inp : new FormControl(' ')
      });
  }

  edit(key)
  {
    console.log(key);
    sessionStorage.setItem('editkey',key);
    this.router.navigate(['./edituser']);
  }
  delete(key)
  {

    if(confirm("Are you sure to delete this record?")) {
      console.log(key);
     this.userlist= JSON.parse(sessionStorage.getItem('users'));
      delete this.userlist[key];
      console.log(this.userlist);
      sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);
    }   

  }

  firstnamesort(){
    console.log('works');   
    this.userlist=JSON.parse(sessionStorage.getItem('users'));
    this.uservalues=Object.values(this.userlist);
    // console.log(this.uservalues);
    this.uservalues=_.sortBy(this.uservalues, ['firstname']);
    console.log(this.uservalues);
    this.sortedlist={}
    for(let i=0;i<this.uservalues.length;i++)
    {
        console.log(this.uservalues[i]);
        this.sortedlist[this.uservalues[i]['phonenumber']]=this.uservalues[i];
    }
    console.log(this.sortedlist);
    this.userlist=this.sortedlist;
    sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);

  }

  lastnamesort(){
    console.log('works');   
    this.userlist=JSON.parse(sessionStorage.getItem('users'));
    this.uservalues=Object.values(this.userlist);
    // console.log(this.uservalues);
    this.uservalues=_.sortBy(this.uservalues, ['lastname']);
    console.log(this.uservalues);
    this.sortedlist={}
    for(let i=0;i<this.uservalues.length;i++)
    {
        console.log(this.uservalues[i]);
        this.sortedlist[this.uservalues[i]['phonenumber']]=this.uservalues[i];
    }
    console.log(this.sortedlist);
    this.userlist=this.sortedlist;
    sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);

  }

  agesort(){
    console.log('works');   
    this.userlist=JSON.parse(sessionStorage.getItem('users'));
    this.uservalues=Object.values(this.userlist);
    // console.log(this.uservalues);
    this.uservalues=_.sortBy(this.uservalues, ['age']);
    console.log(this.uservalues);
    this.sortedlist={}
    for(let i=0;i<this.uservalues.length;i++)
    {
        console.log(this.uservalues[i]);
        this.sortedlist[this.uservalues[i]['phonenumber']]=this.uservalues[i];
    }
    console.log(this.sortedlist);
    this.userlist=this.sortedlist;
    sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);

  }

  dobsort(){
    console.log('works');   
    this.userlist=JSON.parse(sessionStorage.getItem('users'));
    this.uservalues=Object.values(this.userlist);
    // console.log(this.uservalues);
    this.uservalues=_.sortBy(this.uservalues, ['dob']);
    console.log(this.uservalues);
    this.sortedlist={}
    for(let i=0;i<this.uservalues.length;i++)
    {
        console.log(this.uservalues[i]);
        this.sortedlist[this.uservalues[i]['phonenumber']]=this.uservalues[i];
    }
    console.log(this.sortedlist);
    this.userlist=this.sortedlist;
    sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);

  }

  phonesort(){
    console.log('works');   
    this.userlist=JSON.parse(sessionStorage.getItem('users'));
    this.uservalues=Object.values(this.userlist);
    this.uservalues=_.sortBy(this.uservalues, ['phonenumber']);
    console.log(this.uservalues);
    this.sortedlist={}
    for(let i=0;i<this.uservalues.length;i++)
    {
        console.log(this.uservalues[i]);
        this.sortedlist[this.uservalues[i]['phonenumber']]=this.uservalues[i];
    }
    console.log(this.sortedlist);
    this.userlist=this.sortedlist;
    sessionStorage.setItem('users',JSON.stringify(this.userlist));
      this.userkeys=Object.keys(this.userlist);
      this.values=Object.values(this.userlist);
      this.router.navigate(['./listusers']);

  }

}

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {UserComponent} from './user/user.component' 
import {ListusersComponent} from './listusers/listusers.component'
import { EdituserComponent } from './edituser/edituser.component';

const routes: Routes = [ { path:  'adduser', component:  UserComponent},
                         {path : 'listusers',component: ListusersComponent},
                         {path: 'edituser', component :EdituserComponent},
                         {path : '',component: ListusersComponent}
                      ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]

})
export class AppRoutingModule { }

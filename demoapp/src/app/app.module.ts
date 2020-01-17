import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserComponent } from './user/user.component';
import { HeaderComponent } from './header/header.component';
import { ListusersComponent } from './listusers/listusers.component';
import { EdituserComponent } from './edituser/edituser.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import {InitialCapital} from './listusers/custompipe'

@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    HeaderComponent,
    ListusersComponent,
    EdituserComponent,
    InitialCapital
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

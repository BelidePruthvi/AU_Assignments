import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {FormGroup, ReactiveFormsModule} from '@angular/forms';

import { UserComponent } from './user.component';

describe('Component: UserComponent', () => {
  let component: UserComponent;
  beforeEach(() => {
  TestBed.configureTestingModule({
      declarations: [UserComponent],
      imports: [ReactiveFormsModule]
  });

  const fixture = TestBed.createComponent(UserComponent);
  component = fixture.componentInstance;
  it('should create', () => {
        expect(component).toBeTruthy();
      });
});});

// describe('UserComponent', () => {
//   let component: UserComponent;
//   let fixture: ComponentFixture<UserComponent>;

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       declarations: [ UserComponent ]
//     })
//     .compileComponents();
//   }));

//   beforeEach(() => {
//     fixture = TestBed.createComponent(UserComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
// });

import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/Authentication.service';
import {FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {


  myGroup = new FormGroup({
    email: new FormControl(),
    senha: new FormControl()
});

  constructor(
    private authService: AuthenticationService,
     ) { }

  ngOnInit() {
  }
  loginUser(){
    let values = this.myGroup.value;
    this.authService.login(values.email,values.senha);

  }

}
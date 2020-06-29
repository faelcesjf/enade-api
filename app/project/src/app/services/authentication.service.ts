import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Storage } from '@ionic/storage';
import { ToastController, Platform } from '@ionic/angular';
import { BehaviorSubject } from 'rxjs';
import { HttpClient,HttpHeaders } from '@angular/common/http';


@Injectable()
export class AuthenticationService {

  authState = new BehaviorSubject(false);

  constructor(
    private router: Router,
    private storage: Storage,
    private platform: Platform,
    private http: HttpClient,

    public toastController: ToastController
  ) {
    this.platform.ready().then(() => {
      this.ifLoggedIn();
    });
  }

  ifLoggedIn() {
    this.storage.get('USER_INFO').then((response) => {
      if (response) {
        this.authState.next(true);
      }
    });
  }


  async login(email,senha) {

    let url = 'http://localhost:8080/api/usuarios/login';
    let headers = new HttpHeaders();


    
    let postData = {
      "email": email,
      "senha": senha
}
    var usuario;
   await  this.http.post(url, postData,{headers: headers}).toPromise().then(
      (response) => {
      usuario =  JSON.parse(JSON.stringify(response) );
      console.log(usuario);
     
      

    }).catch((response) =>{
    });

    await this.storage.set('USER_INFO', usuario);

    if (usuario.idTipoUsuario == 1){
      this.router.navigate(['dashboard']);
      this.authState.next(true);
  }
  else{
    this.router.navigate(['home']);
    this.authState.next(true);

  }
  
  }

  logout() {
    this.storage.remove('USER_INFO').then(() => {
      this.router.navigate(['login']);
      this.authState.next(false);
    });
  }

  isAuthenticated() {
    return this.authState.value;
  }



}
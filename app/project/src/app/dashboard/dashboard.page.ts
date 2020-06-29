import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../services/Authentication.service';
import { HttpClient,HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
})
export class DashboardPage implements OnInit {

  alunos : any
  isNota = false

  constructor(
    private authService: AuthenticationService,
    private http: HttpClient,


    ) { }

  ngOnInit() {
    this.isNota = false

    this.getAlunosPendentes();
  }

  logoutUser(){
    this.authService.logout();
  }

  
  getAlunos(){

    
    let headers =  new HttpHeaders();
    headers.set('Accept', 'application/json');
    var url = "http://localhost:8080/api/alunos/";
    this.isNota = false;
   
    this.http.get(url).toPromise()
    .then((response)=>{
      this.alunos = response;

    } ).catch((response)=>{
      this.alunos =  [];  
      console.log(response);
    }


    );

  }

  public getAlunosPendentes(){
    


    let headers =  new HttpHeaders();
    headers.set('Accept', 'application/json');
    var url = "http://localhost:8080/api/alunos/relatorios/pendentes/1";
    this.isNota = false;

   
    this.http.get(url).toPromise()
    .then((response)=>{
      this.alunos = response;

    } ).catch((response)=>{
      this.alunos =  [];  
      console.log(response);
    }


    );




  }

  public getAlunosResultado(){
    


    let headers =  new HttpHeaders();
    headers.set('Accept', 'application/json');
    var url = "http://localhost:8080/api/alunos/relatorios/resultados/1";
    this.isNota = true;

   
    this.http.get(url).toPromise()
    .then((response)=>{
      this.alunos = response;

    } ).catch((response)=>{
      this.alunos =  [];  
      console.log(response);
    }


    );




  }
  



}
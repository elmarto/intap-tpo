import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  userEmail: string;
  userPassword: string;
  error: string;

  constructor(public router: Router) {
  }

  ngOnInit() {
  }

  login() {
    if (this.userEmail === 'admin' && this.userPassword === 'admin') {
      this.router.navigate(['/establecimientos']);
    } else {
      this.error = 'Email o Contraseña incorrectos';
    }
  }

}

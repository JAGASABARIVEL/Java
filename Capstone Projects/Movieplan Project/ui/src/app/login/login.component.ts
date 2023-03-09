import { Component } from '@angular/core';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  error:string;
  input:string;
  phone:string;
  password:string;
  returnUrl = './admin';

  constructor(private userService : UserService, private route : Router){}

  checkPhone(event : any){
    this.input = (event.target.value);
    if (this.input.length < 10 && this.input.length > 0){
      this.error = "Phone is invalid";
    }
    else{
      this.error = undefined;
    }
  }

  login(){
    this.userService.login(this.phone, this.password).subscribe((response)=>
    console.log(response));
    localStorage.setItem('isLoggedIn', "true");  
      localStorage.setItem('token', this.phone);
      this.route.navigate([""]);
  }
}

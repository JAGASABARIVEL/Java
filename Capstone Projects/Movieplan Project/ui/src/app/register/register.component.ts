import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name: string;
  phone: string;
  password: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

  }

  register() {
    
    this.userService.register(this.phone, this.name, this.password).subscribe((response) =>
      console.log(response));
    localStorage.setItem('isLoggedIn', "true");
    localStorage.setItem('token', this.phone);
    this.router.navigate(['./admin'])
  }

}

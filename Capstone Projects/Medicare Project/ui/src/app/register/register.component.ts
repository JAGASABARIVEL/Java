import { HttpStatusCode } from '@angular/common/http';
import { OnInit, Component } from '@angular/core';
import { UserService } from '../../service/users.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  phone: string;
  name: string;
  password: string;

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

  }

  register() {
    console.log(this.name);
    console.log(this.phone);
    console.log(this.password);
    this.userService.register(this.phone, this.name, this.password).subscribe((response) =>
      console.log(response));
    localStorage.setItem('isLoggedIn', "true");
    localStorage.setItem('token', this.phone);
    this.router.navigate(['./admin'])
  }
}

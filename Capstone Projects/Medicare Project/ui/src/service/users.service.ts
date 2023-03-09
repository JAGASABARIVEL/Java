import { Injectable } from  '@angular/core';
import { HttpClient } from  '@angular/common/http';

@Injectable( {
    providedIn : "root"
})
export class UserService{
    url:string = "http://localhost:8080";
    userApi:string = "/api/user"
    constructor(private browser : HttpClient){}

    login(phone:string, password:string){
        let loginApi:string = this.url + this.userApi + "/login";
        let uphone = Number(phone);
        return this.browser.post(loginApi, 
            {phone : uphone, password : password}, 
            {responseType: 'text'}
            );
    }
    
    register(phone:string, name:string, password:string){
        let registerApi:string = this.url + this.userApi + "/register";
        let uphone = Number(phone);
        return this.browser.post(registerApi, 
            {uName : name, uPhone : uphone, uPassword : password}, 
            {responseType: 'text'},
            );
    }

    logout() :void {    
        localStorage.setItem('isLoggedIn','false');    
        localStorage.removeItem('token');    
        } 
}
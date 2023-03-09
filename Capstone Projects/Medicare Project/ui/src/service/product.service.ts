import { EventEmitter, Injectable } from  '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { Products } from '../app/model/product.model';

@Injectable( {
    providedIn : "root"
})
export class ProductService{
    url:string = "http://localhost:8080";
    productApi:string = "/api/products";
    cartApi:string = "/api/cart";

    constructor(private browser : HttpClient){}

    products: Products[]
    carts: Products[];
    getProducts(){
        let registerApi:string = this.url + this.productApi + "/get";
        return this.browser.get(registerApi);
    }

     getProductById(pId : number){
        let registerApi:string = this.url + this.productApi + "/get/" + pId;
        return this.browser.get(registerApi);
     }

     setCarts(product_id: number){
        console.log("product_id   " + product_id);
        let phone = localStorage.getItem("token");
        let registerApi:string = this.url + this.cartApi + "/add/" + phone;
        return this.browser.post(registerApi, 
            {mId : Number(product_id)}, 
            {responseType: 'text'}
            );
     }

     getCarts(){
        let phone = localStorage.getItem("token");
        let registerApi:string = this.url + this.cartApi + "/get/" + phone;
        return this.browser.get(registerApi);
     }

     eventEmitter:EventEmitter<string> = new EventEmitter<string>();
}
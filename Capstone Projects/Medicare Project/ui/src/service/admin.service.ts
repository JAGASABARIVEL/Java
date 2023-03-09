import { Injectable } from  '@angular/core';
import { HttpClient } from  '@angular/common/http';

@Injectable( {
    providedIn : "root"
})
export class AdminService{
    url:string = "http://localhost:8080";
    categoryApi:string = "/api/categories";
    productApi:string = "/api/products";

    constructor(private browser : HttpClient){}

    addCategory(category:string){
        let addCategoryApi:string = this.url + this.categoryApi + "/add";
        return this.browser.post(addCategoryApi, 
            {name : category}, 
            {responseType: 'text'}
            );
    }
    
    addProducts(
        pName:string,
        pImage:string,
        pBrand:string,
        pDesc:string,
        pCategory:string,
        pPrice:number,
        quantity:number
    ){
        let registerApi:string = this.url + this.productApi + "/add";
        let uprice = Number(pPrice);
        let uquantity = Number(quantity);

        return this.browser.post(registerApi, 
            {
                pName  : pName,
                pImage : pImage,
                pBrand : pBrand,
                pDesc  : pDesc,
                pCategory:pCategory,
                pPrice : uprice,
                quantity:uquantity
            }, 
            {responseType: 'text'}
            );
    }
}
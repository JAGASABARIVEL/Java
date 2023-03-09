import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
    providedIn: "root"
})
export class AdminService {
    url: string = "http://localhost:8080";
    categoryApi: string = "/api/categories";
    productApi: string = "/api/movie";

    constructor(private browser: HttpClient) { }

    addCategory(category: string) {
        let addCategoryApi: string = this.url + this.categoryApi + "/add";
        return this.browser.post(addCategoryApi,
            { name: category },
            { responseType: 'text' }
        );
    }

    mId: number;
    mName: number;
    mImage: string;
    tickets: number;
    price: number;

    addProducts(
        mName: string,
        mImage: string,
        tickets: number,
        price: number,
    ) {
        let registerApi: string = this.url + this.productApi + "/add";
        let uprice = Number(price);
        let utickets = Number(tickets);

        return this.browser.post(registerApi,
            {
                mName: mName,
                mImage: mImage,
                tickets: utickets,
                price: uprice
            },
            { responseType: 'text' }
        );
    }
}
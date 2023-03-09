import { Injectable, EventEmitter } from '@angular/core';
import { Products } from '../model/Products.model';

@Injectable()
export class ProductService {
     carts : Products[];
     products: Products[] = [
          {
               pId: 1,
               pImage: "https://images.unsplash.com/photo-1518843875459-f738682238a6?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OHx8dmVnZXRhYmxlc3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
               pTitle: "Fresh Mixed Vegetables",
               pDescription: "",
               pPrice: 5
          },
          {
               pId: 2,
               pImage: "https://images.unsplash.com/photo-1606923829579-0cb981a83e2e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fHZlZ2V0YWJsZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
               pTitle: "Fresh Tomatoes",
               pDescription: "",
               pPrice: 5
          },
          {
               pId: 3,
               pImage: "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTJ8fGZvb2R8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
               pTitle: "Fresh Country Vegetables",
               pDescription: "",
               pPrice: 5
          }
     ];

     getProducts(): Products[] {
          return this.products;
     }

     getProductById(pId : number) : Products{
          return this.products.find(product => product.pId === pId);
     }

     setCarts(products: Products[]){
          this.carts = products;
          console.log(this.carts);
     }

     getCarts() : Products[]{
          console.log(this.carts);
          return this.carts;
     }

     eventEmitter:EventEmitter<string> = new EventEmitter<string>();
}

import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Products } from 'src/app/model/Products.model';
import { ProductService } from 'src/app/service/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit{

  products : Products[];
  carts : Products[] = [];
  product_collen : string = "col-sm-12";


  constructor(private productService : ProductService, private router: Router){}

  ngOnInit(): void {
    this.products = this.productService.getProducts();
    this.productService.eventEmitter.subscribe(collen=>{
      this.product_collen = collen});
  }

  updateCollen(){
    this.product_collen = this.carts.length >0? "col-sm-6" : "col-sm-12";
  }

  addToCart($event : any){
    let pId = Number($event.target.id);
    if (this.carts.find(product_id => product_id.pId === pId)){
      return;
    }
    else{
    let product : Products = this.productService.getProductById(pId);
    this.carts.push(product);
    this.productService.setCarts(this.carts);
    }
    this.updateCollen();
  }

  onDetail($event){
    this.router.navigate(['./product-detail'], {queryParams : {'product' : $event.target.id}});
  }
  
}

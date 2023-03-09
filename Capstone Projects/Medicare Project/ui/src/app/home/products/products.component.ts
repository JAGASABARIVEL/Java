import { Component, OnInit, AfterContentChecked } from '@angular/core';
import { Products } from '../../model/product.model';
import { ProductService } from '../../../service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit, AfterContentChecked {
  products: Products[];
  carts: Products[] = [];
  product_collen: string = "col-sm-12";
  product_id : number;


  constructor(private productService: ProductService, private router: Router) { 
    this.updateCollen();
    console.log("constructor " + this.carts);
  }
  ngAfterContentChecked(): void {
    console.log("ngAfterContentChecked " + this.carts);
    this.updateCollen();
  }

  ngOnInit(): void {
    this.productService.getProducts().subscribe((response: Products[]) => {
      this.products = response;
      console.log(this.products);

    });
    this.productService.eventEmitter.subscribe(collen => {
      this.product_collen = collen
    });
    this.productService.getCarts().subscribe((response:Products[])=>{
      this.carts = response;
    })
    console.log("this.products " + this.products);
    this.updateCollen();
  }

  updateCollen() {
    this.product_collen = this.carts.length > 0 ? "col-sm-6" : "col-sm-12";
  }

  addToCart($event: any) {
    let pId = Number($event.target.id);
    let product: Products;

    this.productService.getCarts().subscribe((response:Products[])=>{
      this.carts = response;
      this.updateCollen();
    })
    if (this.carts.find(product_id => product_id.pId === pId)) {
      return;
    }
    else {
      console.log("addToCart " + pId);
      this.productService.getProductById(pId).subscribe((response: Products) => {
        console.log("cart respo " + response.pName);
        product = response;
        console.log("product cart " + product.pId);
        this.product_id = product.pId;

      });

      this.productService.setCarts(this.product_id).subscribe(()=>{
        console.log("Product added to cart");
        this.updateCarts();
        this.updateCollen();
      })

    }

  }

  updateCarts(){
    this.productService.getCarts().subscribe((response:Products[])=>{
      this.carts = response;
      this.updateCollen();
    });
  }
  onDetail($event) {
    this.router.navigate(['./product-detail'], { queryParams: { 'product': $event.target.id } });
  }
}

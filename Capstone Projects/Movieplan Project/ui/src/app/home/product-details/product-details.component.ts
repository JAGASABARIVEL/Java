import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Products } from '../../model/product.model';
import { ProductService } from '../../service/product.service';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product : Products;

  constructor(private productService : ProductService, private router: ActivatedRoute, private route : Router){}

  change_image(el : any){
    let container = document.getElementById("main-image");
    console.log(el.getAttribute("src"));
    container.setAttribute("src", el.getAttribute("src"));
  }

  ngOnInit(): void {
    let id = this.router.snapshot.queryParamMap.get('product');
    this.productService.getProductById(Number(id)).subscribe((response:Products)=>{
      this.product = response;
    });
  }

  chekout(){
    this.route.navigate(["./payment"]);
  }
}

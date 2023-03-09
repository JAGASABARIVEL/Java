import { Component, OnInit } from '@angular/core';
import { Products } from '../../model/product.model';
import { ProductService } from '../../../service/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.css']
})
export class ProductDetailComponent implements OnInit {
  product : Products;

  constructor(private productService : ProductService, private router: ActivatedRoute){}

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
}

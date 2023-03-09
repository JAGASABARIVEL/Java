import { Component, Input } from '@angular/core';
import { Products } from '../../model/product.model';
import { ProductService } from '../../service/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-carts',
  templateUrl: './carts.component.html',
  styleUrls: ['./carts.component.css']
})
export class CartsComponent {
  @Input() cart : Products[];

  constructor(private productService : ProductService, private router : Router){}

  removeFunction(pId : Products){
    this.cart.splice(this.cart.indexOf(pId), 1);
    if(this.cart.length === 0){
      this.productService.eventEmitter.emit("col-sm-12");
    }
  }

  plus($event){
    let plusAttrib : string = $event.target.id
    let countAttribute = 'count' + plusAttrib.slice(4, plusAttrib.length);
    console.log(plusAttrib.slice(4, plusAttrib.length));
    let value = Number(document.getElementById(countAttribute).innerHTML);
    document.getElementById(countAttribute).innerHTML = String(value + 1);
   
  }

  minus($event){
    let minusAttrib : string = $event.target.id
    let countAttribute = 'count' + minusAttrib.slice(5, minusAttrib.length);
    let spliceParam = Number(minusAttrib.slice(5, minusAttrib.length));
    console.log(Number($event.target.id))
    let value = Number(document.getElementById(countAttribute).innerHTML);
    if (value > 0){
        document.getElementById(countAttribute).innerHTML = String(value - 1);
    }
    else{
      this.cart.splice(this.cart.indexOf(this.cart.find(carts=>carts.mId === Number(minusAttrib.slice(5, minusAttrib.length)))), 1);
    }
  }

  total(){
    let tot = 0;
    for(let number of this.cart){
      console.log("cart " + number.mName);
      tot = tot + number.price;
      console.log("price ", number.price);
    }
    console.log("tot " + tot);
    return tot;
  }
  chekout(){
    this.router.navigate(["./payment"]);
  }
  concat(pre, post){
    return pre+post;
  }
}

import { Component } from '@angular/core';
import { AdminService } from '../../../service/admin.service';

@Component({
  selector: 'admin-app-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent {
  pName:string;
	pImage:string;
	pBrand:string;
	pDesc:string;
	pCategory:string;
	pPrice:number;
	quantity:number;

  constructor(private adminService : AdminService){}

  save(){
    this.adminService.addProducts(
      this.pName,
      this.pImage,
      this.pBrand,
      this.pDesc,
      this.pCategory,
      this.pPrice,
      this.quantity
    ).subscribe((response)=>
    console.log(response));
  }
}

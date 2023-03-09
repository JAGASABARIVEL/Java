import { Component } from '@angular/core';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-admin-products',
  templateUrl: './admin-products.component.html',
  styleUrls: ['./admin-products.component.css']
})
export class AdminProductsComponent {
  mName:string;
	mImage:string;
  mTickets:number;
  mPrice:number;

  constructor(private adminService : AdminService){}

  save(){
    this.adminService.addProducts(
      this.mName,
      this.mImage,
      this.mTickets,
      this.mPrice
    ).subscribe((response)=>
    console.log(response));
  }
}

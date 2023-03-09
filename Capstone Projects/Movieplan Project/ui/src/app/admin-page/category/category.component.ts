import { Component } from '@angular/core';
import { AdminService } from '../../service/admin.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent {
  category:string;

  constructor(private adminService : AdminService){}

  save(){
    this.adminService.addCategory(this.category).subscribe((response)=>
      console.log(response));
  }
}

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { CartsComponent } from './home/carts/carts.component';
import { ProductDetailComponent } from './home/product-detail/product-detail.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';

const routes: Routes = [
  { path : "", component : HomeComponent },
  { path : "carts", component : CartsComponent },
  { path : "product-detail", component : ProductDetailComponent },
  { path : "payment", component : PaymentShippingDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

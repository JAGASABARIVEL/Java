import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AuthGuardGuard } from './guards/auth-guard.guard';
import { ProductDetailsComponent } from './home/product-details/product-details.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';

const routes: Routes = [
  { path : "register", component : RegisterComponent },
  { path : "login", component : LoginComponent },
  { path : "admin", component : AdminPageComponent, canActivate : [AuthGuardGuard] },
  { path : "", component : HomeComponent, canActivate : [AuthGuardGuard] },
  { path : "product-detail", component:ProductDetailsComponent },
  { path : "payment", component:PaymentShippingDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

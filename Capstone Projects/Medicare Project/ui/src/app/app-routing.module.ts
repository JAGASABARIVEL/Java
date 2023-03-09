import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AuthGuard } from './guards/auth.guard';
import { HomeComponent } from './home/home.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';

const routes: Routes = [
  { path : "register", component : RegisterComponent },
  { path : "login"   , component : LoginComponent },
  { path : "admin" , component : AdminPageComponent, canActivate : [AuthGuard] },
  { path : "", component : HomeComponent, canActivate : [AuthGuard] },
  { path : "payment", component : PaymentShippingDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

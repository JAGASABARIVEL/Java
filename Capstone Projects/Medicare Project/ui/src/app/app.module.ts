import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { CategoryComponent } from './admin-page/category/category.component';
import { AdminProductsComponent } from './admin-page/admin-products/admin-products.component';
import { AuthGuard } from './guards/auth.guard';
import { CartsComponent } from './home/carts/carts.component';
import { CarouselImageComponent } from './home/carousel-image/carousel-image.component';
import { ProductDetailComponent } from './home/product-detail/product-detail.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './home/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    AdminPageComponent,
    HomeComponent,
    CategoryComponent,
    CartsComponent,
    AdminProductsComponent,
    CarouselImageComponent,
    ProductDetailComponent,
    PaymentShippingDetailsComponent,
    HeaderComponent,
    ProductsComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }

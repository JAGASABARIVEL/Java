import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { AdminProductsComponent } from './admin-page/admin-products/admin-products.component';
import { CategoryComponent } from './admin-page/category/category.component';
import { HomeComponent } from './home/home.component';
import { CarouselImageComponent } from './home/carousel-image/carousel-image.component';
import { CartsComponent } from './home/carts/carts.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';
import { ProductDetailsComponent } from './home/product-details/product-details.component';
import { ProductsComponent } from './home/products/products.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AdminPageComponent,
    AdminProductsComponent,
    CategoryComponent,
    HomeComponent,
    CarouselImageComponent,
    CartsComponent,
    PaymentShippingDetailsComponent,
    ProductDetailsComponent,
    ProductsComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

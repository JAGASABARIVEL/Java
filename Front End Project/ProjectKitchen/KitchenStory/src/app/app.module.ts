import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { ProductsComponent } from './home/products/products.component';
import { CarouselImageComponent } from './home/carousel-image/carousel-image.component';
import { ProductService } from './service/products.service';
import { CartsComponent } from './home/carts/carts.component';
import { ProductDetailComponent } from './home/product-detail/product-detail.component';
import { PaymentShippingDetailsComponent } from './home/payment-shipping-details/payment-shipping-details.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    ProductsComponent,
    CarouselImageComponent,
    CartsComponent,
    ProductDetailComponent,
    PaymentShippingDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [ProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }

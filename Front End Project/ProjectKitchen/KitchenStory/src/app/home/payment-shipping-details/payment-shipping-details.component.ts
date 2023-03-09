import { Component } from '@angular/core';

@Component({
  selector: 'app-payment-shipping-details',
  templateUrl: './payment-shipping-details.component.html',
  styleUrls: ['./payment-shipping-details.component.css']
})
export class PaymentShippingDetailsComponent {

  Phone : string;
  Address : string;

  onPay(){
    console.log("Payment Successful!");
  }
}

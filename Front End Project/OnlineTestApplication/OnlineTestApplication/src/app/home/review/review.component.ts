import { Component, Input } from '@angular/core';
import { Results } from '../../model/question.model';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {
  @Input() results: Results;

  
}

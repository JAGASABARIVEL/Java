import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../../service/question.service';
import { Question, Results } from '../../model/question.model';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit{

  index : number;
  questions : Question[];
  totalQuestion : number;
  results : Results;
  answerSubmitted : boolean;

  constructor(private questionService : QuestionService){}

  ngOnInit(): void {
    this.index = 0
    this.answerSubmitted = false;
    this.questions = this.questionService.getQuestions();
    this.totalQuestion = this.questions.length;
  }

  onSubmit(){
    this.results = this.questionService.verifyAnswer(this.questions);
    console
  }

  onChange(target){
    this.questions[this.index].choice.choosenanswer = target.value;
  }

  onNext($event){
    if (this.index === this.totalQuestion - 1){
      document.getElementById("next").innerHTML = "Submit Answer";
      this.onSubmit();
      this.answerSubmitted = true;
      document.getElementById("next").setAttribute("disabled", "true");
      return;
    }
    this.index = this.index + 1;
  }

  onPrevious(){
    if (this.index <= 0){
      return;
    }
    this.index = this.index - 1;
  }



}

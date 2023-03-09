import { Injectable } from  '@angular/core';
import { Question, Results } from '../model/question.model';

@Injectable( {
    providedIn : "root"
})
export class QuestionService{

    correctAnswers : number = 0;
    wrongAnswers : number = 0;
    results : Results = {correctAnswers : 0, wrongAnswers : 0};
    questions : Question[] = [
        {question : "Which is the national capital of India?",
            choice : {
                choice1 : "New Delhi",
                choice2 : "Bangalore",
                choice3 : "Chennai",
                choice4 : "Hyderabad",
                choosenanswer : ""
            },
            answer : "New Delhi"},

            {question : "Which is the national game of India?",
            choice : {
                choice1 : "Cricket",
                choice2 : "Hockey",
                choice3 : "Tennis",
                choice4 : "Badmitton",
                choosenanswer : ""
            },
            answer : "Hockey"},

            {question : "Which is the national bird of India?",
            choice : {
                choice1 : "Myna",
                choice2 : "Crow",
                choice3 : "Peacock",
                choice4 : "Piegeon",
                choosenanswer : ""
            },
            answer : "Peacock"},

            {question : "Which is the national color of India?",
            choice : {
                choice1 : "Yellow",
                choice2 : "Green",
                choice3 : "Black",
                choice4 : "Orange",
                choosenanswer : ""
            },
            answer : "Black"},

            {question : "Which is the national anthem of India?",
            choice : {
                choice1 : "Jana Gana Mana",
                choice2 : "Jana Gana Mana",
                choice3 : "Jana Gana Mana",
                choice4 : "Jana Gana Mana",
                choosenanswer : ""
            },
            answer : "Jana Gana Mana"},
    ];

    getQuestions() : Question[]{
        return this.questions;
    }

    verifyAnswer(userAnswers : Question[]) : Results{
        for (let question of userAnswers){
            let result  = this.mapUserQuestion(question);
            if (result.answer === question.choice.choosenanswer){
                this.correctAnswers = this.correctAnswers + 1;
            }
            else{
                this.wrongAnswers = this.wrongAnswers + 1;
            }
        }
        this.results.correctAnswers = this.correctAnswers;
        this.results.wrongAnswers = this.wrongAnswers;
        return this.results;
    }

    mapUserQuestion(userAnswer : Question) : Question{
        return this.questions.find(qs=>
            qs.question === userAnswer.question);
    }

}
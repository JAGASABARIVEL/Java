export class Question{
    question : string;
    choice : {
        choice1 : string;
        choice2 : string;
        choice3 : string;
        choice4 : string;
        choosenanswer : string;
    }
    answer : string;
}

export class Results{
    correctAnswers : number = 0;
    wrongAnswers : number = 0;
}
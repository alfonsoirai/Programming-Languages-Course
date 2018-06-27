# Final Project: Tic Tac Toe

## Description

This project consists on the implementation of the TicTacToe game using the Prolog Programming Language and Java for the Graphic User Interface.

## Objective

Being able to implement a logical programming language with some other that we already are used to work with.

## Setup

You will need to have the last version of Java installed, if you dont have it, you can download it in the following link: [https://www.java.com/en/download/](https://www.java.com/en/download/)

Also, you need to have Swipl-Prolog installed. You can download it here: [http://www.swi-prolog.org/Download.html](http://www.swi-prolog.org/Download.html)

Once you installed Java ans Swipl-Prolog, you can need to go to the `TicTacToe.java` file and go to line 151 and indicate your script command to execute swipl-prolog. In my case:
```
/usr/local/bin/swipl
```

On the next line (152), you need to indicate the directory of the Prolog file (main.pl). If you clone the directory such as it is, you can leave it the way it is.

## Execute

It's really simple to execute the TicTacToe. You need to go to you terminal and go all the way to the directory where you have the files downloaded.

i.e.
```
cd ..
```

Whenever you are in the directory, you can execute the make commands.

### Make commands
To compile and execute:
```
make default
```
To just compile:
```
make compile
```
To only run the program (after it's compiled, of course):
```
make run
```

## Conclusions
It was a very challenging project because of the time to do it and for the complexity that using a logical programming has (this case Prolog) Prolog it's not so difficult to learn, however, being able to learn complexity stuff and the implementation of algorithms was difficult for a newbie like me.

I started the project using Python for the frontend. However, I had a bunch of problems trying to connect the Python frontend with the Prolog backend. I made a research and ended with a kind of tutorial and explanation on how to implement it with Java. Thas was the easiest thing. The challenge was being able to implement the Prolog logic in order to work for the TicTacToe and using a Java GUI.

I started implementing the 5.3 exercice in the references that was about only making the Tic Tac Toe on Prolog, with a console GUI. I learned how the alphabeta minimax algorithm worked for decision making games between a user and the computer. This algorithm also works for games like Chess. The main goal of the algorithm is to get the best decision based on alpha and beta that represent the maximum and minimum value respectively. The tree seeks to decrease the number of nodes that are evaluated by the minimax algoritm in the search tree.

## References

[https://www.cpp.edu/~jrfisher/www/prolog_tutorial/5_3.html](https://www.cpp.edu/~jrfisher/www/prolog_tutorial/5_3.html)

[https://www.cpp.edu/~jrfisher/www/prolog_tutorial/8_4.html](https://www.cpp.edu/~jrfisher/www/prolog_tutorial/8_4.html)
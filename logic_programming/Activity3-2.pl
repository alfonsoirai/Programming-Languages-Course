increment(X,Y) :- Y is X+1.

sum(X,Y,Z) :- Z is X+Y.

addone([],[]).
addone([H1|T1], [H2|T2]) :- 
    is(H2, +(H1,1)),
    addone(T1, T2).
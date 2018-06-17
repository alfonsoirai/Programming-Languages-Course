% Exercise 6.1

doubled(List) :- append(X, X, List).

append([], L, L).
    append([H|T], L2, [H|L3]) :- append(T, L2, L3).

prefix(P, L) :- append(P, _, L).
suffix(S, L) :- append(_, S, L).

sublist(Sublist, L) :- suffix(S, L), prefix(Sublist, S).

% Exercise 6.2

reverseBase([], A, A).
reverseBase([H|T], A, R) :- reverseBase(T, [H|A], R).

rev(L, R) :- reverseBase(L, [], R).

palindrome(List) :- rev(List, List).

% Exercise 6.3

toptail(InList, OutList):- append([_|OutList], [_], InList).

% Exercise 6.4

% 1
lastr([], X).
lastr(List, X) :- reverse(List, [X|_]).

% 2
lastrec([X], X).
lastrec([_|T], X) :- lastrec(T, X).

% Exercise 6.5

swapfl([], []).
swapfl([F1 | T1], [F2 | T2]) :- reverse(T1, [L1 | R1]), reverse(T2, [L2 | R2]),
                                F1 = L2,
                                L1 = F2,
                                R1 = R2.

% Exercise 6.6

prefix(P, L) :- append(P, _, L).
suffix(S, L) :- append(_, S, L).
sublist(Sublist, L) :- suffix(S, L), prefix(Sublist, S).

zebraowner(Zebraowner) :- Street = [_, _, _],
                          member(house(red, enlishman, _), Street),
                          member(house(_, spanish, jaguar), Street),
                          member(house(_, Zebraowner, zebra), Street),
                          sublist([house(_, _, snail), house(_, japanese, _)], Street),
                          sublist([house(_, _, snail), house(blue, _, _)], Street).

                

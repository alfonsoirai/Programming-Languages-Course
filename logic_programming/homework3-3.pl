% Exercise 6.1

append([], L, L).
append([H|T], L2, [H|L3]) :- append(T, L2, L3).

prefix(P, L) :- append(P, _, L).
suffix(S, L) :- append(_, S, L).

sublist(Sublist, L) :- suffix(S, L), prefix(Sublist, S).

doubled(List) :- append(X, X, List).

doubled([a,b,c,a,b,c]).
doubled([foo,gubble,foo]).


% Exercise 6.2

reverseBase([], A, A).
reverseBase([H|T], A, R) :- reverseBase(T, [H|A], R).

rev(L, R) :- reverseBase(L, [], R).

palindrome(List) :- rev(List, List).

palindrome([r,o,t,a,t,o,r]).
palindrome([p,o,o,p]).
palindrome([n,o,a,p,l,i,c,a]).


% Exercise 6.3

toptail(InList, OutList):- append([_|OutList], [_], InList).

toptail([a], []).
toptail([a, b], []).
toptail([a, b, c], []).


% Exercise 6.4

% 1
lastr([], X).
lastr(List, X) :- reverse(List, [X|_]).

lastr([a, b, c], c).
lastr([a, c, v], c).

% 2
lastrec([X], X).
lastrec([_|T], X) :- lastrec(T, X).

lastrec([a, b, c], c).
lastrec([a, c, v], c).


% Exercise 6.5

swapfl([], []).
swapfl([F1 | T1], [F2 | T2]) :- reverse(T1, [L1 | R1]), reverse(T2, [L2 | R2]),
                                F1 = L2,
                                L1 = F2,
                                R1 = R2.

swapfl([a,b,c,d,e], [e,b,c,d,a]).
swapfl([a,b,c,d,e], [a,b,c,d,e]).

% Exercise 6.6



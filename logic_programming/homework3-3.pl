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
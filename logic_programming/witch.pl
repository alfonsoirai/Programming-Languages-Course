% witches homework
% Alfonso Irai Contreras Chavez A01631341

% A witch is a woman
witch(X).
woman(girl).

% They burn because they are made of wood
burns(X).
iswood(X).

% The wood floats
floats(X).

% A duck also floats, that means that if the woman weights the same as a duck, she must be made of wood and be a witch
weight(duck, girl).



witch(X) :- burns(X), woman(X).
burns(X) :- iswood(X).
iswood(X) :- floats(X).
floats(X) :- weight(duck, X).
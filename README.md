# mock_tech_interview

Run:
java pandemic.java [gridsize] [rounds] [infection_threshold] [recovery_threshold] "[<x,y>,...]"
for example:
java pandemic.java 10 20 2 3 "[<4,7>,<4,8>,<5,8>,<6,8>,<1,1>,<1,2>,<1,3>,<2,1>,<2,2>,<4,3>,<3,3>,<7,8>]"


# Lessons learned
## Version 1
In version 1 I took a direct approacht to the problem and stored my grid in a integer array.
With the help of modulo, I could find infected neighbours and determine the new state of the cell.
The searching with modulo was a bit messy but I quickly got something working

## Version 2
Here I took the approach of the 2d grid to make searching for the neighbours a bit more elegant.
It seems there are no notable differences in performance.

## Version 3
I found that analysing every cell means I also analyse every non-infected person. This is of course not efficient. So I dove a bit into hashmapping. This way I could only analyse infected cells and then determine if their neigbours change or if they recover.
I will see how far I get, but I suspect it will not be done in time.





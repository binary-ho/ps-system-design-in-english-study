## 1.

in this time, i’m ganna state the way i solve the “jump game”

we have a integer array. and each element mean how many step i can jump forward from that index

## 2.

for example, i can jump 1 or 2 step from the 0 index.

## 3.

i solve this problem in two way

one is try all posibility with memorize

and another one is “starting from the last index, check whether each index reach the end”

## 4.

the first i try all posibility

i write a recursive function that literally play the jump game

check the number, and jump to all next index

and check this array can reach at last index

but this is too slow

## 5.

let’s calaulate the time complexity

at the last index. we can’t go anywhere. so in the last index, we can move zero step

and at the one steps before the last index, we can move one step

and two steps before, we can move two step. but if we move one step, now we can move one step more. so, we need to add the values

this pattern continues, and we can express the recurrence formula inductively as follows

*inductively: 귀납적

*recurrence formula: 점화식

## 6.

but this problem’s input can be 10k

so, mario will be die with big explode

## 7.8.

so, i try to check the visited index by set

we don’t check if next node is visited node

and at the first time visit → add index to set

it make time complexity to squre time in big O notation

now, we don’t need to add all previous values

## 9.

but yesterday. my team mate jason teach me another way

starting from last index, check the minimum index that can reach the last index

for eg. at the last index, we can go to last index.

so, if we can reach at index 4. we can reach last index

and next. index 3 can reach to index 4. so if we can reach at index 3. we can reach last index

this pattern continues, and then i can find the minimum index that can reach last index.

so, if the minimum index is 0 → we can say this array can reach last index

it only O(N) time complexity
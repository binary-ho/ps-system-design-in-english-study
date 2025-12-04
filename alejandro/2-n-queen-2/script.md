## 1.

in this week i solve the N Queens 2

we need to place n queen in n multiply n size board

such that none of the queens can attack each others

## 2.

the easiest way is check every queens attack squares

when i place the one queen, check all her attack squares

and if i remove her, remove all checked position

maybe there is (n * 3) ~ (n * 4) calculation in each placing

## 3.

and each row, there is (N - row) possibility. so, there is O(N*N!)

it’s ok. this problem has only 9 squares in a row

9*9! is only 9***362,880 = 3,265,920**

## 4.

but we can reduce calculation a little with check only index

for example, if i place the queen in (3, 4) i check row 3, col 4, and north-east diagonal 7, north-west diagonal 8 in n is 9

and not place that position

and i place the queen from y 0 to y n and x 0 to x n. so, i can remove the row

i just place one queen in one row. i just place the queen at the row number

for example, there is no queen now, i place the queen row 0

and if there is 8 queen in the board, i place the queen row 8

so, i need only row array and two diagonal arrays

and there is O(N!) good
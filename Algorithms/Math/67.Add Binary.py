#!/usr/bin/env python
#coding: utf8
#author: Yizhen Wang

# https://leetcode.com/problems/add-binary/description/

# tag: Math XOR

def addBinary(a, b):
  aList = list(a)
  bList = list(b)
  sum = []
  carry = 0

  while aList or bList:
    a1 = 0
    b1 = 0
    if aList:
      a1 = int(aList.pop())
    if bList:
      b1 = int(bList.pop())

    sum.append(str(a1^b1^carry))  #异或运算

    if ((a1 & b1) or (a1 & carry) or (b1 & carry)):
      carry = 1
    else:
      carry = 0

  if carry:
    sum.append(str(carry))
  sum.reverse()

  return ''.join(sum)

a = '11'
b = '1'
addBinary(a,b)
print(addBinary(a,b))
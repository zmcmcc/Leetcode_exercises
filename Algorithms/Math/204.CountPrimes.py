'''
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
'''

class Solution(object):
    def countPrimes(self, n):
        count = 0
        isPrime = [True] * n
        for i in range(2,n):
            if isPrime[i] == True:
                count += 1
                for j in range(2*i,n,i):
                    isPrime[j]=False
        return count
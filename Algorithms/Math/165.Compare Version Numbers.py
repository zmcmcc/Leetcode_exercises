#!/usr/bin/env python
#coding: utf8
#author: Yizhen Wang

# https://leetcode.com/problems/compare-version-numbers/description/

# tag: Math

def compareVersion(version1, version2):
  version1 = version1.split('.')
  version2 = version2.split('.')
  l1 = len(version1)
  l2 = len(version2)
  l = max(l1, l2)
  lmin = min(l1, l2)
  for i in range(0, l):
    if i < lmin:
      if int(version1[i]) > int(version2[i]):
        return 1
      elif int(version1[i]) < int(version2[i]):
        return -1
    else:
      if l1 > l2:
        if int(version1[i]) > 0:
          return 1
      else:
        if int(version2[i]) > 0:
          return -1
  return 0

version1 = '1.8.8.9'
version2 = '1.8.8'
compareVersion(version1, version2)
print(compareVersion(version1, version2))

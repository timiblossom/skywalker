#!/usr/bin/env python

import random
import sys

print 'Print out min and max from a list of numbers'

list = random.sample(range(1, 100), 20)
print list

min = sys.maxint
max = -1

for num in list:
  if num < min:
     min = num
  if num > max:
     max = num

print 'Min: ' + str(min)
print 'Max: ' + str(max)



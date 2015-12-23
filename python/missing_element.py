#!/usr/bin/env python

import random
from random import shuffle

print 'Print out the missing element from an unsorted list of numbers in a range'


list = range(1, 100)
shuffle(list)

#print len(list)

ran_num = random.randint(1, 99)
print "About to remove element: " + str(ran_num)
list.remove(ran_num)

#print len(list)

full_sum = 99 * 100 / 2

sum = 0
for num in list:
  sum = sum + num

print "Missing element: " + str(full_sum - sum)




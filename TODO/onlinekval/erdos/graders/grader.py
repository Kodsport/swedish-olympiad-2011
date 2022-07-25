#!/usr/bin/env python

import sys

if "ignore" in sys.argv:
  print "AC 0"
else:
  total_score = 0
  for line in sys.stdin.readlines():
    verdict, score = line.split()
    total_score += float(score)
  if total_score >= 3:
    print "AC 100"
  elif total_score >= 2:
    print "AC 50"
  else:
    print "AC 0"

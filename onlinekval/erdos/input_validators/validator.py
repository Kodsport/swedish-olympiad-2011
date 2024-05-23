#!/usr/bin/python3

import re
import sys

int_pat = "(0|[1-9][0-9]*)"
name_pat = "[A-Z]{1,20}"
name2_pat = "( "+name_pat+")+"
inp1_re = "^"+int_pat+" "+int_pat+"$"
inp2_re = "^"+int_pat+" "+name_pat+name2_pat+"$"

line = sys.stdin.readline()
assert re.match(inp1_re, line)
n, m = [int(x) for x in line.split()]
assert 1 <= n <= 5000 and 1 <= n <= 40000

for i in range(m):
	line = sys.stdin.readline()
	assert re.match(inp2_re, line)
	c = line.split()
	x = int(c[0])
	assert 2 <= x <= 5
	assert len(c) == x + 1

line = sys.stdin.readline()
assert len(line) == 0
sys.exit(42)

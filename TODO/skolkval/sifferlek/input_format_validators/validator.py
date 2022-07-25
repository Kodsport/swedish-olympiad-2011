#!/usr/bin/env python
import sys
from sys import stdin
import re
int_regex = "(0|[1-9][0-9]*)"
first = "^"+int_regex+" "+int_regex+"$"
line1 = stdin.readline()

assert re.compile(first).match(line1), "First line does not consist of two ints"

assert len(stdin.readline()) == 0, "Garbage input"
sys.exit(42)


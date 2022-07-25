#!/bin/bash

PPATH=$(realpath ..)
. ../../../../../testdata_tools/gen.sh

use_solution js.cc

compile gen_rand.py

samplegroup
limits ispositive=0
sample 1

group group1 33
limits ispositive=1
tc rand01 gen_rand n=5 ispositive=1
tc rand02 gen_rand n=5 ispositive=1
tc rand03 gen_rand n=5 ispositive=1
tc rand04 gen_rand n=5 ispositive=1
tc rand05 gen_rand n=5 ispositive=1
tc rand06 gen_rand n=5 ispositive=1
tc rand07 gen_rand n=1 ispositive=1

group group2 67
limits ispositive=0
include_group group1
tc 1
tc rand11 gen_rand n=5 ispositive=0
tc rand12 gen_rand n=5 ispositive=0
tc rand13 gen_rand n=5 ispositive=0
tc rand14 gen_rand n=5 ispositive=0
tc rand15 gen_rand n=5 ispositive=0
tc rand16 gen_rand n=5 ispositive=0
tc rand17 gen_rand n=1 ispositive=0

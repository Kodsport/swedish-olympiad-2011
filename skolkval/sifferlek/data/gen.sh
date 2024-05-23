#!/bin/bash

PPATH=$(realpath ..)
. ../../../testdata_tools/gen.sh

use_solution js.cc

compile gen_rand.py

samplegroup
limits maxn=10000
sample sample01
sample sample02

group group1 40
limits maxn=10000
include_group sample
tc g1-1 gen_rand n=10000
tc g1-2 gen_rand n=10000
tc g1-3 gen_rand n=10000
tc g1-4 gen_rand n=10000
tc g1-5 gen_rand n=10000

group group2 60
limits maxn=1000000
include_group group1
tc g2-1 gen_rand n=1000000
tc g2-2 gen_rand n=1000000
tc g2-3 gen_rand n=1000000
tc g2-4 gen_rand n=1000000
tc g2-5 gen_rand n=1000000

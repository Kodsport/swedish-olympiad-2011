#!/bin/bash

PPATH=$(realpath ..)
. ../../../testdata_tools/gen.sh

use_solution joshua.cpp


samplegroup
sample sample01
sample sample02

group group1 40
include_group sample
tc_manual 1
tc_manual 2
tc_manual 3
tc_manual 4

group group2 60
include_group group1
tc_manual 5

#! /usr/bin/env python3

import getopt
import sys


opts, args = getopt.getopt(sys.argv[1:], "c:", ["conf="])

for opt, arg in opts:
    print("opt=" + opt + " arg=" + arg)

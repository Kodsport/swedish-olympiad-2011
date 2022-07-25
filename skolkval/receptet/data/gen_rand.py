import random
import queue
import sys

def cmdlinearg(name):
    for arg in sys.argv:
        if arg.startswith(name + "="):
            return arg.split("=")[1]
    assert False

random.seed(int(sys.argv[-1]))

ispositive = int(cmdlinearg("ispositive"))
ingredients = int(cmdlinearg("n"))

print(ingredients)
for _ in range(ingredients):
    have = random.randint(0, 1000)
    need = random.randint(max(have, 1) if ispositive else 0, 1000)
    cost = random.randint(1, 1000)
    print(have, need, cost)

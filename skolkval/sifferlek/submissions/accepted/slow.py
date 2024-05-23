#!/usr/bin/python3

def digital_root(n):
    while n >= 10:
        n = sum(int(digit) for digit in str(n))
    return n

def multiplicative_digital_root(n):
    while n >= 10:
        product = 1
        for digit in str(n):
            product *= int(digit)
        n = product
    return n

def count_matching_digital_roots(A, B):
    count = 0
    for number in range(A, B + 1):
        if digital_root(number) == multiplicative_digital_root(number):
            count += 1
    return count

A, B = map(int, input().split())

result = count_matching_digital_roots(A, B)

print(result)

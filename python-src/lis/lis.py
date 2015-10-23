# -*- coding: utf-8 -*-
"""
File: lis.py
Author: Pi Shilong
Description: Longest Increase Sub-sequence for CLRS 15.4-6
"""

def lis(array):
    """return Longest Increase Sub-sequence of array"""
    array_len = len(array)
    best_end = [None] * array_len
    prev = [None] * array_len # prev[i] 是 best_end中第i个元素的前序元素
    m = [None] * array_len

    m[0] = 0
    prev[0] = -1
    best_end[0] = array[0]
    cur_len = 1

    for index in  range(1, array_len):
        v = array[index]
        pos = find_pos(best_end, cur_len, v)
        best_end[pos] = v
        m[pos] = index
        prev[index] = m[pos - 1] if pos > 0 else -1
        if pos + 1 > cur_len:
            cur_len += 1

    m = [x for x in m if x != None]
    pos = m.pop()
    result = []

    while pos != -1:
        result.append(array[pos])
        pos = prev[pos]

    result.reverse()
    result = ' '.join(map(str, result))
    return result

def find_pos(best_end, index, v):
    """return the postion of v in best_end use binary search method"""
    left = 0
    right = index - 1

    while left <= right:
        mid = (left + right) // 2
        if best_end[mid] <= v:
            left = mid + 1 if mid < index else index
        else:
            right = mid - 1

    return left

if __name__ == '__main__':
    input_string = "9,2,5,3,7,11,8,10,13,6"
    input_seq = map(int, input_string.split(','))
    lis(input_seq)

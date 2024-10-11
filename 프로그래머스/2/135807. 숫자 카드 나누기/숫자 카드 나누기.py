def gcd(a,b):
    if a%b == 0:
        return b
    return gcd(b, a%b)

def is_gcd_divide_other(arr, gcdv):
    for a in arr:
        if a%gcdv == 0:
            return True
    return False
def solution(arrA, arrB):

    gcdA = arrA[0]
    gcdB = arrB[0]
    for a in arrA:
        gcdA = gcd(a, gcdA)
    for b in arrB:
        gcdB = gcd(b, gcdB)
    
    flagA = is_gcd_divide_other(arrB, gcdA)
    flagB = is_gcd_divide_other(arrA, gcdB)
    
    if not flagA and not flagB:
        return max(gcdA, gcdB)
    elif not flagA:
        return gcdA
    elif not flagB:
        return gcdB
    
    return 0
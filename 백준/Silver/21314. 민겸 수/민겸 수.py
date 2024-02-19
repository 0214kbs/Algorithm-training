s = input()

m_cnt = 0
min_res, max_res = '', ''
for i in range(len(s)):
    if s[i] == 'K':
        if m_cnt>0:
            max_res += str(5 * 10**m_cnt)
            min_res += str(10**m_cnt + 5)
            m_cnt = 0
        else:
            max_res += '5'
            min_res += '5'
    else:
        m_cnt += 1

if m_cnt>0:
    max_res += '1'*m_cnt
    min_res += str(10**(m_cnt-1))

print(max_res)
print(min_res)
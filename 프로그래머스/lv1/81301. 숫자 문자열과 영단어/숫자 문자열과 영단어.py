def solution(s):
    
    en_list = ["zero","one","two","three","four","five","six","seven","eight","nine"]

    # for en in en_list:
    #     s = s.replace(en,str(en_list.index(en)))
    for i in range(10):
        s=s.replace(en_list[i],str(i))
    return int(s)

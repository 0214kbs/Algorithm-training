def solution(new_id):
    #step 1
    new_id = new_id.lower()

    #step 2
    for c in new_id:
        if c.isalnum() or c=="-" or c=="_" or c==".":
            pass
        else:
            new_id = new_id.replace(c,"")

    #step 3
    while True:
        if new_id.count("..") == 0:
            break
        new_id = new_id.replace("..",".")

    #step 4
    new_id=new_id.strip(".")


    #step 5
    if new_id == "":
        new_id="a"

    #step 6
    if len(new_id) >= 16:
        new_id = new_id[:15]
        if new_id[-1] == ".":
            new_id = new_id[:-1]

    #step 7
    if len(new_id) <=2:
        while True:
            if len(new_id)==3:
                break
            new_id = new_id+new_id[-1]
            
    return new_id
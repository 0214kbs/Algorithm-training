# deque : 양방향 큐
# O(1) 로 접근 가능

from collections import deque
deq = deque()

n = 10
# 맨 앞(데크의 왼쪽 끝)에 원소 삽입
deq.appendleft(n)

# 맨 뒤(데크의 오른쪽 끝)에 원소 삽입
deq.append(n)

# 맨 앞(데크의 왼쪽 끝)에 원소 삭제 & 반환
deq.popleft()

# 맨 뒤(데크의 오른쪽 끝)에 원소 삭제 & 반환
deq.pop()

array = [3,5,1,2,8]
# 주어진 배열array 순환하면서 데크의 오른쪽에 추가
deq.extend(array)

# 주어진 배열array 순환하면서 데크의 왼쪽에 추가
deq.extendleft(array)

# 원소를 데크에서 찾아 삭제
deq.remove(n)

deq = deque([1,2,3,4,5])
# 데크를 num만큼 회전 (양수면 오른쪽, 음수면 왼쪽)
deq.rotate(1) # [5,1,2,3,4]
deq.rotate(-1) # [1,2,3,4,5]

# -----------------------------------------------
# queue
# - append
# - popleft

# 사실 스택에서는 배열.append(3), 배열.pop(), 배열.remove(3), 등등 쓰면됨


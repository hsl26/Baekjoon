A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

def work_hour(arr):
    hStart, mStart, sStart, hEnd, mEnd, sEnd = arr
    start = hStart*3600 + mStart*60 + sStart
    end = hEnd*3600 + mEnd*60 + sEnd

    work = end-start
    hWork = work//3600
    work -= hWork*3600
    mWork = work//60
    sWork = work-mWork*60

    print(hWork, mWork, sWork)
    
work_hour(A)
work_hour(B)
work_hour(C)
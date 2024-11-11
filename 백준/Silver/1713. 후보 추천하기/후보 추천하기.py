N = int(input())
total_recommend = int(input())
recommend = list(map(int, input().split()))

photo = [] # 사진틀
rec_cnt = [] # 추천 받은 횟수

for r in recommend:
    if r in photo: # 이미 추천 받은 애면 횟수만 +1
        r_idx = photo.index(r)
        rec_cnt[r_idx] += 1
        continue

    if len(photo) == N: # 새로 추천받은 친구인데 사진틀에 빈자리 없으면
        min_rec = min(rec_cnt)
        min_idx = rec_cnt.index(min_rec) # 추천 받은 횟수 제일 적은 애 인덱스 찾아서

        photo.pop(min_idx) # 삭제
        rec_cnt.pop(min_idx)

    photo.append(r) # 사진틀에 등록
    rec_cnt.append(1)

photo.sort() 
for p in photo:
    print(p, end=' ')
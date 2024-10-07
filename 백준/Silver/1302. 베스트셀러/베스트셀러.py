N = int(input())
books = [input() for _ in range(N)]
book_list = set(books)

book_count = []
for book in book_list:
    book_count.append([book, books.count(book)])

book_count.sort(key=lambda x:(-x[1], x[0]))
print(book_count[0][0])
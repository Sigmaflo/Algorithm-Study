N = int(input())
col_list = [list(map(int, input().split())) for _ in range(N)]
col_list.sort()

max_coord, max_height = max(col_list, key = lambda x : x[1])

def make_polygon(lst) :
  result = 0
  prev_coord, prev_height = lst[0]
  
  for coord, height in lst[1:] :
    if coord == max_coord :
      result += abs(coord - prev_coord) * prev_height
      return result
    if height > prev_height :
      result += abs(coord - prev_coord) * prev_height
      prev_coord, prev_height = coord, height
  
  return result

def solve() :
  if N == 1 :
    print(max_height)
    return

  left_polygon = make_polygon(col_list)
  right_polygon = make_polygon(list(reversed(col_list)))
  print(left_polygon + right_polygon + max_height )

solve()
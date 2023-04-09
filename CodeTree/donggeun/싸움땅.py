from collections import defaultdict

dx = [0,1,0,-1]
dy = [-1,0,1,0]

n,m,k = map(int,input().split())

arr = [list(map(int,input().split())) for _ in range(n)]

players_score = [0]*(m) # answer 
first_power = [0]*(m)
weapone = [0]*(m)

dic = defaultdict(list)

def reverse_dircetion(d,x,y):
    if d == 0:
        return 2,x+1,y

    elif d == 1:
        return 3,x,y-1

    elif d == 2:
        return 0,x-1,y

    else:
        return 1,x,y+1

def rotate(direction): # 패배자가 벽 또는 플레이어를 만났을때 
    if direction <3 :
        return direction+1
    return 0


def fight(player1,player2):  #플레이어끼리 싸울 때 
    
    player1_power = first_power[player1]+ weapone[player1]
    player2_power = first_power[player2]+ weapone[player2]

    if player1_power>player2_power:
        result = 0

    elif player1_power<player2_power:
        result = 1

    else:
        if first_power[player1]>first_power[player2]:
            result = 0
        else:
            result = 1

    if result == 0:
        
        players_score[player1] += player1_power-player2_power
        
        winner = player1
        loser = player2
    else:
        players_score[player2] += player2_power-player1_power
        winner = player2
        loser = player1

    if weapone[loser]:
        arr[dic[loser][1]][dic[loser][2]].append(weapone[loser])
        weapone[loser] = 0

    return winner,loser

def loser_action(loser_d,loser_x,loser_y,loser_num): # 패배자가 다음 할 행동 
    while True:
        
        for i in range(4):
          
          new_x,new_y = dx[i]+loser_x, dy[i]+loser_y
  
          if 0<=new_x<n and 0<=new_y<n:
              for new_player,value in dic.items():
                  if new_player == loser_num:
                      continue
  
                  if value[1] == new_x and value[2] == new_y:
                      loser_d = rotate(loser_d)
                      break
  
                  else:
                      dic[loser_num] = [loser_d,new_x,new_y,loser_num]
                      
                      get_max_weapon(new_x,new_y,loser_num)                    
                      break
          else:
              loser_d = rotate(loser_d)


def get_max_weapon(a,b,player):
    if arr[a][b]:
        if weapone[player]<max(arr[a][b]): 
            arr[a][b].append(weapone[player]) 
            weapone[player]=max(arr[a][b])
            arr[a][b].remove(weapone[player])

def Round():
  for player_num in range(m):
      
      d,x,y = dic[player_num][0],dic[player_num][1],dic[player_num][2]
      a,b = next_direction(d,x,y)
      winner = player_num # winner 초기화 
      if 0<=a<n and 0<=b<n:
          dic[player_num] = [d,a,b,player_num]

          for new_player,value in dic.items():
              if player_num == new_player:
                continue

              if value[1] == a and value[2] == b:
                  winner,loser = fight(player_num,new_player)
                  loser_action(dic[loser][0],dic[loser][1],dic[loser][2],loser)
                  break

          get_max_weapon(a,b,winner)


      else:
          d,a,b = reverse_dircetion(d,x,y)
          
          dic[player_num] = [d,a,b,player_num]
          winner = player_num # winner 초기화 

          for new_player,value in dic.items():
              if player_num == new_player:
                  continue
              if value[1] == a and value[2] == b:
                  winner,loser = fight(player_num,new_player)
                  loser_action(dic[loser][0],dic[loser][1],dic[loser][2],loser)
                  break

          get_max_weapon(a,b,winner)

for i in range(m):
    x,y,di,s = map(int,input().split())
    dic[i] = [di,x-1,y-1,i] # players dir , vec
    first_power[i] = s

for _ in range(k):    
    Round()

print(*players_score)
# 질문글 참고

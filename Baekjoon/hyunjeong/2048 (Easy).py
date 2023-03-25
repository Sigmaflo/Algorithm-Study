from collections import deque

def find_max_block(board):
    queue = deque([(board, 0)])
    max_block = 0

    while queue:
        curr_board, moves = queue.popleft()
        max_block = max(max_block, max([max(row) for row in curr_board]))

        if moves >= 5:
            continue

        for direction in ['left', 'right', 'up', 'down']:
            new_board, moved = move(curr_board, direction)
            if moved:
                queue.append((new_board, moves + 1))

    return max_block


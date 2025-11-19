from random import randint, choice

def get_list(size) -> list:
    # Build allowed moves for each state. 
    # The initial states have restricted moves, rest allow picks of 1, 2, or 3.
    b = [[0]]
    b.append([1])    
    b.append([1, 2])
    for x in range(3, size + 1): b.append([1, 2, 3])
    return b

def get_roboter_pick(size, b) -> int:
    # Roboter selects a move at random from allowed moves for current size.
    return choice(b[size])

def get_player_pick(size) -> int:
    global bot
    player_pick = randint(1, min(3, size))
    
    # If not in bot mode, prompt user input for their move.
    if not bot: player_pick = int(input(f"CURRENT SIZE: {size} - YOUR PICK: "))
    # Ensure pick is valid; repeat if necessary.
    if player_pick > min(3, size): return get_player_pick(size)
    else: return player_pick

def remove_roboter_pick(b, history):
    # Go backwards through history and remove the first possible roboter move 
    # (used when player wins to adapt bot's move list: simple learning).
    for (size, roboter_zug) in reversed(history):
        if len(b[size]) > 1 and roboter_zug in b[size]:
            b[size].remove(roboter_zug)
            break 

def run_recursively(size, b, history) -> tuple: 
    # Recursive game loop. Returns winner, updated move list, and history.
    roboter_pick = get_roboter_pick(size, b)
    history.append((size, roboter_pick)) # Log current state and roboter choice
    size -= roboter_pick # Update state
    
    # Roboter wins if size reaches zero after its move
    if size == 0:
        return (1, b, history)

    player_pick = get_player_pick(size)
    size -= player_pick # Update state

    # Player wins if size reaches zero after their move
    if size == 0:
        remove_roboter_pick(b, history) # Adjust bot memory for loss
        return (0, b, history)

    # Otherwise, continue recursion until game ends
    winner, b, history = run_recursively(size, b, history)
    return (winner, b, history)

def run(size, times, let_bot_play):
    global bot
    
    wins = 0
    history = []
    bot = let_bot_play # Enable or disable bot mode

    b = get_list(size)
    
    # Run the specified number of games and count roboter wins
    for i in range(times):
        winner, b, _ = run_recursively(size, b, history)
        wins += winner
    
    # Display summary stats for all games played
    print(f"LIST: {b} \nWIN % of ROB: {wins / times * 100:.1f}% \nGAMES PLAYED: {times} \nROBOTER WINS: {wins} \nPLAYER  WINS: {times - wins}")

bot = None
run(size=10, times=2000, let_bot_play=True)

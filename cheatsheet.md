This file will contain documentation for all commands available in your game.

Note:  It's a good idea to also make this list available inside the game, in response to a `HELP` command.


# SPOILER ALERT

If your game includes challenges that must be overcome to win, also list them below.

# Cheatsheet for *Trapped: The Ultimate Challenge*

---

## 🎮 Available Commands

| Command | What It Does |
|:---|:---|
| `look` | Look around your current train car: description, exits, and visible items. |
| `go [direction]` | Move in the given direction (e.g., `go forward`, `go backward`). |
| `take [item]` | Pick up an item in the current car. |
| `inventory` | View all items you're currently carrying. |
| `solve [answer]` | Attempt to solve a room-based puzzle (e.g., `solve 729`). |
| `quit` | Quit the game. |

---
## 🗺️ World Layout (Train Map)

| Car | Description | Items | Special |
|:---|:---|:---|:---|
| Car 1 | Dirty, graffiti-covered. | None | Start here |
| Car 2 | Flickering lights, debris. | Crowbar (real), Gum (fake) | |
| Car 3 | Wrecked car. | Puzzle: Requires `solve 729` | Locked |
| Car 4 | Luggage, wires. | Key (real), Bottle (fake) | |
| Exit Door | Final car. | None | Locked, requires Key |

---

## 🧩 Challenges & Game Systems

- 🔒 **Locked Doors**:  
  - Crowbar opens access to Car 3  
  - Key unlocks Exit Door  

- ⏰ **Timer**:  
  - You have 5 minutes to escape. Time bonuses possible through random events.

- 🎮 **Scoring System**:  
  - +10 for useful items  
  - -5 for fake items  
  - +15 for solving puzzles  
  - Bonus based on escape speed

- 🎭 **Random Events**:  
  - 20% chance during `look()` to trigger spooky or helpful messages  
  - Some events add time (+15s, +30s)

- 🧠 **Puzzles**:  
  - Some rooms require solving a code (e.g., `solve 729`) to continue.

---

## 🏁 Endings

- Escape early: calm exit + high score  
- Escape late: close call + lower score  
- Fail to escape: game over  
- Final score is shown when the game ends
---

## ✨ Notes

- Exits are reversible **unless locked** (you can go forward/backward unless a locked challenge blocks you).
- Inventory can hold multiple items — be strategic about what you carry!
- You can win by reaching the Exit Door with the Key before time runs out.

---

## 🏆 Winning

- Escape the subway train by using the Crowbar and Key wisely.
- If time runs out, the train starts moving again with you still trapped inside...


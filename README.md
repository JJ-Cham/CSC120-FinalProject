# CSC120-FinalProject
# Trapped: The Ultimate Challenge
Final Project — Escape Game
By JJ Cham

---

## 🚇 Project Description

You wake up on a stalled subway train somewhere deep under the Bronx. The doors are jammed. The lights flicker. You must find a way through a series of damaged train cars, using found items to escape — before time runs out.

Gameplay includes:
- Movement through connected train cars
- Pickup and use of key items (Crowbar, Key)
- Locked doors that require exploration and puzzle solving
- Random spooky events and lucky bonus events
- A countdown timer for added tension
- Multiple outcomes depending on player actions and time remaining

---

## 🎮 Commands

- `look` — Inspect your current location (description, exits, visible items)
- `go [direction]` — Move in a direction (e.g., `go forward`, `go backward`)
- `take [item]` — Pick up an item
- `inventory` — Check what you're carrying
- `solve` - solve the a room-based puzzle
- `quit` — Exit the game

For full command descriptions and game map, see [`cheatsheet.md`](./cheatsheet.md).

---

## 🧩 Architecture Diagram

The game uses an object-oriented structure with classes for `Game`, `Player`, `Train`, `CarLocation`, and `Item`.

---

## 📋 Reflection Questions

### 📐 Design Justification
I designed the game using a simple but strong object-oriented structure with classes for Game, Player, Train, CarLocation, and Item. Each class has a clear responsibility, making the program organized, easy to understand, and easy to extend later.

Alternative considered:
At first, I thought about not creating a Train class, and instead just linking CarLocation objects directly inside Game. But I decided against that because putting all the train setup into Train.java makes the code way more modular and easier to change. if I wanted to add or rearrange cars later, I would only need to edit the Train class, not the whole game logic.

### 🧠 New Things I Learned
- How to structure a full text adventure in Java.
- How to lock/unlock paths with item-based puzzles.
- How to use timers and random events to create pressure and excitement.
- How to cleanly handle player input and command parsing.
- I would also probably add Level 2: once you escape the first train, you realize you're still trapped underground, and have to navigate tunnels to find your way out. Or make it even bigger to where different stations or lines add even more cool aspects to the game. 
- Another thing I learned and something that was vital was knowing and choosing when to stop. Since, there are so many cool things that you can do with code especially when it comes to games and having the mindset of I can do better or perfectionist mindset it can actually do more harm than good. And I learned that stopping doesn't have to mean just stop adding to the project but it can mean stop looking for or creating issues that aren't there. It can mean take a break and it can mean stop doing this portion and move on. 

### 🚀 Unlimited Time Features
If I had unlimited time, I would add:
- Hidden tunnels and alternate escape paths
- Sound effects and animations (JavaFX)
- Random monster encounters
- Multiple endings and extended lore

---

## 📄 Files Included

- `Game.java`
- `Player.java`
- `Train.java`
- `CarLocation.java`
- `Item.java`
- `cheatsheet.md`
- `readme.md`

---

## 📜 License

This project was completed for Final Project 2 as part of coursework for CS120 - OOP.

## Deliverables:
 - Your final codebase 
 - Your revised annotated architecture diagram
 - Design justification (including a brief discussion of at least one alternative you considered)
 - A map of your game's layout (if applicable)
 - `cheatsheet.md`
 - Completed `rubric.md`
  

## New Features for Final Version

- A scoring system that rewards good decisions (real items, puzzle solving) and penalizes bad ones (useless items, failed attempts).

- A room-based puzzle system (solve [answer]) that adds interaction beyond movement.

- Multiple endings based on how much time you have left when you escape.

- Random events that can either build suspense or reward you with extra time.

- Final score is calculated at the end and displayed to the player.



## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project? (Answered)
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement? (Answered)
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

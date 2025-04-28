# CSC120-FinalProject
# Trapped: The Ultimate Challenge
Final Project 2 (FP2) — Escape Adventure Game
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
- `quit` — Exit the game

For full command descriptions and game map, see [`cheatsheet.md`](./cheatsheet.md).

---

## 🧩 Architecture Diagram

![Architecture Diagram](./architecture.png)

The game uses an object-oriented structure with classes for `Game`, `Player`, `Train`, `CarLocation`, and `Item`.

---

## 📋 Reflection Questions

### 📐 Design Justification
I designed the game using a clean object-oriented approach. Each class has a clear responsibility, making the code modular and easy to update. 
Alternative considered: I thought about managing cars only inside `Game`, but using a separate `Train` class made the setup more organized and extensible.

### 🧠 New Things I Learned
- How to structure a full text adventure in Java.
- How to lock/unlock paths with item-based puzzles.
- How to use timers and random events to create pressure and excitement.
- How to cleanly handle player input and command parsing.
- I would also probably add Level 2: once you escape the first train, you realize you're still trapped underground, and have to navigate tunnels to find your way out. Or make it even bigger to where different stations or lines add even more cool aspects to the game. 

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
- `architecture.png`
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
  

## Design justification
I designed the game using a simple but strong object-oriented structure with classes for Game, Player, Train, CarLocation, and Item. Each class has a clear responsibility, making the program organized, easy to understand, and easy to extend later.

Alternative considered:
At first, I thought about not creating a Train class, and instead just linking CarLocation objects directly inside Game. But I decided against that because putting all the train setup into Train.java makes the code way more modular and easier to change — if I wanted to add or rearrange cars later, I would only need to edit the Train class, not the whole game logic.


## Additional Reflection Questions
 - What was your **overall approach** to tackling this project?
 - What **new thing(s)** did you learn / figure out in completing this project?
 - Is there anything that you wish you had **implemented differently**?
 - If you had **unlimited time**, what additional features would you implement?
 - What was the most helpful **piece of feedback** you received while working on your project? Who gave it to you?
 - If you could go back in time and give your past self some **advice** about this project, what hints would you give?
 - _If you worked with a team:_ please comment on how your **team dynamics** influenced your experience working on this project.

# textBasedDrawing

Please implement a simple text (ASCII) based drawing program (something similar to a simplified version of Paint). The basic program
should allow users to:

1. Create a new canvas
2. Draw on the canvas using text based commands
3. Quit the program

Your solution should run 'out of the box' and interactively (i.e. it should respond to commands entered manually, see below).

## Commands 

Example  | Description
-------- | -------------
C w h    | Create a new canvas of width w and height h
L x1 y1 x2 y2|  Draw a new line from coordinates (x1, y1) to (x2, y2) horizontally or vertically. Lines are made up of the x character
R x1 y1 x2 y2| Draw a new rectangle, with upper left corner at coordinate (x1, y1) and lower right coordinate at (x2, y2). Lines are made up of the x character
Q | Quit the program

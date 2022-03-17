# SENG2200 Programming Languages and Paradigms
## Assignment 1 (Due: 18/03/22)

### Problem Statement
You  are  to  write  a  program  for  a  Stock  and  Station  Agent  based  in  Denman,  NSW.    Your 
program will be used to compare different land parcels for their value and how appropriate they 
are  for  particular  types  of  agriculture  as  well  as  soil  conservation  and  possible  pasture 
improvement.

### Implementation
Read polygon specs from the start to end of a file specified from the first command line argument.
Parse and store each polygon specification. A polygon will be specified in the input by 
the letter P, followed by the  number of sides the polygon has, and then pairs of numbers which 
represent the respective vertices on the Cartesian plane (x-value then y-value).
ou do not have to worry about any of the data being missing, or out of order.


### Objectives
- Writter Report
- Point Class
  - Store Two Coordinates (x, y)
  - toString Method
  - distanceFromOrigin Method
- Polygon Class
  - Array Of Points
  - toString Method
  - polygonArea Method
  - leastDistanceFromOrigin Method
  - comesBefore Method (Will implement the ComparePoly interface
- ComparePoly Interface
  - Decleration of the comesBefore Method
- MyPolygons Class (Data Structure: Cirular Doubly Linked List)
  - Sentinel node
  - pepend Method (addToHead)
  - apend Method (addToTail)
  - insert Method (Inserts before the current node)
  - next Method (Moves current to the next node)
  - resetCurrent Method (Resets current to the sentinel node)
  - remove Method (removes an item from the head of the list)

### Running Program
``` javac A1.java ```
``` java A1 "filename" ```

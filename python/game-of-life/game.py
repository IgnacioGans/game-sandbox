"""
A simulation of Conway's game of life, written in Pygame.
"""
import pygame
import copy

class Cell:
	"""A single cell in the game of life."""

	CELL_WIDTH = CELL_HEIGHT = 16
	def __init__(self, x, y):
		self.x = x
		self.y = y

		self.rect = pygame.Rect((x,y), (self.CELL_WIDTH, self.CELL_HEIGHT))
		self.rectinner = self.rect.inflate(-4, -4)
		self.alive = False
		self.changed = True

	def draw(self, screen):
		pygame.draw.rect(screen, (0, 0, 0), self.rect)
		if self.alive:
			innercolour = (255, 0, 0)
		else:
			innercolour = (255, 255, 255)
		pygame.draw.rect(screen, innercolour, self.rectinner)
		self.changed = False

	def toggleAlive(self):
		"""Toggles the alive state of the current cell."""
		self.alive = not self.alive
		self.changed = True
	
	
		
	

class Game:
	"""Main game logic."""

	def __init__(self, width = 256, height = 256):
		self.width = width
		self.height = height
		self.screen = pygame.display.set_mode((width, height))

		self.rows = self.columns = 16

		self.framerate = 3
		self.clock = pygame.time.Clock()

		self.__running = True

		self.createCells()

	def createCells(self):
		self.cells = list(list())
		for i in range(self.rows):
			l = list()
			for j in range(self.columns):
				l.append(Cell(i*Cell.CELL_WIDTH, j*Cell.CELL_HEIGHT))
			self.cells.append(l)

		#print len(self.cells)
		self.cells[4][3].alive = True
		self.cells[4][4].alive = True
		self.cells[4][5].alive = True
		self.cells[3][5].alive = True
		self.cells[2][4].alive = True


	def main(self):
		while self.__running:
			# Check for events
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.__running = False
				elif event.type == pygame.MOUSEBUTTONDOWN:
					xClick = event.pos[0]/Cell.CELL_WIDTH
					yClick = event.pos[1]/Cell.CELL_HEIGHT
					self.cells[xClick][yClick].toggleAlive()

					
			#self.screen.fill((0,0,0))
			for i in range(len(self.cells)):
				for j in range(len(self.cells[i])):
					if self.cells[i][j].changed:
						self.cells[i][j].draw(self.screen)

			pygame.display.flip()

			# Work out next iteration
			#newCells = self.cells
			newCells = copy.deepcopy(self.cells)
			for i in range(len(self.cells)):
				for j in range(len(self.cells[i])):
					neigh = self.getCellNeighbours(i,j)
					count = 0
					#print len(neigh)
					#print neigh
					for k in range(len(neigh)):
						if self.cells[neigh[k][0]][neigh[k][1]].alive == True:
							count += 1

					#print "(%s, %s): %s. %s neighbours" %(i, j, count, len(neigh))
					if self.cells[i][j].alive:
						if count < 2 or count > 3:
							newCells[i][j].toggleAlive()
					else:
						if count == 3:
							newCells[i][j].toggleAlive()


			self.cells = newCells
			
			self.clock.tick(self.framerate)

	def getCellNeighbours(self, i, j):
		l = list(list())
		if i-1 >= 0:
			l.append([i-1, j])
			if j-1 >= 0:
				l.append([i-1, j-1])
			if j+1 < len(self.cells):
				l.append([i-1, j+1])

		if i+1 < len(self.cells[0]):
			l.append([i+1, j])
			if j-1 >= 0:
				l.append([i+1, j-1])
			if j+1 < len(self.cells):
				l.append([i+1, j+1])

		if j-1 >= 0:
			l.append([i, j-1])
		if j+1 < len(self.cells):
			l.append([i, j+1])

		return l
	

window = Game()
window.main()

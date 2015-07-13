import pygame

class Cell:
	"""A single cell in the world."""

	def __init__(self, x, y):
		self.x = x
		self.y = y
		self.width = self.height = 32
		self.rect = pygame.Rect(self.x, self.y, self.width, self.height)

		self.alive = False # True if the cell is "alive"

	def position(self):
		return self.x, self.y
	
class Game:
	"""Main game logic, render loop etc."""

	def __init__(self):
		self.screen = pygame.display.set_mode((640,480))
		self.clock = pygame.time.Clock()
		self.framerate = 30
		self.running = True

		# initialise grid
		self.rows = self.columns = 8
		self.grid = list(list())
		for i in range(self.rows):
			row = list()
			for j in range(self.columns):
				c = Cell(i,j)
				row.append(c)
			self.grid.append(row)

	def main(self):
		while self.running:
			# event checking
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.running = False

			newgrid = self.grid
			for i in len(self.grid):
				for j in len(self.grid[i]):
					checkNeighbours(i,j)

			self.screen.fill((0,0,0))
			pygame.display.flip()
			self.clock.tick(self.framerate)

	# Returns the number of neighbours of a particular Cell that are alive.
	# TODO
	def checkNeighbours(self, i, j):
		pass
			

g = Game()
g.main()

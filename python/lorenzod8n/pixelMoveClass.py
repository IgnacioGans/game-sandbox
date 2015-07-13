import pygame
import math, random

class Square:
	"""A square in our little slice of paradise."""

	def __init__(self, x, y):
		self.pos = [x,y]

		self.dir = [0,0]

	def getPosition(self):
		return self.pos

	def getDirection(self):
		return self.dir

	def getNextPosition(self):
		self.pos[0] += self.dir[0]
		self.pos[1] += self.dir[1]
		return self.pos

	def setXDirection(self, xdir):
		self.dir[0] = xdir
	
	def setYDirection(self, ydir):
		self.dir[1] = ydir

class Game:
	"""Main controller for the whole game."""

	def __init__(self):
		self.width = 640
		self.height = 480

		self.screen = pygame.display.set_mode((self.width, self.height))
		self.running = True
		self.clock = pygame.time.Clock()
		self.frameRate = 30

		self.pixel = Square(self.width/2, self.height/2)

	def main(self):
		# Main game loop
		while self.running:
			# Event checking
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.running = False
				elif event.type == pygame.KEYDOWN:
					if event.key == pygame.K_UP:
						self.pixel.setXDirection(0)
						self.pixel.setYDirection(-1)
					elif event.key == pygame.K_DOWN:
						self.pixel.setXDirection(0)
						self.pixel.setYDirection(1)
					elif event.key == pygame.K_LEFT:
						self.pixel.setXDirection(-1)
						self.pixel.setYDirection(0)
					elif event.key == pygame.K_RIGHT:
						self.pixel.setXDirection(1)
						self.pixel.setYDirection(0)

			self.screen.fill((0,0,0))
			pixelPos = self.pixel.getNextPosition()
			self.screen.set_at(pixelPos, (255,255,255))

			if pixelPos[0] <= 0 or pixelPos[0] >= self.width or pixelPos[1] <= 0 or pixelPos[1] >= self.height:
				print "CRASH!"
				self.running = False
				
			pygame.display.flip()
			self.clock.tick(self.frameRate)


g = Game()
g.main()

	

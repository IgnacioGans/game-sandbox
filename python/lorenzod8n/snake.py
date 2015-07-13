import pygame
import math, random

class Snake:
	"""A snake."""

	def __init__(self, surface, screenWidth, screenHeight):
		self.surface = surface
		self.pos = [screenWidth/2, screenHeight/2]
		self.dir = [1,0]
		self.length = 100
		self.body = []
		self.crashed = False
		#self.drawCount = 0

	def getX(self):
		return self.pos[0]
	def getY(self):
		return self.pos[1]
	def getPos(self):
		return self.pos
	def nextPos(self):
		self.pos[0] += self.dir[0]
		self.pos[1] += self.dir[1]
		return self.pos

	def getLength(self):
		return self.length

	def getXDir(self):
		return self.dir[0]
	def getYDir(self):
		return self.dir[1]
	def getDir(self):
		return self.dir

	def setXDir(self, dir):
		self.dir[0] = dir
	def setYDir(self, dir):
		self.dir[1] = dir
	def setDir(self, dir):
		self.setXDir(dir[0])
		self.setYDir(dir[1])
	
	def draw(self):
		self.nextPos()
		r,g,b,a = self.surface.get_at()
		if (self.pos[0], self.pos[1]) in self.body:
			self.crashed = True

		self.body.insert(0, (self.pos[0], self.pos[1]))
		if len(self.body) >= self.length:
			self.body.pop()

			
		
		#decreaseColour = 255/self.length
		#minusColour = 0

		for i in range(len(self.body)):
			self.surface.set_at(self.body[i], (255, 255, 255))
			#minusColour += decreaseColour


	
class Game:
	"""The main class for the game proper."""

	def __init__(self):
		self.width = 640
		self.height = 480

		self.screen = pygame.display.set_mode((self.width, self.height))
		self.snake = Snake(self.screen, self.width, self.height)

		self.clock = pygame.time.Clock()
		self.frameRate = 30
		self.running = True
	
	def main(self):
		while self.running:
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.running = False
				elif event.type == pygame.KEYDOWN:
					if event.key == pygame.K_UP or event.key == pygame.K_w:
						self.snake.setDir((0, -1))
					elif event.key == pygame.K_DOWN or event.key == pygame.K_s:
						self.snake.setDir((0, 1))
					elif event.key == pygame.K_LEFT or event.key == pygame.K_a:
						self.snake.setDir((-1, 0))
					elif event.key == pygame.K_RIGHT or event.key == pygame.K_d:
						self.snake.setDir((1,0))

			# Main game
			self.screen.fill((0,0,0))
			self.snake.draw()
			if self.snake.crashed or self.snake.getX() <= 0 or self.snake.getX() >= self.width or self.snake.getY() <= 0 or self.snake.getY() >= self.height:
				print "CRASHED!"
				self.running = False
				
			pygame.display.flip()
			self.clock.tick(self.frameRate)

g = Game()
g.main()
	

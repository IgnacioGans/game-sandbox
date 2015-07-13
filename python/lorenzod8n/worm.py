import pygame
import random

class Worm:
	def __init__(self, surface):
		self.surface = surface
		self.x = surface.get_width()/2
		self.y = surface.get_height()/2
		self.length = 1 # current maximum length of the worm
		self.lengthLimit = 50 # worm will not grow any more past this point

		self.vx = 0
		self.vy = -1
		self.body = []
		self.crashed = False
		self.colour = (255, 255, 0)

	def move(self):
		self.x += self.vx
		self.y += self.vy

	def position(self):
		return self.x, self.y

	def eat(self):
		self.lengthLimit += 25

	def draw(self):
		if (self.lengthLimit > self.length):
			self.length += 1

		if (self.x, self.y) in self.body:
			self.crashed = True

		self.body.insert(0, (self.x, self.y))

		if len(self.body) > self.length:
			deadPixel = self.body.pop()
			self.surface.set_at(deadPixel, (0,0,0))

		self.surface.set_at((self.x, self.y), self.colour)



class Food:
	def __init__(self, surface):
		self.surface = surface
		self.x = random.randint(0, surface.get_width())
		self.y = random.randint(0, surface.get_height())
		self.colour = (255, 255, 255)
		self.rect = pygame.Rect(self.x, self.y, 3, 3)

	def draw(self):
		pygame.draw.rect(self.surface, self.colour, self.rect, 0)

	def position(self):
		return self.x, self.y

	def erase(self):
		pygame.draw.rect(self.surface, (0,0,0), self.rect, 0)
	

class Game:
	"""Main game handling"""

	def __init__(self):
		self.width = 150
		self.height = 150

		self.screen = pygame.display.set_mode((self.width, self.height))
		self.clock = pygame.time.Clock()
		self.frameRate = 30

		self.worm = Worm(self.screen)
		self.food = Food(self.screen)

		self.running = True
		self.score = 0
	
	def main(self):
		while self.running:
			for event in pygame.event.get():
				if event.type == pygame.QUIT:
					self.running = False
				elif event.type == pygame.KEYDOWN:
					if event.key == pygame.K_UP or event.key == pygame.K_w:
						self.worm.vx = 0
						self.worm.vy = -1
					elif event.key == pygame.K_DOWN or event.key == pygame.K_s:
						self.worm.vx = 0
						self.worm.vy = 1
					elif event.key == pygame.K_LEFT or event.key == pygame.K_a:
						self.worm.vx = -1
						self.worm.vy = 0
					elif event.key == pygame.K_RIGHT or event.key == pygame.K_d:
						self.worm.vx = 1
						self.worm.vy = 0

			#self.screen.fill((0,0,0))

			self.worm.move()
			self.worm.draw()
			self.food.draw()

				

			#print self.worm.position(), self.food.position(), self.worm.position() == self.food.position()
			wormrect = pygame.Rect(self.worm.x, self.worm.y, 1, 1)
			if self.worm.crashed:
				self.running = False
			elif self.worm.x <= 0 or self.worm.x >= self.screen.get_width()-1:
				self.running = False
			elif self.worm.y <= 0 or self.worm.y >= self.screen.get_height()-1:
				self.running = False
			elif self.food.rect.contains(wormrect):
				self.score += 1
				self.worm.eat()
				print "Score = %d" %self.score
				self.food.erase()
				self.food = Food(self.screen)
				

			pygame.display.flip()
			self.clock.tick(self.frameRate)
		print "Game over!"
		print "Final score: %d" %self.score
	
g = Game()
g.main()

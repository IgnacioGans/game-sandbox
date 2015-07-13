import pygame
import sys, getopt
import math, random


def main(argv):
	opts, args = getopt.getopt(argv, "h:w:")
	#print opts
	#print args

	width = 640
	height = 480
	for pair in opts:
		#print pair
		if pair[0] == '-w':
			width = (int)(pair[1])
		elif pair[0] == '-h':
			height = (int)(pair[1])
	screen = pygame.display.set_mode((width, height))

	# Position of the pixel
	x = width/2
	y = height/2

	# Direction of the pixel
	dirX = 0
	dirY = -1

	# Main game loop
	running = True
	clock = pygame.time.Clock()
	squareWidth = 20
	while running:
		x += dirX
		y += dirY

		if x-squareWidth/2 <= 0 or x+squareWidth/2 >= width or y-squareWidth/2 <= 0 or y+squareWidth/2 >= height:
			print "Crash!"
			running = False 

		# Check for event input
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				running = False
			elif event.type == pygame.KEYDOWN:
				if event.key == pygame.K_UP:
					dirX = 0
					dirY = -1
				elif event.key == pygame.K_DOWN:
					dirX = 0
					dirY = 1
				elif event.key == pygame.K_LEFT:
					dirX = -1
					dirY = 0
				elif event.key == pygame.K_RIGHT:
					dirX = 1
					dirY = 0

		screen.fill((0,0,0))
		for i in range(x-squareWidth/2, x+squareWidth/2):
			for j in range(y-squareWidth/2, y+squareWidth/2):
				screen.set_at((i,j), (255, 255, 255))
		pygame.display.flip()
		clock.tick(30)

main(sys.argv[1:])

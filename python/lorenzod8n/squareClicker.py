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

	# Main game loop
	running = True
	clock = pygame.time.Clock()
	clickPositions = []
	squareWidth = 20
	while running:
		# Check for event input
		for event in pygame.event.get():
			if event.type == pygame.QUIT:
				running = False
			elif event.type == pygame.MOUSEBUTTONDOWN:
				clickPositions.append(event.pos)
				print event.pos


		screen.fill((0,0,0))
		for pos in clickPositions:
			for i in range(pos[0]-squareWidth/2, pos[0]+squareWidth/2):
				for j in range(pos[1]-squareWidth/2, pos[1]+squareWidth/2):
					screen.set_at((i,j), (255, 255, 255))
		pygame.display.flip()
		clock.tick(30)

main(sys.argv[1:])

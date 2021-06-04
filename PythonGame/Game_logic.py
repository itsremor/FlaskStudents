import pygame
from Settings import WIDTH, HEIGHT
import Colors
import os
import random

game_folder = os.path.dirname(__file__)
img_folder = os.path.join(game_folder, 'Models')
ball_models = (pygame.image.load(os.path.join(img_folder, 'default_ball.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_one.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_two.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_three.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_four.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_five.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_six.png')),
               pygame.image.load(os.path.join(img_folder, 'ball_seven.png'))
               )
game_field_model = pygame.image.load(os.path.join(img_folder, 'game_field.png'))


class Player(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = ball_models[0]
        self.rect = self.image.get_rect()


class Ball(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        ball_value = random.randint(1, 7)
        self.image = ball_models[ball_value]
        self.rect = self.image.get_rect()

    def move(self, width):
        if width > 0:
            if not self.rect.right + width > WIDTH:
                self.rect.x += width
        else:
            if not self.rect.left + width < 0:
                self.rect.x += width


class Game_field(pygame.sprite.Sprite):
    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = game_field_model
        self.rect = self.image.get_rect()
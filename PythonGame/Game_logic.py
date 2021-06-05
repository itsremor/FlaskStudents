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
        self.ball_value = random.randint(1, 7)
        self.image = ball_models[self.ball_value]
        self.rect = self.image.get_rect()

    def move(self, width):
        if width > 0:
            if not self.rect.right + width > WIDTH:
                self.rect.x += width
        else:
            if not self.rect.left + width < 0:
                self.rect.x += width

    def drop_down(self, column, row):
        self.rect.x = column * 100
        self.rect.y = row * 100 + 100


class Game_field(pygame.sprite.Sprite):
    balls_field = [[None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None],
                   [None, None, None, None, None, None, None]]

    def __init__(self):
        pygame.sprite.Sprite.__init__(self)
        self.image = game_field_model
        self.rect = self.image.get_rect()
        self.score = 0

    def get_new_ball(self, ball, ball_col):
        for i in 6, 5, 4, 3, 2, 1, 0:
            if self.balls_field[i][ball_col] is None:
                self.balls_field[i][ball_col] = ball
                return i
        else:
            return -1

    def check_horizontal_line(self, row):
        counter = 0
        for i in range(0, 7, +1):
            if not self.balls_field[row][i] is None:
                counter += 1
        return counter

    def check_vertical_line(self, column):
        counter = 0
        for i in range(0, 7, +1):
            if not self.balls_field[i][column] is None:
                counter += 1
        return counter

    def is_need_to_remove(self, ball_row, ball_col):
        if not self.balls_field[ball_row][ball_col] is None:
            if self.check_vertical_line(ball_col) == self.balls_field[ball_row][ball_col].ball_value:
                return True
            elif self.check_horizontal_line(ball_row) == self.balls_field[ball_row][ball_col].ball_value:
                return True
        return False

    def remove_from_game_field(self, ball_row, ball_column, all_sprites):
        #if self.is_need_to_remove(ball_row, ball_column):
            all_sprites.remove(self.balls_field[ball_row][ball_column])
            self.balls_field[ball_row][ball_column] = None

    def check_all_field(self, all_sprites):
        row_and_columns = []
        for i in range(0, 7, +1):
            for j in range(0, 7, +1):
                if self.is_need_to_remove(i, j):
                    row_and_columns.append(Row_and_column(i,j))
        self.score += len(row_and_columns)
        for i in row_and_columns:
            self.remove_from_game_field(i.row, i.column, all_sprites)


    def drop_balls_down(self, all_sprites):
        flag_line_drop = False
        for i in range(0, 6, +1):
            for j in range(0, 7, +1):
                if not self.balls_field[i][j] is None:
                    if self.balls_field[i+1][j] is None:
                        self.balls_field[i+1][j] = self.balls_field[i][j]
                        self.balls_field[i][j] = None
                        self.balls_field[i+1][j].rect.y += 100
                        i = 0
                        j = 0
                        flag_line_drop = True
                        break
                if flag_line_drop:
                    break



class Row_and_column():
    def __init__(self, row, column):
        self.row = row
        self.column = column
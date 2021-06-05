import pygame

import Colors
import Game_logic
from Settings import WIDTH, HEIGHT, FPS


def open_game_window():
    global new_ball
    clock = pygame.time.Clock()
    pygame.init()
    pygame.mixer.init()
    screen = pygame.display.set_mode((WIDTH, HEIGHT))
    pygame.display.set_caption("Цепочки")
    running = True
    all_sprites = pygame.sprite.Group()


    game_field = Game_logic.Game_field()
    all_sprites.add(game_field)

    pygame.font.SysFont('arial', 72)
    font1 = pygame.font.Font(None, 30)

    new_ball_flag = True
    make_move = True
    prev_keys = -1

    new_ball_position = 0

    while running:
        clock.tick(FPS)

        score = font1.render(f'Score is: ' + str(game_field.score), True, Colors.BLACK)
        screen.blit(score, (530, 810))
        pygame.display.update()

        game_field.check_all_field(all_sprites)

        if new_ball_flag:
            new_ball = Game_logic.Ball()
            all_sprites.add(new_ball)
            new_ball_flag = False
            new_ball.move(100 * new_ball_position)

        keys = pygame.key.get_pressed()

        if keys[pygame.K_UP]:
            if make_move:
                new_ball.move(100)
                if new_ball_position != 6:
                    new_ball_position += 1
            make_move = False

        if keys != prev_keys:
            make_move = True
        prev_keys = pygame.key.get_pressed()

        if keys[pygame.K_RIGHT]:
            if make_move:
                new_ball.move(100)
                if new_ball_position != 6:
                    new_ball_position += 1
            make_move = False

        if keys[pygame.K_LEFT]:
            if make_move:
                new_ball.move(-100)
                if new_ball_position != 0:
                    new_ball_position -= 1
            make_move = False

        if keys[pygame.K_DOWN]:
            if make_move:
                marker = game_field.get_new_ball(new_ball, new_ball_position)
                if marker == -1:
                    running = False
                else:
                    new_ball.drop_down(new_ball_position, marker)
                    new_ball_flag = True
                    make_move = False
            # #удаляет спрайт, а потом и сам шарик с поля
            # all_sprites.remove(game_field.balls_field[marker][new_ball_position])
            # game_field.balls_field[marker][new_ball_position] = None

        game_field.drop_balls_down(all_sprites)

        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False

        all_sprites.update()
        all_sprites.draw(screen)
        pygame.display.flip()

    pygame.quit()

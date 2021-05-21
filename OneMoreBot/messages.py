import vk_api
import httplib2
import re
from vk_api.longpoll import VkLongPoll, VkEventType


from main import vk_session, session_api, longpoll

def ask_name(user_id):
    message = 'Как тебя зовут?'
    message_err = 'Я не понимаю тебя. Можешь написать ещё раз?'
    name = ''
    vk_session.method('messages.send', {'user_id': user_id, 'message': message, 'random_id': 0})

    for event in longpoll.listen():
        if event.type == VkEventType.MESSAGE_NEW:
            if event.to_me:
                msg = event.text.lower()

                if re.match(r'[^а-яa-z]', msg):
                    vk_session.method('messages.send', {'user_id': user_id, 'message': message_err, 'random_id': 0})
                    continue
    print(name)

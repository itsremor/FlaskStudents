import vk_api
import httplib2
import messages
from vk_api.longpoll import VkLongPoll, VkEventType
from toks import changelink_vrn_main_token

vk_session = vk_api.VkApi(token=changelink_vrn_main_token)
session_api = vk_session.get_api()
longpoll = VkLongPoll(vk_session)


for event in longpoll.listen():
    if event.type == VkEventType.MESSAGE_NEW:
        if event.to_me:
            msg = event.text.lower()
            msg_user_id = event.user_id

            if msg == '#хочунафорум':
                print('a')
               #messages.ask_name(msg_user_id)

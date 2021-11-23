import json

import echovr_api


try:
    game_state = echovr_api.fetch_state()

    print(f"Game status: {game_state.game_status}")
    print(f"Seconds on clock: {game_state.game_clock}")
    print(f"Score: {game_state.blue_team.score} - {game_state.orange_team.score}")

    if game_state.game_status == game_state.game_status.round_end:
        # Run Code to get JSON file

except ConnectionError as e:
    print("Connection refused. Make sure you're running Echo VR with the -http option and that you're in a match.")
except json.decoder.JSONDecodeError as e:
    print("Could not decode response. (Not valid JSON.)")
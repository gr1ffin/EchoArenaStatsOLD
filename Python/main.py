import echovr_api

try:
    game_state = echovr_api.fetch_state()

    print(f"Game status: {game_state.game_status}")
    print(f"Seconds on clock: {game_state.game_clock}")
    print(f"Score: {game_state.blue_team.score} - {game_state.orange_team.score}")

    if game_state.game_status == game_state.game_status.round_end:
        print("round end")
        # Put code here to run method that updates a .json file that is read by another program

except ConnectionError as e:
    # ECHO VR is not running, or you didn't pass the -http parameter when
    # starting it.
    print("lol")
except json.decoder.JSONDecodeError as e:
    # ECHO VR is currently not in an Arena match
    print('fail')


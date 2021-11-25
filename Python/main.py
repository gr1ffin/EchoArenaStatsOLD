import requests
import time
apiData = None


def requests_api():
    global apiData
    req = requests.get("http://127.0.0.1:6721/session")
    if req.status_code == 200:
        apiData = req.json()
    else:
        print(req.status_code)

while True:
    requests_api()
    if apiData is None:
        time.sleep(3)
    else:
        if "post_match" == apiData["game_status"]:
            f = open("C:\\Users\\Public\\Public Documents\\\\EchoStatsLogger\\detectChange.txt", "a")
            f.write(str(apiData))
            f.close()
            break
        else:
            time.sleep(.5)
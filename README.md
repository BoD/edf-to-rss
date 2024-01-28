# edf-to-rss

Monitor your EDF consumption with an RSS feed.

## Docker instructions

### Building and pushing the image to Docker Hub

```
docker image rm bodlulu/edf-to-rss:latest
DOCKER_USERNAME=<your docker hub login> DOCKER_PASSWORD=<your docker hub password> ./gradlew dockerPushImage
```

### Running the image

```
docker pull bodlulu/edf-to-rss
docker run \
-p <PORT TO LISTEN TO>:8080 \
-v <path to directory containing playwright browser binaries>:/playwright-browsers \
-v <path to directory containing your storage-state.json file>:/storage-state \
-e EDF_EMAIL=<your EDF email> \
-e EDF_PASSWORD=<your EDF password> \
bodlulu/edf-to-rss
```

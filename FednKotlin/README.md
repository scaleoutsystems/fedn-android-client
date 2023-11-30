## Running the App in a Docker Container

To run the app in a Docker container, follow these steps:

1. Make sure you have Docker installed on your machine. If not, you can download and install it from the official Docker website.

2. Navigate to the project directory:

    ```shell
    cd FednKotlin
    ```

3. Build the Docker image using the provided Dockerfile:

    ```shell
    docker build -t fedn-kotlin .
    ```

4. Create env.txt file like so:

    ```shell
    touch env.txt
    ```

5. Update the env.txt file to include your connection string, token and client name. The connection string is the url to the server (include protocol), and the token is a valid token for the server. These values can be obtained via the studio interface, under the clients tab. The client name is the name of the client, and will be generated if null. The env.txt file should look like this:

    ```shell
    FEDN_URL=<your-fedn-url>
    FEDN_TOKEN=<your-fedn-token>
    FEDN_NAME=<your-fedn-name>
    ```

6. Once the image is built, you can run the app in a Docker container:

    ```shell
    docker run --env-file env.txt fedn-kotlin
    ```

    alternatively, skip step 3 and 4 and run the app in a Docker container with the following command:

    ```shell
    docker run -e "FEDN_URL=<your-fedn-url>" -e "FEDN_TOKEN=<your-fedn-token>" -e "FEDN_NAME=<your-fedn-name>" fedn-kotlin
    ```

    This command starts the client and connects it to the Fedn network. The client will then start to listen for training jobs. When a training job is received, the client will run the training function and send the trained model back to the server. The client will then wait for a new training job. If the connection is lost, the client will try to reconnect to the server. If the client is not able to reconnect to the server, the client will stop and the user will be notified.

7. This app uses a jar file to run the client. If you want to run the app with a different jar file (update by building the android app), you can do so by replacing the fedn-client.jar file in the app/dependencies folder with your own jar file. Make sure that the jar file is named fedn-client.jar.

8. To update the app with a new jar file, you need to rebuild the Docker image. To do this, run the following command:

    ```shell
    docker build -t fedn-kotlin .
    ```

9. To update training functionality, you need to update the runTrainingProcess function in FednKotlin/app/src/main/kotlin/fednkotlin/App.kt. After doing this you need to rebuild the Docker image as explained in step 7. 

That's it! You have successfully run the app in a Docker container. Feel free to explore and test the app in this environment.

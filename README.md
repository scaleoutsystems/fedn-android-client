# Android-Client
This repository contains the source code for the Android client for the Federated Learning framework Fedn. The client logic is implemented in the fednclient library, which is included in the app module. The app module contains a simple example of how to use the library. The example is done using Android [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager). 


## Usage

The IFednClient interface should be used to connect to the Fedn network and run training. The client is implemented using [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html). The client is started by calling the runProcess function. The runProcess function takes a function as input, which is the function that will be called when training is to be run. The function should take a ByteArray as input and return a ByteArray as output. The input ByteArray is the model that is to be trained, and the output ByteArray is the trained model. The runProcess function also takes two optional callback functions as input. The first callback function updates the user on the state of the client. The second callback function updates the user on the state of the model.

If the client is started with a valid connection string and token, the client will try to connect to the Fedn server. If the connection is successful, the client will start to listen for training jobs. When a training job is received, the client will run the training function and send the trained model back to the server. The client will then wait for a new training job. If the connection is lost, the client will try to reconnect to the server. If the client is not able to reconnect to the server, the client will stop and the user will be notified.

To gain more control over the process one can, instead of running runProcess, run the following functions in order: attachClientToNetwork (attaches the client to the network), sendHeartbeats (notifies the network that the client is still alive), listenToModelUpdateRequestStream (listens for model update requests and runs the training when a request is received)

To interact with the Fedn server, the client needs a valid connection string and a token. For testing purposes these can be obtained via the Studio interface, under the clients tab. The connection string is the url to the server, and the token is a valid token for the server.

### Example

For a real example, see the FednWorker class implemented in the app module. The following code snippet shows how to use the library:

```kotlin

// Create a new instance of the client
val fednClient: IFednClient = FednClient(
                connectionString = myConnectionString, // String - valid url
                token = myToken, // String - token
                name = name, // String? = null - name of client, will be generated if null 
                heartbeatInterval = 5000, // Long = 5000 - milliseconds between heart beats
                port = 443, // Int = 443 - port to be used for grpc
                defaultDispatcher = Dispatchers.IO, // CoroutineDispatcher = Dispatchers.IO - dispatcher used to create context
                _httpHandler = null, // IHttpHandler? = null - interface defined in library, can be used to override interaction with fedn rest api. Used for testing purposes
                _grpcHandler = null // IGrpcHandler? = null - interface defined in library, can be used to override interaction with fedn grpc client. Used for testing purposes
            )

// Function to be called when training is to be run. (ByteArray) -> ByteArray
val trainModel: (ByteArray) -> ByteArray = { modelIn ->
    //run training here
    modelIn
}

// Start the client
fednClient.runProcess(trainModel, onAttachStateChanged = { state ->

    println("onAssignStateChanged: $state")

}, onUpdateModelStateChanged = { state ->

    println("onUpdateModelStateChanged $state")

})
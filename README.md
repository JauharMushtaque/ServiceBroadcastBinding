# ServiceBroadcastBinding
How to use PendingIntent and BroadcastReceiver to communicate from a Service to a client/Activity

we have local service, responsible for performing some time-consuming operations.
Activity makes the requests to the service, but does not bind to it - just sends the intent with request. 
Additionally, Activity includes the information of BroadcastReceiver that should be called back when service is done with the requested task.
The information is passed by PendingIntent. 
The service handles the task in background thread and when task is finished, service broadcasts the BroadcastReceiver with an answer.

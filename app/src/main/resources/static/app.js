let stompClient = null;


function sendName() {
    let msg = JSON.stringify({ 'text': $("#name").val() });
    console.log("=>",msg);
    stompClient.send("/backendroot/channel", {}, msg);

    stompClient.send("/backendroot/broadcast", {}, msg);
}

$(function () {
    stompClient = Stomp.over(new SockJS('/websocket-endpoint'));
    stompClient.debug = null
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/user/message', function (greeting) {
            // console.log(greeting);
            console.log("channel",JSON.parse(greeting.body),"<=");
        });

        stompClient.subscribe('/message', function (greeting) {
            // console.log(greeting);
            console.log("Broadcast",JSON.parse(greeting.body),"<=");
        });
    }, function(message){
        console.log(message);
    });

    $("#send").click(function () { sendName(); });
});
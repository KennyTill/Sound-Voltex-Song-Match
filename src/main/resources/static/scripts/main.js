(function(){
    var retrieve = document.getElementById("btn-search");


    var url = "http://localhost:8080/findAll";
    retrieve.addEventListener("click", function(e){
        var oReq = new XMLHttpRequest();
        oReq.onload = function(){
            console.log("inside onload event");
        };

        oReq.open("POST", url, true);
        oReq.setRequestHeader("X-Requested-With", "XMLHttpRequest");
        oReq.send();
    });
}());
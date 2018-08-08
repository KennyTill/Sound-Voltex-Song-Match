$(document).ready(function(){
    $("#results-table").hide();
    $("#no-match-div").hide();
});

//Search Functionality
$("#btn-search").click(function (e) {

    e.preventDefault();
    $("#results-table tbody > tr").remove();

    var formData = $("#form-search").serialize();

    $.ajax({
        type: "POST",
        url: "/findMatches",
        data: formData,
        success: function (data) {
            if (data.length > 0){
                $('#results-table').show();
                $('#no-match-div').hide();
            } else {
                $("#results-table").hide();
                $("#no-match-div").show();
            }
            $.each(data, function () {
                var html = "<tr><td>";
                html+= this.name + "</td>";

                for (var i = 0; i < this.difficulties.length; i++){
                    html+= "<td>" + this.difficulties[i] + "</td>";
                }

                html+= "</tr>";
                $("#results-table").append(html);
            });
        }
    });
});


//starting number larger p1
$("#playerOneStart").change(function (e) {
    var playerOneStart = parseInt($("#playerOneStart").val());
    var playerOneEnd = parseInt($("#playerOneEnd").val());
    if (playerOneStart > playerOneEnd) {
        $("#playerOneEnd").val(playerOneStart.toString());
    }
});

//ending number smaller p1
$("#playerOneEnd").change(function (e) {
    var playerOneStart = parseInt($("#playerOneStart").val());
    var playerOneEnd = parseInt($("#playerOneEnd").val());
    if (playerOneEnd < playerOneStart) {
        $("#playerOneStart").val(playerOneEnd.toString());
    }
});

//starting number larger p2
$("#playerTwoStart").change(function (e) {
    var playerTwoStart = parseInt($("#playerTwoStart").val());
    var playerTwoEnd = parseInt($("#playerTwoEnd").val());
    if (playerTwoStart > playerTwoEnd) {
        $("#playerTwoEnd").val(playerTwoStart.toString());
    }
});

//ending number smaller p2
$("#playerTwoEnd").change(function (e) {
    var playerTwoStart = parseInt($("#playerTwoStart").val());
    var playerTwoEnd = parseInt($("#playerTwoEnd").val());
    if (playerTwoEnd < playerTwoStart) {
        $("#playerTwoStart").val(playerTwoEnd.toString());
    }
});


$("#player-toggle").click(function (e) {
    e.preventDefault();
    $("#player-two-box").toggle();
    if ($("#player-two-box").is(":hidden")) {
        //max range to not mess with the search
        $("#playerTwoStart").val("1");
        $("#playerTwoEnd").val("20");
        $("#player-toggle").text("+");
    } else {
        //set both back to 1
        $("#playerTwoStart").val("1");
        $("#playerTwoEnd").val("1");
        $("#player-toggle").text("-");
    }
});
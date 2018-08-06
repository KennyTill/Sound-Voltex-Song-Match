//Search Functionality
$("#btn-search").click(function(e){
    console.log('things!');
    e.preventDefault();
    var formData = $("#form-search").serialize();
    console.log(formData);

    $.ajax({
        type: "POST",
        url: "/findMatches",
        data: formData,
        success: function(data){
            console.log(data);
        }
    });
});

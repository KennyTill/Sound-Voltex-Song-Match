//
//
// function submitFormToEndpoint(){
//     console.log("inside submit function");
//     //Call submit action on form
//     $("#form-search").submit(function (e){
//
//         console.log("inside submit form action");
//         var form = $("#form-search");
//         console.log(form);
//         var url = form.attr("action");
//
//         //ajax the form out to our matches endpoint
//         $.ajax({
//             type: "POST",
//             url: url,
//             data: form.serialize(),
//             success:function (data){
//                 console.log(data);
//             },
//             error: function (data){
//                 console.log(data)
//             }
//         });
//         //stop standard post submit
//         e.preventDefault();
//     });
// }
//
// $(document).ready(function(){
//     submitFormToEndpoint();
// });

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
// $("#form-search").on("submit", function(e){
//     console.log("inside submit form action");
//
//     //stop standard post submit
//     e.preventDefault();
//
//     var form = $(this);
//     console.log(form);
//     var url = form.attr("action");
//
//     //ajax the form out to our matches endpoint
//     $.ajax({
//         type: "POST",
//         url: url,
//         data: form.serialize(),
//         success:function (data){
//             console.log(data);
//         },
//         error: function (data){
//             console.log(data)
//         }
//     });
//
// });
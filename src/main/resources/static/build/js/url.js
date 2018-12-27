$(document).ready(function() {
    $('.toRM').on('click', function() {
        htmlobj=$.ajax({url:"test2",async:false});
        $("#content").html(htmlobj.responseText);
        alert(htmlobj.responseText);
    });

});
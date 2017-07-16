/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function() {
    $(function() {
        $("#search").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "SearchController",
                    type: "GET",
                    data: {
                        term: request.term
                    },
                    dataType: "json",
                    success: function(data) {
                        // alert(data);
                        response(data);
                        // alert(response);
                    }

                });
            },
            select: function(event, ui) {
                $("input#autoText").val(ui.item.value);
            }
        });
    });
});


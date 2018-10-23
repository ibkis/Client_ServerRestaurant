

$(document).ready(function(){
   $('.x_content .Noterestaurant').on('click',function(event){
         event.preventDefault();
         var href=$(this).attr('href');
         $.get(href,function(restaurantBean,status){
            $('.myForm #id').val(restaurantBean.id);
            $('.myForm #Nom').val(restaurantBean.nom);
         });
        $('.myForm #exampleModal').modal();
   });
});

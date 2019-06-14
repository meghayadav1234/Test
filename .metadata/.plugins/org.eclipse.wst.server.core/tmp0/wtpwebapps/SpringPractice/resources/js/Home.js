function login(){

$.ajax({  
           type: 'POST',  
           dataType: 'json',  
           url: '/homeController/login',  
           data: null,
           success: function (Data) {  
               alert(data.id);  
               alert(data.name);  
           },  
           error: function (XMLHttpRequest, textStatus, errorThrown) {  
  
           }  
       }); 
}


// $(function(){
//     function myFormCheck(){
//         console.log(1)
//         $("div.overlay").fadeIn();
//     }
//     // 開啟 Modal 彈跳視窗
//     $("input.btn").on("myFormCheck", function(){
//     });
    
//     // 關閉 Modal
//     $("button.btn_modal_close").on("myFormCheck", function(){
//       $("div.overlay").fadeOut();
//     });
    
//   });
function myFormCheck(){
            
    console.log(1)
    $("div.overlay").css("display", "block");

    $("button.btn_modal_close").on("click", function(){
        $("div.overlay").css("display", "none");
    })
 }

$(function(){
  
    // 開啟 Modal 彈跳視窗
    $("input.btn").on("myFormCheck", function(){
      $("div.overlay").fadeIn();
    });
    
    // 關閉 Modal
    $("button.btn_modal_close").on("myFormCheck", function(){
      $("div.overlay").fadeOut();
    });
    
  });


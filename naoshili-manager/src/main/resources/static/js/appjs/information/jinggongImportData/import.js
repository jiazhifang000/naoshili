$().ready(function () {
   validateRule();
});

$.validator.setDefaults({
   submitHandler: function () {
      save();
   }
});

function save() {
   var formdata = new FormData(document.getElementById("signupForm"));
   $.ajax({
      cache: true,
      type: "POST",
      url: "/information/jinggongImportData/ajaxImport",
      data: formdata,// 你的formid
      async: false,
      processData: false,   // jQuery不要去处理发送的数据
      contentType: false,
      error: function (request) {
         parent.layer.alert("Connection error");
      },
      success: function (data) {
         console.log(data)
         if (data.code == 0) {
            parent.layer.msg("导入成功");
            parent.reLoad();
            var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
            parent.layer.close(index);

         } else {
            parent.layer.alert(data.msg)
         }

      }
   });

}

function validateRule() {
   var icon = "<i class='fa fa-times-circle'></i> ";
   $("#signupForm").validate({
      rules: {},
      messages: {}
   })
}
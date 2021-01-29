$(function () {
   load();

});

function load() {
   $('#exampleTable')
      .bootstrapTable(
         {
            method: 'get', // 服务器数据的请求方式 get or post
            url: "/information/userBasic/list", // 服务器数据的加载地址
            //	showRefresh : true,
            //	showToggle : true,
            //	showColumns : true,
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            // queryParamsType : "limit",
            // //设置为limit则会发送符合RESTFull格式的参数
            singleSelect: false, // 设置为true将禁止多选
            // contentType : "application/x-www-form-urlencoded",
            // //发送到服务器的数据编码类型
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            //search : true, // 是否显示搜索框
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
            queryParams: function (params) {
               return {
                  //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                  limit: params.limit,
                  offset: params.offset
                  // name:$('#searchName').val(),
                  // username:$('#searchName').val()
               };
            },
            // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
            // queryParamsType = 'limit' ,返回参数必须包含
            // limit, offset, search, sort, order 否则, 需要包含:
            // pageSize, pageNumber, searchText, sortName,
            // sortOrder.
            // 返回false将会终止请求
            columns: [
               {
                  checkbox: true
               },
               {
                  field: 'userId',
                  title: '用户id'
               },
               {
                  field: 'name',
                  title: '姓名'
               },
               {
                  field: 'idCard',
                  title: '身份证'
               },
               {
                  field: 'birthday',
                  title: '生日'
               },
               {
                  field: 'age',
                  title: '年龄'
               },
               {
                  field: 'gender',
                  title: '性别'
               },
               {
                  field: 'school',
                  title: '学校'
               },
               {
                  field: 'grade',
                  title: '年级'
               },
               {
                  field: 'classname',
                  title: '班级'
               },
               {
                  field: 'contacts',
                  title: '联系人'
               },
               {
                  field: 'phone',
                  title: '电话'
               }, {
                  field: 'eyeHealth',
                  title: '眼健康',
                  formatter: function (value) {
                     if (value == 1) {
                        return "正视"
                     } else if (value == 2) {
                        return "假性近视"
                     } else if (value == 3) {
                        return "未确诊近视"
                     } else if (value == 4) {
                        return "真性近视"
                     } else if (value == 5) {
                        return "弱视"
                     } else {
                        return "其他"
                     }
                  }
               },

               {
                  title: '操作',
                  field: 'id',
                  align: 'center',
                  formatter: function (value, row, index) {
                     var e = '<a class="btn btn-primary btn-sm ' + s_edit_h + '" href="#" mce_href="#" title="编辑" onclick="edit(\''
                        + row.id
                        + '\')"><i class="fa fa-edit"></i></a> ';
                     var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                        + row.id
                        + '\')"><i class="fa fa-remove"></i></a> ';
                     var f = '<a class="btn btn-success btn-sm" href="#" title="环境信息"  mce_href="#" onclick="environmentInfo(\''
                        + row.id
                        + '\')"><i class="fa fa-home"></i></a> ';
                     var g = '<a class="btn btn-success btn-sm" href="#" title="眼睛信息"  mce_href="#" onclick="eyeInfo(\''
                        + row.userId
                        + '\')"><i class="fa fa-eye"></i></a> ';
                     return e + d + f + g;
                  }
               }]
         });


}

function reLoad() {
   $('#exampleTable').bootstrapTable('refresh');
}

function environmentInfo(id) {
   var showpage = layer.open({
      type: 2,
      title: '环境信息',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['1000px', '1000px'],
      content: '/information/userBasic/environmentInfo/' + id // iframe的url
   });
   layer.full(showpage);
}

function eyeInfo(id) {
   var showpage = layer.open({
      type: 2,
      title: '环境信息',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['1000px', '1000px'],
      content: '/information/userEyeData/eyelist/' + id // iframe的url
   });
   layer.full(showpage);
}


function add() {
   var showpage = layer.open({
      type: 2,
      title: '增加',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['1000px', '1000px'],
      content: '/information/userBasic/add' // iframe的url
   });
   layer.full(showpage);
}

function batchadd() {
   var showpage = layer.open({
      type: 2,
      title: '增加',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: '/information/userBasic/importtemplate' // iframe的url
   });
}

function daoru() {
   var formData = new FormData(document.getElementById("signupForm"));
   $.ajax({
      cache: true,
      type: "POST",
      url: "/information/userBasic/importMember",
      data: formData,// 你的formid
      processData: false,
      contentType: false,
      async: false,
      error: function (request) {
         parent.layer.alert("网络超时");
      },
      success: function (data) {
         if (data.code == 0) {
            parent.layer.msg(data.msg);
            parent.reLoad();
            var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
            parent.layer.close(index);
         } else {
            parent.layer.alert(data.msg)
         }

      }
   });
}

function edit(id) {
   layer.open({
      type: 2,
      title: '编辑',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['1000px', '800px'],
      content: '/information/userBasic/edit/' + id // iframe的url
   });
}

function edit1(id) {
   layer.open({
      type: 2,
      title: '编辑',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['1000px', '800px'],
      content: '/information/userEyeData/edit/' + id // iframe的url
   });
}

function remove(id) {
   layer.confirm('确定要删除选中的记录？', {
      btn: ['确定', '取消']
   }, function () {
      $.ajax({
         url: "/information/userBasic/remove",
         type: "post",
         data: {
            'id': id
         },
         success: function (r) {
            if (r.code == 0) {
               layer.msg(r.msg);
               reLoad();
            } else {
               layer.msg(r.msg);
            }
         }
      });
   })
}

function resetPwd(id) {
}

function batchRemove() {
   var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
   if (rows.length == 0) {
      layer.msg("请选择要删除的数据");
      return;
   }
   layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
      btn: ['确定', '取消']
      // 按钮
   }, function () {
      var ids = new Array();
      // 遍历所有选择的行数据，取每条数据对应的ID
      $.each(rows, function (i, row) {
         ids[i] = row['id'];
      });
      $.ajax({
         type: 'POST',
         data: {
            "ids": ids
         },
         url: '/information/userBasic/batchRemove',
         success: function (r) {
            if (r.code == 0) {
               layer.msg(r.msg);
               reLoad();
            } else {
               layer.msg(r.msg);
            }
         }
      });
   }, function () {

   });
}
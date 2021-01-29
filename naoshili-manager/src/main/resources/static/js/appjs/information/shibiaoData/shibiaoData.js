var prefix = "/information/shibiaoData"
$(function () {
   load();
});

function load() {
   $('#exampleTable3')
      .bootstrapTable(
         {
            method: 'get', // 服务器数据的请求方式 get or post
            url: prefix + "/list", // 服务器数据的加载地址
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
                  offset: params.offset,
                  dataId: $('#id').val()
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
               /*{
                  checkbox : true
               },
                                       {
                  field : 'id',
                  title : 'id'
               },
                  */                     {
                  field: 'dataId',
                  title: '实验序号'
               },
               {
                  field: 'experimentalMode',
                  title: '实验类型',
                  formatter: function (value) {
                     if (value == 1) {
                        return "多段移动视标试验"
                     } else if (value == 2) {
                        return "单段移动视标试验"
                     } else if (value == 3) {
                        return "闪烁视标试验"
                     }
                  }
               },
               {
                  field: 'time',
                  title: '时间'
               }, /*
																{
									field : 'localtion', 
									title : '位置（移动视标）' 
								},
										*/             /*     {
                  field: 'speed',
                  title: '速度（移动视标）'
               },
               {
                  field: 'visualStandard1',
                  title: '视标1（交替通断）'
               },
               {
                  field: 'visualStandard2',
                  title: '视标2（交替通断）'
               },
               {
                  field: 'visualStandard3',
                  title: '视标3（交替通断）'
               }*/
               {
                  title: '操作',
                  field: 'id',
                  align: 'center',
                  formatter: function (value, row, index) {
                     var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="实验参数" onclick="getparams(\'' + row.dataId + '\',\'' + row.experimentalMode + '\')"><i class="fa fa-database"></i></a> ';
                     var d = '<a class="btn btn-warning btn-sm" href="#" title="实验数据"  mce_href="#" onclick="getData(\'' + row.dataId + '\',\'' + row.experimentalMode + '\')"><i class="fa fa-bar-chart"></i></a> ';
                     var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                        + row.id
                        + '\')"><i class="fa fa-key"></i></a> ';
                     return e + d;
                  }
               }]
         });
}

function reLoad() {
   $('#exampleTable').bootstrapTable('refresh');
}

function add() {
   layer.open({
      type: 2,
      title: '增加',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/add' // iframe的url
   });
}

//条件表
function getparams(id, experimentalMode) {
   console.log(id, experimentalMode)
   //移动
   if (experimentalMode == 1 || experimentalMode == 2) {
      var page = layer.open({
         type: 2,
         title: '实验参数',
         maxmin: true,
         shadeClose: false, // 点击遮罩关闭层
         area: ['800px', '520px'],
         content: '/information/shibiaoMoveIf/page/' + id // iframe的url
      });
      layer.full(page)
   }
   //闪烁
   else if (experimentalMode == 3) {
      var page = layer.open({
         type: 2,
         title: '实验参数',
         maxmin: true,
         shadeClose: false, // 点击遮罩关闭层
         area: ['800px', '520px'],
         content: '/information/shibiaoTwinkleIf/page/' + id // iframe的url
      });
      layer.full(page)
   }

}

function getData(id, experimentalMode) {
   console.log(id, id)
   var page = layer.open({
      type: 2,
      title: '实验参数',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/detail?id=' + id + '&experimentalMode=' + experimentalMode// iframe的url
   });
   layer.full(page)
}


function edit(id) {
   layer.open({
      type: 2,
      title: '编辑',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/edit/' + id // iframe的url
   });
}

function remove(id) {
   layer.confirm('确定要删除选中的记录？', {
      btn: ['确定', '取消']
   }, function () {
      $.ajax({
         url: prefix + "/remove",
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
   var rows = $('#exampleTable3').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
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
         url: prefix + '/batchRemove',
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
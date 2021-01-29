var prefix = "/information/collectionInfo"
$(function () {
   load();
});

function load() {
   $('#exampleTable')
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
                  id: $('#id').val(),
                  responsibleDoctor: $('#responsibleDoctor').val(),
                  idCard: $('#idCard').val(),
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
               },*/
               {
                  field: 'id',
                  title: '实验序号'
               },
               /* {
                   field: 'idCard',
                   title: '身份证'
                },*/
               /*						{
            field : 'collectionDate',
            title : '采集日期'
         },
            */                     {
                  field: 'collectionDate',
                  title: '采集时间'
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
               /*{
                  field: 'responsibleDoctor',
                  title: '负责医生'
               },*/
               /*{
                  field: 'deviceName',
                  title: '设备名称'
               },
               {
                  field: 'avgDiopter',
                  title: '精工平均屈光度'
               }*/
               {
                  title: '操作',
                  field: 'id',
                  align: 'center',
                  formatter: function (value, row, index) {
                     var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="报告" onclick="report(\''
                        + row.id
                        + '\')"><i class="fa fa-line-chart"></i></a> ';
                     var d = '<a class="btn btn-warning btn-sm ' + s_remove_h + '" href="#" title="删除"  mce_href="#" onclick="remove(\''
                        + row.id
                        + '\')"><i class="fa fa-remove"></i></a> ';
                     var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                        + row.id
                        + '\')"><i class="fa fa-key"></i></a> ';
                     return e;
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

function report(id) {
   var page = layer.open({
      type: 2,
      title: '分析报告',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: '/information/DataReport/list/' + id // iframe的url
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
var prefix = "/information/riliImportData"
$(function () {
   load();
});

function load() {
   $('#exampleTable4')
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
                  dataId: $('#id').val(),
                  type: $('#type1').val()
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
                  checkbox: true
               },
               {
                  field: 'id',
                  title: 'id'
               },*/
               {
                  field: 'dataId',
                  title: '实验序号'
               },
               {
                  field: 'ch1',
                  title: 'ch1'
               },
               {
                  field: 'ch2',
                  title: 'ch2'
               },
               {
                  field: 'ch3',
                  title: 'ch3'
               },
               {
                  field: 'ch4',
                  title: 'ch4'
               },
               {
                  field: 'ch5',
                  title: 'ch5'
               },
               {
                  field: 'ch6',
                  title: 'ch6'
               },
               {
                  field: 'ch7',
                  title: 'ch7'
               },
               {
                  field: 'ch8',
                  title: 'ch8'
               },
               {
                  field: 'ch9',
                  title: 'ch9'
               },
               {
                  field: 'ch10',
                  title: 'ch10'
               },
               {
                  field: 'ch11',
                  title: 'ch11'
               },
               {
                  field: 'ch12',
                  title: 'ch12'
               },
               {
                  field: 'ch13',
                  title: 'ch13'
               },
               {
                  field: 'ch14',
                  title: 'ch14'
               },
               {
                  field: 'ch15',
                  title: 'ch15'
               },
               {
                  field: 'ch16',
                  title: 'ch16'
               },
               {
                  field: 'ch17',
                  title: 'ch17'
               },
               {
                  field: 'ch18',
                  title: 'ch18'
               },
               {
                  field: 'ch19',
                  title: 'ch19'
               },
               {
                  field: 'ch20',
                  title: 'ch20'
               },
               {
                  field: 'ch21',
                  title: 'ch21'
               },
               {
                  field: 'ch22',
                  title: 'ch22'
               },
               {
                  field: 'mark',
                  title: '外部标记'
               },
               {
                  field: 'time',
                  title: '采集时间'
               },
               {
                  field: 'type',
                  title: '文件类型',
                  formatter: function (value) {
                     if (value == 1) {
                        return "oxy"
                     } else if (value == 2) {
                        return "deoxy"
                     } else if (value == 3) {
                        return "total"
                     } else {
                        return "MES"
                     }
                  }
               },
               /*{
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
                     var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                        + row.id
                        + '\')"><i class="fa fa-key"></i></a> ';
                     return e + d;
                  }
               }*/]
         });
}

function load11() {
   $('#exampleTable5')
      .bootstrapTable(
         {
            method: 'get', // 服务器数据的请求方式 get or post
            url: "/information/riliImportData/meslist", // 服务器数据的加载地址
            //	showRefresh : true,
            //	showToggle : true,
            //	showColumns : true,
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: false, // 设置为true会在底部显示分页条
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
                  dataId: $('#id').val(),
                  type: $('#type1').val()
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
                  checkbox: true
               },
               {
                  field: 'id',
                  title: 'id'
               },*/

               {
                  field: 'dataId',
                  title: '实验序号'
               },
               {
                  field: 'ch1',
                  title: 'ch1'
               },
               {
                  field: 'ch1_1',
                  title: 'ch1_1'
               },
               {
                  field: 'ch2',
                  title: 'ch2'
               },
               {
                  field: 'ch2_1',
                  title: 'ch2_1'
               },
               {
                  field: 'ch3',
                  title: 'ch3'
               },
               {
                  field: 'ch3_1',
                  title: 'ch3_1'
               },
               {
                  field: 'ch4',
                  title: 'ch4'
               },
               {
                  field: 'ch4_1',
                  title: 'ch4_1'
               },
               {
                  field: 'ch5',
                  title: 'ch5'
               },
               {
                  field: 'ch5_1',
                  title: 'ch5_1'
               },
               {
                  field: 'ch6',
                  title: 'ch6'
               },
               {
                  field: 'ch6_1',
                  title: 'ch6_1'
               },
               {
                  field: 'ch7',
                  title: 'ch7'
               },
               {
                  field: 'ch7_1',
                  title: 'ch7_1'
               },
               {
                  field: 'ch8',
                  title: 'ch8'
               },
               {
                  field: 'ch8_1',
                  title: 'ch8_1'
               },
               {
                  field: 'ch9',
                  title: 'ch9'
               },
               {
                  field: 'ch9_1',
                  title: 'ch9_1'
               },
               {
                  field: 'ch10',
                  title: 'ch10'
               },
               {
                  field: 'ch10_1',
                  title: 'ch10_1'
               },
               {
                  field: 'ch11',
                  title: 'ch11'
               },
               {
                  field: 'ch11_1',
                  title: 'ch11_1'
               },
               {
                  field: 'ch12',
                  title: 'ch12'
               },
               {
                  field: 'ch12_1',
                  title: 'ch12_1'
               },
               {
                  field: 'ch13',
                  title: 'ch13'
               },
               {
                  field: 'ch13_1',
                  title: 'ch13_1'
               },
               {
                  field: 'ch14',
                  title: 'ch14'
               },
               {
                  field: 'ch14_1',
                  title: 'ch14_1'
               },
               {
                  field: 'ch15',
                  title: 'ch15'
               },
               {
                  field: 'ch15_1',
                  title: 'ch15_1'
               },
               {
                  field: 'ch16',
                  title: 'ch16'
               },
               {
                  field: 'ch16_1',
                  title: 'ch16_1'
               },
               {
                  field: 'ch17',
                  title: 'ch17'
               },
               {
                  field: 'ch17_1',
                  title: 'ch17_1'
               },
               {
                  field: 'ch18',
                  title: 'ch18'
               },
               {
                  field: 'ch18_1',
                  title: 'ch18_1'
               },
               {
                  field: 'ch19',
                  title: 'ch19'
               },
               {
                  field: 'ch19_1',
                  title: 'ch19_1'
               },
               {
                  field: 'ch20',
                  title: 'ch20'
               },
               {
                  field: 'ch20_1',
                  title: 'ch20_1'
               },
               {
                  field: 'ch21',
                  title: 'ch21'
               },
               {
                  field: 'ch21_1',
                  title: 'ch21_1'
               },
               {
                  field: 'ch22',
                  title: 'ch22'
               },
               {
                  field: 'ch22_1',
                  title: 'ch22_1'
               },
               {
                  field: 'mark',
                  title: '外部标记'
               },
               {
                  field: 'time',
                  title: '采集时间'
               },
               {
                  field: 'type',
                  title: '文件类型',
                  formatter: function (value) {
                     if (value == 1) {
                        return "oxy"
                     } else if (value == 2) {
                        return "deoxy"
                     } else if (value == 3) {
                        return "total"
                     } else {
                        return "MES"
                     }
                  }
               },
               /*{
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
                     var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                        + row.id
                        + '\')"><i class="fa fa-key"></i></a> ';
                     return e + d;
                  }
               }*/]
         });
}

var barChart1 = echarts.init(document.getElementById("main5"));
var barChart2 = echarts.init(document.getElementById("mesChart"));

var option = {
   title: {
      text: 'CH1-CH22通道全部数据'
   },
   tooltip: {
      trigger: 'axis'
   },
   grid: {
      top: '15%',//距上边距

      left: '15%',//距离左边距

      right: '15%',//距离右边距

      bottom: '15%',//距离下边距

   },
   legend: {
      top: '5%',
      left: '3%',
      data: ['全选', 'CH1', 'CH2', 'CH3', 'CH4', 'CH5', 'CH6', 'CH7', 'CH8', 'CH9',
         'CH10', 'CH11', 'CH12', 'CH13', 'CH14', 'CH15', 'CH16', 'CH17', 'CH18', 'CH19',
         'CH20', 'CH21', 'CH22']
   },
   xAxis: {
      name: '采集时间',
      type: 'category',
      boundaryGap: false,
      /*data: xoxy*/
   },
   yAxis: {
      type: 'value'
   },
   dataZoom: [{
      type: 'inside',
      start: 0,
      end: 100
   }, {
      start: 0,
      end: 100,
      handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
      handleSize: '80%',
      handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
      }
   }],
   series: [
      {
         type: 'line',
      },
      {
         type: 'line',
      },
      {
         type: 'line',
      },
      {
         type: 'line',

      },
      {
         /*name: 'CH4',*/
         type: 'line',

         /*data: ch4oxy*/
      },
      {
         /*name: 'CH5',*/
         type: 'line',

         /*data: ch5oxy*/
      }
      ,
      {
         /*name: 'CH6',*/
         type: 'line',

         /*data: ch6oxy*/
      }
      ,
      {
         /*name: 'CH7',*/
         type: 'line',

         /*data: ch7oxy*/
      }
      ,
      {
         /*name: 'CH8',*/
         type: 'line',

         /*data: ch8oxy*/
      }
      ,
      {
         /*name: 'CH9',*/
         type: 'line',

         /*data: ch9oxy*/
      }
      ,
      {
         /*name: 'CH10',*/
         type: 'line',

         /*data: ch10oxy*/
      }
      ,
      {
         /*name: 'CH11',*/
         type: 'line',

         /*data: ch11oxy*/
      }, {
         /*name: 'CH12',*/
         type: 'line',

         /*data: ch12oxy*/
      },
      {
         /*name: 'CH13',*/
         type: 'line',

         /*data: ch13oxy*/
      },
      {
         /*name: 'CH14',*/
         type: 'line',

         /*data: ch14oxy*/
      },
      {
         /*name: 'CH15',*/
         type: 'line',

         /*data: ch15oxy*/
      }
      ,
      {
         /*name: 'CH16',*/
         type: 'line',

         /*data: ch16oxy*/
      }
      ,
      {
         /*name: 'CH17',*/
         type: 'line',

         /*data: ch17oxy*/
      }
      ,
      {
         /*name: 'CH18',*/
         type: 'line',

         /*data: ch18oxy*/
      }
      ,
      {
         /*name: 'CH19',*/
         type: 'line',

         /*data: ch19oxy*/
      }
      ,
      {
         /*name: 'CH20',*/
         type: 'line',

         /*data: ch20oxy*/
      }
      ,
      {
         /*name: 'CH21',*/
         type: 'line',

         /*data: ch21oxy*/
      },
      {
         /* name: 'CH22',*/
         type: 'line',

         /*data: ch22oxy*/
      }
   ]
}
barChart1.setOption(option)
barChart1.showLoading();

var option1 = {
   title: {
      text: 'MES数据'
   },
   tooltip: {
      trigger: 'axis'
   },
   grid: {
      top: '15%',//距上边距

      left: '15%',//距离左边距

      right: '15%',//距离右边距

      bottom: '15%',//距离下边距

   },
   legend: {
      top: '5%',
      left: '3%',
      data: ['全选', 'CH1', 'CH1_1', 'CH2', 'CH2_1', 'CH3', 'CH3_1', 'CH4', 'CH4_1', 'CH5', 'CH5_1', 'CH6', 'CH6_1', 'CH7', 'CH7_1', 'CH8', 'CH8_1', 'CH9', 'CH9_1',
         'CH10', 'CH10_1', 'CH11', 'CH11_1', 'CH12', 'CH12_1', 'CH13', 'CH13_1', 'CH14', 'CH14_1', 'CH15', 'CH15_1', 'CH16', 'CH16_1', 'CH17', 'CH17_1', 'CH18', 'CH18_1', 'CH19', 'CH19_1',
         'CH20', 'CH20_1', 'CH21', 'CH21_1', 'CH22', 'CH22_1']
   },
   xAxis: {
      name: '采集时间',
      type: 'category',
      boundaryGap: false,
      /*data: xoxy*/
   },
   yAxis: {
      type: 'value'
   },
   dataZoom: [{
      type: 'inside',
      start: 0,
      end: 100
   }, {
      start: 0,
      end: 100,
      handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
      handleSize: '80%',
      handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
      }
   }],
   series: [
      {
         type: 'line',
      },
      {
         type: 'line',

      },
      {
         type: 'line',
      },
      {
         type: 'line',
      },
      {
         type: 'line',

      },
      {
         /*name: 'CH4',*/
         type: 'line',

         /*data: ch4oxy*/
      },
      {
         /*name: 'CH5',*/
         type: 'line',

         /*data: ch5oxy*/
      },
      {
         /*name: 'CH6',*/
         type: 'line',

         /*data: ch6oxy*/
      },
      {
         /*name: 'CH7',*/
         type: 'line',

         /*data: ch7oxy*/
      },
      {
         /*name: 'CH8',*/
         type: 'line',

         /*data: ch8oxy*/
      },
      {
         /*name: 'CH9',*/
         type: 'line',

         /*data: ch9oxy*/
      },
      {
         /*name: 'CH10',*/
         type: 'line',

         /*data: ch10oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',

         /*data: ch11oxy*/
      },
      {
         /*name: 'CH12',*/
         type: 'line',

         /*data: ch12oxy*/
      },
      {
         /*name: 'CH13',*/
         type: 'line',

         /*data: ch13oxy*/
      },
      {
         /*name: 'CH14',*/
         type: 'line',

         /*data: ch14oxy*/
      },
      {
         /*name: 'CH15',*/
         type: 'line',

         /*data: ch15oxy*/
      },
      {
         /*name: 'CH16',*/
         type: 'line',

         /*data: ch16oxy*/
      },
      {
         /*name: 'CH17',*/
         type: 'line',

         /*data: ch17oxy*/
      },
      {
         /*name: 'CH18',*/
         type: 'line',

         /*data: ch18oxy*/
      },
      {
         /*name: 'CH19',*/
         type: 'line',

         /*data: ch19oxy*/
      },
      {
         /*name: 'CH20',*/
         type: 'line',

         /*data: ch20oxy*/
      },
      {
         /*name: 'CH21',*/
         type: 'line',

         /*data: ch21oxy*/
      },
      {
         /* name: 'CH22',*/
         type: 'line',

         /*data: ch22oxy*/
      },
      {
         type: 'line',
      },
      {
         type: 'line',
      },
      {
         type: 'line',

      },
      {
         /*name: 'CH4',*/
         type: 'line',

         /*data: ch4oxy*/
      },
      {
         /*name: 'CH5',*/
         type: 'line',

         /*data: ch5oxy*/
      },
      {
         /*name: 'CH6',*/
         type: 'line',

         /*data: ch6oxy*/
      },
      {
         /*name: 'CH7',*/
         type: 'line',

         /*data: ch7oxy*/
      },
      {
         /*name: 'CH8',*/
         type: 'line',

         /*data: ch8oxy*/
      },
      {
         /*name: 'CH9',*/
         type: 'line',

         /*data: ch9oxy*/
      },
      {
         /*name: 'CH10',*/
         type: 'line',

         /*data: ch10oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',

         /*data: ch11oxy*/
      },
      {
         /*name: 'CH12',*/
         type: 'line',

         /*data: ch12oxy*/
      },
      {
         /*name: 'CH13',*/
         type: 'line',

         /*data: ch13oxy*/
      },
      {
         /*name: 'CH14',*/
         type: 'line',

         /*data: ch14oxy*/
      },
      {
         /*name: 'CH15',*/
         type: 'line',

         /*data: ch15oxy*/
      },
      {
         /*name: 'CH16',*/
         type: 'line',

         /*data: ch16oxy*/
      },
      {
         /*name: 'CH17',*/
         type: 'line',

         /*data: ch17oxy*/
      },
      {
         /*name: 'CH18',*/
         type: 'line',

         /*data: ch18oxy*/
      },
      {
         /*name: 'CH19',*/
         type: 'line',

         /*data: ch19oxy*/
      },
      {
         /*name: 'CH20',*/
         type: 'line',

         /*data: ch20oxy*/
      },
      {
         /*name: 'CH21',*/
         type: 'line',

         /*data: ch21oxy*/
      },
      {
         /* name: 'CH22',*/
         type: 'line',

         /*data: ch22oxy*/
      }
   ]
}
barChart2.setOption(option1)
barChart2.showLoading();

var selectArr = option.legend.data;
console.log(selectArr, "selectArr")
barChart1.on('legendselectchanged', function (obj) {
   var selected = obj.selected;
   var name = obj.name;
// 使用 legendToggleSelect Action 会重新触发 legendselectchanged Event，导致本函数重复运行
// 使得 无 selected 对象
   if (name == '全选') {//需要配置一个legend为‘全选’的名称
//alert("33");
      var flag = $(this).attr('flag');
      if (flag == 1) {
         var val = false;
         $(this).attr('flag', 0);
         $(this).val('全选中');
      } else {
         var val = true;
         $(this).attr('flag', 1);
         $(this).val('全不选');
      }
      var obj = {};
      for (var key in selectArr) {
         obj[selectArr[key]] = val;
      }
      option.legend.selected = obj;

      barChart1.setOption(option);
   }
});

var selectArr1 = option1.legend.data;
console.log(selectArr1, "selectArr1")
barChart2.on('legendselectchanged', function (obj) {
   var selected = obj.selected;
   var name = obj.name;
// 使用 legendToggleSelect Action 会重新触发 legendselectchanged Event，导致本函数重复运行
// 使得 无 selected 对象
   if (name == '全选') {//需要配置一个legend为‘全选’的名称
//alert("33");
      var flag = $(this).attr('flag');
      if (flag == 1) {
         var val = false;
         $(this).attr('flag', 0);
         $(this).val('全选中');
      } else {
         var val = true;
         $(this).attr('flag', 1);
         $(this).val('全不选');
      }
      var obj = {};
      for (var key in selectArr1) {
         obj[selectArr1[key]] = val;
      }
      option1.legend.selected = obj;

      barChart2.setOption(option1);
   }
});

function loadImportChart(type) {
   if (type == "4") {
      $("#mesChart").show()
      $('#main5').hide();

      var id = $('#id').val()
      $.ajax({
         type: "get",
         async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url: "/information/riliImportData/getMes",    //请求发送到TestServlet处
         data: {id: id, type: type},
         dataType: "json",        //返回数据形式为json
         success: function (result) {
            var indexs = result.data.index;
            index = [];
            for (var i = 0; i < indexs.length; i++) {
               if (i == 0) {
                  index.push(
                     [{
                        xAxis: result.data.xoxy[indexs[0]]
                     }, {
                        xAxis: result.data.xoxy[indexs[i + 1]]
                     }]
                  );
               } else if (i % 2 == 0 && i > 1) {
                  index.push(
                     [{
                        xAxis: result.data.xoxy[indexs[i]]
                     }, {
                        xAxis: result.data.xoxy[indexs[i + 1]]
                     }]
                  );
               }
            }
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
               barChart2.hideLoading();    //隐藏加载动画
               barChart2.setOption({        //加载数据图表
                  xAxis: {
                     data: result.data.xoxy
                  },
                  series: [
                     {
                        name: '全选'

                     }, {
                        name: 'CH1',
                        data: result.data.ch1oxy,
                        markArea: {
                           data: index
                        },
                     },
                     {
                        name: 'CH1_1',
                        data: result.data.ch1_1oxy
                     },
                     {
                        name: 'CH2',
                        data: result.data.ch2oxy
                     },
                     {
                        name: 'CH2_1',
                        data: result.data.ch2_2oxy
                     },
                     {
                        name: 'CH3',
                        data: result.data.ch3oxy
                     },
                     {
                        name: 'CH3_1',
                        data: result.data.ch3_1oxy
                     }
                     ,
                     {
                        name: 'CH4',
                        data: result.data.ch4oxy
                     }
                     ,
                     {
                        name: 'CH4_1',
                        data: result.data.ch4_1oxy
                     }
                     ,
                     {
                        name: 'CH5',
                        data: result.data.ch5oxy
                     }
                     ,
                     {
                        name: 'CH5_1',
                        data: result.data.ch5_1oxy
                     }
                     ,
                     {
                        name: 'CH6',
                        data: result.data.ch6oxy
                     }
                     ,
                     {
                        name: 'CH6_1',
                        data: result.data.ch6_1oxy
                     },
                     {
                        name: 'CH7',
                        data: result.data.ch7oxy
                     },
                     {
                        name: 'CH7_1',
                        data: result.data.ch7_1oxy
                     },
                     {
                        name: 'CH8',
                        data: result.data.ch8oxy
                     },
                     {
                        name: 'CH8_1',
                        data: result.data.ch8_1oxy
                     }
                     ,
                     {
                        name: 'CH9',
                        data: result.data.ch9oxy
                     }
                     ,
                     {
                        name: 'CH9_1',
                        data: result.data.ch9_1oxy
                     }
                     ,
                     {
                        name: 'CH10',
                        data: result.data.ch10oxy
                     }
                     ,
                     {
                        name: 'CH10_1',
                        data: result.data.ch10_1oxy
                     }
                     ,
                     {
                        name: 'CH11',
                        data: result.data.ch11oxy
                     }
                     ,
                     {
                        name: 'CH11_1',
                        data: result.data.ch11_1oxy
                     },
                     {
                        name: 'CH12',
                        data: result.data.ch12oxy
                     },
                     {
                        name: 'CH12_1',
                        data: result.data.ch12_1oxy
                     },
                     {
                        name: 'CH13',
                        data: result.data.ch13oxy
                     },
                     {
                        name: 'CH13_1',
                        data: result.data.ch13_1oxy
                     },
                     {
                        name: 'CH14',
                        data: result.data.ch14oxy
                     },
                     {
                        name: 'CH14_1',
                        data: result.data.ch14_1oxy
                     }
                     ,
                     {
                        name: 'CH15',
                        data: result.data.ch15oxy
                     }
                     ,
                     {
                        name: 'CH15_1',
                        data: result.data.ch15_1oxy
                     }
                     ,
                     {
                        name: 'CH16',
                        data: result.data.ch16oxy
                     }
                     ,
                     {
                        name: 'CH16_1',
                        data: result.data.ch16_1oxy
                     }
                     ,
                     {
                        name: 'CH17',
                        data: result.data.ch17oxy
                     }
                     ,
                     {
                        name: 'CH17_1',
                        data: result.data.ch17_1oxy
                     },
                     {
                        name: 'CH18',
                        data: result.data.ch18oxy
                     },
                     {
                        name: 'CH18_1',
                        data: result.data.ch18_1oxy
                     },
                     {
                        name: 'CH19',
                        data: result.data.ch19oxy
                     },
                     {
                        name: 'CH19_1',
                        data: result.data.ch19_1oxy
                     }
                     ,
                     {
                        name: 'CH20',
                        data: result.data.ch20oxy
                     }
                     ,
                     {
                        name: 'CH20_1',
                        data: result.data.ch20_1oxy
                     }
                     ,
                     {
                        name: 'CH21',
                        data: result.data.ch21oxy
                     }
                     ,
                     {
                        name: 'CH21_1',
                        data: result.data.ch21_1oxy
                     }
                     ,
                     {
                        name: 'CH22',
                        data: result.data.ch22oxy
                     }
                     ,
                     {
                        name: 'CH22_1',
                        data: result.data.ch22_1oxy
                     }]
               });

               setTimeout(() => {
                  barChart2.resize();
               }, 100)
            }
         },
         error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            barChart1.hideLoading();
         }
      })
   } else {
      $('#mesChart').hide();
      $('#main5').show();
      var id = $('#id').val()
      $.ajax({
         type: "get",
         async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
         url: "/information/riliImportData/getImport",    //请求发送到TestServlet处
         data: {id: id, type: type},
         dataType: "json",        //返回数据形式为json
         success: function (result) {
            var indexs = result.data.index;
            index = [];
            for (var i = 0; i < indexs.length; i++) {
               if (i == 0) {
                  index.push(
                     [{
                        xAxis: result.data.xoxy[indexs[0]]
                     }, {
                        xAxis: result.data.xoxy[indexs[i + 1]]
                     }]
                  );
               } else if (i % 2 == 0 && i > 1) {
                  index.push(
                     [{
                        xAxis: result.data.xoxy[indexs[i]]
                     }, {
                        xAxis: result.data.xoxy[indexs[i + 1]]
                     }]
                  );
               }
            }
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
               barChart1.hideLoading();    //隐藏加载动画
               barChart1.setOption({        //加载数据图表
                  xAxis: {
                     data: result.data.xoxy
                  },
                  series: [{
                     name: '全选'

                  }, {
                     name: 'CH1',
                     data: result.data.ch1oxy,
                     markArea: {
                        data: index
                     },
                  },
                     {
                        name: 'CH2',
                        data: result.data.ch2oxy
                     },
                     {
                        name: 'CH3',
                        data: result.data.ch3oxy
                     },
                     {
                        name: 'CH4',
                        data: result.data.ch4oxy
                     },
                     {
                        name: 'CH5',
                        data: result.data.ch5oxy
                     }
                     ,
                     {
                        name: 'CH6',
                        data: result.data.ch6oxy
                     }
                     ,
                     {
                        name: 'CH7',
                        data: result.data.ch7oxy
                     }
                     ,
                     {
                        name: 'CH8',
                        data: result.data.ch8oxy
                     }
                     ,
                     {
                        name: 'CH9',
                        data: result.data.ch9oxy
                     }
                     ,
                     {
                        name: 'CH10',
                        data: result.data.ch10oxy
                     }
                     ,
                     {
                        name: 'CH11',
                        data: result.data.ch11oxy
                     },
                     {
                        name: 'CH12',
                        data: result.data.ch12oxy
                     },
                     {
                        name: 'CH13',
                        data: result.data.ch13oxy
                     },
                     {
                        name: 'CH14',
                        data: result.data.ch14oxy
                     },
                     {
                        name: 'CH15',
                        data: result.data.ch15oxy
                     }
                     ,
                     {
                        name: 'CH16',
                        data: result.data.ch16oxy
                     }
                     ,
                     {
                        name: 'CH17',
                        data: result.data.ch17oxy
                     }
                     ,
                     {
                        name: 'CH18',
                        data: result.data.ch18oxy
                     }
                     ,
                     {
                        name: 'CH19',
                        data: result.data.ch19oxy
                     }
                     ,
                     {
                        name: 'CH20',
                        data: result.data.ch20oxy
                     }
                     ,
                     {
                        name: 'CH21',
                        data: result.data.ch21oxy
                     },
                     {
                        name: 'CH22',
                        data: result.data.ch22oxy
                     }]
               });

               setTimeout(() => {
                  barChart1.resize();
               }, 100)
            }
         },
         error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            barChart1.hideLoading();
         }
      })
   }

}

loadImportChart('1');

function reLoad() {
   if ($('#type1').val()) {

      if ($('#type1').val() == 4) {
         loadImportChart($('#type1').val())
         load11();
         $('#exampleTable4').bootstrapTable('togglePagination')
         $('#exampleTable5').bootstrapTable('togglePagination')
         $('#exampleTable4').hide();
         $('#exampleTable5').show();

      } else {
         loadImportChart($('#type1').val())
         $('#exampleTable4').bootstrapTable('refresh');
         $('#exampleTable4').bootstrapTable('togglePagination')
         $('#exampleTable5').bootstrapTable('togglePagination')
         $('#exampleTable4').show();
         $('#exampleTable5').hide();
      }
   } else {
      loadImportChart(6)
      $('#exampleTable4').bootstrapTable('refresh');
   }

}


function importCsv() {
   console.log($('#id').val())
   layer.open({
      type: 2,
      title: '导入csv文件',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/importCsv/' + $('#id').val() // iframe的url
   });
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

function exportExcel() {
   var dataId = $('#id').val();
   var type = $('#type1').val();

   console.log(dataId)
   console.log(type)

   window.location.href = "/information/riliImportData/export?dataId=" + dataId + "&type=" + type;

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